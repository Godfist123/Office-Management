package com.as.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.as.domain.ExpenseDetail;

/**
 * 报销详情数据访问层
 * @author 小陈
 *
 */
public interface ExpenseDetailMapper {

	/**
	 * 新增
	 * @param expenseDetail
	 */
	public void insert(List<ExpenseDetail> list);
	
	/**
	 * 修改
	 * @param expenseDetail
	 */
	public void update(@Param("list")List<ExpenseDetail> list,@Param("expenseid")Integer expenseid);
	
	
	/**
	 * 根据报销id查询
	 * @return
	 */
	public List<ExpenseDetail> selectByExpenseId(Integer expenseid);
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Integer id);
	
//	/**
//	 * 分页查询
//	 * @param expenseDetail
//	 * @return
//	 */
//	public List<ExpenseDetail> select(ExpenseDetail expenseDetail);
}
