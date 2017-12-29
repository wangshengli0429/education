package com.framework.test;


import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class UserControllerTest {

	private static final Logger logger = Logger.getLogger(UserControllerTest.class);
    private static final String LY_USER_NAME = "18518783371";
    private static final String LY_PASSWORD = "a1234567";
    private static String token;

    @Before
    public void setUp() throws Exception {
    }

    private static CloseableHttpClient httpClient = null;

    @BeforeClass
    public static void init() throws IOException {
        httpClient = HttpClients.createDefault();
    }

    @AfterClass
    public static void dispose() {
        HttpClientUtils.closeQuietly(httpClient);
    }
    @Test
    public void basicAddTest() throws IOException {
        token = UserLoginTest.login(LY_USER_NAME, LY_PASSWORD);
        final String URL = BaseConfigHolder.BASE_URL + "/user/getUserById";
        logger.debug("url:" + URL + ",token:" + token);
 
        int id =1;
 
        HttpPost httpPost = new HttpPost(URL);
//        httpPost.addHeader("Authorization", "Bearer " + "9c961ac1-5bdd-4752-ac43-f49af0571fbb");
        ContentType contentType = ContentType.create("application/json", Charset.forName("UTF-8"));

        String infoStr = JSON.toJSONString(id);
        HttpEntity entity = new StringEntity(infoStr, contentType);
        
      //建立一个NameValuePair数组，用于存储欲传递的参数
        List<BasicNameValuePair> params=new ArrayList<BasicNameValuePair>();
        //添加参数
        params.add(new BasicNameValuePair("custBasicInfo", infoStr));
        httpPost.setEntity(entity);

        httpPost.addHeader("Authorization", "Bearer " + token);
        try (CloseableHttpResponse resp = httpClient.execute(httpPost);) {
            System.out.println("提交用户基本信息发生状态" + resp.getStatusLine());
            HttpEntity resultEntity = resp.getEntity();
            String result = EntityUtils.toString(resultEntity);

            logger.debug(result);

        } catch (IOException e) {
            logger.error("提交用户基本信息发生错误:", e);
            Assert.fail("提交用户基本信息发生IO异常.");
        }
    }


}
