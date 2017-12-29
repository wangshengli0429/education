package com.education.framework.authority.operater.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.education.framework.authority.base.BaseController;
import com.education.framework.authority.notes.CurrentUser;
import com.education.framework.authority.operater.service.OperaterService;
import com.education.framework.common.service.LogFormatService;
import com.education.framework.model.user.LoginUser;
import com.google.common.collect.Maps;

@Controller
@RequestMapping("/user")
public class OperaterContrller extends BaseController {

    /** 日志 */
    private static Logger LOGGER = Logger.getLogger(OperaterContrller.class);
    @Autowired
    private OperaterService operaterService;
    /** startTime */
    private long startTime;

    /** 跳转到员工列表页 */
    @RequestMapping("/admin/toOperaterPage")
    public String toOperaterPage() {

        LOGGER.info("跳转到员工列表页...");
        LOGGER.info(LogFormatService.logFormat("测试员工列表页..."));
        return "admin/authority/user/list";
    }
    
    /** 父目录列表 */
    @ResponseBody
    @RequestMapping(value = "/admin/list", method = {RequestMethod.POST,RequestMethod.GET})
    public Map<String, Object> findAllUser(@RequestParam int rows, @RequestParam int page,
            @RequestParam String userName,@CurrentUser LoginUser user) {
        Map<String, Object> map = Maps.newHashMap();
        Map<String, Object> paramsMap = Maps.newHashMap();
        try {
            // 设置检索条子菜单名
            paramsMap.put("userName", userName);
//            paramsMap.put("userId", user.getUserId());
            // 设置检索开始条数
            paramsMap.put("rowStart", (page - 1) * rows);
            // 设置检索截止条数
            paramsMap.put("pageSize", rows);
            // 设置总数
            map.put("total", operaterService.findAllUserCount(paramsMap));
            // 设置用户列表信息
            map.put("rows", operaterService.findAllUser(paramsMap));
            LOGGER.info(LogFormatService.logFormat("分页获取父菜单列表success"));
        } catch (Exception e) {
            LOGGER.error(LogFormatService.logFormat("获取父菜单列表异常"), e);
        }
        return map;
    }
}
