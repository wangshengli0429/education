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
public class SubjectControllerTest extends BaseTest{

    @Test
    public void testGetById() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/subject/getByDepartmentCode?departmentCode=1"));
    }

    @Test
    public void testGetBasicData() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/subject/basicData"));
    }

}
