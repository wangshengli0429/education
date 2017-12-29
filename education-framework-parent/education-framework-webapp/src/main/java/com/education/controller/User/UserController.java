package com.education.controller.User;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.education.framework.common.base.ApiResult;
import com.education.framework.common.base.StatusCode;
import com.education.framework.model.user.UserInfo;
import com.education.framework.service.user.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/getUserById",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult getUserById(@RequestParam(required=true)int id){
		System.out.println("123");
		System.out.println("123");
		System.out.println("123");
		System.out.println("123");
		UserInfo userInfo = userService.getUser(id);
		
		
		return  new ApiResult(StatusCode.EDU_CODE_000.getCode(),StatusCode.EDU_CODE_000.getMsg(),userInfo);
	}
	@RequestMapping(value="/",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public void getUserById1(Model model, HttpServletRequest request,@RequestParam(required=true)int id){
		System.out.println("123");
		System.out.println("123");
		System.out.println("123");
		System.out.println("123");
		System.out.println("123");
		System.out.println("123");
		System.out.println("123");
		 
	}
	
}
