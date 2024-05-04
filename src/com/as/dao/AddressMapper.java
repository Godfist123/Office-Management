package com.as.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.as.domain.Address;

/**
 * 通讯录数据访问层
 * @author 小陈
 *
 */
public interface AddressMapper {

	/**
	 * 新增
	 * @param address
	 */
	public void insert(Address address);
	
	/**
	 * 删除
	 * @param addressid
	 */
	public void delete(Integer addressid);
	
	/**
	 * 修改
	 * @param address
	 */
	public void update(Address address);
	
	/**
	 * 分页查询
	 * @param skip
	 * @param take
	 * @param address
	 * @return
	 */
	public List<Address> select(@Param("skip")Integer skip,@Param("take")Integer take,@Param("address")Address address);
	
	/**
	 * 获取记录条数
	 * @param address
	 * @return
	 */
	public int getRowCount(@Param("address")Address address);
	
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
	public void deleteAll(@Param("addressids")Integer[] addressids);
	
	
}
