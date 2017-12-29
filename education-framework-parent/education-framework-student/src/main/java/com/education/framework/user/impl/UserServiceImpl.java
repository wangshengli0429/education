package com.education.framework.user.impl;
 

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.framework.dao.user.UserDao;
import com.education.framework.model.user.UserInfo;
import com.education.framework.service.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	 /** 日志 */
    private static Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
    
    @Autowired
    private UserDao userDao;
	@Override
	@Transactional
	public UserInfo getUser(int id) {
		UserInfo userInfo = null;
		try {
			userInfo = userDao.getUserById(id);
		} catch (Exception e) {
			LOGGER.debug("系统异常：",e);
			System.out.println(e);
		}
		return userInfo;
	}

}
