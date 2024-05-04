package com.as.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.dao.SignMapper;
import com.as.domain.Employee;
import com.as.domain.Sign;
import com.as.service.SignService;
import com.as.util.Common;
import com.as.util.DateUtils;
import com.as.util.Pages;

@Service
public class SignServiceImpl implements SignService {

	@Autowired
	private SignMapper signMapper;
	
	
	@Override
	public Pages<Sign> list(Integer currPage, Sign sign) {
		
		if(currPage==null) currPage=1;
		if(sign.getDepartid()==null) sign.setDepartid(0);
		
		List<Sign> list=this.signMapper.select(Common.PAGESIZE*(currPage-1), Common.PAGESIZE, sign);
		
		int rowCount=this.signMapper.getRowCount(sign);
		Pages<Sign> pages=new Pages<Sign>(currPage, rowCount, Common.PAGESIZE, list);
		return pages;
	}


	@Override
	public void signIn(Sign sign,HttpSession session) {
		
		//获取当前登录的员工id
		Employee employee=(Employee)session.getAttribute("emp");
		sign.setEmpid(employee.getEmpId());

		this.signMapper.insert(sign);
	}
	

	@Override
	public void signOut(Sign sign) {

		this.signMapper.update(sign);
	}


	@Override
	public Integer selectSignTag(Integer empid, String signtime,HttpSession session) {
		
		signtime=DateUtils.getLocalNow();
		
		//获取当前登录的员工id
		Employee employee=(Employee)session.getAttribute("emp");
		empid=employee.getEmpId();
		
		return this.signMapper.selectSignTag(empid, signtime)==null?0:this.signMapper.selectSignTag(empid, signtime);
	}

	@Override
	public int getRowCount(Sign sign) {

		return this.signMapper.getRowCount(sign);
		
	}

	@Override
	public Integer getSignDay(Sign sign) {
		
		return this.signMapper.getSignDay(sign);
	}
	
	@Override
	public List<Sign> detail(Sign sign){
		
		return this.signMapper.detail(sign);
	}

}
