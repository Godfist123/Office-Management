package com.as.service;

import javax.servlet.http.HttpSession;

import com.as.domain.Schedule;
import com.as.util.Pages;

/**
 *  日程表的业务逻辑接口
 * @author 小陈
 *
 */
public interface ScheduleService  {
	

	public void append(Schedule schedule,HttpSession session);

	public void remove(Integer scheduleid);
	
	public void modify(Schedule schedule);

	public Pages<Schedule> list(Integer currPage, Schedule schedule,HttpSession session);
	
	public int getRowCount(Schedule schedule);
	
	public Schedule selectById(Integer scheduleid);

	public void removes(Integer[] scheduleids);

}
