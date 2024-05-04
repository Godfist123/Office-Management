package com.as.util;

/**
 * 常量类
 * @author 小陈
 *
 */
public class Common {

	/**
	 * 每页大小
	 */
	public static final int PAGESIZE=Integer.parseInt(ReadProperies.getInstance().getProperty("pageSize"));
	public static final String URL=ReadProperies.getInstance().getProperty("url");
	public static final String USERNAME=ReadProperies.getInstance().getProperty("username");
	public static final String PASSWORD=ReadProperies.getInstance().getProperty("password");
	public static final String DRIVER=ReadProperies.getInstance().getProperty("driver");
	/**
	 * 图片上传目录
	 */
	public static final String UPLOAD=ReadProperies.getInstance().getProperty("upload");
}
