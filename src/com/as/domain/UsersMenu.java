package com.as.domain;

/**
 * 用户的权限实体类
 * @author 小陈
 *
 */
public class UsersMenu {

	/**
	 * 用户的权限id
	 */
	private Integer id;
	
	/**
	 * 权限id对应menu的menuid
	 */
	private Integer menuid;
	
	/*
	 * 对应employee表的empid
	 */
	private Integer empid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	
}
