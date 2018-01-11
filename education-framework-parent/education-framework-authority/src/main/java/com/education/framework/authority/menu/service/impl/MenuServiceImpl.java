package com.education.framework.authority.menu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.framework.authority.menu.dao.MenuDao;
import com.education.framework.authority.menu.model.Menu;
import com.education.framework.authority.menu.service.MenuService;
import com.education.framework.common.base.ApiResult;

@Service
@Transactional
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuDao menuDao;
	@Override
	public ApiResult findAllMenu(Map<String, Object> map) {
		
		
		
		return null;
	}

	@Override
	public ApiResult deleteMenu(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResult insertMenu(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResult updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> getMenuByCode(String manageCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
