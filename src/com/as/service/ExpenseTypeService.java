package com.as.service;

import com.as.domain.ExpenseType;
import com.as.util.Pages;

/**
 *	报销类型的业务逻辑接口
 * @author 小陈
 *
 */
public interface ExpenseTypeService {

	/**
	 * 新增
	 * @param extypename
	 */
	public void append(String extypename);
	
	/**
	 * 删除
	 * @param extypeid
	 */
	public void remove(Integer extypeid);
	
	/**
	 * 修改
	 * @param expenseType
	 */
	public void modify(ExpenseType expenseType);
	
	/**
	 * 分页查询
	 * @param skip
	 * @param take
	 * @param expenseType
	 * @return
	 */
	public Pages<ExpenseType> list(Integer currPage,ExpenseType expenseType);
	
	/**
	 * 获取记录条数
	 * @param expenseType
	 * @return
	 */
	public int getRowCount(ExpenseType expenseType);
	
	/**
	 * 根据id查询
	 * @param extypeid
	 * @return
	 */
	public ExpenseType selectById(Integer extypeid);
	
	/**
	 * 批量删除
	 * @param extypeids
	 */
	public void removes(Integer[] extypeids);
	
	
}
