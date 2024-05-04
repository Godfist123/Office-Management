package com.as.service;

import com.as.domain.AddrGroup;
import com.as.util.Pages;

/**
 * 通讯录组业务逻辑接口
 * @author 小陈
 *
 */
public interface AddrGroupService {

	/**
	 * 新增
	 * @param addrGroup
	 */
	public void append(AddrGroup addrGroup);
	
	/**
	 * 删除
	 * @param groupid
	 */
	public void remove(Integer groupid);
	
	/**
	 * 修改
	 * @param addrGroup
	 */
	public void modify(AddrGroup addrGroup);
	
	/**
	 * 分页查询
	 * @param skip
	 * @param take
	 * @param addrGroup
	 * @return
	 */
	public Pages<AddrGroup> list(Integer currPage,AddrGroup addrGroup);
	
	/**
	 * 根据通讯录id查询
	 * @param groupid
	 * @return
	 */
	public AddrGroup selectById(Integer groupid);
	
	/**
	 * 批量删除
	 * @param groupids
	 */
	public void removes(Integer[] groupids);
	
	
}
