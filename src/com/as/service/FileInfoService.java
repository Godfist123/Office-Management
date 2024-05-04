package com.as.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.as.domain.FileInfo;
import com.as.util.Pages;
/**
 * 文件上传的业务逻辑接口
 * @author 小陈
 *
 */
public interface FileInfoService  {
	
	/**
	 * 新增
	 * @param fileInfo
	 */
	public void append(FileInfo fileInfo,MultipartFile file,HttpServletRequest request);
	
	/**
	 * 删除
	 * @param fileid
	 */
	public void remove(Integer fileid);

	/**
	 * 修改下载次数
	 * @param fileid
	 */
	public void modify(Integer fileid);
	
	/**
	 * 条件查询
	 * @param currPage
	 * @param fileInfo
	 * @return
	 */
	public Pages<FileInfo> list(Integer currPage, FileInfo fileInfo);

	/**
	 * 获取记录条数
	 * @param fileInfo
	 * @return
	 */
	public int getRowCount(FileInfo fileInfo);
	
	/**
	 * 根据id查询
	 * @param fileid
	 * @return
	 */
	public FileInfo selectById(Integer fileid);
	
	/**
	 * 批量删除
	 * @param fileid
	 */
	public void removes(Integer[] fileid);
}
