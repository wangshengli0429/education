package com.framework.test;

import com.education.framework.service.TestService;

import javax.annotation.Resource;

import com.education.framework.model.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by zhoulin on 2018/3/30.
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
public class Testm {

//    @Resource
//    private TestService testService;
//
//    @org.junit.Test
//    public void test(){
//        Test test = testService.getById(1);
//        System.out.println(test);
//    }

}
