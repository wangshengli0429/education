package com.framework.test.controller;

import com.framework.test.base.BaseTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class StudentControllerTest extends BaseTest {


    @Test
    public void testGetById() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getById?id=1"));
    }

}
