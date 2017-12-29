package com.education.framework.authority.common.service;

import org.apache.commons.lang.StringUtils;

import com.education.framework.common.util.Const;

/**
 * 正则验证
 */

public final class Regservice {

    /** 邮箱正则 */
    private static final String NAMEREG = "^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$";
    /** 密码正则：数字、字母 */
    private static final String PWDREG = "^[0-9a-zA-Z]+$";
    /** 用户名的长度 */
    private static final Integer USER_NAME_LEN = 50;
    /** 密码最小长度 */
    private static final Integer PWD_MIN_LEN = 8;
    /** 密码最大长度 */
    private static final Integer PWD_MAX_LEN = 16;

    /**
     * 验证用户名
     * 
     * @param userName
     * @return
     */
    public static String confUserName(String userName) {
        String errorMsg = "";
        if (StringUtils.isBlank(userName)) {
            errorMsg = Const.Base.LOGIN_USERNAME_ERRINFO;
        } else if (!userName.matches(NAMEREG)) {
            errorMsg = Const.Base.USER_NAME_REG;
        } else if (userName.length() > USER_NAME_LEN) {
            errorMsg = Const.Base.USER_NAME_LEN;
        }
        return errorMsg;
    }
    
    /**
     * 密码验证
     * @param password
     * @return
     */
    public static String confPassword(String password) {
        String errorMsg = "";
        if (StringUtils.isBlank(password)) {
            errorMsg = Const.Base.LOGIN_PASSWORD_ERRINFO;
        } else if (!password.matches(PWDREG)) {
            errorMsg = Const.Base.LOGIN_PWD_REG;
        } else if (password.length() < PWD_MIN_LEN || PWD_MIN_LEN > PWD_MAX_LEN) {
            errorMsg = Const.Base.LOGIN_PWD_LEN;
        }
        return errorMsg;
    }
}
