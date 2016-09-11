package com.happyheng.dispatcher;

import com.happyheng.service.BaseService;
import com.happyheng.service.LocationService;
import com.happyheng.service.NewUserService;
import com.happyheng.service.SecretaryService;
import com.happyheng.service.SharesService;

public class ServiceDispatcher {


	// 根据请求的数据得到相应的处理Service类
	public BaseService getService(String content, String messageType, String event) {

		BaseService service = null;

		// 说明是新用户
		if (messageType.equals("event") && event.equals("subscribe")) {
			service = new NewUserService();
		}
		// 说明是归属地查询
		else if (content.startsWith(LocationService.FILTER_NAME)) {
			service = new LocationService();
		}
		// 说明是股票查询
		else if (content.startsWith(SharesService.FILTER_NAME)) {
			service = new SharesService();
		} else {
			service = new SecretaryService();
		}
		return service;
	}
}
