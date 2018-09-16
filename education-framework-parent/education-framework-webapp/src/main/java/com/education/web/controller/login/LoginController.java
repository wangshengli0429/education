package com.education.web.controller.login;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "web_login",method = RequestMethod.POST)
public class LoginController {

    private static Logger logger = Logger.getLogger(com.education.app.controller.login.LoginController.class);

    @RequestMapping("doLogin")
    public String login(Model model, String manageCode, String managePwd,HttpSession session) {



        return null;
    }

}
