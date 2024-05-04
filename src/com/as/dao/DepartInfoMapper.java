package com.as.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.as.domain.DepartInfo;

/**
 * 部门信息表数据访问层
 * @author 小陈
 *
 */
public interface DepartInfoMapper {
	
	/**
	 * 新增
	 * @param departInfo
	 */
	public void insert(DepartInfo departInfo);
	
	/**
	 * 删除
	 * @param departId
	 */
	public void delete(Integer departId);
	
	/**
	 * 修改
	 * @param departInfo
	 */
	public void update(DepartInfo departInfo);
	
	/**
	 * 分页条件查询
	 * @param currPage
	 * @param departInfo
	 * @return
	 */
	public List<DepartInfo> select(@Param("skip")Integer skip,@Param("take")Integer take,@Param("DepartInfo")DepartInfo departInfo);
	
	/**
	 * 获取记录条数
	 * @param departInfo
	 * @return
	 */
	public Integer getRowCount(@Param("DepartInfo")DepartInfo departInfo);
	
	/**
	 * 根据id查询
	 * @param departId
	 * @return
	 */
	public DepartInfo selectById(Integer departId);
	
	/**
	 * 批量删除
	 * @param departIds
	 */
	public void deleteAll(@Param("departIds")Integer[] departIds);
	
	
}
