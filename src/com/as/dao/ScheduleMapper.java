package com.as.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.as.domain.Schedule;

/**
 * 	日程表文件上传数据访问层
 * @author 小陈
 *
 */
public interface ScheduleMapper {

	/**
	 *	 新增
	 * @param schedule
	 */
	public void insert(Schedule schedule);
	
	/**
	 *	 删除
	 * @param scheduleid
	 */
	public void delete(Integer scheduleid);
	
	/**
	 *	修改
	 * @param schedule
	 */
	public void update(Schedule schedule);

	/**
	 * 	分页条件查询
	 * @param skip
	 * @param take
	 * @param schedule
	 * @return
	 */
	public List<Schedule> select(@Param("skip")Integer skip,@Param("take")Integer take,@Param("schedule")Schedule schedule);
	
	/**
	 * 	获取记录条数
	 * @param schedule
	 * @return
	 */
	public int getRowCount(@Param("schedule")Schedule schedule);
	
	/**
	 *	 根据id查询
	 * @param scheduleid
	 * @return
	 */
	public Schedule selectOne(Integer scheduleid);
	
	/**
	 * 	批量删除
	 * @param scheduleids
	 */
	public void deleteAll(@Param("scheduleids")Integer[] scheduleids);
	
}
