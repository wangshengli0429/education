package com.education.framework.repo;

import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class DictionaryRepo {

    @Resource
    private CommonMysqlClient mysqlClient;
}
