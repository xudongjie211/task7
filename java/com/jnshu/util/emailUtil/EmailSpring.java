package com.jnshu.util.emailUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailSpring {
	@Autowired
	private  EmailArgs ea;
	
//	public  void send_common(String email,String sub,String content) throws IOException {
//
//		final String url = "http://api.sendcloud.net/apiv2/mail/send";
//
//		final String rcpt_to = email;
//
//		String subject = sub;
//		String html = content;
//
//		HttpPost httpPost = new HttpPost(url);
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//
//		List<NameValuePair> params = new ArrayList<NameValuePair>();
//		params.add(new BasicNameValuePair("apiUser",ea.getApiUser() ));
//		params.add(new BasicNameValuePair("apiKey", ea.getApiKey()));
//		params.add(new BasicNameValuePair("to", rcpt_to));
//		params.add(new BasicNameValuePair("from", ea.getFrom()));
//		params.add(new BasicNameValuePair("fromName", ea.getFromName()));
//		params.add(new BasicNameValuePair("subject", subject));
//		params.add(new BasicNameValuePair("html", html));
//
//		httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//
//		HttpResponse response = httpClient.execute(httpPost);
//
//		// 处理响应
//		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//			// 正常返回, 解析返回数据
//			System.out.println(EntityUtils.toString(response.getEntity()));
//		} else {
//			System.err.println("error");
//		}
//		httpPost.releaseConnection();
//	}
	
	public  void send_common(String email,String sub,String code) throws IOException {

		final String url = "http://api.sendcloud.net/apiv2/mail/send";

		final String rcpt_to = email;

		String subject = sub;
		String html = "<h1>来自技能树的激活邮件</h1><h3><a href='http://localhost:8888/task7/register?code="+code+"'>http://localhost:8888/task7/register?code="+code+"</a></h3>";

		HttpPost httpPost = new HttpPost(url);
		CloseableHttpClient httpClient = HttpClients.createDefault();

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("apiUser",ea.getApiUser() ));
		params.add(new BasicNameValuePair("apiKey", ea.getApiKey()));
		params.add(new BasicNameValuePair("to", rcpt_to));
		params.add(new BasicNameValuePair("from", ea.getFrom()));
		params.add(new BasicNameValuePair("fromName", ea.getFromName()));
		params.add(new BasicNameValuePair("subject", subject));
		params.add(new BasicNameValuePair("html", html));

		httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

		HttpResponse response = httpClient.execute(httpPost);

		// 处理响应
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			// 正常返回, 解析返回数据
			System.out.println(EntityUtils.toString(response.getEntity()));
		} else {
			System.err.println("error");
		}
		httpPost.releaseConnection();
	}
	
	
	
	
	
}
