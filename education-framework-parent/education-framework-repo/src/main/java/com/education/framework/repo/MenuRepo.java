package com.education.framework.repo;

import com.education.framework.model.bo.MenuBo;
import com.education.framework.model.co.MenuCo;
import com.education.framework.model.po.Menu;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class MenuRepo extends BaseDao<Menu,MenuCo,MenuBo> {

    @Resource
    private CommonMysqlClient mysqlClient;
}
