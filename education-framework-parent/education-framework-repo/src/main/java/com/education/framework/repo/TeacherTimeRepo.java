package com.education.framework.repo;

import com.education.framework.model.bo.TeacherTimeBo;
import com.education.framework.model.co.TeacherTimeCo;
import com.education.framework.model.po.TeacherTime;
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
public class TeacherTimeRepo extends BaseDao<TeacherTime,TeacherTimeCo,TeacherTimeBo> {

    @Resource
    private CommonMysqlClient mysqlClient;

    /**
     *  根据教师id和日期查询
     * @param teacherId
     * @return
     */
    public List<TeacherTimeBo> listByTeacherAndDate(Integer teacherId,String dateStr) {
        StringBuilder sql = new StringBuilder("SELECT * FROM teacher_time t WHERE t.deleted = 0 ");
        List<Object> parm = new ArrayList<>();
        if (StringUtils.isNotBlank(dateStr)){
            sql.append(" and t.begin_time like '%" + dateStr + "%' ");
        }
        if (null != teacherId){
            sql.append(" and t.teacher_id = ? ");
            parm.add(teacherId);
        }
        List<TeacherTimeBo> sqlResult = mysqlClient.query(sql.toString(), parm.toArray(), new BeanPropertyRowMapper<>(TeacherTimeBo.class));
        return sqlResult;
    }

}
