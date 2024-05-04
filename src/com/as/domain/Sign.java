package com.as.domain;

/**
 * 签到实体类
 * @author 小陈
 *
 */
public class Sign {

	/**
	 * 签到id
	 */
	private Integer signid;

	/**
	 * 对应职员的empid
	 */
	private Integer empid;

	/**
	 * 签到时间
	 */
	private String signtime;

	/**
	 * 签到备注
	 */
	private String signdesc;

	/**
	 * 签到标记 ,1-签到 2-签退 (迟到值为3,早退值为4)
	 */
	private Integer signtag;

	/**
	 * 查询时输入的开始时间
	 */
	private String begintime;

	/**
	 * 查询时输入的结束时间
	 */
	private String endtime;

	/**
	 * 员工名字
	 */
	private String empname;

	/**
	 * 部门id
	 */
	private Integer departid;

	/**
	 * 部门名字
	 */
	private String departname;
	

	public Integer getDepartid() {
		return departid;
	}

	public void setDepartid(Integer departid) {
		this.departid = departid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getDepartname() {
		return departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
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

	public Integer getSignid() {
		return signid;
	}

	public void setSignid(Integer signid) {
		this.signid = signid;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getSigntime() {
		return signtime;
	}

	public void setSigntime(String signtime) {
		this.signtime = signtime;
	}

	public String getSigndesc() {
		return signdesc;
	}

	public void setSigndesc(String signdesc) {
		this.signdesc = signdesc;
	}

	public Integer getSigntag() {
		return signtag;
	}

	public void setSigntag(Integer signtag) {
		this.signtag = signtag;
	}
	
	
}
