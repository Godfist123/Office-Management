package com.as.domain;

/**
 * 通讯录组实体类
 * @author 小陈
 *
 */
public class AddrGroup {
	
	/**
	 * 通讯录id
	 */
	private int groupid;
	
	/**
	 * 通讯组名称
	 */
	private String groupname;
	
	/**
	 * 通讯备注
	 */
	private String remark;
	
	
	public AddrGroup() {}

	public AddrGroup(int groupid, String groupname, String remark) {
		super();
		this.groupid = groupid;
		this.groupname = groupname;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "AddrGroup [groupid=" + groupid + ", groupname=" + groupname + ", remark=" + remark + "]";
	}

	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
}
