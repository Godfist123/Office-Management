package com.as.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.dao.MenuMapper;
import com.as.domain.Menu;
import com.as.domain.UsersMenu;
import com.as.service.MenuService;

/**
 * 	权限的逻辑层实现类
 * @author 小陈
 *
 */
@Service //IOC控制反转,实现NewsTypeServiceImpl的创建和管理
public class MenuServiceImpl implements MenuService{
	
	//DI 依赖注入
	@Autowired
	private MenuMapper menuMapper;
	
	
	@Override
	public List<Menu> selectMenu(Integer parentid){
		
		List<Menu> list= this.menuMapper.selectMenu(parentid);
		
		return list;
	}


	@Override
	public List<UsersMenu> selectByEmpId(Integer empid) {

		return this.menuMapper.selectByEmpId(empid);
	}
	
	
	@Override
	public void updateUsersMenu(Integer[] menuids,Integer empid) {
		
		this.menuMapper.delete(empid);
		this.menuMapper.insertMenuids(menuids, empid);
	}


	@Override
	public List<Menu> selectLoginMenu(Integer empid, Integer parentid) {

		return this.menuMapper.selectLoginMenu(empid, parentid);
	}
	
	
}
