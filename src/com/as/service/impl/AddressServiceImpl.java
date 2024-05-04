package com.as.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.dao.AddressMapper;
import com.as.domain.Address;
import com.as.service.AddressService;
import com.as.util.Common;
import com.as.util.Pages;

/**
 * 通讯录业务逻辑层实现类
 * @author 小陈
 *
 */
@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressMapper addressMapper;

	
	@Override
	public void append(Address address){
		
		this.addressMapper.insert(address);
	}
	
	@Override
	public void remove(Integer addressid){
		
		this.addressMapper.delete(addressid);
	}
	
	@Override
	public void modify(Address address){
		
		this.addressMapper.update(address);
	}
	
	@Override
	public Pages<Address> list(Integer currPage,Address address){
		
		 //查询时初始页面没有值
		 if (address.getGroupid()==null) address.setGroupid(0);
		 
		List<Address> list=this.addressMapper.select((currPage-1)*Common.PAGESIZE, Common.PAGESIZE, address);
		int rowCount=this.addressMapper.getRowCount(address);
		Pages<Address> pages=new Pages<Address>(currPage, rowCount, Common.PAGESIZE, list);
		
		return pages;
	}
	
	
	@Override
	public Address selectById(Integer addressid){
		
		return this.addressMapper.selectById(addressid);
	}

	@Override
	public void removes(Integer[] addressids) {
		
		this.addressMapper.deleteAll(addressids);		
	}
	
}
