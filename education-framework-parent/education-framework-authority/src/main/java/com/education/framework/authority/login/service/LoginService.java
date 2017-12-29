package com.education.framework.authority.login.service;

import java.util.Map;

public interface LoginService {

    /**
     * 登录处理
     * 
     * @param valueMap
     */
    void doLogin(Map<String, Object> valueMap);
}
