package com.as.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取属性文件类
 * 通用类
 * @date 2021-09-14
 * @author teacher Zhang
 *
 */
public class ReadProperies extends Properties {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ReadProperies readProperies=null;
	
	//私有的构造函数
	private ReadProperies() 
	{
		//读取属性文件
		//存放在src/db.propteries
		InputStream is=this.getClass().getResourceAsStream("/configuration.properties");
		//加载
		try {
			this.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ReadProperies getInstance()
	{
		if(readProperies==null)
		{
			readProperies=new ReadProperies();
		}
		return readProperies;
	}
	

}
