package com.as.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录的拦截器
 * @author 小陈
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	//控制器方法执行后,视图渲染也结束后,被执行
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
//		System.out.println("控制器方法执行后,视图渲染也结束后,被执行");
		
	}

	//控制器方法执行后,被执行
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
//		System.out.println("控制器方法执行后,被执行");

	}

	//控制器方法执行前,返回值表示是否中断后续操作,返回值true,继续向下执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

		//得到session
		HttpSession session=request.getSession();
		
		//判断用户是否登录
		if(session.getAttribute("emp")==null) {
			
			//重定向到登录页面
			response.sendRedirect("/oa/employee/login");
			
			return false;
		}else {
			return true;
		}
	}

}
