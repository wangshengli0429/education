package com.education.framework.repo;

import com.education.framework.model.bo.UserBo;
import com.education.framework.model.co.UserCo;
import com.education.framework.model.po.User;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class UserRepo extends BaseDao<User,UserCo,UserBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

}
