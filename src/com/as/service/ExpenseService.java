package com.as.service;

import javax.servlet.http.HttpSession;

import com.as.domain.Expense;
import com.as.util.Pages;

/**
 *	报销的业务逻辑接口
 * @author 小陈
 *
 */
public interface ExpenseService {

	/**
	 * 新增
	 * @param expense
	 */
	public void append(Expense expense);
	
	/**
	 * 删除
	 * @param expenseid
	 */
	public void remove(Integer expenseid);
	
	/**
	 * 修改
	 * @param expense
	 */
	public void modify(Expense expense);
	
	/**
	 * 分页查询
	 * @param skip
	 * @param take
	 * @param expense
	 * @return
	 */
	public Pages<Expense> list(Integer currPage,Expense expense,HttpSession session);
	
	/**
	 * 获取记录条数
	 * @param expense
	 * @return
	 */
	public int getRowCount(Expense expense);
	
	/**
	 * 根据新闻栏目id查询
	 * @param expenseid
	 * @return
	 */
	public Expense selectById(Integer expenseid);
	
	/**
	 * 批量删除
	 * @param expenseids
	 */
	public void removes(Integer[] expenseids);
	
	
	/**
	 * 报销单据提交
	 * @param expenseid
	 */
	public void submit(Integer expenseid);
	
	
	/**
	 * 审批单据
	 */
	public void approve(Expense expense);
	
}
