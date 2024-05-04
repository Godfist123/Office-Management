package com.as.domain;

/**
 * 报销详情实体类
 * @author 小陈
 *
 */
public class ExpenseDetail {

	/**
	 * 报销详情编号
	 */
	private Integer id;

	/**
	 * 添加时间
	 */
	private String addtime;

	/**
	 * 对应报销表expenseid
	 */
	private Integer expenseid;

	/**
	 * 对应报销类别表的extypeid
	 */
	private Integer extypeid;
	
	/**
	 * 报销类别id对应的报销类别名称
	 */
	private String extypename;

	/**
	 * 报销金额
	 */
	private Integer money;

	/**
	 * 费用说明
	 */
	private String costdesc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public Integer getExpenseid() {
		return expenseid;
	}

	public void setExpenseid(Integer expenseid) {
		this.expenseid = expenseid;
	}

	public Integer getExtypeid() {
		return extypeid;
	}

	public void setExtypeid(Integer extypeid) {
		this.extypeid = extypeid;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public String getCostdesc() {
		return costdesc;
	}

	public void setCostdesc(String costdesc) {
		this.costdesc = costdesc;
	}

	public String getExtypename() {
		return extypename;
	}

	public void setExtypename(String extypename) {
		this.extypename = extypename;
	}
	
	
	
	
}
