package com.as.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.as.domain.NewsType;
import com.as.service.NewsTypeService;
import com.as.util.Pages;

/**
 * 	新闻栏目模块的控制层
 * @author 小陈
 *
 */
@Controller
@RequestMapping("/newstype")
public class NewsTypeController {
	
	// 依赖注入
	@Autowired
	private NewsTypeService newsTypeService;
	
	/**
	 * 列表页面显示
	 * @param currPage
	 * @param newsType
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value = "currPage",defaultValue = "1")Integer currPage,NewsType newsType) {
		
		//模糊查询为空时,页数1/0, limit出错
		if(currPage==0) currPage=1;
			
		Pages<NewsType> pages=this.newsTypeService.list(currPage, newsType);
		
		ModelAndView mv=new ModelAndView("newstype/list");
		
		mv.addObject("pages", pages);
		
		return mv;
	}
	
	/**
	 * 新增页面显示
	 * @return
	 */
	@GetMapping("/append")
	public ModelAndView append() {
		
		ModelAndView mv=new ModelAndView("newstype/append");
		
		return mv;
	}
	
	/**
	 * 新增页面处理
	 * @param newsType
	 * @return
	 */
	@PostMapping("/append")
	public ModelAndView append(NewsType newsType) {
		
		this.newsTypeService.append(newsType);
		
		ModelAndView mv=new ModelAndView("redirect:/newstype/list");
		
		return mv;
	}
	
	/**
	 * 修改页面显示
	 * @return
	 */
	@GetMapping("/edit")
	public ModelAndView edit(Integer newsTypeId) {
		
		NewsType newsType=this.newsTypeService.selectById(newsTypeId);
		
		ModelAndView mv=new ModelAndView("newstype/edit");
		mv.addObject("newsType", newsType);
		
		return mv;
	}
	
	/**
	 * 修改页面处理
	 * @param newsType
	 * @return
	 */
	@PostMapping("/modify")
	public ModelAndView modify(NewsType newsType) {
		
		this.newsTypeService.modify(newsType);
		
		ModelAndView mv=new ModelAndView("redirect:/newstype/list");
		
		return mv;
	}
	
	/**
	 * 删除
	 * @param newsTypeId
	 * @return
	 */
	@GetMapping("/remove")
	public ModelAndView remove(Integer newsTypeId) {
		
		this.newsTypeService.remove(newsTypeId);
		
		ModelAndView mv=new ModelAndView("redirect:/newstype/list");
		
		return mv;
	}
	
	/**
	 * 批量删除
	 * @param newsTypeIds
	 * @return
	 */
	@RequestMapping("/removes")
	public ModelAndView removes(Integer[] newsTypeIds) {
		
		this.newsTypeService.removes(newsTypeIds);
		
		ModelAndView mv=new ModelAndView("redirect:/newstype/list");
		
		return mv;
		
	}
	
	
}
