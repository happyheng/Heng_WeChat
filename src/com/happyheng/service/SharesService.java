package com.happyheng.service;

import com.happyheng.request.LocationRequest;
import com.happyheng.request.SharesRequest;

public class SharesService extends BaseService{

	public static String FILTER_NAME = "股票";
	
	@Override
	protected String getResponce(String requestString, String fromUserName) {
		
		
		String locationString = requestString.substring(2).trim();
		String result = SharesRequest.getReponce(locationString);

		if (result.equals("")) {
			return "查询失败 T^T";
		} else {
			return result;
		}
		
	}

}
