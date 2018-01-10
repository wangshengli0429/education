package com.education.framework.authority.role.dao;

import java.util.List;
import java.util.Map;

import com.education.framework.authority.role.model.Role;

public interface RoleDao {

    /**
     * 获取所有角色
     * 
     * @param map
     * @return
     */
    List<Role> findAllRole(Map<String, Object> map);
    
    Integer findRoleCount(Map<String, Object> map);
    /**
     * 根据用户ID获取用所拥有的角色
     * 
     * @param userId
     * @return
     */
    List<Role> getRoleByManagementCode(String manageCode);
    
    Role getRoleById(Map<String, Object> map);
    int insertRole(Role role);
    int updateRole(Role role);
    int deleteRole(Integer roleId);
}
