package com.as.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseDao {
	
	
	protected SqlSession session;
	

	
	/**
	 * MyBatis获取数据库连接
	 * @return SqlSession
	 */
	protected SqlSession getSqlSession(){
		try {
			//读取数据库连接的配置文件
			InputStream inputStream=Resources.getResourceAsStream("configuration.xml");
			//创建数据库连接工程
			SqlSessionFactoryBuilder sessionFactoryBuilder=new SqlSessionFactoryBuilder();
			//将配置文件的输入流赋予连接工程，通过连接工程创建连接工厂
			SqlSessionFactory sessionFactory=sessionFactoryBuilder.build(inputStream);
			session=sessionFactory.openSession(true);//打开一个连接
		//其中true,改为自动提交.默不写的话表示手动提交
			return session;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("空");
			return null;
		}
	}
	
	

	
}
