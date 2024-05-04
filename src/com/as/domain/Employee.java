package com.as.domain;

/**
 * 员工实体类
 * @author 小陈
 *
 */
public class Employee {
	
	/**
	 * 员工登录的标识  1正常、2加锁、3账号或密码错误
	 */
	private Integer flag;
	
	/**
	 * 员工id
	 */
	private Integer empId;
	
	/**
	 * 添加时间
	 */
	private String addTime;

	/**
	 * 员工姓名
	 */
	private String empName;

	/**
	 * 性别
	 */
	private String gender;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 职位
	 */
	private String position;

	/**
	 * 员工登录账号
	 */
	private String loginName;

	/**
	 * 聘用日期
	 */
	private String hireDate;

	/**
	 * 部门id
	 */
	private Integer departId;

	/**
	 * 部门名字
	 */
	private String departName;

	/**
	 * 员工移动电话
	 */
	private String mobile;

	/**
	 * 员工办公电话
	 */
	private String tel;

	/**
	 * 员工家庭电话
	 */
	private String familyTel;

	/**
	 * 生日
	 */
	private String birthday;

	/**
	 * 住址
	 */
	private String address;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 状态 1正常 2加锁
	 */
	private Integer state;

	/**
	 * 图片
	 */
	private String picture;

	
	/**
	 * 默认构造
	 */
	public Employee(){}
	
	/**
	 * 带参构造
	 * @param empId
	 * @param addTime
	 * @param empName
	 * @param gender
	 * @param password
	 * @param position
	 * @param loginName
	 * @param hireDate
	 * @param departId
	 * @param mobile
	 * @param tel
	 * @param familyTel
	 * @param birthday
	 * @param address
	 * @param remark
	 * @param state
	 * @param picture
	 */
	public Employee(Integer empId, String addTime, String empName, String gender, String password, String position,
			String loginName, String hireDate, Integer departId, String mobile, String tel, String familyTel,
			String birthday, String address, String remark, Integer state, String picture) {
		super();
		this.empId = empId;
		this.addTime = addTime;
		this.empName = empName;
		this.gender = gender;
		this.password = password;
		this.position = position;
		this.loginName = loginName;
		this.hireDate = hireDate;
		this.departId = departId;
		this.mobile = mobile;
		this.tel = tel;
		this.familyTel = familyTel;
		this.birthday = birthday;
		this.address = address;
		this.remark = remark;
		this.state = state;
		this.picture = picture;
	}
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", addTime=" + addTime + ", empName=" + empName + ", gender=" + gender
				+ ", password=" + password + ", position=" + position + ", loginName=" + loginName + ", hireDate="
				+ hireDate + ", departId=" + departId + ", mobile=" + mobile + ", tel=" + tel + ", familyTel="
				+ familyTel + ", birthday=" + birthday + ", address=" + address + ", remark=" + remark + ", state="
				+ state + ", picture=" + picture + "]";
	}

	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public Integer getDepartId() {
		return departId;
	}

	public void setDepartId(Integer departId) {
		this.departId = departId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFamilyTel() {        //大小写！！！！！！！！！！！！！！
		return familyTel;
	}

	public void setFamilyTel(String familyTel) {
		this.familyTel = familyTel;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
	
}
