package com.education.framework.dao.user;

import java.util.Map;

import com.education.framework.model.user.User;


public interface UserDao {
	 
	int insertUser(User user);
	int updateUserById(User user);
	User queryUserById(Map<String, Object> map);
}
