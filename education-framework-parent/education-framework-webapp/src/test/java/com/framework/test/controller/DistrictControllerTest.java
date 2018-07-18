package com.framework.test.controller;

import com.framework.test.base.BaseTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author zhoulin
 * @createTime 2018/7/17.
 * @lastUpdater zhoulin
 * @lastUpdateTime 2018/7/17.
 * @note
 */
public class DistrictControllerTest extends BaseTest {

    @Test
    public void testGetById() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/district/cityTree"));
    }

}
