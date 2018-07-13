package com.framework.test.controller;

import com.education.framework.model.bo.TeacherBo;
import com.education.framework.model.vo.TeacherVo;
import com.framework.test.base.BaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Created by zhoulin on 2018/4/4.
 */
public class TeacherControllerTest extends BaseTest{

    @Test
    public void testGetById() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/teacher/getById?id=1"));
    }

    @Test
    public void testList() throws Exception{
        TeacherVo bvo = new TeacherVo();
        mockMvc.perform(MockMvcRequestBuilders.
        get("/teacher/list").contentType(MediaType.APPLICATION_JSON_UTF8)
        .param("pageNum","1")
        .param("pageSize","10"));

    }

    @Test
    public void testPage() throws Exception{
        TeacherBo bo = new TeacherBo();
        bo.setName("aa");
        mockMvc.perform(MockMvcRequestBuilders.get("/dictionary/page")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(toJsonStr(bo))
        );
    }

    @Test
    public void updateById() throws Exception{
        TeacherBo bo = new TeacherBo();
        bo.setId(1);
        bo.setName("bb");
        mockMvc.perform(MockMvcRequestBuilders.put("/dictionary/update")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(toJsonStr(bo))
        );
    }

    @Test
    public void deleteById() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/dictionary/delete?id=1")
        );
    }

}
