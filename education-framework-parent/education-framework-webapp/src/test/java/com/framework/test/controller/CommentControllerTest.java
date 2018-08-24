package com.framework.test.controller;

import com.framework.test.base.BaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class CommentControllerTest extends BaseTest {

    @Test
    public void testList() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.
                get("/comment/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("pageNum","1")
                .param("pageSize","10"));

    }

}
