package com.as.domain;

/**
 * 	新闻栏目的实体类
 * @author 小陈
 *
 */
public class NewsType {

	/**
	 * 新闻栏目id
	 */
	 private int newsTypeId;
	 
	 /**
	  * 添加时间
	  */
	 private String addTime;
	 
	 /**
	  * 新闻栏目上级id
	  */
	 private int  newsParentId;
	 
	 /**
	  * 新闻栏目名称
	  */
	 private String  newsName;
	 
	 /**
	  * 新闻栏目描述
	  */
	 private String newsDesc;

	 
	 public NewsType() {}
	 
	 public NewsType(int newsTypeId, String addTime, int newsParentId, String newsName, String newsDesc) {
		super();
		this.newsTypeId = newsTypeId;
		this.addTime = addTime;
		this.newsParentId = newsParentId;
		this.newsName = newsName;
		this.newsDesc = newsDesc;
	}

	@Override
	public String toString() {
		return "NewsType [newsTypeId=" + newsTypeId + ", addTime=" + addTime + ", newsParentId=" + newsParentId
				+ ", newsName=" + newsName + ", newsDesc=" + newsDesc + "]";
	}

	public int getNewsTypeId() {
		return newsTypeId;
	}

	public void setNewsTypeId(int newsTypeId) {
		this.newsTypeId = newsTypeId;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public int getNewsParentId() {
		return newsParentId;
	}

	public void setNewsParentId(int newsParentId) {
		this.newsParentId = newsParentId;
	}

	public String getNewsName() {
		return newsName;
	}

	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}

	public String getNewsDesc() {
		return newsDesc;
	}

	public void setNewsDesc(String newsDesc) {
		this.newsDesc = newsDesc;
	}
	 
	
	 
}
