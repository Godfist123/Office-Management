package com.as.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
public class BaseController {
	

	/**
	 * 重定向字符串
	 */
	protected static final String REDIRECT="redirect:";

	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected Map<String,Object> map;
	protected Model model;
	
	//在这个注解的时方法会在每个controller方法执行前执行
	@ModelAttribute
	private void init(HttpServletRequest request,HttpServletResponse response,Map<String,Object> map,Model model) {
		//System.out.println("会在所有方法执行前执行！！");
		this.request=request;
		this.response=response;
		this.session=request.getSession();	
		this.map=map;
		this.model=model;
		
	}
	
	/**
	 * 获取项目的物理路径
	 * @return 路径
	 */
	protected String getRealPath() {
		return session.getServletContext().getRealPath("/");
	}
	
	
		//在表单提交时先执行这个注解的方法，进行表单数据的转换
		@InitBinder
		public void initBinder(HttpServletRequest request,ServletRequestDataBinder binder)throws Exception 
		{   
			DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  
			CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);  
			binder.registerCustomEditor(Date.class, dateEditor); 
		} 
		
		/**
		 * 字符串重新编码utf8
		 * @param msg
		 * @return
		 */
	public String stringEncode(String msg) {
		
		String encode="";
		try {
			encode=URLEncoder.encode(msg,"utf8");
		}catch(UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		return encode;
	}
	
}





