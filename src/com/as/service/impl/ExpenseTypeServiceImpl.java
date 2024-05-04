package com.as.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.dao.ExpenseTypeMapper;
import com.as.domain.ExpenseType;
import com.as.service.ExpenseTypeService;
import com.as.util.Common;
import com.as.util.Pages;

/**
 * 	报销的逻辑层实现类
 * @author 小陈
 *
 */
@Service //IOC控制反转,实现ExpenseServiceImpl的创建和管理
public class ExpenseTypeServiceImpl implements ExpenseTypeService{
	
	//DI 依赖注入,实现ExpenseTypeMapper接口并赋值
	@Autowired
	private ExpenseTypeMapper expenseTypeMapper;
	
	@Override
	public void append(String extypename) {
		
		this.expenseTypeMapper.insert(extypename);
	}
	
	@Override
	public void remove(Integer extypeid) {
		
		this.expenseTypeMapper.delete(extypeid);
	}
	
	@Override
	public void modify(ExpenseType expenseType) {
		
		this.expenseTypeMapper.update(expenseType);
	}
	
	@Override
	public Pages<ExpenseType> list(Integer currPage,ExpenseType expenseType){
		
		List<ExpenseType> list= this.expenseTypeMapper.select((currPage-1)*Common.PAGESIZE, Common.PAGESIZE, expenseType);
		int rowCount=this.expenseTypeMapper.getRowCount(expenseType);
		Pages<ExpenseType> pages=new Pages<ExpenseType>(currPage, rowCount, Common.PAGESIZE, list);
		
		return pages;
	}
	
	@Override
	public int getRowCount(ExpenseType expenseType) {
		
		return this.expenseTypeMapper.getRowCount(expenseType);
	}
	
	@Override
	public ExpenseType selectById(Integer extypeid) {
		
		return this.expenseTypeMapper.selectOne(extypeid);
	}

	@Override
	public void removes(Integer[] extypeids) {
		
		this.expenseTypeMapper.deleteAll(extypeids);
	}
}
