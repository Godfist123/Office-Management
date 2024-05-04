package com.as.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.as.domain.Employee;

/**
 * 员工数据访问接口
 * @author 小陈
 *
 */
public interface EmployeeMapper {

	/**
	 * 	新增
	 * @param employee
	 */
	public void insert(Employee employee);
	
	/**
	 * 	删除
	 * @param empId
	 */
	public void delete(Integer empId);
	
	/**
	 * 	修改
	 * @param employee
	 */
	public void update(Employee employee);
	
	/**
	 * 	分页条件查询
	 * @param skip
	 * @param take
	 * @param employee
	 * @return
	 */
	public List<Employee> select(@Param("skip")Integer skip,@Param("take")Integer take,@Param("employee")Employee employee);
	
	/**
	 * 	获取记录条数
	 * @param employee
	 * @return
	 */
	public Integer getRowCount(@Param("employee")Employee employee);
	
	/**
	 *	 根据员工id查询
	 * @param empId
	 * @return
	 */
	public Employee selectById(Integer empId);
	
	/**
	 * 	批量删除
	 * @param empIds
	 */
	public void deleteAll(@Param("empIds")Integer[] empIds);
	
	/**
	 * 登录
	 */
	public Employee login(Employee employee);
	
	/**
	 * 查询去重后的职位
	 * @param employee
	 * @return
	 */
	public List<Employee> listPosition(Employee employee);
	
	/**
	 * 修改密码
	 * @param empId
	 */
	public void updatePassword(@Param("empId")Integer empId,@Param("password")String password);
	
	
	/**
	 * 修改用户状态
	 * @param empId
	 */
	public void updateState(Integer empId);
}
