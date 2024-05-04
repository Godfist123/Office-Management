package com.as.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.as.domain.AddrGroup;

/**
 * 通讯录组数据访问层
 * @author 小陈
 *
 */
public interface AddrGroupMapper {

	/**
	 * 新增
	 * @param addrGroup
	 */
	public void insert(AddrGroup addrGroup);
	
	/**
	 * 删除
	 * @param groupid
	 */
	public void delete(Integer groupid);
	
	/**
	 * 修改
	 * @param addrGroup
	 */
	public void update(AddrGroup addrGroup);
	
	/**
	 * 分页查询
	 * @param skip
	 * @param take
	 * @param addrGroup
	 * @return
	 */
	public List<AddrGroup> select(@Param("skip")Integer skip,@Param("take")Integer take,@Param("addrGroup")AddrGroup addrGroup);
	
	/**
	 * 获取记录条数
	 * @param addrGroup
	 * @return
	 */
	public int getRowCount(@Param("addrGroup")AddrGroup addrGroup);
	
	/**
	 * 根据新闻id查询
	 * @param groupid
	 * @return
	 */
	public AddrGroup selectOne(Integer groupid);
	
	/**
	 * 批量删除
	 * @param groupids
	 */
	public void deleteAll(@Param("groupids")Integer[] groupids);
	
	
	
	
}
