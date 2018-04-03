package com.education.framework.dao.user;

import com.education.framework.model.po.User;

import java.util.Map;



public interface UserDao {
	 
	int insertUser(User user);
	int updateUserById(User user);
	User queryUserById(Map<String, Object> map);
}
