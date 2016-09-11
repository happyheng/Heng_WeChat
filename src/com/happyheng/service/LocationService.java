package com.happyheng.service;

import com.happyheng.request.LocationRequest;

public class LocationService extends BaseService {

	public static String FILTER_NAME = "归属地";

	@Override
	protected String getResponce(String requestString, String fromUserName) {
		
		String locationString = requestString.substring(3).trim();
		String result = LocationRequest.getReponce(locationString);

		if (result.equals("")) {
			return "查询失败 T^T";
		} else {
			return result;
		}
	}

}
