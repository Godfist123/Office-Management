package com.as.domain;

import java.util.List;

/**
 * 权限菜单实体类
 * @author 小陈
 *
 */
public class Menu {
	
	/**
	 * 一对多关系,一里加多的集合属性
	 */
	private List<Menu> list;
	
	/**
	 * 一对多查询,一里加多的字段属性
	 */
	private Integer empid;
	
	/**
	 * 权限菜单id
	 */
	private Integer menuid;
	
	/**
	 * 菜单名称
	 */
	private String menuname;
	
	/**
	 * 菜单地址
	 */
	private String url;
	
	/**
	 * 上级id
	 */
	private Integer parentid;
	
	/**
	 * 图标
	 */
	private String ico;
	
	

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getIco() {
		return ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}

	public List<Menu> getList() {
		return list;
	}

	public void setList(List<Menu> list) {
		this.list = list;
	}
	
	
}
