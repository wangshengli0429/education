package com.education.framework.authority.operater.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.education.framework.authority.operater.dao.OperaterDao;
import com.education.framework.authority.operater.service.OperaterService;
import com.education.framework.common.service.LogFormatService;
import com.education.framework.model.user.User;

@Service
@Transactional
public class OperaterServiceImpl implements OperaterService {

    /** 日志 */
    private static Logger LOGGER = Logger.getLogger(OperaterServiceImpl.class);
    @Autowired
    private OperaterDao userDao;

    /**
     * 用户列表
     * 
     * @param map
     * @return
     */
    @Override
    public List<User> findAllUser(Map<String, Object> map) {
        LOGGER.info(LogFormatService.logFormat("获取用户列表", OperaterServiceImpl.class.toString() + ":findAllUser"));
        return userDao.findAllUser(map);
    }

    /**
     * 用户统计
     * 
     * @param map
     * @return
     */
    @Override
    public Integer findAllUserCount(Map<String, Object> map) {
        LOGGER.info(LogFormatService.logFormat("用户统计", OperaterServiceImpl.class.toString() + ":findAllUser"));
        return userDao.findAllUserCount(map);
    }

    /**
     * 根据ID获取用户
     * 
     * @param userId 用户ID
     * @return
     */
    @Override
    public User findByUserId(Integer userId) {
        LOGGER.info(LogFormatService.logFormat("根据ID获取用户", OperaterServiceImpl.class.toString() + ":findAllUser"));
        return null;
    }

    /**
     * 根据userName获取用户
     * 
     * @param userName 用户名
     * @return
     */
    @Override
    public User findByUserName(String userName) {
        User user = userDao.findByUserName(userName);
        if (user != null) {
            LOGGER.info(LogFormatService.logFormat("根据userName获取用户成功",
                    OperaterServiceImpl.class.toString() + ":findAllUser"));
        } else {
            LOGGER.info(LogFormatService.logFormat("根据userName获取用户:用户信息为空",
                    OperaterServiceImpl.class.toString() + ":findAllUser"));
        }
        return user;
    }

    /**
     * 修改用户信息
     * 
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {
        LOGGER.info(LogFormatService.logFormat("修改用户信息", OperaterServiceImpl.class.toString() + ":findAllUser"));
        return false;
    }

    /**
     * 修改用户密码
     * 
     * @param user
     * @return
     */
    @Override
    public boolean updatePassword(User user) {
        LOGGER.info(LogFormatService.logFormat("修改用户密码", OperaterServiceImpl.class.toString() + ":findAllUser"));
        return false;
    }

    /**
     * 添加用户
     * 
     * @param user
     * @return
     */
    @Override
    public boolean insertUser(User user) {
        LOGGER.info(LogFormatService.logFormat("添加用户", OperaterServiceImpl.class.toString() + ":findAllUser"));
        return false;
    }

    /**
     * 删除用户
     * 
     * @param user
     * @return
     */
    @Override
    public boolean deleteUser(User user) {
        LOGGER.info(LogFormatService.logFormat("删除用户", OperaterServiceImpl.class.toString() + ":findAllUser"));
        return false;
    }

}
