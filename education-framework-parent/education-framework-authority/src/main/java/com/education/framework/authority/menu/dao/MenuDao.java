package com.education.framework.authority.menu.dao;

import java.util.List;
import java.util.Map;

import com.education.framework.authority.menu.model.Menu;

public interface MenuDao {
	List<Menu> findAllMenu(Map<String, Object> map);
	int findAllMenuCount(Map<String, Object> map);
	
	int deleteMenu(String id);
	int insertMenu(Menu menu);
	int updateMenu(Menu menu);
	/**
	 * 根据Code获取菜单 
	 * @param manageCode
	 * @return
	 */
	List<Menu> getMenuByCode(Map<String, Object> map);
}
