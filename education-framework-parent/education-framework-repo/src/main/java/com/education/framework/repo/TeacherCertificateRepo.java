package com.education.framework.repo;

import com.education.framework.model.bo.TeacherCertificateBo;
import com.education.framework.model.co.TeacherCertificateCo;
import com.education.framework.model.po.TeacherCertificate;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class TeacherCertificateRepo extends BaseDao<TeacherCertificate,TeacherCertificateCo,TeacherCertificateBo> {

    @Resource
    private CommonMysqlClient mysqlClient;
}
