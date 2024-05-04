package com.as.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.as.domain.AddrGroup;
import com.as.domain.Address;
import com.as.domain.Employee;
import com.as.service.AddrGroupService;
import com.as.service.AddressService;
import com.as.service.EmployeeService;
import com.as.util.Pages;

/**
 * 通讯录的控制层
 * @author 小陈
 *
 */
@Controller
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	@Autowired
	private EmployeeService employeeService ;
	@Autowired
	private AddrGroupService addrGroupService;
	
	/**
	 * 显示主界面信息
	 * @param currPage
	 * @param address
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value = "currPage",defaultValue = "1")Integer currPage,Address address) {
		
		if(currPage==null) currPage=1;
		
		Pages<Address> pages=this.addressService.list(currPage, address);
		//显示关联的通讯组表的通讯组姓名
		Pages<AddrGroup> addrGroup=this.addrGroupService.list(-1, new AddrGroup());
		
		ModelAndView mv=new ModelAndView("address/list");
		mv.addObject("pages", pages)
		.addObject("addrGroup", addrGroup)
		.addObject("address", address); 
		
		return mv;
	}
	
	/**
	 * 新增页面显示
	 * @return
	 */
	@GetMapping("/append")
	public ModelAndView append() {
		
		Pages<Employee> employee=this.employeeService.list(-1, new Employee());
		Pages<AddrGroup> addrGroup=this.addrGroupService.list(-1, new AddrGroup());
		
		ModelAndView mv=new ModelAndView("address/append");
		mv.addObject("employee", employee)
		.addObject("addrGroup", addrGroup);
		
		return mv;
	}
	
	/**
	 * 新增页面处理
	 * @param address
	 * @return
	 */
	@PostMapping("/append")
	public ModelAndView append(Address address) {
		
		this.addressService.append(address);
		ModelAndView mv=new ModelAndView("redirect:/address/list");
		
		return mv;
	}
	
	/**
	 * 修改页面显示
	 * @param addressid
	 * @return
	 */
	@GetMapping("/edit")
	public ModelAndView edit(Integer addressid) {
		
		Pages<Employee> employee=this.employeeService.list(-1, new Employee());
		Pages<AddrGroup> addrGroup=this.addrGroupService.list(-1, new AddrGroup());
		Address address=this.addressService.selectById(addressid);
		
		ModelAndView mv=new ModelAndView("address/edit");
		mv.addObject("address",address )
		.addObject("employee",employee )
		.addObject("addrGroup",addrGroup );
		
		return mv;
	}
	
	/**
	 * 修改页面处理
	 * @param address
	 * @return
	 */
	@PostMapping("/modify")
	public ModelAndView modify(Address address) {
		
		this.addressService.modify(address);
		ModelAndView mv=new ModelAndView("redirect:/address/list");
		
		return mv;
	}
	
	/**
	 * 删除
	 * @param addressid
	 * @return
	 */
	@GetMapping("/remove")
	public ModelAndView remove(Integer addressid) {
		
		this.addressService.remove(addressid);
		ModelAndView mv=new ModelAndView("redirect:/address/list");
		
		return mv;
	}
	
	/**
	 * 批量删除
	 * @param addressid
	 * @return
	 */
	@GetMapping("/removes")
	public ModelAndView removes(Integer[] addressids){
	
		this.addressService.removes(addressids);
		ModelAndView mv=new ModelAndView("redirect:/address/list");
		
		return mv;
	}
}
