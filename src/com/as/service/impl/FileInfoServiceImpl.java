package com.as.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.as.dao.FileInfoMapper;
import com.as.domain.Employee;
import com.as.domain.FileInfo;
import com.as.service.FileInfoService;
import com.as.util.Common;
import com.as.util.Pages;
import com.as.util.UploadsFile;

/**
 *	 文件上传的业务逻辑层实现类
 * @author 小陈
 *
 */
@Service  //IOC控制反转,实现FileInfoServiceImpl的创建和管理
public class FileInfoServiceImpl implements FileInfoService{

	//DI 依赖注入,实现FileInfoMapper接口并赋值
	@Autowired
	private FileInfoMapper fileInfoMapper;
	
	
	@Override
	public void append(FileInfo fileInfo,MultipartFile file,HttpServletRequest request) {

		UploadsFile.fileUp(file, request);
		
		//文件大小
		fileInfo.setFilesize(UploadsFile.getFileSize());
		//上传后的文件名称
		fileInfo.setFileurl(UploadsFile.getFileUrl());
		
		//得到登录者的员工id
		int empid=((Employee)request.getSession().getAttribute("emp")).getEmpId();
		fileInfo.setEmpid(empid);
		this.fileInfoMapper.insert(fileInfo);
	}

	@Override
	public void remove(Integer fileid) {

		this.fileInfoMapper.delete(fileid);
	}

	@Override
	public void modify(Integer fileid) {

		this.fileInfoMapper.update(fileid);
	}
	
	@Override
	public Pages<FileInfo> list(Integer currPage, FileInfo fileInfo) {

		List<FileInfo> list=this.fileInfoMapper.select((currPage-1)*Common.PAGESIZE, Common.PAGESIZE, fileInfo);
		int rowCount=this.fileInfoMapper.getRowCount(fileInfo);
		Pages<FileInfo> pages=new Pages<FileInfo>(currPage, rowCount, Common.PAGESIZE, list);
		
		return pages;
	}

	@Override
	public int getRowCount(FileInfo fileInfo) {

		return this.fileInfoMapper.getRowCount(fileInfo);
	}

	@Override
	public FileInfo selectById(Integer fileid) {

		return this.fileInfoMapper.selectOne(fileid);
	}
	
	@Override
	public void removes(Integer[] fileids) {
		
		this.fileInfoMapper.deleteAll(fileids);
	}
	
	
}
