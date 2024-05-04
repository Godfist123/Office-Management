package com.as.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.as.domain.News;

/**
 * 新闻数据访问层
 * @author 小陈
 *
 */
public interface NewsMapper {

	/**
	 * 新增
	 * @param news
	 */
	public void insert(News news);
	
	/**
	 * 删除
	 * @param newsid
	 */
	public void delete(Integer newsid);
	
	/**
	 * 修改
	 * @param news
	 */
	public void update(News news);
	
	/**
	 * 分页查询
	 * @param skip
	 * @param take
	 * @param news
	 * @return
	 */
	public List<News> select(@Param("skip")Integer skip,@Param("take")Integer take,@Param("news")News news);
	
	/**
	 * 获取记录条数
	 * @param news
	 * @return
	 */
	public int getRowCount(@Param("news")News news);
	
	/**
	 * 根据新闻id查询
	 * @param newsid
	 * @return
	 */
	public News selectById(Integer newsid);
	
	/**
	 * 批量删除
	 * @param newsids
	 */
	public void deleteAll(@Param("newsids")Integer[] newsids);
	
	/**
	 * 审核
	 * @param newsid
	 */
	public void examine(Integer newsid);
	
	
	
}
