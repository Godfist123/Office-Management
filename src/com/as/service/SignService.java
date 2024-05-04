package com.as.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.as.domain.Sign;
import com.as.util.Pages;


/**
 * 签到业务逻辑层接口
 * @author 小陈
 *
 */
public interface SignService {

	
	/**
	 * 条件分页查询
	 * @param skip
	 * @param take
	 * @param sign
	 * @param session 
	 * @return
	 */
	public Pages<Sign> list(Integer currPage,Sign sign);
	
	
	/**
	 * 获取记录条数
	 * @param sign
	 */
	public int getRowCount(Sign sign);
	
	/**
	 * 签到
	 * @param sign
	 */
	public void signIn(Sign sign,HttpSession session);
	
	
	/**
	 * 查询当前登录用户当天的签到状态
	 * @param empid
	 * @param signtime
	 * @return
	 */
	public Integer selectSignTag(Integer empid,String signtime,HttpSession session);
	
	
	/**
	 * 签退
	 * @param sign
	 */
	public void signOut(Sign sign);
	
	/**
	 * 获取实际出勤天数
	 */
	public Integer getSignDay(Sign sign);
	
	/**
	 * 详情显示
	 * @param sign
	 * @return
	 */
	public List<Sign> detail(Sign sign);
	
}
