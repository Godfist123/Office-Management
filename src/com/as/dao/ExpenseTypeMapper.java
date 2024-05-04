package com.as.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.as.domain.ExpenseType;

/**
 * 报销数据访问层
 * @author 小陈
 *
 */
public interface ExpenseTypeMapper {

	/**
	 * 新增
	 * @param extypename
	 */
	public void insert(String extypename);
	
	/**
	 * 删除
	 * @param extypeid
	 */
	public void delete(Integer extypeid);
	
	/**
	 * 修改
	 * @param expenseType
	 */
	public void update(ExpenseType expenseType);
	
	/**
	 * 分页查询
	 * @param skip
	 * @param take
	 * @param expenseType
	 * @return
	 */
	public List<ExpenseType> select(@Param("skip")Integer skip,@Param("take")Integer take,@Param("expenseType")ExpenseType expenseType);
	
	/**
	 * 获取记录条数
	 * @param expenseType
	 * @return
	 */
	public int getRowCount(@Param("expenseType")ExpenseType expenseType);
	
	/**
	 * 根据id查询
	 * @param extypeid
	 * @return
	 */
	public ExpenseType selectOne(Integer extypeid);
	
	/**
	 * 批量删除
	 * @param extypeids
	 */
	public void deleteAll(@Param("extypeids")Integer[] extypeids);
	
	
	
	
}
