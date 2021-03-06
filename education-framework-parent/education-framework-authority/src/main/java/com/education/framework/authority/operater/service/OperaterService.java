package com.education.framework.authority.operater.service;

import java.util.List;
import java.util.Map;

import com.education.framework.model.user.User;

/**
 * 用户
 */

public interface OperaterService {

    /**
     * 用户列表
     * 
     * @param map
     * @return
     */
    List<User> findAllUser(Map<String, Object> map);

    /**
     * 用户统计
     * 
     * @param map
     * @return
     */
    Integer findAllUserCount(Map<String, Object> map);

    /**
     * 根据ID获取用户
     * 
     * @param userId 用户ID
     * @return
     */
    User findByUserId(Integer userId);

    /**
     * 根据userName获取用户
     * 
     * @param userName 用户名
     * @return
     */
    User findByUserName(String userName);

    /**
     * 修改用户信息
     * 
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 修改用户密码
     * 
     * @param user
     * @return
     */
    boolean updatePassword(User user);

    /**
     * 添加用户
     * 
     * @param user
     * @return
     */
    boolean insertUser(User user);

    /**
     * 删除用户
     * 
     * @param user
     * @return
     */
    boolean deleteUser(User user);
}
