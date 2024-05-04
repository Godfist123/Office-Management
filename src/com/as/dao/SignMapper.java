package com.as.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.as.domain.Sign;

/**
 * 签到数据访问层
 * @author 小陈
 *
 */
public interface SignMapper {
	
	/**
	 * 条件分页查询
	 * @param skip
	 * @param take
	 * @param sign
	 * @return
	 */
	public List<Sign> select(@Param("skip")Integer skip,@Param("take")Integer take,@Param("sign")Sign sign);
	
	/**
	 * 获取记录条数
	 * @param sign
	 * @return
	 */
	public int getRowCount(@Param("sign")Sign sign);
	
	/**
	 * 签到
	 * @param sign
	 */
	public void insert(Sign sign);
	
	/**
	 * 查询当前登录用户当天的签到状态
	 * @param empid
	 * @param signtime
	 * @return
	 */
	public Integer selectSignTag(@Param("empid")Integer empid,@Param("signtime")String signtime);
	
	/**
	 * 签退
	 * @param sign
	 */
	public void update(Sign sign);
	
	/**
	 * 获取实际出勤天数
	 */
	public Integer getSignDay(Sign sign);
	
	/**
	 * 详情显示
	 * @param sign
	 * @return
	 */
	public List<Sign> detail(@Param("sign")Sign sign);
	
	

}
