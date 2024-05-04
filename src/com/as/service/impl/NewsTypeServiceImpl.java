package com.as.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.dao.NewsTypeMapper;
import com.as.domain.NewsType;
import com.as.service.NewsTypeService;
import com.as.util.Common;
import com.as.util.Pages;

/**
 * 	新闻栏目的逻辑层实现类
 * @author 小陈
 *
 */
@Service //IOC控制反转,实现NewsTypeServiceImpl的创建和管理
public class NewsTypeServiceImpl implements NewsTypeService{
	
	//DI 依赖注入
	@Autowired
	private NewsTypeMapper newsTypeMapper;
	
	@Override
	public void append(NewsType newsType) {
		
		this.newsTypeMapper.insert(newsType);
	}
	
	@Override
	public void remove(Integer newsTypeId) {
		
		this.newsTypeMapper.delete(newsTypeId);
	}
	
	@Override
	public void modify(NewsType newsType) {
		
		this.newsTypeMapper.update(newsType);
	}
	
	@Override
	public Pages<NewsType> list(Integer currPage,NewsType newsType){
		
		List<NewsType> list= this.newsTypeMapper.select((currPage-1)*Common.PAGESIZE, Common.PAGESIZE, newsType);
		int rowCount=this.newsTypeMapper.getRowCount(newsType);
		Pages<NewsType> pages=new Pages<NewsType>(currPage, rowCount, Common.PAGESIZE, list);
		
		return pages;
	}
	
	@Override
	public int getRowCount(NewsType newsType) {
		
		return this.newsTypeMapper.getRowCount(newsType);
	}
	
	@Override
	public NewsType selectById(Integer newsTypeId) {
		
		return this.newsTypeMapper.selectById(newsTypeId);
	}

	@Override
	public void removes(Integer[] newsTypeIds) {
		
		this.newsTypeMapper.deleteAll(newsTypeIds);
	}
}
