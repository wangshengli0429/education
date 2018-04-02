package com.education.framework.repo;

import com.education.framework.model.bo.AuthenticationBo;
import com.education.framework.model.co.AuthenticationCo;
import com.education.framework.model.po.Authentication;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class AuthenticationRepo extends BaseDao<Authentication,AuthenticationCo,AuthenticationBo> {

    @Resource
    private CommonMysqlClient mysqlClient;
}
