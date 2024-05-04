package com.as.util;

import java.util.List;

/**
 * 分页类
 * 泛型类:类型参数化,调用时指明具体的类型的
 * 
 * @author 小陈
 *
 */

public class Pages<T> {
	
	/**
	 * 分页类的默认构造方法
	 */
	public Pages() {}
	
	/**
	 * 分页类带参构造方法
	 * @param currPage 当前页
	 * @param rowCount 记录数
	 * @param pageSize 每页大小
	 * @param list 查询结果
	 */
	public Pages(int currPage,int rowCount,int pageSize,List<T> list) {
		this.calc(currPage, rowCount, pageSize, list);
	}
	
	
	/**
	 * 首页
	 */
	private int first;
	
	/**
	 * 前一页
	 */
	private int pre;
	
	/**
	 * 下一页
	 */
	private int next;
	
	/**
	 * 末页
	 */
	private int last;
	
	/**
	 * 当前页
	 */
	private int currPage;
	
	/**
	 * 总记录条数
	 */
	private int rowCount;
	
	/**
	 * 总页数
	 */
	private int pages;
	
	/**
	 * 每页大小
	 */
	private int pageSize;
	
	/**
	 * 查询结果
	 */
	private List<T> list;
	
	/**
	 * 分页的属性初始化方法
	 * @param currPage
	 * @param rowCount
	 * @param pageSize
	 * @param list
	 */
	public void calc(int currPage,int rowCount,int pageSize,List<T> list)
	{
		this.currPage=currPage;
		this.rowCount=rowCount;
		this.pageSize=pageSize;
		this.list=list;
		//总页数=总记录数%每页大小==0?总记录数/每页大小:总记录数/每页大小+1;
		this.pages=this.rowCount%this.pageSize==0?this.rowCount/this.pageSize:this.rowCount/this.pageSize+1;
		this.first=1;
		this.pre=this.currPage>1?this.currPage-1:1;
		this.next=this.pages>this.currPage?this.currPage+1:this.pages;
		this.last=pages;
	}
	
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getPre() {
		return pre;
	}
	public void setPre(int pre) {
		this.pre = pre;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
