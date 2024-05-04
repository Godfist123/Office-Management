package com.as.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 报销类型模块的控制层
 * @author 小陈
 *
 */
@Controller
@RequestMapping("/expensetype")
public class ExpenseTypeController {

	/**
	 * 新增报销类型
	 * @param extypename
	 * @return
	 */
	@GetMapping("/append")
	public ModelAndView append(String extypename) {
		
		ModelAndView mv=new ModelAndView();
		return mv;
		
	}
}
