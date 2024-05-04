package com.as.service;

import java.util.List;

import com.as.domain.Menu;
import com.as.domain.UsersMenu;

/**
 *	权限的业务逻辑接口
 * @author 小陈
 *
 */
public interface MenuService {

	
	/**
	 * 查询权限菜单
	 * @param menu
	 * @return
	 */
	public List<Menu> selectMenu(Integer parentid);

	/**
	 * 得到用户的权限
	 * @param empid
	 * @return
	 */
	public List<UsersMenu> selectByEmpId(Integer empid);
	
	/**
	 * 修改权限
	 * @param menuids
	 * @param empid
	 */
	public void updateUsersMenu(Integer[] menuids,Integer empid);
	
	
	/**
	 * 查出当前登录用户的权限(显示在侧边栏)
	 * @param empid
	 * @param parentid
	 * @return
	 */
	public List<Menu> selectLoginMenu(Integer empid,Integer parentid);
	
	
	
}
