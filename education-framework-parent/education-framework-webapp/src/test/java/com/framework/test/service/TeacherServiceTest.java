package com.framework.test.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.base.Page;
import com.education.framework.model.base.PageParam;
import com.education.framework.model.bo.TeacherBo;
import com.education.framework.model.co.TeacherCo;
import com.education.framework.model.po.TeacherTime;
import com.education.framework.service.TeacherApi;
import com.education.framework.service.TeacherTimeApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {
                "classpath:spring/spring-db.xml",
                "classpath:spring/spring-mvc.xml",
                "classpath:spring/spring-config.xml"
        }
)
@WebAppConfiguration
public class TeacherServiceTest {

    @Resource
    private TeacherApi teacherApi;

    @Resource
    private TeacherTimeApi teacherTimeApi;

    @Test
    public void testListByCodes(){
        TeacherCo condition = new TeacherCo();
        condition.setName("aa");
        PageParam pageParam = new PageParam();
        pageParam.setPageNum(1);
        pageParam.setPageSize(10);
        ApiResponse<Page<TeacherBo>> apiResponse = teacherApi.getPageByCondition(condition,pageParam);
        System.out.println();
    }

    @Test
    public void save(){
        TeacherBo teacherBo = new TeacherBo();
        teacherBo.setName("aa");
        ApiResponse<Integer> apiResponse = teacherApi.save(teacherBo);
        System.out.println();
    }

}
