package com.as.domain;

/**
 * 	日程实体类
 * @author 小陈
 *
 */
public class Schedule {


	/**
	 * 	日程编号
	 */
	private int scheduleid;

	/**
	 * 	创建时间
	 */
	private String addtime;

	/**
	 * 	标题
	 */
	private String title;

	/**
	 * 	员工id
	 */
	private Integer empid;

	/**
	 * 	员工名
	 */
	private String empname;
	/**
	 * 	开始时间
	 */
	private String begintime;

	/**
	 * 	结束时间
	 */
	private String endtime;

	/**
	 * 	内容
	 */
	private String content;

	/**
	 * 	联系人
	 */
	private String concatname;

	/**
	 * 	联系人地址
	 */
	private String address;

	/**
	 * 	电话
	 */
	private String tel;

	/**
	 * 	备注
	 */
	private String demo;

	/**
	 * 	是否公开  1-私有  2-公开
	 */
	private int ifprivate;

	/**
	 * 	日程状态  1-未完成  2-完成  3-进行中
	 */
	private Integer state;
	
	
	public Schedule() {}
	
	
	public Schedule(int scheduleid, String addtime, String title, int empid, String begintime, String endtime,
			String content, String concatname, String address, String tel, String demo, int ifprivate, int state) {
		super();
		this.scheduleid = scheduleid;
		this.addtime = addtime;
		this.title = title;
		this.empid = empid;
		this.begintime = begintime;
		this.endtime = endtime;
		this.content = content;
		this.concatname = concatname;
		this.address = address;
		this.tel = tel;
		this.demo = demo;
		this.ifprivate = ifprivate;
		this.state = state;
	}


	@Override
	public String toString() {
		return "schedule [scheduleid=" + scheduleid + ", addtime=" + addtime + ", title=" + title + ", empid=" + empid
				+ ", begintime=" + begintime + ", endtime=" + endtime + ", content=" + content + ", concatname="
				+ concatname + ", address=" + address + ", tel=" + tel + ", demo=" + demo + ", ifprivate=" + ifprivate
				+ ", state=" + state + "]";
	}


	public Integer getScheduleid() {
		return scheduleid;
	}


	public void setScheduleid(int scheduleid) {
		this.scheduleid = scheduleid;
	}


	public String getAddtime() {
		return addtime;
	}


	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Integer getEmpid() {
		return empid;
	}


	public void setEmpid(Integer empid) {
		this.empid = empid;
	}


	public String getBegintime() {
		return begintime;
	}


	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}


	public String getEndtime() {
		return endtime;
	}


	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getConcatname() {
		return concatname;
	}


	public void setConcatname(String concatname) {
		this.concatname = concatname;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getDemo() {
		return demo;
	}


	public void setDemo(String demo) {
		this.demo = demo;
	}


	public int getIfprivate() {
		return ifprivate;
	}


	public void setIfprivate(int ifprivate) {
		this.ifprivate = ifprivate;
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
	
}
