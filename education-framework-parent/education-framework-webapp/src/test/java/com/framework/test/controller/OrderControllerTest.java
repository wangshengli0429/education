package com.framework.test.controller;

import com.framework.test.base.BaseTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class OrderControllerTest extends BaseTest {

    @Test
    public void testGetById() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/order/details?id=1"));
    }

    @Test
    public void testGetOrder() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/order/order?id=1"));
    }

}
