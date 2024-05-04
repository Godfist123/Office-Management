package com.as.service;

import com.as.domain.DepartInfo;
import com.as.util.Pages;

/**
 *	 部门信息表业务逻辑接口
 * @author 小陈
 *
 */
public interface DepartInfoService {
	
	/**
	 * 新增
	 * @param departInfo
	 */
	public void append(DepartInfo departInfo);
	
	/**
	 * 删除
	 * @param departId
	 */
	public void remove(Integer departId);
	
	/**
	 * 修改
	 * @param departInfo
	 */
	public void modify(DepartInfo departInfo);
	
	/**
	 * 分页条件查询
	 * @param currPage
	 * @param departInfo
	 * @return
	 */
	public Pages<DepartInfo> list(Integer currPage,DepartInfo departInfo);
	
	/**
	 * 根据id查询
	 * @param departId
	 * @return
	 */
	public DepartInfo selectOne(Integer departId);
	
	/**
	 * 批量删除
	 * @param departIds
	 */
	public void removes(Integer[] departIds);
	
}
