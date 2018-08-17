package com.framework.test.controller;

import com.framework.test.base.BaseTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class AttentionControllerTest extends BaseTest {

    @Test
    public void deleteById() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/attention/cancel")
                .param("teacherId","1")
        );
    }

}
