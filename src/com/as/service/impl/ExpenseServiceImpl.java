package com.as.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.dao.ExpenseMapper;
import com.as.domain.Expense;
import com.as.service.ExpenseService;
import com.as.util.Common;
import com.as.util.Pages;

/**
 * 	报销的逻辑层实现类
 * @author 小陈
 *
 */
@Service //IOC控制反转,实现ExpenseServiceImpl的创建和管理
public class ExpenseServiceImpl implements ExpenseService{
	
	//DI 依赖注入,实现ExpenseMapper接口并赋值
	@Autowired
	private ExpenseMapper expenseMapper;
	
	@Override
	public void append(Expense expense) {
		
		this.expenseMapper.insert(expense);
	}
	
	@Override
	public void remove(Integer newsTypeId) {
		
		this.expenseMapper.delete(newsTypeId);
	}
	
	@Override
	public void modify(Expense expense) {
		
		this.expenseMapper.update(expense);
	}
	
	@Override
	public Pages<Expense> list(Integer currPage,Expense expense,HttpSession session){
		
		List<Expense> list= this.expenseMapper.select((currPage-1)*Common.PAGESIZE, Common.PAGESIZE, expense);
		int rowCount=this.expenseMapper.getRowCount(expense);
		Pages<Expense> pages=new Pages<Expense>(currPage, rowCount, Common.PAGESIZE, list);
		
		return pages;
	}
	
	@Override
	public int getRowCount(Expense expense) {
		
		return this.expenseMapper.getRowCount(expense);
	}
	
	@Override
	public Expense selectById(Integer expenseid) {
		
		return this.expenseMapper.selectOne(expenseid);
	}

	@Override
	public void removes(Integer[] expenseids) {
		
		this.expenseMapper.deleteAll(expenseids);
	}

	@Override
	public void submit(Integer expenseid) {

		this.expenseMapper.updateState(expenseid);
		
	}

	@Override
	public void approve(Expense expense) {

		this.expenseMapper.approve(expense);
	}
}
