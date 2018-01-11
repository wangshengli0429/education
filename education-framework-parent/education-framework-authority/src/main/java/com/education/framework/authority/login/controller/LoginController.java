package com.education.framework.authority.login.controller;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.education.framework.authority.base.BaseController;
import com.education.framework.authority.common.service.VarKeys;
import com.education.framework.authority.login.model.LoginUser;
import com.education.framework.authority.login.service.LoginService;
import com.education.framework.authority.notes.CurrentUser;
import com.education.framework.common.service.LogFormatService;
import com.education.framework.common.util.Const;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    /** 日志 */
    private static Logger LOGGER = Logger.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;
    /** startTime */
    private long startTime;

    /**
     * 登录
     */
    @RequestMapping(value = "doLogin", method = {RequestMethod.POST,RequestMethod.GET})
    public String login(Model model, LoginUser loginUser, HttpSession session) {
        startTime = System.currentTimeMillis();
        String userName = null;
        LOGGER.info(LogFormatService.logogram("登录start..."));
        //String url = "manager/index";
        String url = "manager/index1";
        if (loginUser == null) {
            model.addAttribute(VarKeys.MSG, Const.Base.LOGIN_PARAM_ERRINFO);
            LOGGER.error(LogFormatService.logogram(Const.Base.LOGIN_PARAM_ERRINFO));
        } else if (StringUtils.isBlank(loginUser.getManageCode())) {
            model.addAttribute(VarKeys.MSG, Const.Base.LOGIN_USERNAME_ERRINFO);
            LOGGER.error(LogFormatService.logogram("登录信息:" + Const.Base.LOGIN_USERNAME_ERRINFO));
        } else if (StringUtils.isBlank(loginUser.getManagePwd())) {
            model.addAttribute(VarKeys.MSG, Const.Base.LOGIN_PASSWORD_ERRINFO);
            model.addAttribute("userName", loginUser.getManageCode());
            LOGGER.error(LogFormatService.logogram("登录信息:" + Const.Base.LOGIN_PASSWORD_ERRINFO));
        } else {
            userName = loginUser.getManageCode();
            try {
                valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.LOGIN_USER), loginUser);
                loginService.doLogin(valueMap);
                boolean flag =
                        valueMap.get(VarKeys.structKey(VarKeys.LOGIN, VarKeys.FLAG)) == null ? false
                                : (boolean) valueMap.get(VarKeys.structKey(VarKeys.LOGIN, VarKeys.FLAG));
                String msg =
                        valueMap.get(VarKeys.structKey(VarKeys.LOGIN, VarKeys.MSG)) == null ? ""
                                : (String) valueMap.get(VarKeys.structKey(VarKeys.LOGIN, VarKeys.MSG));
                if (!flag) {
                    model.addAttribute(VarKeys.MSG, msg);
                    model.addAttribute("userName", loginUser.getManageCode());
                    LOGGER.info(LogFormatService.logogram("登录失败"));
                } else {
                    loginUser = (LoginUser) valueMap.get(VarKeys.structKey(VarKeys.LOGIN, VarKeys.LOGIN_USER));
                    if (loginUser == null) {
                        valueMap.remove(VarKeys.structKey(VarKeys.LOGIN, VarKeys.LOGIN_USER));
                        model.addAttribute(VarKeys.MSG, "登录时异常，请重新登录");
                        model.addAttribute("userName", userName);
                        LOGGER.info(LogFormatService.logogram("登录失败,loginUser获取信息错误"));
                    } else {
                        session.setAttribute("user", loginUser);
                        
//                        Integer isstaff = loginUser.getIsstaff();
//                        if (isstaff != null) {
//                            if (isstaff == Const.Base.ISSTAFF_N) { // 用户
//                                url = "index";
//                                LOGGER.info(LogFormatService.logogram("登录成功》信息:" + loginUser.toString()));
//                            } else if (isstaff == Const.Base.ISSTAFF_Y) { // 员工
//                                url = "main";
//                                model.addAttribute("menuList", valueMap.get("login.menuList"));
//                                LOGGER.info(LogFormatService.logogram("登录成功》信息:" + loginUser.toString()));
//                            } else {
////                                valueMap.remove(VarKeys.structKey(VarKeys.LOGIN, VarKeys.LOGIN_USER));
////                                session.removeAttribute("user");
////                                model.addAttribute(VarKeys.MSG, Const.Base.LOGIN_STAFF_ERRINFO);
//                                model.addAttribute("userName", userName);
//                                
//                                LOGGER.info(LogFormatService.logogram(Const.Base.LOGIN_STAFF_ERRINFO + "<isstaff:"
//                                        + isstaff + ">"));
//                            }
//                        } else {
//                            valueMap.remove(VarKeys.structKey(VarKeys.LOGIN, VarKeys.LOGIN_USER));
//                            session.removeAttribute("user");
//                            model.addAttribute(VarKeys.MSG, Const.Base.LOGIN_STAFF_ERRINFO);
//                            model.addAttribute("userName", userName);
//                            LOGGER.info(LogFormatService.logogram(Const.Base.LOGIN_STAFF_ERRINFO + "<isstaff:"
//                                    + isstaff + ">"));
//                        }
                    }
                }
            } catch (Exception e) {
                if (session.getAttribute("user") != null) {
                    session.removeAttribute("user");
                }
                valueMap.remove(VarKeys.structKey(VarKeys.LOGIN, VarKeys.LOGIN_USER));
                model.addAttribute(VarKeys.MSG, "系统繁忙，请稍候再试");
                model.addAttribute("userName", loginUser.getManageCode());
                LOGGER.error(LogFormatService.logFormat("登录end,登录异常", startTime,
                        LoginController.class.toString() + ":login"), e);
            }
        }
        LOGGER.info(LogFormatService.logFormat("登录end", startTime, LoginController.class.toString() + ":login"));
       
        return url;
    }

    /** 父目录列表 */
    @ResponseBody
    @RequestMapping(value = "tomain", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView findAllUser(@CurrentUser LoginUser user) {
        
    	LOGGER.info(LogFormatService.logFormat("去后台主页"));
         
        return new ModelAndView("manager/index");
    }
    /**
     * 退出
     */
    @RequestMapping("logout")
    public String logout(Model model, HttpSession session, HttpServletResponse response) {
        startTime = System.currentTimeMillis();
        LOGGER.info(LogFormatService.logFormat("退出start..."));
        try {
            session.removeAttribute("user");
            valueMap.clear();
            this.jsonResponse("{\"success\":true,\"msg\":\"退出成功\"}", response);
            LOGGER.info(LogFormatService.logFormat("退出成功:", startTime, LoginController.class.toString() + ":logout"));
        } catch (Exception e) {
            LOGGER.error(LogFormatService.logFormat("退出失败", startTime, LoginController.class.toString() + ":logout"), e);
        }
        return null;
    }
}
