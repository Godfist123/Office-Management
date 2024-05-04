package com.as.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.dao.ExpenseDetailMapper;
import com.as.domain.ExpenseDetail;
import com.as.service.ExpenseDetailService;

/**
 * 报销详情业务逻辑实现类
 * @author 小陈
 *
 */
@Service
public class ExpenseDetailServiceImpl implements ExpenseDetailService {
	
	@Autowired
	private ExpenseDetailMapper expenseDetailMapper;

	@Override
	public void append(Integer[] extypeid,Integer[] money,String[] costdesc,Integer expenseid) {

		List<ExpenseDetail> list=new ArrayList<ExpenseDetail>();
		
		//循环添加
		for (int i = 0; i < money.length; i++) {
			
			ExpenseDetail expenseDetail=new ExpenseDetail();
			expenseDetail.setExpenseid(expenseid);
			expenseDetail.setCostdesc(costdesc[i]);
			expenseDetail.setMoney(money[i]);
			expenseDetail.setExtypeid(extypeid[i]);
			
			list.add(expenseDetail);
		}
		this.expenseDetailMapper.insert(list);
	}
	
	@Override
	public List<ExpenseDetail> selectByExpenseId(Integer expenseid) {

		return this.expenseDetailMapper.selectByExpenseId(expenseid);
	}

	@Override
	public void modify(Integer[] id,Integer[] extypeid,Integer[] money,String[] costdesc,Integer expenseid) {
		
		List<ExpenseDetail> list=new ArrayList<ExpenseDetail>();
		
		//循环修改
		for (int i = 0; i < money.length; i++) {
			
			ExpenseDetail expenseDetail=new ExpenseDetail();
			expenseDetail.setCostdesc(costdesc[i]);
			expenseDetail.setMoney(money[i]);
			expenseDetail.setExtypeid(extypeid[i]);
			expenseDetail.setId(id[i]);
			expenseDetail.setExpenseid(expenseid);
			
			list.add(expenseDetail);
		}
		
		this.expenseDetailMapper.update(list,expenseid);
		
		
	}

	@Override
	public void remove(Integer id) {
		this.expenseDetailMapper.delete(id);
	}



}
