package com.as.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.as.domain.FileInfo;

/**
 * 	文件上传数据访问层
 * @author 小陈
 *
 */
public interface FileInfoMapper {

	/**
	 *	 新增
	 * @param fileInfo
	 */
	public void insert(FileInfo fileInfo);
	
	/**
	 *	 删除
	 * @param fileid
	 */
	public void delete(Integer fileid);
	
	/**
	 *	修改下载次数
	 * @param fileid
	 */
	public void update(Integer fileid);
	
	/**
	 * 	分页条件查询
	 * @param skip
	 * @param take
	 * @param fileInfo
	 * @return
	 */
	public List<FileInfo> select(@Param("skip")Integer skip,@Param("take")Integer take,@Param("fileInfo")FileInfo fileInfo);
	
	/**
	 * 	获取记录条数
	 * @param fileInfo
	 * @return
	 */
	public int getRowCount(@Param("fileInfo")FileInfo fileInfo);
	
	/**
	 * 根据id查询
	 * @param fileid
	 * @return
	 */
	public FileInfo selectOne(Integer fileid);
	
	/**
	 * 批量删除
	 * @param departIds
	 */
	public void deleteAll(@Param("fileids")Integer[] fileids);
}
