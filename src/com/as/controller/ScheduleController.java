package com.as.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.as.domain.Schedule;
import com.as.service.ScheduleService;
import com.as.util.Pages;

/**
 * 	日程表模块的控制层
 * @author 小陈
 *
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController extends BaseController{

	// 依赖注入
	@Autowired
	private ScheduleService scheduleService;

	/**
	 * ajax
	 * @param schedule
	 * @return
	 */
	@RequestMapping("/ajaxselect")
	@ResponseBody
	public List<Schedule> select(Schedule schedule){
		
		List<Schedule> list=this.scheduleService.list(-1, schedule, session).getList();
		return list;
	}
	
	/**
	 * 列表页面显示
	 * @param currPage
	 * @param schedule
	 * @return
	 */
	@RequestMapping("/list")
//	@ResponseBody
	public ModelAndView list(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, Schedule schedule) {
		
		ModelAndView mv=null;
		this.session=this.request.getSession();
		
		//判断是否登录
		if(session.getAttribute("emp")==null) {
			
			mv=new ModelAndView("employee/login");
		}else {
			
			//模糊查询为空时,页数1/0, limit出错
			if(currPage==0) currPage=1;
			
			Pages<Schedule> pages = this.scheduleService.list(currPage, schedule, session);
			
			mv = new ModelAndView("schedule/list");
			mv.addObject("pages", pages).addObject("schedule", schedule);
		}

		return mv;
	}
	
	/**
	 * 新增页面显示
	 * @return
	 */
	@GetMapping("/append")
	public ModelAndView append() {
		
		ModelAndView mv=new ModelAndView("schedule/append");
		
		return mv;
	}
	
	/**
	 * 新增页面处理
	 * @param schedule
	 * @return
	 */
	@PostMapping("/append")
	public ModelAndView append(Schedule schedule) {
		
		this.session=this.request.getSession();
		
		this.scheduleService.append(schedule, session);
		ModelAndView mv=new ModelAndView("redirect:/schedule/list");
		
		return mv;
	}
	
	/**
	 * 查看日程详情
	 * @param scheduleid
	 * @return
	 */
	@GetMapping("/detail")
	public ModelAndView edit(Integer scheduleid) {
		
		Schedule schedule=this.scheduleService.selectById(scheduleid);
		
		ModelAndView mv=new ModelAndView("schedule/detail");
		mv.addObject("schedule", schedule);
		
		return mv;
	}
	
	/**
	 * 修改请求处理	
	 * @param schedule
	 * @return
	 */
	@PostMapping("/modify")  // 表单中name名字与对象的属性名相同时,自动赋值
	public ModelAndView modify(Schedule schedule) {
		
		this.scheduleService.modify(schedule);
		ModelAndView mv=new ModelAndView("redirect:/schedule/list");
		
		return mv;
	}
	
	/**
	 * 删除
	 * @param scheduleid
	 * @return
	 */
	@GetMapping("/remove")
	public ModelAndView remove(Integer scheduleid) {
		
		this.scheduleService.remove(scheduleid);
		ModelAndView mv=new ModelAndView("redirect:/schedule/list");
		
		return mv;
	}
	
	
	/**
	 * 批量删除
	 * @param scheduleids
	 * @return
	 */
	@GetMapping("/removes")
	public ModelAndView removes(Integer[] scheduleids) {
		
		this.scheduleService.removes(scheduleids);
		ModelAndView mv=new ModelAndView("redirect:/schedule/list");
		
		return mv;
	}

}
