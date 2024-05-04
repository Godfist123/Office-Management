package com.as.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.as.domain.DepartInfo;
import com.as.domain.Employee;
import com.as.service.DepartInfoService;
import com.as.service.EmployeeService;
import com.as.service.MenuService;
import com.as.util.Pages;
import com.as.util.RandomValidateCode;
import com.as.util.UploadFile;

/**
 * 	员工模块的控制层
 * @author 小陈
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController extends BaseController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartInfoService departInfoService;
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * 登录页面显示
	 * @return
	 */
	@GetMapping("/login")
	public ModelAndView login() {
		
		ModelAndView mv=new ModelAndView("employee/login");
		
		return mv;
	}
	
	/**
	 * 处理登录
	 * @param employee
	 * @return
	 */
	@PostMapping("/login")
	public ModelAndView login(Employee employee,String vercode) {
		
		HttpSession session=request.getSession();
		
		ModelAndView mv=null;
		
		//得到session对象
		//判断验证码
		String vercode1=session.getAttribute(RandomValidateCode.RANDOMCODEKEY).toString();
		System.out.println("验 证 码:"+vercode1);
		System.out.println("输入码:"+vercode);
		if(!vercode.equals(vercode1))
		{
			//request.setAttribute("code", "输入验证码不正确");
			mv=new ModelAndView("redirect:login?msg="+this.stringEncode("验证码不正确"));
		}else {
			
			Employee emp=this.employeeService.login(employee);
			
			if (emp.getFlag()==1) {
				
				session.setAttribute("emp", emp);
				//当前登录用户的权限集合,存session中,用来显示所有页面的侧边栏权限列表
				session.setAttribute("usersMenu", this.menuService.selectLoginMenu(emp.getEmpId(), 0));
				mv=new ModelAndView("redirect:/schedule/list");
				
			}else if (emp.getFlag()==2) {
				
				mv=new ModelAndView("redirect:/employee/login?msg="+this.stringEncode("账号已加锁"));
			
			}else {
				
				mv=new ModelAndView("redirect:login?msg="+this.stringEncode("账号或密码不正确"));// redirect:login等同于 redirect:/employee/login
			}
		}
		return mv;
	}
	
	/**
	 * 显示信息
	 * @param currPage
	 * @param employee
	 * @return
	 */
//	@ResponseBody
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value = "currPage",defaultValue = "1")Integer currPage,Employee employee) {
		
		ModelAndView mv=null;
		this.session=this.request.getSession();
		
		//判断是否登录
		if(session.getAttribute("emp")==null) {
			
			mv=new ModelAndView("employee/login");
		}else {
			
		//模糊查询为空时,页数1/0, limit出错
		if(currPage==0) currPage=1;
		
		mv=new ModelAndView("employee/list");
		
		//列表信息
		Pages<Employee> pages=this.employeeService.list(currPage, employee);
		//查出所有职位,用于查询的下拉列表
		List<Employee> employee2=this.employeeService.Listposition(new Employee());
		//查出关联的部门表的所有部门名字,用于查询的下拉列表
		List<DepartInfo> departInfo=this.departInfoService.list(-1, new DepartInfo()).getList();
		//查出职位为经理的employee
		Employee employee3=new Employee();
		employee3.setPosition("经理");
		List<Employee> listLeader=this.employeeService.list(-1, employee3).getList();

		mv.addObject("pages", pages)
		.addObject("employee", employee)
		.addObject("departInfo", departInfo)
		.addObject("employee2", employee2)
		.addObject("listLeader", listLeader);
		
		}
		return mv;
		
		//模糊查询为空时,页数1/0, limit出错
//		if(currPage==0) currPage=1;
//		
//		ModelAndView mv=new ModelAndView("employee/list");
//		
//		Pages<Employee> pages=this.employeeService.list(currPage, employee);
//		//查出所有职位,用于查询的下拉列表
//		List<Employee> employee2=this.employeeService.Listposition(new Employee());
//		//查出关联的部门表的所有部门名字,用于查询的下拉列表
//		List<DepartInfo> departInfo=this.departInfoService.list(-1, new DepartInfo()).getList();
//
//		mv.addObject("pages", pages).
//		addObject("employee", employee).
//		addObject("departInfo", departInfo).
//		addObject("employee2", employee2);
//		
//		return mv;
	}
	
	/**
	 *	 新增页面显示
	 * @return
	 */
	@GetMapping("/append")
	public ModelAndView append() {
		
		List<DepartInfo> departInfo=this.departInfoService.list(-1, new DepartInfo()).getList();
		
		ModelAndView mv=new ModelAndView("employee/append");
		mv.addObject("departInfo", departInfo);
		
		return mv;
	}
	
	/**
	 *	 新增页面处理
	 * @param employee
	 * @return
	 */
	@PostMapping("/append")
	public ModelAndView append(Employee employee,MultipartFile files) {
		
		String filename=UploadFile.fileUp(files, this.request);
		employee.setPicture(filename);
		
		this.employeeService.append(employee);
		
		ModelAndView mv=new ModelAndView("redirect:/employee/list");
		
		return mv;
	}
	
	/**
	 * 	修改页面显示
	 * @return
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(Integer empId) {
		
		Employee employee=this.employeeService.selectOne(empId);
		//所属部门下拉列表显示的所有值
		List<DepartInfo> departInfo=this.departInfoService.list(-1, new DepartInfo()).getList();
		
		ModelAndView mv=new ModelAndView("employee/edit");
		mv.addObject("employee", employee).
		addObject("departInfo", departInfo);
		
		return mv;  //下拉列表修改
	}
	
	/**
	 *	 修改页面处理
	 * @param employee
	 * @return
	 */
	@PostMapping("/modify")
	public ModelAndView modify(Employee employee,MultipartFile files) {
		
		this.employeeService.modify(employee, files);
		ModelAndView mv=new ModelAndView("redirect:/employee/list");
		
		return mv;
	}
	
	/**
	 * 	删除处理
	 * @param empId
	 * @return
	 */
	@GetMapping("/remove")
	public ModelAndView remove(Integer empId) {
		
		this.employeeService.remove(empId);
		
		ModelAndView mv=new ModelAndView("redirect:/employee/list");
		
		return mv;
	}
	
	/**
	 * 	批量删除
	 * @param empIds
	 * @return
	 */
	@RequestMapping("/removes")
	public ModelAndView removes(Integer[] empIds) {
		
		this.employeeService.removes(empIds);
		
		ModelAndView mv=new ModelAndView("redirect:/employee/list");
		
		return mv;
	}

	/**
	 * 安全退出
	 * @return
	 */
	@GetMapping("/exit")
	public ModelAndView exit() {
		
		session=this.request.getSession();
		session.removeAttribute("emp");
		
		ModelAndView mv=new ModelAndView("redirect:/employee/login");
		
		return mv;
	}
	
	/**
	 * 用户个人中心界面显示
	 * @return
	 */
	@RequestMapping("/center")
	public ModelAndView center() {
		
		ModelAndView mv=new ModelAndView("employee/center");
		
		return mv;
	}
	
	/**
	 * 修改用户状态
	 * @return
	 */
	@RequestMapping("/updateState")
	public ModelAndView updateState(Integer empId) {
		
		this.employeeService.updateState(empId);
		ModelAndView mv=new ModelAndView("redirect:list");
		
		return mv;
	}
	
	/**
	 * 修改用户密码页面显示
	 * @param employee
	 * @return
	 */
	@RequestMapping("/updatePassword")
	public ModelAndView updatePassword() {
		
		ModelAndView mv=new ModelAndView("employee/updatepassword");
		
		return mv;
	}
	
	/**
	 * 修改用户密码处理
	 * @return
	 */
	@RequestMapping("/toUpdatePassword")
	public ModelAndView toUpdatePassword(String newpwd) {
		
		Employee employee=(Employee) this.session.getAttribute("emp");
		this.employeeService.updatePassword(employee.getEmpId(),newpwd);
		
		ModelAndView mv=new ModelAndView("redirect:login");
		
		return mv;
	}
	
	/**
	 * 输出验证码图片
	 * @param request
	 * @param response
	 */
	@RequestMapping("/image")
	public void getCodeImage(HttpServletRequest request,HttpServletResponse response)
	{
		response.setContentType("image/jpeg");//设置响应类型,告诉浏览器输出的内容为图片
	        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
	        response.setHeader("Cache-Control", "no-cache");
	        response.setDateHeader("Expire", 0);
	        RandomValidateCode randomValidateCode = new RandomValidateCode();
	        try {
	            randomValidateCode.getRandcode(request, response);//输出图片方法
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	
	
}
