package com.as.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.as.domain.Menu;
import com.as.domain.UsersMenu;

/**
 * 权限数据访问层
 * @author 小陈
 *
 */
public interface MenuMapper {

	
	/**
	 * 查询菜单
	 * @param parentid
	 * @return
	 */
	public List<Menu> selectMenu(Integer parentid);
	
	/**
	 * 得到当前用户的权限
	 * @param empid
	 * @return
	 */
	public List<UsersMenu> selectByEmpId(Integer empid);
	
	
	//保存修改后的权限时, 1.删除原有的权限, 2.批量添加
	/**
	 * 删除当前用户原有的权限
	 * @param empid
	 */
	public void delete(Integer empid);
	
	/**
	 * 批量添加
	 * @param menuids
	 */
	public void insertMenuids(@Param("menuids")Integer[] menuids,@Param("empid")Integer empid);
	
	/**
	 * 查出当前登录用户的权限(显示在侧边栏)
	 * @param empid
	 * @param parentid
	 * @return
	 */
	public List<Menu> selectLoginMenu(@Param("empid")Integer empid,@Param("parentid")Integer parentid);
	
}
