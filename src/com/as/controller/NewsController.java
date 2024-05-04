package com.as.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.as.domain.Employee;
import com.as.domain.News;
import com.as.service.EmployeeService;
import com.as.service.NewsService;
import com.as.util.Pages;

/**
 * 	新闻模块的控制层
 * @author 小陈
 *
 */
@Controller
@RequestMapping("/news")
public class NewsController {
	
	// 依赖注入
	@Autowired
	private NewsService newsService;
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * 列表页面显示
	 * @param currPage
	 * @param news
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value = "currPage",defaultValue = "1")Integer currPage,News news) {
		
		//模糊查询为空时,页数1/0, limit出错
		if(currPage==0) currPage=1;
		
		Pages<News> pages=this.newsService.list(currPage, news);
		//显示查询作者的下拉列表
		List<News> listNews=this.newsService.list(-1, new News()).getList();
		
		ModelAndView mv=new ModelAndView("news/list");
		
		mv.addObject("pages", pages).addObject("listNews", listNews);
		
		return mv;
	}
	
	/**
	 * 新增页面显示
	 * @return
	 */
	@GetMapping("/append")
	public ModelAndView append() {
		
		List<News> listNews=this.newsService.list(-1, new News()).getList();
		List<Employee> listEmployee=this.employeeService.list(-1, new Employee()).getList();
		
		ModelAndView mv=new ModelAndView("news/append");
		mv.addObject("listEmployee", listEmployee)
		.addObject("listNews", listNews);
		
		return mv;
	}
	
	/**
	 * 新增页面处理
	 * @param news
	 * @return
	 */
	@PostMapping("/append")
	public ModelAndView append(News news) {
		
		this.newsService.append(news);
		
		ModelAndView mv=new ModelAndView("redirect:/news/list");
		
		return mv;
	}
	
	/**
	 * 修改页面显示
	 * @return
	 */
	@GetMapping("/edit")
	public ModelAndView edit(Integer newsid) {
		
		News news=this.newsService.selectById(newsid);
		//显示所有empname
		List<Employee> listEmployee=this.employeeService.list(-1, new Employee()).getList();
		List<News> listNews=this.newsService.list(-1, new News()).getList();
		
		ModelAndView mv=new ModelAndView("news/edit");
		mv.addObject("news", news)
		.addObject("listEmployee", listEmployee)
		.addObject("listNews", listNews);
		
		return mv;
	}
	
	/**
	 * 修改页面处理
	 * @param news
	 * @return
	 */
	@PostMapping("/modify")
	public ModelAndView modify(News news) {
		
		this.newsService.modify(news);
		
		ModelAndView mv=new ModelAndView("redirect:/news/list");
		
		return mv;
	}
	
	/**
	 * 删除
	 * @param newsid
	 * @return
	 */
	@GetMapping("/remove")
	public ModelAndView remove(Integer newsid) {
		
		this.newsService.remove(newsid);
		
		ModelAndView mv=new ModelAndView("redirect:/news/list");
		
		return mv;
	}
	
	/**
	 * 批量删除
	 * @param newsids
	 * @return
	 */
	@RequestMapping("/removes")
	public ModelAndView removes(Integer[] newsids) {
		
		this.newsService.removes(newsids);
		
		ModelAndView mv=new ModelAndView("redirect:/news/list");
		
		return mv;
	}
	
	/**
	 * 审核新闻
	 * @param newsid
	 * @return
	 */
	@RequestMapping("/examine")
	public ModelAndView removes(Integer newsid) {
		
		this.newsService.examine(newsid);
		
		ModelAndView mv=new ModelAndView("redirect:/news/list");
		
		return mv;
	}
	
	
}
