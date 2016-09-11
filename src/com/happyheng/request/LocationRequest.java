package com.happyheng.request;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.happyheng.network.HttpClient;

public class LocationRequest {
	
	public static final String REQUEST_URL = "http://apis.juhe.cn/mobile/get";
	public static final String REQUEST_KEY = "aab0f829f98c7f2e14c5c2f6afc6d985";
	
	public static String getReponce(String phoneNum){
		
		Map<String, String> requestMap = new HashMap<>();
		requestMap.put("key", REQUEST_KEY);
		requestMap.put("phone", phoneNum);
		
		String responce = HttpClient.doSyncRequest(REQUEST_URL, requestMap, false);
		
		JSONObject json = JSON.parseObject(responce);
		if (json.getInteger("resultcode") == 200) {
			JSONObject resultJson = json.getJSONObject("result");
			
			StringBuffer result = new StringBuffer();
			result.append(phoneNum).append("\n");
			//先添加地址
			result.append(resultJson.getString("province")).append(resultJson.getString("city")).append("\n");
			//再添加运营商
			result.append(resultJson.getString("company"));
			
			return result.toString();
		} else {
			return "";
		}
		
	}

}
