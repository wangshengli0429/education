package com.education.framework.authority.menu.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.education.framework.authority.menu.dao.MenuDao;
import com.education.framework.authority.menu.model.Menu;
@Repository
public class MenuDaoOImpl extends SqlSessionDaoSupport implements MenuDao {

	
	@Override
	public List<Menu> findAllMenu(Map<String, Object> map) {
		return this.getSqlSession().selectList("menu.findAllMenu", map);
	}

	@Override
	public int findAllMenuCount(Map<String, Object> map) {
		return this.getSqlSession().selectOne("menu.findAllMenuCount", map);
	}

	@Override
	public int deleteMenu(String id) {
		return this.getSqlSession().delete("menu.deleteMenu", id);
	}

	@Override
	public int insertMenu(Menu menu) {
		return this.getSqlSession().insert("menu.insertMenu", menu);
	}

	@Override
	public int updateMenu(Menu menu) {
		return this.getSqlSession().update("menu.updateMenu", menu);
	}

	@Override
	public  List<Menu> getMenuByCode(Map<String, Object> map) {
		return this.getSqlSession().selectList("menu.getMenuByCode", map);
	}

}
