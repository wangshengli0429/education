package com.education.framework.dao.user.impl;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.education.framework.dao.user.UserDao;
import com.education.framework.model.user.User;
@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public int insertUser(User user) {
		return this.getSqlSession().insert("user.insertUser", user);
	}

	@Override
	public int updateUserById(User user) {
		return this.getSqlSession().update("user.updateUserById", user);
	}

	@Override
	public User queryUserById(Map<String, Object> map) {
		return this.getSqlSession().selectOne("user.queryUserById", map);
	}

}
