package com.as.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.as.domain.Employee;
import com.as.domain.Expense;
import com.as.domain.ExpenseDetail;
import com.as.domain.ExpenseType;
import com.as.service.EmployeeService;
import com.as.service.ExpenseDetailService;
import com.as.service.ExpenseService;
import com.as.service.ExpenseTypeService;
import com.as.util.DateUtils;
import com.as.util.Pages;

/**
 * 	报销模块的控制层
 * @author 小陈
 *
 */
@Controller
@RequestMapping("/expense")
public class ExpenseController extends BaseController{

	// 依赖注入
	@Autowired
	private ExpenseService expenseService;
	@Autowired
	private ExpenseTypeService expenseTypeService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ExpenseDetailService expenseDetailService;

	/**
	 * 报销管理列表页面显示
	 * @param currPage
	 * @param expense
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, Expense expense) {
		
		//模糊查询为空时,页数1/0, limit出错
		if(currPage==0) currPage=1;
		//查询下拉列表的初始化
		if(expense.getSugstate()==null) expense.setSugstate(0);
		if(expense.getState()==null) expense.setState(1);
		
		Employee employee=(Employee)session.getAttribute("emp");
		expense.setEmpid(employee.getEmpId());
		
		
		this.session=this.request.getSession();
		
		ModelAndView mv = new ModelAndView("expense/list");
		Pages<Expense> pages = this.expenseService.list(currPage, expense, session);
		//链式写法
		mv.addObject("pages", pages).addObject("expense", expense);

		return mv;
	}
	
	/**
	 * 报销管理-查看详情
	 * @param expenseid
	 * @return
	 */
	@GetMapping("/detail")
	public ModelAndView detail(Integer expenseid) {
		
		
		Expense expense=this.expenseService.selectById(expenseid);
		List<ExpenseDetail> listdetail=this.expenseDetailService.selectByExpenseId(expenseid);
		List<ExpenseType> listExType=this.expenseTypeService.list(-1, new ExpenseType()).getList();
		
		//审批人下拉列表
		Employee employee=new Employee();
		employee.setPosition("经理");
		List<Employee> listEmployee=this.employeeService.list(-1, employee).getList();
		
		//获取服务器当前时间
		String datetime=DateUtils.getFormatDateTime(LocalDateTime.now());
		
		
		ModelAndView mv=new ModelAndView("expense/detail");
		mv.addObject("expense", expense)
		.addObject("listExType", listExType)
		.addObject("listdetail", listdetail)
		.addObject("listEmployee",listEmployee)
		.addObject("datetime", datetime);
		
		return mv;
	}
	
	/**
	 * 报销管理-查看详情-修改处理
	 * @param extypeid
	 * @param moneys
	 * @param costdescs
	 * @return
	 */
	@PostMapping("/modify")
	public ModelAndView modify(Integer[] id,Integer[] extypeid,Integer[] money,String[] costdesc,Expense expense) {
		
		//修改报销单
		this.expenseService.modify(expense);
		
		//修改报销单详情: 1.先删除所有报销详情
		for (int i = 0; i < id.length; i++) {
			
			this.expenseDetailService.remove(id[i]);
		}
		
		// 2.再重新添加报销详情
		this.expenseDetailService.append(extypeid, money, costdesc, expense.getExpenseid());
		
		ModelAndView mv=new ModelAndView("redirect:list");
		
		return mv;
	}
	
	/**
	 * 报销单据新增页面显示
	 * @return
	 */
	@GetMapping("/append")
	public ModelAndView append() {
		
		List<ExpenseType> listExType=this.expenseTypeService.list(-1, new ExpenseType()).getList();
		
		Employee employee=new Employee();
		employee.setPosition("经理");
		List<Employee> listEmployee=this.employeeService.list(-1, employee).getList();
		
		//获取当前时间
		String datetime=DateUtils.getFormatDateTime(LocalDateTime.now());
		
		ModelAndView mv=new ModelAndView("expense/append");
		mv.addObject("listExType", listExType)
		.addObject("listEmployee",listEmployee)
		.addObject("datetime", datetime);
		
		return mv;
	}
	
	/**
	 * 报销单据新增页面处理
	 * @param expense
	 * @return
	 */
	@PostMapping("/append")
	public ModelAndView append(Expense expense,Integer[] extypeid,Integer[] money,String[] costdesc) {
		
		Employee employee=(Employee)session.getAttribute("emp");
		expense.setEmpid(employee.getEmpId());
		
		this.expenseService.append(expense);
		this.expenseDetailService.append(extypeid, money, costdesc, expense.getExpenseid());
		
		
		ModelAndView mv=new ModelAndView("redirect:/expense/list");
		
		return mv;
	}
	
	
	/**
	 * 报销管理-删除
	 * @param expenseid
	 * @return
	 */
	@GetMapping("/remove")
	public ModelAndView remove(Integer expenseid) {
		
		this.expenseService.remove(expenseid);
		ModelAndView mv=new ModelAndView("redirect:/expense/list");
		
		return mv;
	}
	
	/**
	 * 报销单详情-删除
	 * @param id
	 * @return
	 */
	@GetMapping("/removedetail/{id}")
	@ResponseBody
	public String removedetail(@PathVariable Integer id) {
		
		this.expenseDetailService.remove(id);
		
		return "ok";
	}
	
	/**
	 * 批量删除
	 * @param expenseid
	 * @return
	 */
	@GetMapping("/removes")
	public ModelAndView removes(Integer[] expenseids) {
		
		this.expenseService.removes(expenseids);
		ModelAndView mv=new ModelAndView("redirect:/expense/list");
		
		return mv;
	}
	
	/**
	 * 报销管理-单据提交
	 * @param expenseid
	 * @return
	 */
	@RequestMapping("/submit")
	public ModelAndView submit(Integer expenseid) {
		
		this.expenseService.submit(expenseid);
		ModelAndView mv=new ModelAndView("redirect:list");
		return mv;
	}
	
	/**
	 * 报销审批列表页面显示
	 * @param currPage
	 * @param expense
	 * @return
	 */
	@RequestMapping("/myconfirm")
	public ModelAndView myconfirm(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, Expense expense) {
		
		//模糊查询为空时,页数1/0, limit出错
		if(currPage==0) currPage=1;
		
		//查询下拉列表的初始化
		if(expense.getSugstate()==null) expense.setSugstate(1);
		
		Employee employee=(Employee)session.getAttribute("emp");
		
		//
		expense.setConfirmperson(employee.getEmpId()); //当前登录的审批人
		
		ModelAndView mv = new ModelAndView("expense/myconfirm");
		Pages<Expense> pages = this.expenseService.list(currPage, expense, session);
		//链式写法
		mv.addObject("pages", pages).addObject("expense", expense);

		return mv;
	}
	
	/**
	 * 审批功能页面显示
	 * @return
	 */
	@GetMapping("/examine")
	public ModelAndView examine(Integer expenseid) {
		
		Expense expense=this.expenseService.selectById(expenseid);
		List<ExpenseDetail> listdetail=this.expenseDetailService.selectByExpenseId(expenseid);
		
		ModelAndView mv=new ModelAndView("expense/examine");
		mv.addObject("expense", expense)
		.addObject("listdetail", listdetail);
		
		return mv;
	}
	
	
	/**
	 * 审批功能实现
	 * @return
	 */
	@PostMapping("/approve")
	public ModelAndView approve(Expense expense) {
		
		this.expenseService.approve(expense);
		
		ModelAndView mv=new ModelAndView("redirect:/expense/myconfirm");
		
		return mv;
	}

}
