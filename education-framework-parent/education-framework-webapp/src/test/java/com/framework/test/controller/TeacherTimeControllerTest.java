package com.framework.test.controller;

import com.framework.test.base.BaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class TeacherTimeControllerTest extends BaseTest {

    @Test
    public void testList() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.
                get("/teacherTime/listByTeacherAndDate").contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("teacherId","1")
                .param("dateStr","2018-08-12"));

    }

}
