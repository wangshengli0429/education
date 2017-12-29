package com.education.framework.authority.login.service.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.framework.authority.common.service.VarKeys;
import com.education.framework.authority.login.service.LoginService;
import com.education.framework.authority.operater.service.OperaterService;
import com.education.framework.common.service.LogFormatService;
import com.education.framework.common.util.Const;
import com.education.framework.common.util.MD5Util;
import com.education.framework.model.user.LoginUser;
import com.education.framework.model.user.User;

@Service
public class LoginServiceImpl implements LoginService {

    /** 日志 */
    private static Logger LOGGER = Logger.getLogger(LoginServiceImpl.class);
    @Autowired
    private OperaterService operaterService;
    
    /** startTime */
    private long startTime;

    /**
     * 登录处理
     * 
     * @param valueMap
     */
    @Override
    public void doLogin(Map<String, Object> valueMap) {
        startTime = System.currentTimeMillis();
       
        String userName =
                ((LoginUser) valueMap.get(VarKeys.structKey(VarKeys.LOGIN, VarKeys.LOGIN_USER))).getUserName();
        String password =
                ((LoginUser) valueMap.get(VarKeys.structKey(VarKeys.LOGIN, VarKeys.LOGIN_USER))).getPassWord();
        User user = operaterService.findByUserName(userName);
        startTime = System.currentTimeMillis();
        try {
            if (user == null) {
                valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.FLAG), false);
                valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.MSG), Const.Base.USER_ERRINFO);
                LOGGER.error(LogFormatService.logFormat(Const.Base.USER_ERRINFO + "<userName:" + userName + ">",
                        startTime, LoginServiceImpl.class.toString() + ":doLogin"));
            } else {
                if (StringUtils.isNotBlank(user.getPassword())
                        && MD5Util.getEncryptedPwd(password).equals(user.getPassword())) {
//                	   roleList = roleService.getRole(user.getUserId());
                       valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.FLAG), true);
                       valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.LOGIN_USER), new LoginUser(user, null));
                       if (user.getIsstaff() != null && user.getIsstaff() == Const.Base.ISSTAFF_Y) {
//                           findMenuListByUserId(valueMap);
                       }
//                       findResourceByUser(valueMap);
                } else {
                    valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.FLAG), false);
                    valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.MSG), Const.Base.USER_PWD_ERRINFO);
                    LOGGER.error(LogFormatService.logFormat(
                            Const.Base.USER_PWD_ERRINFO + "<userName:" + userName + ">", startTime,
                            LoginServiceImpl.class.toString() + ":doLogin"));
                }
            }
        } catch (Exception e) {
            valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.FLAG), false);
            valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.MSG),
                    "系统繁忙，请稍候再试");
            LOGGER.error(LogFormatService.logFormat("用户<" + userName + ">:登录异常", startTime,
                    LoginServiceImpl.class.toString() + ":doLogin"), e);
        }
    }

    /**
     * 根据角色ID查询角色信息与目录.
     * 
     * @param valueMap
     */
    
}
