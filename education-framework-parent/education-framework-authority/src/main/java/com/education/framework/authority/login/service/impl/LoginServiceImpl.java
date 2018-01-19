package com.education.framework.authority.login.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.education.framework.authority.common.service.VarKeys;
import com.education.framework.authority.login.model.LoginUser;
import com.education.framework.authority.login.service.LoginService;
import com.education.framework.authority.management.model.Management;
import com.education.framework.authority.management.service.ManagementService;
import com.education.framework.authority.menu.model.Menu;
import com.education.framework.authority.menu.service.MenuService;
import com.education.framework.authority.role.service.RoleService;
import com.education.framework.common.base.ApiResult;
import com.education.framework.common.service.LogFormatService;
import com.education.framework.common.util.Const;
import com.education.framework.common.util.MD5Util;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Service
public class LoginServiceImpl implements LoginService {

    /** 日志 */
    private static Logger LOGGER = Logger.getLogger(LoginServiceImpl.class);
    @Autowired
    private ManagementService managementService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    /** startTime */
    private long startTime;

    /**
     * 登录处理
     * 
     * @param valueMap
     */
    @Override
    public void doLogin(Map<String, Object> valueMap) {
        startTime = System.currentTimeMillis();
        List<String> roleList = Lists.newArrayList();
        String userName =
                ((LoginUser) valueMap.get(VarKeys.structKey(VarKeys.LOGIN, VarKeys.LOGIN_USER))).getManageCode();
        String password =
                ((LoginUser) valueMap.get(VarKeys.structKey(VarKeys.LOGIN, VarKeys.LOGIN_USER))).getManagePwd();
        ApiResult apiResult = managementService.findByManagementCode(userName);
        Management  manage= null;
        if(null!=apiResult && 9 == apiResult.getCode()){
        	manage = (Management)apiResult.getData();
        }
        
        startTime = System.currentTimeMillis();
        try {
            if (manage == null) {
                valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.FLAG), false);
                valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.MSG), Const.Base.USER_ERRINFO);
                LOGGER.error(LogFormatService.logFormat(Const.Base.USER_ERRINFO + "<userName:" + userName + ">",
                        startTime, LoginServiceImpl.class.toString() + ":doLogin"));
            } else {
                if (StringUtils.isNotBlank(manage.getManagePwd())
                		
                		//TODO MD5加密
//                        && MD5Util.getEncryptedPwd(password).equals(manage.getManagePwd())
                        ) {
                	   roleList = roleService.getRole(manage.getManageCode());
                       valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.FLAG), true);
                       valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.LOGIN_USER), new LoginUser(manage, roleList));
//                       if (user.getIsstaff() != null && user.getIsstaff() == Const.Base.ISSTAFF_Y) {
//                           findMenuListByUserId(valueMap);
//                       }
//                       findResourceByUser(valueMap);
                       
                       findMenuListByManageCode(valueMap);
                } else {
                    valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.FLAG), false);
                    valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.MSG), Const.Base.USER_PWD_ERRINFO);
                    LOGGER.error(LogFormatService.logFormat(
                            Const.Base.USER_PWD_ERRINFO + "<userName:" + userName + ">", startTime,
                            LoginServiceImpl.class.toString() + ":doLogin"));
                }
            }
        } catch (Exception e) {
            valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.FLAG), false);
            valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.MSG),
                    "系统繁忙，请稍候再试");
            LOGGER.error(LogFormatService.logFormat("用户<" + userName + ">:登录异常", startTime,
                    LoginServiceImpl.class.toString() + ":doLogin"), e);
        }
    }

    /**
     * 根据角色ID查询角色信息与目录.
     * 
     * @param valueMap
     */
    private void findMenuListByManageCode(Map<String, Object> valueMap) {
    	  List<Menu> subMenuVoList = Lists.newArrayList();
          List<Menu> parentMenuList = Lists.newArrayList();
          List<Menu> subMenuList = Lists.newArrayList();
          List<Map<String, Object>> resultList = Lists.newArrayList();

          startTime = System.currentTimeMillis();
          LOGGER.info(LogFormatService.logogram("根据角色ID查询角色信息start..."));
          try {
              if (((LoginUser) valueMap.get(VarKeys.structKey(VarKeys.LOGIN, VarKeys.LOGIN_USER))).getManageCode() != null) {
            	  
                  subMenuVoList = menuService.getMenuByRoleCode(((LoginUser) valueMap.get(VarKeys.structKey(VarKeys.LOGIN,
                          VarKeys.LOGIN_USER))).getManageCode());
//                          subMenuService.findMenuListByUserId(((LoginUser) valueMap.get(VarKeys.structKey(VarKeys.LOGIN,
//                                  VarKeys.LOGIN_USER))).getUserId());
                  parentMenuList = menuService.getMenuByRoleCode(((LoginUser) valueMap.get(VarKeys.structKey(VarKeys.LOGIN,
                          VarKeys.LOGIN_USER))).getManageCode());
                  if (CollectionUtils.isEmpty(subMenuVoList)) {
                      LOGGER.info(LogFormatService.logFormat(
                              "用户<"
                                      + ((LoginUser) valueMap.get(VarKeys.structKey(
                                              VarKeys.LOGIN, VarKeys.LOGIN_USER))).getManageCode()
                                      + ">无有权限的子目录", startTime, LoginServiceImpl.class.toString()
                                      + ":findMenuListByUserId"));
                  } else if (CollectionUtils.isEmpty(parentMenuList)) {
                      LOGGER.info(LogFormatService.logFormat("没有父目录", startTime, LoginServiceImpl.class.toString()
                              + ":findMenuListByUserId"));
                  } else {
                      for (Menu parentMenu : parentMenuList) {
                          Map<String, Object> map = Maps.newHashMap();
                          subMenuList = Lists.newArrayList();
                          for (Menu subMenuVo : subMenuVoList) {
                              if (parentMenu.getMenuCode() == subMenuVo.getParentCode()) {
                                  subMenuList.add(subMenuVo);
                              }
                          }
                          if (CollectionUtils.isNotEmpty(subMenuList)) {
                              map.put("parantCode", parentMenu.getMenuCode());
                              map.put("menuDescr", parentMenu.getMenuDescr());
                              map.put("subMenuList", subMenuList);
                              resultList.add(map);
                          }
                      }
                    
//                      net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(resultList);
                      valueMap.put(VarKeys.structKey(VarKeys.LOGIN, VarKeys.MENU_LIST), resultList);
                      LOGGER.info(LogFormatService.logFormat("获取目录成功:" + resultList.toString(), startTime,
                              LoginServiceImpl.class.toString() + ":findMenuListByUserId"));
                  }
              }
          } catch (Exception e) {
              LOGGER.error(LogFormatService.logFormat("获取目录异常", startTime,
                      LoginServiceImpl.class.toString() + ":findMenuListByUserId"), e);
          }
    }
}
