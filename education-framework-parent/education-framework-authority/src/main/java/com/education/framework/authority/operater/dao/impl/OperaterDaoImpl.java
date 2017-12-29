package com.education.framework.authority.operater.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import com.education.framework.authority.operater.dao.OperaterDao;
import com.education.framework.model.user.User;

/**
 * 用户
 */

@Component
public class OperaterDaoImpl extends SqlSessionDaoSupport implements OperaterDao{

    /**
     * 用户列表
     * 
     * @param map
     * @return
     */
    @Override
    public List<User> findAllUser(Map<String, Object> map) {
        return this.getSqlSession().selectList("operater.findAllUser", map);
    }

    /**
     * 用户统计
     * 
     * @param map
     * @return
     */
    @Override
    public Integer findAllUserCount(Map<String, Object> map) {
        return this.getSqlSession().selectOne("operater.findAllUserCount", map);
    }

    /**
     * 根据ID获取用户
     * 
     * @param userId 用户ID
     * @return
     */
    @Override
    public User findByUserId(Integer userId) {
        return this.getSqlSession().selectOne("operater.findByUserId", userId);
    }

    /**
     * 根据userName获取用户
     * 
     * @param userName 用户名
     * @return
     */
    @Override
    public User findByUserName(String userName) {
        return this.getSqlSession().selectOne("operater.findByUserName", userName);
    }

    /**
     * 修改用户信息
     * 
     * @param user
     * @return
     */
    @Override
    public Integer updateUser(User user) {
        return this.getSqlSession().update("operater.updateUser", user);
    }

    /**
     * 修改用户密码
     * 
     * @param user
     * @return
     */
    @Override
    public Integer updatePassword(User user) {
        return this.getSqlSession().update("operater.updatePassword", user);
    }

    /**
     * 添加用户
     * 
     * @param user
     * @return
     */
    @Override
    public Integer insertUser(User user) {
        return this.getSqlSession().insert("operater.insertUser", user);
    }

    /**
     * 删除用户
     * 
     * @param user
     * @return
     */
    @Override
    public Integer deleteUser(User user) {
        return this.getSqlSession().update("operater.deleteUser", user);
    }

}
