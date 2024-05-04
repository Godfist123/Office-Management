package com.as.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.as.domain.DepartInfo;
import com.as.domain.Employee;
import com.as.domain.Menu;
import com.as.domain.UsersMenu;
import com.as.service.DepartInfoService;
import com.as.service.EmployeeService;
import com.as.service.MenuService;
import com.as.util.Pages;

/**
 * 	权限菜单模块的控制层
 * @author 小陈
 *
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartInfoService departInfoService;
	
	@Autowired
	private MenuService menuService;
	
	
	/**
	 * 显示主界面信息
	 * @param currPage
	 * @param employee
	 * @return
	 */
//	@ResponseBody
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value = "currPage",defaultValue = "1")Integer currPage,Employee employee) {
		
		
		//模糊查询为空时,页数1/0, limit出错
		if(currPage==0) currPage=1;
		
		ModelAndView mv=new ModelAndView("menu/list");
		
		Pages<Employee> pages=this.employeeService.list(currPage, employee);
		//查出所有职位,用于查询的下拉列表
		List<Employee> employee2=this.employeeService.Listposition(new Employee());
		//查出关联的部门表的所有部门名字,用于查询的下拉列表
		List<DepartInfo> departInfo=this.departInfoService.list(-1, new DepartInfo()).getList();

		mv.addObject("pages", pages).
		addObject("employee", employee).
		addObject("departInfo", departInfo).
		addObject("employee2", employee2);
		
		return mv;
	}
	
	
	/**
	 * 显示分配权限界面的父级权限
	 * @return
	 */
	@RequestMapping("/showmenu")
	public ModelAndView showmenu(Integer empid) {
		
		//父级权限
		List<Menu> list=this.menuService.selectMenu(0);
		ModelAndView mv=new ModelAndView("menu/showmenu");
		mv.addObject("list", list)
		.addObject("empid", empid);
		
		return mv;
	}
	
	/**
	 * ajax方法,得到当前用户的权限
	 */
	@RequestMapping("/selectbyempid")
	@ResponseBody
	public List<UsersMenu> selectbyempid(Integer empid) {
		
		return this.menuService.selectByEmpId(empid);
		
	}
	
	/**
	 * 修改权限
	 * @return
	 */
	@RequestMapping("/updateUsersMenu")
	public String updateUsersMenu(Integer[] menuids,Integer empid) {
		
		this.menuService.updateUsersMenu(menuids, empid);
		
		return "redirect:list";
	}
	
}
