package com.as.domain;

/**
 * 报销类型实体类
 * @author 小陈
 *
 */
public class ExpenseType {

	/**
	 * 报销类型编号
	 */
	private Integer extypeid;
	
	/**
	 * 报销类型名称
	 */
	private String extypename;
	
	public ExpenseType() {}

	public ExpenseType(Integer extypeid, String extypename) {
		super();
		this.extypeid = extypeid;
		this.extypename = extypename;
	}

	public Integer getExtypeid() {
		return extypeid;
	}

	public void setExtypeid(Integer extypeid) {
		this.extypeid = extypeid;
	}

	public String getExtypename() {
		return extypename;
	}

	public void setExtypename(String extypename) {
		this.extypename = extypename;
	}
	
}
