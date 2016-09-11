package com.happyheng.request;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.happyheng.network.HttpClient;

/**
 * 图片机器人的接口请求类
 * @author liuheng
 *
 */
public class TuLingRequest {
	//图灵机器人的key
	public static final String TULING_KEY = "6cc5357b84ce5bf24a784370fb491557";
	//图灵机器人的url
	public static final String TULING_BASE_URL = "http://www.tuling123.com/openapi/api";
	public static final String KEY_CODE = "code";
	public static final String KEY_TEXT = "text";
	//调用正确的返回值
	public static final int RESPONCE_CODE_SUCCESS = 100000;
	//出现错误的提示
	public static final String RESPONCE_WORNG = "好像出错了呢~";
	
	public static String getResponce(String info, String uid){
		Map<String, String> requestMap = new HashMap<>();
		requestMap.put("key", TULING_KEY);
		requestMap.put("info", info);
		requestMap.put("userid", uid);
		
		String resultJson = HttpClient.doSyncRequest(TULING_BASE_URL, requestMap);
		JSONObject json = JSON.parseObject(resultJson);  
		
		String result = "";
		
		int responceCode = json.getIntValue(KEY_CODE);
		if (responceCode == RESPONCE_CODE_SUCCESS) {
			result = json.getString(KEY_TEXT);
		} else {
			result = RESPONCE_WORNG;
		}
		System.out.println("结果为"+result);
		
		return result;
	}
}
