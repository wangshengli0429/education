package com.education.framework.authority.menu.service;

import java.util.List;
import java.util.Map;

import com.education.framework.authority.menu.model.Menu;
import com.education.framework.common.base.ApiResult;

public interface MenuService {
	ApiResult findAllMenu(Map<String, Object> map);
	
	ApiResult deleteMenu(String id);
	ApiResult insertMenu(Menu menu);
	ApiResult updateMenu(Menu menu);
	List<Menu> getMenuByCode(String manageCode);
}
