package com.education.framework.authority.role.service;

import java.util.List;
import java.util.Map;

import com.education.framework.authority.role.model.Role;
import com.education.framework.common.base.ApiResult;

public interface RoleService {
	  /**
     * 获取所有角色
     * 
     * @param map
     * @return
     */
    ApiResult findAllRole(Map<String, Object> map);
    
    List<String> getRole(String manageCode);
    ApiResult getRoleById(Map<String, Object> map);
    ApiResult insertRole(Role role);
    ApiResult updateRole(Role role);
    ApiResult deleteRole(Integer roleId);
}
