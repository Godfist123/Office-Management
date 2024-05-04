package com.as.domain;

/**
 * 新闻实体类
 * @author 小陈
 *
 */
public class News {

	/**
	 * 编号
	 */
	private Integer newsid;
	
	/**
	 * 新闻栏目id对应新闻栏目表newstypeid 
	 */
	private Integer newsparentid;
	
	
	/**
	 * 新闻所属栏目
	 */
	private String newsname;
	
	/**
	 * 新闻标题
	 */
	private String newstitle;
	
	/**
	 * 新闻内容
	 */
	private String newscontent;
	
	/**
	 * 新闻作者#员工表的empid
	 */
	private Integer empid;
	
	/**
	 * 新闻作者#员工表的empname
	 */
	private String empname;
	
	/**
	 * 发布时间
	 */
	private String publishtime;
	
	/**
	 * 新闻标识 0 没有审核 1 审核
	 */
	private Integer state;

	
	public News() {}
	
	public News(Integer newsid, Integer newsparentid, String newstitle, String newscontent, Integer empid, String publishtime,
			int state) {
		super();
		this.newsid = newsid;
		this.newsparentid = newsparentid;
		this.newstitle = newstitle;
		this.newscontent = newscontent;
		this.empid = empid;
		this.publishtime = publishtime;
		this.state = state;
	}


	@Override
	public String toString() {
		return "News [newsid=" + newsid + ", newsparentid=" + newsparentid + ", newstitle=" + newstitle
				+ ", newscontent=" + newscontent + ", empid=" + empid + ", empname=" + empname + ", publishtime="
				+ publishtime + ", state=" + state + "]";
	}

	public Integer getNewsid() {
		return newsid;
	}

	public void setNewsid(Integer newsid) {
		this.newsid = newsid;
	}

	public Integer getNewsparentid() {
		return newsparentid;
	}

	public void setNewsparentid(Integer newsparentid) {
		this.newsparentid = newsparentid;
	}

	public String getNewstitle() {
		return newstitle;
	}

	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}

	public String getNewscontent() {
		return newscontent;
	}

	public void setNewscontent(String newscontent) {
		this.newscontent = newscontent;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getNewsname() {
		return newsname;
	}

	public void setNewsname(String newsname) {
		this.newsname = newsname;
	}
	
}
