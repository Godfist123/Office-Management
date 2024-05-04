package com.as.service;

import com.as.domain.NewsType;
import com.as.util.Pages;

/**
 *	新闻栏目的业务逻辑接口
 * @author 小陈
 *
 */
public interface NewsTypeService {

	/**
	 * 新增
	 * @param newsType
	 */
	public void append(NewsType newsType);
	
	/**
	 * 删除
	 * @param newsTypeId
	 */
	public void remove(Integer newsTypeId);
	
	/**
	 * 修改
	 * @param newsType
	 */
	public void modify(NewsType newsType);
	
	/**
	 * 分页查询
	 * @param skip
	 * @param take
	 * @param newsType
	 * @return
	 */
	public Pages<NewsType> list(Integer currPage,NewsType newsType);
	
	/**
	 * 获取记录条数
	 * @param newsType
	 * @return
	 */
	public int getRowCount(NewsType newsType);
	
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
	public void removes(Integer[] newsTypeIds);
	
}
