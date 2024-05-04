package com.as.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.as.domain.Employee;
import com.as.util.Pages;

/**
 * 	员工业务逻辑层接口
 * @author 小陈
 *
 */
public interface EmployeeService {

	/**
	 * 	新增
	 * @param employee
	 */
	public void append(Employee employee);
	
	/**
	 * 	删除
	 * @param empId
	 */
	public void remove(Integer empId);
	
	/**
	 * 	修改
	 * @param employee
	 */
	public void modify(Employee employee,MultipartFile files);
	
	/**
	 *	 分页查询
	 * @param currPage
	 * @param employee
	 * @return
	 */
	 public Pages<Employee> list(Integer currPage,Employee employee);
	
	/**
	 *	 根据id查询
	 * @param empId
	 * @return
	 */
	public Employee selectOne(Integer empId);
	
	/**
	 * 	批量删除
	 * @param empIds
	 */
	public void removes(Integer[] empIds);
	
	/**
	 * 登录
	 */
	public Employee login(Employee employee);
	
	/**
	 * 查询去重后的职位
	 * @param employee
	 * @return
	 */
	public List<Employee> Listposition(Employee employee);
	
	/**
	 * 修改密码
	 * @param empId
	 */
	public void updatePassword(Integer empId,String password);
	
	/**
	 * 修改用户状态
	 * @param empId
	 */
	public void updateState(Integer empId);
	
}
