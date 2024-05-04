package com.as.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.dao.ScheduleMapper;
import com.as.domain.Employee;
import com.as.domain.Schedule;
import com.as.service.ScheduleService;
import com.as.util.Common;
import com.as.util.Pages;

/**
 * 	日程表业务逻辑层实现类
 * @author 小陈
 *
 */
@Service //IOC控制反转,实现UsersServiceImpl的创建和管理
public class ScheduleServiceImpl implements ScheduleService{
	
	//DI 依赖注入,实现UsersMapper接口并赋值
	@Autowired
	private ScheduleMapper scheduleMapper;
	
	@Override
	public void append(Schedule schedule,HttpSession session) {
		
		//获取当前登录的员工
		Employee employee=(Employee)session.getAttribute("emp");
		schedule.setEmpid(employee.getEmpId());

		this.scheduleMapper.insert(schedule);
	}

	@Override
	public void remove(Integer scheduleid) {

		this.scheduleMapper.delete(scheduleid);
	}

	@Override
	public void modify(Schedule schedule) {

		this.scheduleMapper.update(schedule);
	}
	@Override
	public Pages<Schedule> list(Integer currPage, Schedule schedule,HttpSession session) {

		//获取当前登录的员工id
		Employee employee=(Employee)session.getAttribute("emp");
		schedule.setEmpid(employee.getEmpId());
		
		List<Schedule> list=this.scheduleMapper.select((currPage-1)*Common.PAGESIZE, Common.PAGESIZE, schedule);
		int rowCount=this.scheduleMapper.getRowCount(schedule);
		Pages<Schedule> pages=new Pages<Schedule>(currPage, rowCount, Common.PAGESIZE, list);
		
		return pages;
	}

	@Override
	public int getRowCount(Schedule schedule) {

		return this.scheduleMapper.getRowCount(schedule);
	}
	
	@Override
	public Schedule selectById(Integer scheduleid) {
	
		return this.scheduleMapper.selectOne(scheduleid);
	}
	
	@Override
	public void removes(Integer[] scheduleids) {
	
		 this.scheduleMapper.deleteAll(scheduleids);
	}
}
