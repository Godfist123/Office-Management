package com.as.service;

import com.as.domain.News;
import com.as.util.Pages;

/**
 * 新闻的业务逻辑层
 * @author 小陈
 *
 */
public interface NewsService {

	
	/**
	 * 新增
	 * @param news
	 */
	public void append(News news);
	
	/**
	 * 删除
	 * @param newsid
	 */
	public void remove(Integer newsid);
	
	/**
	 * 修改
	 * @param news
	 */
	public void modify(News news);
	
	/**
	 * 分页查询
	 * @param skip
	 * @param take
	 * @param news
	 * @return
	 */
	public Pages<News> list(Integer currPage,News news);
	
	
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
	public void removes(Integer[] newsids);

	
	/**
	 * 审核
	 * @param newsid
	 */
	public void examine(Integer newsid);

	
}
