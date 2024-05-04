package com.as.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.dao.DepartInfoMapper;
import com.as.domain.DepartInfo;
import com.as.service.DepartInfoService;
import com.as.util.Common;
import com.as.util.Pages;

/**
 *	 部门信息表的业务逻辑层实现类
 * @author 小陈
 *
 */
@Service  //IOC控制反转,实现DepartInfoServiceImpl的创建和管理
public class DepartInfoServiceImpl implements DepartInfoService{

	//DI 依赖注入,实现DepartInfoMapper接口并赋值
	@Autowired
	private DepartInfoMapper departInfoMapper;
	
	
	@Override
	public void append(DepartInfo departInfo) {
		
		this.departInfoMapper.insert(departInfo);
	}
	
	@Override
	public void remove(Integer departId) {
		
		this.departInfoMapper.delete(departId);
	}
	
	@Override
	public void modify(DepartInfo departInfo) {
		
		this.departInfoMapper.update(departInfo);
	}
	
	@Override
	public Pages<DepartInfo> list(Integer currPage,DepartInfo departInfo){
		
		List<DepartInfo> list=this.departInfoMapper.select((currPage-1)*Common.PAGESIZE, Common.PAGESIZE, departInfo);
		
		int rowCount=this.departInfoMapper.getRowCount(departInfo);
		Pages<DepartInfo> pages=new Pages<DepartInfo>(currPage, rowCount, Common.PAGESIZE, list);
		
		return pages;
	}
	
	@Override
	public DepartInfo selectOne(Integer departId) {
		
		return this.departInfoMapper.selectById(departId);
	}

	@Override
	public void removes(Integer[] departIds) {

		this.departInfoMapper.deleteAll(departIds);
		
	}
	
	
}
