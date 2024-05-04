package com.as.domain;

/**
 * 报销实体类
 * @author 小陈
 *
 */
public class Expense {
	
	/**
	 * 报销编号
	 */
	private Integer expenseid;
	
	/**
	 * 添加时间
	 */
	private String addtime;
	
	/**
	 * 填报人对应员工id
	 */
	private Integer empid;
	
	/**
	 * 员工id对应员工姓名
	 */
	private String empname;
	
	/**
	 * 总金额
	 */
	private Double total;
	
	/**
	 * 事由
	 */
	private String reason;
	
	/**
	 * 审批人对应员工id
	 */
	private Integer confirmperson;
	
	/**
	 * 审批人id对应审批人姓名
	 */
	private String leadername;
	
	/**
	 * 状态 1-新建 2-已提交 3-已审批
	 */
	private Integer state;
	
	/**
	 * 审批结果 1-待审批 2-批准 3-不批准
	 */
	private Integer sugstate;
	
	/**
	 * 审批意见
	 */
	private String 	suggestion;
	
	/**
	 * 审批时间
	 */
	private String sugtime;
	
	/**
	 * 查询的起始填报时间
	 */
	private String begintime;
	
	/**
	 * 查询的终止填报时间
	 */
	private String endtime;
	
	
	/**
	 * 查询的起始审批时间
	 */
	private String beginsugtime;
	
	/**
	 * 查询的终止审批报时间
	 */
	private String endsugtime;
	
	/**
	 * 员工所属部门
	 */
	private String departname;
	
	/**
	 * 员工职位
	 */
	private String position;
	
	
	public Expense() {
		
		
	}

	public Expense(Integer expenseid, String addtime, Integer empid, String empname, Double total, String reason,
			Integer confirmperson, Integer state, Integer sugstate, String suggestion, String sugtime) {
		super();
		this.expenseid = expenseid;
		this.addtime = addtime;
		this.empid = empid;
		this.empname = empname;
		this.total = total;
		this.reason = reason;
		this.confirmperson = confirmperson;
		this.state = state;
		this.sugstate = sugstate;
		this.suggestion = suggestion;
		this.sugtime = sugtime;
	}


	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartname() {
		return departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
	}

	public String getLeadername() {
		return leadername;
	}

	public void setLeadername(String leadername) {
		this.leadername = leadername;
	}

	public String getBeginsugtime() {
		return beginsugtime;
	}

	public void setBeginsugtime(String beginsugtime) {
		this.beginsugtime = beginsugtime;
	}

	public String getEndsugtime() {
		return endsugtime;
	}

	public void setEndsugtime(String endsugtime) {
		this.endsugtime = endsugtime;
	}

	public Integer getExpenseid() {
		return expenseid;
	}

	public void setExpenseid(Integer expenseid) {
		this.expenseid = expenseid;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getConfirmperson() {
		return confirmperson;
	}

	public void setConfirmperson(Integer confirmperson) {
		this.confirmperson = confirmperson;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getSugstate() {
		return sugstate;
	}

	public void setSugstate(Integer sugstate) {
		this.sugstate = sugstate;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getSugtime() {
		return sugtime;
	}

	public void setSugtime(String sugtime) {
		this.sugtime = sugtime;
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

	
	
}
