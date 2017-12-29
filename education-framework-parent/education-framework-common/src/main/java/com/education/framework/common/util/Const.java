package com.education.framework.common.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.education.framework.common.service.LogFormatService;

/**
 * 常量类
 */
public class Const {

    /** log */
    private static final Logger LOGGER = Logger.getLogger(Const.class);
    public static final String UNKONW = "未知错误";

    /**
     * init method
     */
    @SuppressWarnings("unused")
    private void init() {
        LOGGER.info(LogFormatService.logogram("初始化常量参数"));
        try {
            Base.initLogin(isstaffy, isstaffn, loginParamErr, loginUserNameErr, loginPwdErr, loginStaffErr);
            Base.initUser(userErr, userPwdErr, userNameReg, userNameLen, userPwdReg, userPwdLen);
            Base.initCurdMsg(addSucess, addFailed, updateSucess, updateFailed, delSucess, delFailed, findSucess,
                    findFailed);
            LOGGER.info(LogFormatService.logogram("初始化常量参数success..."));
        } catch (Exception e) {
            LOGGER.error(LogFormatService.logogram("初始化常量参数failed"), e);
        }
    }

    @Value("${etp.login.isstaffy}")
    private String isstaffy;
    @Value("${etp.login.isstaffn}")
    private String isstaffn;
    @Value("${etp.login.param.errInfo}")
    private String loginParamErr;
    @Value("${etp.login.userName.errInfo}")
    private String loginUserNameErr;
    @Value("${etp.login.password.errInfo}")
    private String loginPwdErr;
    @Value("${etp.login.staff.errInfo}")
    private String loginStaffErr;
    @Value("${etp.user.errInfo}")
    private String userErr;
    @Value("${etp.user.pwd.errInfo}")
    private String userPwdErr;
    @Value("${etp.user.userName.reg}")
    private String userNameReg;
    @Value("${etp.user.userName.len}")
    private String userNameLen;
    @Value("${etp.user.pwd.reg}")
    private String userPwdReg;
    @Value("${etp.user.pwd.len}")
    private String userPwdLen;
    // CRUD
    @Value("${etp.add.sucess}")
    private String addSucess;
    @Value("${etp.add.failed}")
    private String addFailed;
    @Value("${etp.update.sucess}")
    private String updateSucess;
    @Value("${etp.update.failed}")
    private String updateFailed;
    @Value("${etp.del.sucess}")
    private String delSucess;
    @Value("${etp.del.failed}")
    private String delFailed;
    @Value("${etp.find.sucess}")
    private String findSucess;
    @Value("${etp.find.failed}")
    private String findFailed;

    public static class Base {

        public static Integer ISSTAFF_Y;
        public static Integer ISSTAFF_N;
        public static String LOGIN_PARAM_ERRINFO;
        public static String LOGIN_USERNAME_ERRINFO;
        public static String LOGIN_PASSWORD_ERRINFO;
        public static String LOGIN_STAFF_ERRINFO;

        public static String USER_ERRINFO;
        public static String USER_PWD_ERRINFO;
        public static String USER_NAME_REG;
        public static String USER_NAME_LEN;
        public static String LOGIN_PWD_REG;
        public static String LOGIN_PWD_LEN;

        public static String ADD_SUCESS;
        public static String ADD_FAILED;
        public static String UPDATE_SUCESS;
        public static String UPDATE_FAILED;
        public static String DEL_SUCESS;
        public static String DEL_FAILED;
        public static String FIND_SUCESS;
        public static String FIND_FAILED;

        /**
         * init login error param
         */
        private static void initLogin(String isstaffy, String isstaffn, String loginParamErr, String loginUserNameErr,
                String loginPwdErr, String loginStaffErr) {
            ISSTAFF_Y = Integer.parseInt(isstaffy);
            ISSTAFF_N = Integer.parseInt(isstaffn);
            LOGIN_PARAM_ERRINFO = loginParamErr;
            LOGIN_USERNAME_ERRINFO = loginUserNameErr;
            LOGIN_PASSWORD_ERRINFO = loginPwdErr;
            LOGIN_STAFF_ERRINFO = loginStaffErr;
        }

        /**
         * init user error param
         */
        private static void initUser(String userErr, String userPwdErr, String userNameReg, String userNameLen,
                String userPwdReg, String userPwdLen) {
            USER_ERRINFO = userErr;
            USER_PWD_ERRINFO = userPwdErr;
            USER_NAME_REG = userNameReg;
            USER_NAME_LEN = userNameLen;
            LOGIN_PWD_REG = userPwdReg;
            LOGIN_PWD_LEN = userPwdLen;
        }

        /**
         * init CURD msg
         */
        private static void initCurdMsg(String addSucess, String addFailed, String updateSucess, String updateFailed,
                String delSucess, String delFailed, String findSucess, String findFailed) {
            ADD_SUCESS = addSucess;
            ADD_FAILED = addFailed;
            UPDATE_SUCESS = updateSucess;
            UPDATE_FAILED = updateFailed;
            DEL_SUCESS = delSucess;
            DEL_FAILED = delFailed;
            FIND_SUCESS = findSucess;
            FIND_FAILED = findFailed;
        }
    }

    /**
     * 返回结果处理枚举
     */
    public static class ResultCode {

        /**
         * ERR_MSG.
         */
        public static final String[] ERR_MSG = {
                "success", // 00
                "未知原因", // 01
                "请求参数格式错误" // 02
        };
        public static final int SUCCESS = 0;
        public static final int ERR_UNKOWN = 1;
        public static final int ERR_REQUEST_PARAM_ERROR = 2;
    }

    /** 有效 */
    public final static String FLAG_1 = "1";
    /** 无效 */
    public final static String FLAG_0 = "0";
    /** 员工权限 */
    public final static String ADMIN = "admin";
    /** 运行数据库数驱动 */
    public final static String MYSQL = "com.mysql.jdbc.Driver";
    /** DELETE */
    public static final String DELETE = "DELETE";
    /** UPDATE */
    public static final String UPDATE = "UPDATE";
    /** INSERT */
    public static final String INSERT = "INSERT";
    /** ADD */
    public static final String ADD = "add";
    /** UPT */
    public static final String UPT = "update";

}
