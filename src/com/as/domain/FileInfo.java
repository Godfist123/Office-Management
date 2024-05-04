package com.as.domain;

/**
 * 	文件上传实体类
 */
public class FileInfo {
	
	/**
	 * 	文件id
	 */
	private Integer fileid;

	/**
	 * 	文件名称
	 */
	private String filename;

	/**
	 * 	文件地址
	 */
	private String fileurl;

	/**
	 * 	文件介绍
	 */
	private String filedesc;

	/**
	 * 	员工id,谁上传的文件
	 */
	private Integer empid;

	/**
	 * 	上传员工
	 */
	private String empname;

	/**
	 * 	上传员工所在的部门
	 */
	private String departname;

	/**
	 * 	下载次数
	 */
	private Integer count;

	/**
	 * 	文件大小
	 */
	private Double filesize;

	/**
	 * 	上传时间
	 */
	private String posttime;

	public FileInfo() {
		
	}
	
	public FileInfo(Integer fileid, String filename, String fileurl, String filedesc, Integer empid, Integer count,
			Double filesize, String posttime) {
		super();
		this.fileid = fileid;
		this.filename = filename;
		this.fileurl = fileurl;
		this.filedesc = filedesc;
		this.empid = empid;
		this.count = count;
		this.filesize = filesize;
		this.posttime = posttime;
	}

	@Override
	public String toString() {
		return "FileInfo [fileid=" + fileid + ", filename=" + filename + ", fileurl=" + fileurl + ", filedesc="
				+ filedesc + ", empid=" + empid + ", count=" + count + ", filesize=" + filesize + ", posttime="
				+ posttime + "]";
	}

	public Integer getFileid() {
		return fileid;
	}

	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFileurl() {
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	public String getFiledesc() {
		return filedesc;
	}

	public void setFiledesc(String filedesc) {
		this.filedesc = filedesc;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getFilesize() {
		return filesize;
	}

	public void setFilesize(Double filesize) {
		this.filesize = filesize;
	}

	public String getPosttime() {
		return posttime;
	}

	public void setPosttime(String posttime) {
		this.posttime = posttime;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getDepartname() {
		return departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
	}

	
}
