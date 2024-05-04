package com.as.domain;

/**
 * 通讯录实体类
 * @author 小陈
 *
 */
public class Address {
	
	/**
	 * 通讯组名
	 */
	private String groupname;
	
	/**
	 * 员工姓名
	 */
	private String empname;

	/**
	 * 通讯录id
	 */
	private Integer addressid;
	
	/**
	 * 添加时间
	 */
	private String addtime;
	
	/**
	 * 员工id对应员工表empid
	 */
	private Integer empid;
	
	/**
	 * 通讯组id对应通讯录组表groupid 
	 */
	private Integer groupid;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private String gender;
	
	/**
	 * 生日
	 */
	private String birthday;
	
	/**
	 * 婚姻状况 0未婚 1已婚
	 */
	private Integer marry;
	
	/**
	 * 部门名称
	 */
	private String departname;
	
	/**
	 * 职位名称
	 */
	private String position;
	
	/**
	 * 公司名称
	 */
	private String companyname;
	
	/**
	 * 办公电话
	 */
	private String tel;
	
	/**
	 * 移动电话
	 */
	private String mobile;
	
	/**
	 * 家庭电话
	 */
	private String familytel;
	
	/**
	 * 电子邮箱
	 */
	private String email;
	
	/**
	 * 家庭地址
	 */
	private String homeaddress;

	public Address() {}
	
	public Address(Integer addressid, String addtime, Integer empid, Integer groupid, String name, String gender,
			String birthday, Integer marry, String departname, String position, String companyname, String tel,
			String mobile, String familytel, String email, String homeaddress) {
		super();
		this.addressid = addressid;
		this.addtime = addtime;
		this.empid = empid;
		this.groupid = groupid;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.marry = marry;
		this.departname = departname;
		this.position = position;
		this.companyname = companyname;
		this.tel = tel;
		this.mobile = mobile;
		this.familytel = familytel;
		this.email = email;
		this.homeaddress = homeaddress;
	}


	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", addtime=" + addtime + ", empid=" + empid + ", groupid=" + groupid
				+ ", name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", marry=" + marry
				+ ", departname=" + departname + ", position=" + position + ", companyname=" + companyname + ", tel="
				+ tel + ", mobile=" + mobile + ", familytel=" + familytel + ", email=" + email + ", homeaddress="
				+ homeaddress + "]";
	}

	public Integer getAddressid() {
		return addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
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

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getMarry() {
		return marry;
	}

	public void setMarry(Integer marry) {
		this.marry = marry;
	}

	public String getdepartname() {
		return departname;
	}

	public void setdepartname(String departname) {
		this.departname = departname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFamilytel() {
		return familytel;
	}

	public void setFamilytel(String familytel) {
		this.familytel = familytel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}
	
}
