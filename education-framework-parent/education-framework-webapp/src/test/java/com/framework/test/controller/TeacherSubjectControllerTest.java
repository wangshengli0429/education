package com.framework.test.controller;

import com.framework.test.base.BaseTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author zhoulin
 * @createTime 2018/7/6.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/6.
 * @note
 */
public class TeacherSubjectControllerTest extends BaseTest {

    @Test
    public void testGetByTeacherId() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/teacherSubject/byTeacherId?teacherId=1"));
    }

    @Test
    public void testGetById() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/teacherSubject/getById?id=1"));
    }

}
