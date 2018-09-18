package com.education.framework.service;

import java.util.Map;

/**
 * @author wq
 * @createTime 2018/9/16.
 * @lastUpdater wq
 * @lastUpdateTime 2018/9/16.
 * @note
 */
public interface LoginApi {
    /**
     * 验证提交参数
     * @param userName
     * @param password
     * @return
     */
    Map<String,Object> validate(String userName, String password);

}
