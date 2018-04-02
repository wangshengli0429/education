package com.education.framework.repo;

import com.education.framework.model.bo.RoleMenuBtnBo;
import com.education.framework.model.co.RoleMenuBtnCo;
import com.education.framework.model.po.RoleMenuBtn;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class RoleMenuBtnRepo extends BaseDao<RoleMenuBtn,RoleMenuBtnCo,RoleMenuBtnBo> {

    @Resource
    private CommonMysqlClient mysqlClient;
}
