package com.as.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.as.domain.NewsType;

/**
 * 	新闻栏目的数据访问层
 * @author 小陈
 *
 */
public interface NewsTypeMapper {

	/**
	 * 新增
	 * @param newsType
	 */
	public void insert(NewsType newsType);
	
	/**
	 * 删除
	 * @param newsTypeId
	 */
	public void delete(Integer newsTypeId);
	
	/**
	 * 修改
	 * @param newsType
	 */
	public void update(NewsType newsType);
	
	/**
	 * 分页查询
	 * @param skip
	 * @param take
	 * @param newsType
	 * @return
	 */
	public List<NewsType> select(@Param("skip")Integer skip,@Param("take")Integer take,@Param("newsType")NewsType newsType);
	
	/**
	 * 获取记录条数
	 * @param newsType
	 * @return
	 */
	public int getRowCount(@Param("newsType")NewsType newsType);
	
	/**
	 * 根据新闻栏目id查询
	 * @param newsTypeId
	 * @return
	 */
	public NewsType selectById(Integer newsTypeId);
	
	/**
	 * 批量删除
	 * @param newsTypeIds
	 */
	public void deleteAll(@Param("newsTypeIds")Integer[] newsTypeIds);
	
	
	
}
