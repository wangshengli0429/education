package com.education.framework.repo;

import com.education.framework.model.bo.ButtonBo;
import com.education.framework.model.co.ButtonCo;
import com.education.framework.model.po.Button;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class ButtonRepo extends BaseDao<Button,ButtonCo,ButtonBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

}
