package com.as.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.dao.AddrGroupMapper;
import com.as.domain.AddrGroup;
import com.as.service.AddrGroupService;
import com.as.util.Common;
import com.as.util.Pages;

/**
 * 通讯录组业务逻辑实现类
 * @author 小陈
 *
 */
@Service
public class AddrGroupServiceImpl implements AddrGroupService {

	
	@Autowired
	private AddrGroupMapper addrGroupMapper;
	
	@Override
	public void append(AddrGroup addrGroup){
		
		this.addrGroupMapper.insert(addrGroup);
	}
	
	@Override
	public void remove(Integer groupid){
		
		this.addrGroupMapper.delete(groupid);
	}
	
	@Override
	public void modify(AddrGroup addrGroup){
		
		this.addrGroupMapper.update(addrGroup);
	}
	
	@Override
	public Pages<AddrGroup> list(Integer currPage,AddrGroup addrGroup){
		
		List<AddrGroup> list=this.addrGroupMapper.select((currPage-1)*Common.PAGESIZE, Common.PAGESIZE, addrGroup);
		int rowCount=this.addrGroupMapper.getRowCount(addrGroup);
		Pages<AddrGroup> pages=new Pages<AddrGroup>(currPage, rowCount, Common.PAGESIZE, list);
		
		return pages;
	}
	
	@Override
	public AddrGroup selectById(Integer groupid){
		
		return this.addrGroupMapper.selectOne(groupid);
	}

	@Override
	public void removes(Integer[] groupids) {
		
		this.addrGroupMapper.deleteAll(groupids);
	}

}
