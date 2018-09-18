package com.education.web.controller.login;

import javax.servlet.http.HttpSession;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/login-web")
public class LoginWebController  {

    /** 日志 */
    private static Logger LOGGER = Logger.getLogger(LoginWebController.class);

    /**
     * 登录
     */
    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    public String login(Model model,String manageCode,String managePwd, HttpSession session) {
        String url = "manager/index";
        String message = null;
        /*if (StringUtils.isBlank(manageCode)) {
            message = "";
        } else if (StringUtils.isBlank(managePwd)) {

        } else {


        }*/
        return url;
    }
}