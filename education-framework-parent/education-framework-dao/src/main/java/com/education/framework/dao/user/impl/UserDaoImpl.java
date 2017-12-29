package com.education.framework.dao.user.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.education.framework.dao.user.UserDao;
import com.education.framework.model.user.UserInfo;

@Repository
public class UserDaoImpl extends  SqlSessionDaoSupport implements UserDao {
	@Override
	public UserInfo getUserById(int id) {
		return this.getSqlSession().selectOne("userInfo.getUserById",id);
	}

 
}
