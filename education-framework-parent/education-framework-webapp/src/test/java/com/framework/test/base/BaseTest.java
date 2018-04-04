package com.framework.test.base;

import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhoulin on 2018/4/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {
                "classpath:spring/spring-db.xml",
                "classpath:spring/spring-mvc.xml",
                "classpath:spring/spring-config.xml"
        }
)
@WebAppConfiguration
public class BaseTest {

    @Resource
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;
    protected MockHttpServletRequestBuilder builder;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
                .alwaysDo(MockMvcResultHandlers.print()).build();
    }

    @After
    public void end() {
        try {
            if (mockMvc != null && builder != null) {
                mockMvc.perform(builder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void print(Object o) {
        System.out.println(o);
    }

    protected void print(Object[] os) {
        for (Object o : os) {
            System.out.println(o);
        }
    }

    protected MockHttpServletRequestBuilder get(String url) {
        builder = MockMvcRequestBuilders.get(url);
        return builder;
    }

    protected MockHttpServletRequestBuilder put(String url) {
        builder = MockMvcRequestBuilders.put(url).contentType(MediaType.APPLICATION_JSON_UTF8);
        return builder;
    }

    protected MockHttpServletRequestBuilder post(String url) {
        builder = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_UTF8);
        return builder;
    }

    protected MockHttpServletRequestBuilder delete(String url) {
        builder =MockMvcRequestBuilders.delete(url);
        return builder;
    }


    protected void print(List<Object> objectList) {
        for (Object o : objectList) {
            System.out.println(o);
        }
    }

    protected String printAsJson(Object o) {
        String json = JSON.toJSONString(o);
        print(json);
        return json;
    }
    protected String toJsonStr(Object o) {
        return JSON.toJSONString(o);
    }

    protected Integer getRandomInt(Integer maxNum) {
        return (int) (Math.random() * maxNum);
    }

    protected Integer getRandomInt() {
        return getRandomInt(10000);
    }


}
