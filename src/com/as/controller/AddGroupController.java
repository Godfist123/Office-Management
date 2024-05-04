package com.as.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.as.domain.AddrGroup;
import com.as.service.AddrGroupService;
import com.as.util.Pages;

/**
 * 通讯组模块的控制层
 * @author 小陈
 *
 */
@Controller
@RequestMapping("/addrgroup")
public class AddGroupController {

	
	@Autowired
	private AddrGroupService addrGroupService;
	
	/**
	 * 显示主页面
	 * @param currPage
	 * @param addrGroup
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value = "currPage",defaultValue = "1")Integer currPage,AddrGroup addrGroup) {
		
		if(currPage==0) currPage=1;
		
		Pages<AddrGroup> pages=this.addrGroupService.list(currPage, addrGroup);
		
		Pages<AddrGroup> list=this.addrGroupService.list(-1, new AddrGroup());
		
		ModelAndView mv=new ModelAndView("addrgroup/list");
		mv.addObject("pages", pages).addObject("addrGroup", addrGroup).addObject("list", list.getList());
		
		return mv;
	}
	
	/**
	 * 新增页面显示
	 * @return
	 */
	@GetMapping("/append")
	public ModelAndView append() {
		
		ModelAndView mv=new ModelAndView("addrgroup/append");
		
		return mv;
	}
	
	/**
	 * 新增页面处理
	 * @param addrgroup
	 * @return
	 */
	@PostMapping("/append")
	public ModelAndView append(AddrGroup addrGroup) {
		
		this.addrGroupService.append(addrGroup);
		
		ModelAndView mv=new ModelAndView("redirect:/addrgroup/list");
		
		return mv;
	}
	
	/**
	 * 修改页面显示
	 * @return
	 */
	@GetMapping("/edit")
	public ModelAndView edit(Integer groupid) {
		
		AddrGroup addrGroup=this.addrGroupService.selectById(groupid);
		
		ModelAndView mv=new ModelAndView("addrgroup/edit");
		mv.addObject("addrGroup", addrGroup);
		
		return mv;
	}
	
	/**
	 * 修改页面处理
	 * @param addrGroup
	 * @return
	 */
	@PostMapping("/modify")
	public ModelAndView modify(AddrGroup addrGroup) {
		
		this.addrGroupService.modify(addrGroup);
		
		ModelAndView mv=new ModelAndView("redirect:/addrgroup/list");
		
		return mv;
	}
	
	/**
	 * 删除
	 * @param addrgroupId
	 * @return
	 */
	@GetMapping("/remove")
	public ModelAndView remove(Integer groupid) {
		
		this.addrGroupService.remove(groupid);
		
		ModelAndView mv=new ModelAndView("redirect:/addrgroup/list");
		
		return mv;
	}
	
	/**
	 * 批量删除
	 * @param newsids
	 * @return
	 */
	@RequestMapping("/removes")
	public ModelAndView removes(Integer[] groupids) {
		
		this.addrGroupService.removes(groupids);
		
		ModelAndView mv=new ModelAndView("redirect:/addrgroup/list");
		
		return mv;
	}
	
}
