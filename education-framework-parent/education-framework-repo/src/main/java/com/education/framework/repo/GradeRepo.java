package com.education.framework.repo;

import com.education.framework.model.bo.GradeBo;
import com.education.framework.model.co.GradeCo;
import com.education.framework.model.po.Grade;
import com.education.framework.repo.base.BaseDao;
import com.education.framework.repo.base.CommonMysqlClient;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/2.
 */
@Repository
public class GradeRepo extends BaseDao<Grade,GradeCo,GradeBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

    /**
     *  根据code集合集合查询
     * @param codes
     * @return
     */
    public List<GradeBo> listByCodes(List<String> codes) {
        if (CollectionUtils.isEmpty(codes)){
            return new ArrayList<GradeBo>();
        }
        StringBuilder sql = new StringBuilder("SELECT * FROM grade t WHERE t.deleted = 0 ");
        sql.append(" and t.code in('");
        sql.append(StringUtils.join(codes,"','"));
        sql.append("');");
        return mysqlClient.query(sql.toString(), new Object[]{}, new BeanPropertyRowMapper<>(GradeBo.class));
    }

}
