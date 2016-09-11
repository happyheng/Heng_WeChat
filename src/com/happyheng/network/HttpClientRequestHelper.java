package com.happyheng.network;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * 获取HttpClient中Request请求对象的帮助类
 */
public class HttpClientRequestHelper {

	public static Request getPostRequest(String url, Map<String, String> requestMao)
			throws UnsupportedEncodingException {

		FormBody.Builder builder = new FormBody.Builder();

		for (String key : requestMao.keySet()) {
			System.out.println("key= " + key + " and value= " + requestMao.get(key));
			builder.add(key, requestMao.get(key));
		}

		RequestBody requestBody = builder.build();
		return new Request.Builder().url(url).post(requestBody).build();
	}

	public static Request getGetRequest(String url, Map<String, String> requestMao)
			throws UnsupportedEncodingException {

		StringBuffer requestUrl = new StringBuffer(url);
		requestUrl.append("?");

		for (String key : requestMao.keySet()) {
			System.out.println("key= " + key + " and value= " + requestMao.get(key));
			requestUrl.append(key).append("=").append(requestMao.get(key)).append("&");
		}
		// 将最后的&字符去掉
		requestUrl.deleteCharAt(requestUrl.length() - 1);

		return new Request.Builder().url(requestUrl.toString()).build();
	}

}
