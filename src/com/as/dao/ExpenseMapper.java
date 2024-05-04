package com.as.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.as.domain.Expense;

/**
 * 报销数据访问层
 * @author 小陈
 *
 */
public interface ExpenseMapper {

	/**
	 * 新增
	 * @param expense
	 */
	public void insert(Expense expense);
	
	/**
	 * 删除
	 * @param expenseid
	 */
	public void delete(Integer expenseid);
	
	/**
	 * 修改
	 * @param expense
	 */
	public void update(Expense expense);
	
	/**
	 * 分页查询
	 * @param skip
	 * @param take
	 * @param expense
	 * @return
	 */
	public List<Expense> select(@Param("skip")Integer skip,@Param("take")Integer take,@Param("expense")Expense expense);
	
	/**
	 * 获取记录条数
	 * @param expense
	 * @return
	 */
	public int getRowCount(@Param("expense")Expense expense);
	
	/**
	 * 根据新闻id查询
	 * @param expenseid
	 * @return
	 */
	public Expense selectOne(Integer expenseid);
	
	/**
	 * 批量删除
	 * @param expenseids
	 */
	public void deleteAll(@Param("expenseids")Integer[] expenseids);
	
	/**
	 * 修改状态为提交
	 * @param expenseid
	 */
	public void updateState(Integer expenseid);
	
	/**
	 * 审批单据
	 */
	public void approve(Expense expense);
	
	
	
	
}
