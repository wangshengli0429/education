package com.education.framework.authority.menu.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.framework.authority.menu.dao.MenuDao;
import com.education.framework.authority.menu.model.Menu;
import com.education.framework.authority.menu.service.MenuService;
import com.education.framework.common.base.ApiResult;
import com.google.common.collect.Maps;

@Service
@Transactional
public class MenuServiceImpl implements MenuService{

    private static Logger logger = Logger.getLogger(MenuServiceImpl.class);
	@Autowired
	private MenuDao menuDao;
	@Override
	public ApiResult findAllMenu(Map<String, Object> map) {
		
		
		
		return null;
	}

	@Override
	public ApiResult deleteMenu(String id) {
		 
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
		Map<String, Object> map = Maps.newHashMap();
		map.put("manageCode", manageCode);
		List<Menu> menuList = menuDao.getMenuByCode(map);
		logger.info("菜单："+menuList.size());
		return menuList;
	}

}
