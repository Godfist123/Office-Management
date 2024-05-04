package com.as.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.as.dao.EmployeeMapper;
import com.as.domain.Employee;
import com.as.service.EmployeeService;
import com.as.util.Common;
import com.as.util.Pages;
import com.as.util.UploadFile;

/**
 * 	员工业务逻辑层实现类
 * @author 小陈
 *
 */
@Service //IOC控制反转,实现UsersServiceImpl的创建和管理
public class EmployeeServiceImpl implements EmployeeService{
	
	//DI 依赖注入,实现UsersMapper接口并赋值
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private HttpServletRequest request;
	
	
	@Override
	public void append(Employee employee) {
		
		this.employeeMapper.insert(employee);
	}
	
	@Override
	public void remove(Integer empId) {
		
		this.employeeMapper.delete(empId);
	}
	
	@Override
	public void modify(Employee employee,MultipartFile files) {
		
		//上传图片
		String filename=UploadFile.fileUp(files, request);
		//如果上传新的文件
		if(filename!=null) {
			
			employee.setPicture(filename);
		}
		
		this.employeeMapper.update(employee);
	}
	
	 @Override
	 public Pages<Employee> list(Integer currPage,Employee employee){
		 
		 //查询时初始页面没有值
		 if (employee.getState()==null) employee.setState(0);
		 if (employee.getDepartId()==null) employee.setDepartId(0);
		 
		 List<Employee> list=this.employeeMapper.select((currPage-1)*Common.PAGESIZE, Common.PAGESIZE, employee);
		 int rowCount=this.employeeMapper.getRowCount(employee);  
		 Pages<Employee> pages=new Pages<Employee>(currPage, rowCount, Common.PAGESIZE, list);
		 return pages;
	 }
	
	@Override
	public Employee selectOne(Integer empId) {
		
		return this.employeeMapper.selectById(empId);
	}

	@Override
	public void removes(Integer[] empIds) {

		this.employeeMapper.deleteAll(empIds);
		
	}

	@Override
	public Employee login(Employee employee) {

		Employee emp=this.employeeMapper.login(employee);
		
		if(emp!=null) {
			
			if(emp.getState()==1) {
				//正常
				emp.setFlag(1);
			}else {
				//加锁
				emp.setFlag(2);
			}
		}else {
			//账号或密码不正确
			emp=new Employee();
			emp.setFlag(3);
		}
		
		return emp;
	}

	@Override
	public List<Employee> Listposition(Employee employee) {

		return this.employeeMapper.listPosition(employee);
	}

	@Override
	public void updatePassword(Integer empId,String password) {

		this.employeeMapper.updatePassword(empId,password);
	}

	@Override
	public void updateState(Integer empId) {

		this.employeeMapper.updateState(empId);
	}
	
}
