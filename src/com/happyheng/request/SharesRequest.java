package com.happyheng.request;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.happyheng.network.HttpClient;

public class SharesRequest {
	
	public static final String REQUEST_URL = "http://web.juhe.cn:8080/finance/stock/hs";
	public static final String REQUEST_KEY = "8173c4fa59be736b206b77616413bcb2";
	
	public static String getReponce(String gid){
		Map<String, String> requestMap = new HashMap<>();
		requestMap.put("key", REQUEST_KEY);
		//默认获取的是上正指数
		requestMap.put("gid", "sh"+gid);
		
		String responce = HttpClient.doSyncRequest(REQUEST_URL, requestMap, false);
		
		JSONObject json = JSON.parseObject(responce);
		if (json.getInteger("resultcode") == 200) {
			
			StringBuffer result = new StringBuffer();
			JSONObject dataJson = json.getJSONArray("result").getJSONObject(0).getJSONObject("data");
			
			result.append("股票名称   ").append(dataJson.getString("name")).append("\n");
			result.append("当前价格   ").append(dataJson.getString("nowPri")).append("\n");
			result.append("涨跌幅     ").append(dataJson.getString("increase"));
			
			return result.toString();
		}else {
			return "";
		}
	}
}
