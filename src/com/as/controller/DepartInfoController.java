package com.as.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.as.domain.DepartInfo;
import com.as.service.DepartInfoService;
import com.as.util.Pages;

/**
 * 	部门模块的控制层
 * @author 小陈
 *
 */
@Controller
@RequestMapping("/departinfo")
public class DepartInfoController {
 
	// 依赖注入
	@Autowired
	private DepartInfoService departInfoService;

	/**
	 * 列表页面显示
	 * @param currPage
	 * @param departInfo
	 * @return
	 */
	@RequestMapping("/list")
//	@ResponseBody // ajax方法,测试用
	public ModelAndView list(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, DepartInfo departInfo) {
		
		//模糊查询为空时,页数1/0, limit出错
		if(currPage==0) currPage=1;
		
		ModelAndView mv = new ModelAndView("departinfo/list");
		Pages<DepartInfo> pages = this.departInfoService.list(currPage, departInfo);
		//链式写法
		mv.addObject("pages", pages).addObject("departinfo", departInfo);

		return mv;
	}
	
	/**
	 * 新增页面显示
	 * @return
	 */
	@GetMapping("/append")
	public ModelAndView append() {
		
		ModelAndView mv=new ModelAndView("departinfo/append");
		
		return mv;
	}
	
	/**
	 * 新增页面处理
	 * @param departInfo
	 * @return
	 */
	@PostMapping("/append")
	public ModelAndView append(DepartInfo departInfo) {
		
		this.departInfoService.append(departInfo);
		ModelAndView mv=new ModelAndView("redirect:/departinfo/list");
		
		return mv;
	}
	
	/**
	 * 修改页面显示
	 * @param departId
	 * @return
	 */
	@GetMapping("/edit")
	public ModelAndView edit(Integer departId) {
		
		DepartInfo departInfo=this.departInfoService.selectOne(departId);
		
		ModelAndView mv=new ModelAndView("departinfo/edit");
		mv.addObject("departInfo", departInfo);
		
		return mv;
	}
	
	/**
	 * 修改页面处理
	 * @param departInfo
	 * @return
	 */
	@PostMapping("/modify")  // 表单中name名字与对象的属性名相同时,自动赋值
	public ModelAndView modify(DepartInfo departInfo) {
		
		this.departInfoService.modify(departInfo);
		ModelAndView mv=new ModelAndView("redirect:/departinfo/list");
		
		return mv;
	}
	
	/**
	 * 删除
	 * @param departId
	 * @return
	 */
	@GetMapping("/remove")
	public ModelAndView remove(Integer departId) {
		
		this.departInfoService.remove(departId);
		ModelAndView mv=new ModelAndView("redirect:/departinfo/list");
		
		return mv;
	}
	
	
	/**
	 * 批量删除
	 * @param departId
	 * @return
	 */
	@GetMapping("/removes")
	public ModelAndView removes(Integer[] departIds) {
		
		this.departInfoService.removes(departIds);
		ModelAndView mv=new ModelAndView("redirect:/departinfo/list");
		
		return mv;
	}

}
