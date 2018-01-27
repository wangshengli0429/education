package com.education.framework.authority.role.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.education.framework.authority.base.BaseController;
import com.education.framework.authority.common.service.VarKeys;
import com.education.framework.authority.login.controller.LoginController;
import com.education.framework.authority.login.model.LoginUser;
import com.education.framework.authority.login.service.LoginService;
import com.education.framework.authority.notes.CurrentUser;
import com.education.framework.authority.role.service.RoleService;
import com.education.framework.common.base.ApiResult;
import com.education.framework.common.service.LogFormatService;
import com.education.framework.common.util.Const;
import com.google.common.collect.Maps;

/*
 * 角色
 * @author 王海忠
 * @date 2018.1.22
 * 
 * */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
	 /** 日志 */
    private static Logger logger = Logger.getLogger(RoleController.class);
    
    @Autowired
    private RoleService roleService; 
    
    @RequestMapping(value="list",method={RequestMethod.GET,RequestMethod.POST})
    public String GetRoleAllList(){
    	return "manager/sys/roles";
    }
    
    @RequestMapping(value="getAllRole",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ApiResult getAllRole(@RequestParam(required=false) String keyword, @RequestParam Integer page, @RequestParam Integer limit) {
		logger.info("controller comment getAllRole begin");
		Map<String,Object> map = Maps.newHashMap();
		// 检索条件
		map.put("keyword", keyword);
		map.put("rowStart", page-1);
		map.put("pageSize",limit);
		ApiResult apiResult = roleService.findAllRole(map);
		return apiResult;
	}

}
