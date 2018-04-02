package com.education.framework.repo;

import com.education.framework.model.bo.MenuRoleBo;
import com.education.framework.model.co.MenuRoleCo;
import com.education.framework.model.po.MenuRole;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class MenuRoleRepo extends BaseDao<MenuRole,MenuRoleCo,MenuRoleBo> {

    @Resource
    private CommonMysqlClient mysqlClient;
}
