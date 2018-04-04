package com.framework.test.service;

import com.education.framework.common.response.ApiResponse;
import com.education.framework.model.bo.DictionaryBo;
import com.education.framework.service.DictionaryApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
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
public class DictionaryServiceTest {

    @Resource
    private DictionaryApi dictionaryApi;

    @Test
    public void testListByCodes(){
        List<String> list = new ArrayList<String>();
        list.add("ww");
        list.add("aa");
        ApiResponse<List<DictionaryBo>> apiResponse = dictionaryApi.getListByCodes(list);
        System.out.println();
    }

}
