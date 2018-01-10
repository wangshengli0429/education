package com.education.framework.authority.management.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.education.framework.authority.management.dao.ManagementDao;
import com.education.framework.authority.model.Management;
@Repository
public class ManageDaoImpl extends SqlSessionDaoSupport implements
		ManagementDao {

	@Override
	public List<Management> findAllManagement(Map<String, Object> map) {
		return this.getSqlSession().selectList("management.findAllManagement", map);
	}

	@Override
	public int findAllManagementCount(Map<String, Object> map) {
		return this.getSqlSession().selectOne("management.findAllManagementCount", map);
	}

	@Override
	public int deleteManagement(String id) {
	 
		return this.getSqlSession().update("management.deleteManagement", id);
	}

	@Override
	public int insertManagement(Management management) {
		return this.getSqlSession().insert("management.insertManagement", management);
	}

	@Override
	public int updateManagement(Management management) {
		return this.getSqlSession().update("management.updateManagement", management);
	}

	@Override
	public int updateManagetByPassword(Management management) {
		return this.getSqlSession().update("management.updateManagetByPassword", management);
	}

	@Override
	public Management findByManagementCode(String manageCode) {
		 
		return this.getSqlSession().selectOne("management.findByManagementCode", manageCode);
	}

}
