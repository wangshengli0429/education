package com.framework.test.controller;

import com.education.framework.model.vo.TeacherVo;
import com.framework.test.base.BaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class AttentionControllerTest extends BaseTest {

    @Test
    public void deleteById() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/attention/cancel")
                .param("teacherId","1")
        );
    }

    @Test
    public void testList() throws Exception{
        TeacherVo bvo = new TeacherVo();
        mockMvc.perform(MockMvcRequestBuilders.
                get("/attention/student").contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("studentId","1")
                .param("pageNum","1")
                .param("pageSize","10"));

    }

}
