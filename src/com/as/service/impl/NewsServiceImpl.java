package com.as.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.dao.NewsMapper;
import com.as.domain.News;
import com.as.service.NewsService;
import com.as.util.Common;
import com.as.util.Pages;

/**
 * 新闻的业务逻辑的实现类
 * @author 小陈
 *
 */
@Service
public class NewsServiceImpl implements NewsService{

	//依赖注入
	@Autowired
	private NewsMapper newsMapper;
	
	@Override
	public void append(News news){
		
		this.newsMapper.insert(news);
	}
	
	@Override
	public void remove(Integer newsid){
		
		this.newsMapper.delete(newsid);
	}
	
	@Override
	public void modify(News news){
		
		this.newsMapper.update(news);
	}
	
	@Override
	public Pages<News> list(Integer currPage,News news){
		
		//查询时初始页面没有值
		if(news.getState()==null) news.setState(-1);
		
		List<News> list=this.newsMapper.select((currPage-1)*Common.PAGESIZE, Common.PAGESIZE, news);
		int rowCount=this.newsMapper.getRowCount(news);
		Pages<News> pages=new Pages<News>(currPage, rowCount, Common.PAGESIZE, list);
		
		return pages;
	}
	
	
	@Override
	public News selectById(Integer newsid){
		
		return this.newsMapper.selectById(newsid);
	}

	@Override
	public void removes(Integer[] newsids) {

		this.newsMapper.deleteAll(newsids);
	}

	@Override
	public void examine(Integer newsid) {

		this.newsMapper.examine(newsid);
	}
	
}
