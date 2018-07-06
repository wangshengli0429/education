package com.framework.test.controller;

import com.framework.test.base.BaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author zhoulin
 * @createTime 2018/7/5.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/5.
 * @note
 */
public class TeacherCertificateControllerTest extends BaseTest {

    @Test
    public void testGetById() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/teacherCertificate/teacherId?teacherId=1"));
    }

}
