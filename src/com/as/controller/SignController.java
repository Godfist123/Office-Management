package com.as.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.as.domain.DepartInfo;
import com.as.domain.Employee;
import com.as.domain.Sign;
import com.as.service.DepartInfoService;
import com.as.service.SignService;
import com.as.util.DateUtils;
import com.as.util.Pages;

/**
 * 签到模块的控制层
 * @author 小陈
 *
 */
@Controller
@RequestMapping("/sign")
public class SignController extends BaseController{
	
	@Autowired
	private SignService signService;
	
	@Autowired
	private DepartInfoService departInfoService;
	
	/**
	 * 显示主界面
	 * @param currPage
	 * @param sign
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value = "currPage",defaultValue = "1")Integer currPage,Sign sign) {
		
		
		Pages<Sign> pages=this.signService.list(currPage, sign);
		List<DepartInfo> listDepart=this.departInfoService.list(-1, new DepartInfo()).getList();
		
		if(sign.getBegintime()==null) sign.setBegintime("2021-11-20");
		if(sign.getEndtime()==null) sign.setEndtime("2021-12-01");
		
		//获取时间差,得到应出勤天数
		long sub= DateUtils.dateDifference(sign.getBegintime(), sign.getEndtime());
		
		//当前登录的员工
		Employee employee=(Employee)session.getAttribute("emp"); 
		//获取用户实际出勤天数
		Sign sign2=new Sign();
		sign2.setEmpid(employee.getEmpId());
		sign2.setBegintime(sign.getBegintime());
		sign2.setEndtime(sign.getEndtime());
		int dayCount=this.signService.getSignDay(sign2);
		
		ModelAndView mv=new ModelAndView("sign/list");
		mv.addObject("pages", pages)
		.addObject("sign", sign)	
		.addObject("listDepart", listDepart)
		.addObject("sub", sub)
		.addObject("dayCount", dayCount);
		
		return mv;
	}
	
	/**
	 *	 考勤打卡页面显示
	 * @return
	 */
	@GetMapping("/append")
	public ModelAndView append(Integer empid, String signtime) {
		
		//获取当前登录的用户
		this.session=this.request.getSession();
		
		int signtag=this.signService.selectSignTag(empid, signtime, session);
		
		ModelAndView mv=new ModelAndView("sign/append");
		mv.addObject("signtag", signtag);
		
		return mv;
	}
	
	/**
	 * 签到处理
	 * @param sign
	 */
	@ResponseBody
	@RequestMapping("/signin")
	public void append(Sign sign){
		
		//获取当前登录的用户
		this.session=this.request.getSession();
		
		this.signService.signIn(sign, session);
		
	}

	
	/**
	 * 签退处理
	 * @param sign
	 */
	@ResponseBody
	@RequestMapping("/signout")
	public void signout(Sign sign){
		
		this.signService.signOut(sign);
		
	}
	
	/**
	 * 详情页显示
	 * @param currPage
	 * @param sign
	 * @return
	 */
	@RequestMapping("/detail")
//	@ResponseBody
		
	public String detail(Sign sign,Integer empid){
		
//		sign.setEmpid(empid);
//		List<Sign> list = this.signService.list(-1, sign).getList();
		
//		ModelAndView mv = new ModelAndView("sign/detail");
//		mv.addObject("list", list);

		return "sign/detail";
	}
	
	/**
	 * 详情页数据  ajax
	 * @param sign
	 * @return
	 */
	@RequestMapping("/ajaxselect")
	@ResponseBody
	public List<Sign> ajaxselect(Sign sign) {
		
		List<Sign> list=this.signService.detail(sign);
		
		return list;
	}

}
