package com.education.framework.repo;

import com.education.framework.model.bo.ManageRoleBo;
import com.education.framework.model.co.ManageRoleCo;
import com.education.framework.model.po.ManageRole;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class ManageRoleRepo extends BaseDao<ManageRole,ManageRoleCo,ManageRoleBo> {

    @Resource
    private CommonMysqlClient mysqlClient;
}
