package com.framework.test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author lvpwolf
 *
 */
public class UserLoginTest {

	private static CloseableHttpClient httpClient = HttpClients.createDefault();

	private static final Logger logger = Logger.getLogger(UserLoginTest.class);
	// 登录地址
	public static final String USER_LOGIN_URL = BaseConfigHolder.BASE_URL + "/oauth/token";

	@BeforeClass
	public static void init() {
		httpClient = HttpClients.createDefault();
	}

	@AfterClass
	public static void dispose() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	/**
	 * F1004 登录接口
	 */
	@Test
	public void testLogin() {

		// 创建httppost
		HttpPost httpPost = null;

		try {
			String username = "18518783371" ;
			String password = "a1234567" ; // 密码
			String client_id = "m1"; // 固定值
			String client_secret = "s1"; // 固定值
			String grant_type = "password"; // 固定值
			String scope = "write"; // 固定值
			// 创建参数队列
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("username", username));
			params.add(new BasicNameValuePair("password", password));
			params.add(new BasicNameValuePair("client_id", client_id));
			params.add(new BasicNameValuePair("client_secret", client_secret));
			params.add(new BasicNameValuePair("password", password));
			params.add(new BasicNameValuePair("grant_type", grant_type));
			params.add(new BasicNameValuePair("scope", scope));

			params.add(new BasicNameValuePair("versionFlag", "NEW"));
		//	params.add(new BasicNameValuePair("openId", "123434"));

			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(params, Charset.forName("UTF-8"));
			
			httpPost = new HttpPost(USER_LOGIN_URL);
			httpPost.setEntity(uefEntity);

			try (CloseableHttpResponse response = httpClient.execute(httpPost);) {
				StatusLine statusLine = response.getStatusLine();
				Assert.assertEquals((long) HttpStatus.SC_OK, (long) statusLine.getStatusCode());
				HttpEntity entity = response.getEntity();
				Assert.assertNotNull(entity);
				String entityStr = EntityUtils.toString(entity, "UTF-8");
				logger.info("response: " + entityStr);
				JSONObject jsonObj = JSON.parseObject(entityStr);
				Assert.assertEquals(0, jsonObj.getIntValue("state"));
				//Assert.assertNotNull(jsonObj.get("token"));				
			} catch (Exception e1) {
				e1.printStackTrace();
				Assert.fail();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			Assert.fail();
		}
	}

	/**
	 * F1004 登录接口
	 */
	@Test
	public void testLogin180() {

		// 创建httppost
		HttpPost httpPost = null;

		try {
			String username = "18033502480"; // 用户名 手机号
			String password = "11111111"; // 密码

			String client_id = "m1"; // 固定值
			String client_secret = "s1"; // 固定值
			String grant_type = "password"; // 固定值
			String scope = "write"; // 固定值
			// 创建参数队列
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("username", username));
			params.add(new BasicNameValuePair("password", password));
			params.add(new BasicNameValuePair("client_id", client_id));
			params.add(new BasicNameValuePair("client_secret", client_secret));
			params.add(new BasicNameValuePair("password", password));
			params.add(new BasicNameValuePair("grant_type", grant_type));
			params.add(new BasicNameValuePair("scope", scope));

			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(params, Charset.forName("UTF-8"));

			httpPost = new HttpPost(USER_LOGIN_URL);
			httpPost.setEntity(uefEntity);

			try (CloseableHttpResponse response = httpClient.execute(httpPost);) {
				StatusLine statusLine = response.getStatusLine();
				Assert.assertEquals((long) HttpStatus.SC_OK, (long) statusLine.getStatusCode());
				HttpEntity entity = response.getEntity();
				Assert.assertNotNull(entity);
				String entityStr = EntityUtils.toString(entity, "UTF-8");

				logger.info("response: " + entityStr);
				JSONObject jsonObj = JSON.parseObject(entityStr);
				Assert.assertEquals(0, jsonObj.getIntValue("state"));
				Assert.assertNotNull(jsonObj.get("token"));

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public static String login() throws IOException {
		return login(USER_LOGIN_URL);
	}

	public static String login(String url) throws IOException {
		return login(url, BaseConfigHolder.DEFAULT_USERNAME, BaseConfigHolder.DEFAULT_PASSWORD);
	}

	public static String login(String username, String password) throws IOException {
		return login(USER_LOGIN_URL, username, password);
	}

	public static String login(String url, String username, String password) throws IOException {
		logger.debug("userName:" + username + ",password:" + password + ",url:" + url);
		// 创建httppost
		HttpPost httpPost = null;
		try (CloseableHttpClient httpClient = HttpClients.createDefault();) {

			String client_id = "m1"; // 固定值
			String client_secret = "s1";
			String grant_type = "password";
			String scope = "write";
			// 创建参数队列
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("username", username));
			params.add(new BasicNameValuePair("password", password));
			params.add(new BasicNameValuePair("client_id", client_id));
			params.add(new BasicNameValuePair("client_secret", client_secret));
			params.add(new BasicNameValuePair("password", password));
			params.add(new BasicNameValuePair("grant_type", grant_type));
			params.add(new BasicNameValuePair("scope", scope));

			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(params, "UTF-8");

			httpPost = new HttpPost(url);
			httpPost.setEntity(uefEntity);

			try (CloseableHttpResponse response = httpClient.execute(httpPost);) {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
//					logger.i("response: " + EntityUtils.toString(entity, "UTF-8"));
					String entityStr = EntityUtils.toString(entity, "UTF-8");
					JSONObject jsonObj = JSON.parseObject(entityStr);
					return String.valueOf(jsonObj.get("token"));
					// LOG.i("response: " + EntityUtils.toString(entity,
					// "UTF-8"));
				}
			}

			return null;
		}
	}

	public static void saveFeedBack() {
		// 创建httppost
		HttpPost httpPost = null;
		String username = BaseConfigHolder.DEFAULT_USERNAME;
		String password = BaseConfigHolder.DEFAULT_PASSWORD;
		String client_id = "m1";
		String client_secret = "s1";
		String grant_type = "password";
		String scope = "write";
		// 创建参数队列
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("password", password));
		params.add(new BasicNameValuePair("client_id", client_id));
		params.add(new BasicNameValuePair("client_secret", client_secret));
		params.add(new BasicNameValuePair("password", password));
		params.add(new BasicNameValuePair("grant_type", grant_type));
		params.add(new BasicNameValuePair("scope", scope));
		UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(params, Charset.forName("UTF-8"));

		httpPost = new HttpPost(USER_LOGIN_URL);
		httpPost.setEntity(uefEntity);
		try (CloseableHttpResponse response = httpClient.execute(httpPost);) {

			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					logger.info("response: " + EntityUtils.toString(entity, "UTF-8"));
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				response.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {

		}

	}
}
