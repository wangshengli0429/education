package com.education.framework.repo;

import com.education.framework.model.bo.SubjectBo;
import com.education.framework.model.co.SubjectCo;
import com.education.framework.model.po.Subject;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class SubjectRepo extends BaseDao<Subject,SubjectCo,SubjectBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

}
