package com.as.service;

import java.util.List;

import com.as.domain.ExpenseDetail;

/**
 *	报销详情的业务逻辑接口
 * @author 小陈
 *
 */
public interface ExpenseDetailService {

	/**
	 * 新增
	 * @param expenseDetail
	 */
	public void append(Integer[] extypeid,Integer[] money,String[] costdesc,Integer expenseid);
	
	/**
	 * 修改
	 * @param expenseDetail
	 */
	public void modify(Integer[] id,Integer[] extypeid,Integer[] money,String[] costdesc,Integer expenseid);
	
	/**
	 * 删除
	 * @param id
	 */
	public void remove(Integer id);
	
	/**
	 * 根据报销id查询
	 * @return
	 */
	public List<ExpenseDetail> selectByExpenseId(Integer expenseid);
	
	
	
	
//	/**
//	 * 修改
//	 * @param expenseDetail
//	 */
//	public void modify(ExpenseDetail expenseDetail);
//	
//	/**
//	 * 分页查询
//	 * @param skip
//	 * @param take
//	 * @param expenseDetail
//	 * @return
//	 */
//	public Pages<ExpenseDetail> list(Integer currPage,ExpenseDetail expenseDetail);
//	
//	/**
//	 * 获取记录条数
//	 * @param expenseDetail
//	 * @return
//	 */
//	public int getRowCount(ExpenseDetail expenseDetail);
//	
//	
//	/**
//	 * 批量删除
//	 * @param id
//	 */
//	public void removes(Integer[] id);
//	
}
