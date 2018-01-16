package com.education.framework.authority.role.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.education.framework.authority.role.dao.RoleDao;
import com.education.framework.authority.role.model.Role;

@Repository
public class RoleDaoImpl extends SqlSessionDaoSupport implements RoleDao{

	@Override
	public List<Role> findAllRole(Map<String, Object> map) {
		return this.getSqlSession().selectList("role.RoleDaoImpl",map);
	}

	@Override
	public Integer findRoleCount(Map<String, Object> map) {
		return this.getSqlSession().selectOne("role.findRoleCount", map);
	}

	@Override
	public List<Role> getRoleByManagementCode(@Param("manageCode")String manageCode) {
		return this.getSqlSession().selectList("role.getRoleByManagementCode", manageCode);
	}

	@Override
	public Role getRoleById(Map<String, Object> map) {
		
		return this.getSqlSession().selectOne("role.getRoleById", map);
	}

	@Override
	public int insertRole(Role role) {
		return this.getSqlSession().insert("role.insertRole", role);
	}

	@Override
	public int updateRole(Role role) {
		return this.getSqlSession().update("role.updateRole", role);
	}

	@Override
	public int deleteRole(Integer roleId) {
		return this.getSqlSession().delete("role.deleteRole", roleId);
	}

}
