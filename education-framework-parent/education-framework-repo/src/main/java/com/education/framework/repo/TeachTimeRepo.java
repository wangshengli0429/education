package com.education.framework.repo;

import com.education.framework.model.bo.TeachTimeBo;
import com.education.framework.model.co.TeachTimeCo;
import com.education.framework.model.po.TeachTime;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class TeachTimeRepo extends BaseDao<TeachTime,TeachTimeCo,TeachTimeBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

}
