package com.as.service;

import com.as.domain.Address;
import com.as.util.Pages;

/**
 * 通讯录业务逻辑接口
 * @author 小陈
 *
 */
public interface AddressService {

	/**
	 * 新增
	 * @param address
	 */
	public void append(Address address);
	
	/**
	 * 删除
	 * @param addressid
	 */
	public void remove(Integer addressid);
	
	/**
	 * 修改
	 * @param address
	 */
	public void modify(Address address);
	
	/**
	 * 分页查询
	 * @param skip
	 * @param take
	 * @param address
	 * @return
	 */
	public Pages<Address> list(Integer currPage,Address address);
	
	/**
	 * 根据通讯录id查询
	 * @param addressid
	 * @return
	 */
	public Address selectById(Integer addressid);
	
	/**
	 * 批量删除
	 * @param addressids
	 */
	public void removes(Integer[] addressids);
	
}
