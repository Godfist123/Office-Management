package com.as.domain;

/**
 * 部门信息表实体类
 * @author 小陈
 *
 */
public class DepartInfo {

	/**
	 * 	部门id
	 */
	private Integer departId;
	
	/**
	 * 	部门名字
	 */
	private String departName;
	
	/**
	 * 	部门邮箱
	 */
	private String departEmail;
	
	/**
	 * 	部门电话
	 */
	private String departTel;
	
	/**
	 * 	部门描述
	 */
	private String departDesc;

	/**
	 * 	默认构造
	 */
	public DepartInfo() {}
	
	/**
	 * 带参构造
	 * @param departId
	 * @param departName
	 * @param departEmail
	 * @param departTel
	 * @param departDesc
	 */
	public DepartInfo(Integer departId, String departName, String departEmail, String departTel, String departDesc) {
		super();
		this.departId = departId;
		this.departName = departName;
		this.departEmail = departEmail;
		this.departTel = departTel;
		this.departDesc = departDesc;
	}
	

	@Override
	public String toString() {
		return "DepartInfo [departId=" + departId + ", departName=" + departName + ", departEmail=" + departEmail
				+ ", departTel=" + departTel + ", departDesc=" + departDesc + "]";
	}

	public Integer getDepartId() {
		return departId;
	}

	public void setDepartId(Integer departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getDepartEmail() {
		return departEmail;
	}

	public void setDepartEmail(String departEmail) {
		this.departEmail = departEmail;
	}

	public String getDepartTel() {
		return departTel;
	}

	public void setDepartTel(String departTel) {
		this.departTel = departTel;
	}

	public String getDepartDesc() {
		return departDesc;
	}

	public void setDepartDesc(String departDesc) {
		this.departDesc = departDesc;
	}
	
	
	
}
