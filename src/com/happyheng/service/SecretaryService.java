package com.happyheng.service;

import org.apache.commons.lang3.StringUtils;

import com.happyheng.entity.BaseMessage;
import com.happyheng.entity.TextMessage;
import com.happyheng.request.TuLingRequest;

/**
 * 进行消息处理的逻辑类
 * 
 * @author liuheng
 *
 */
public class SecretaryService extends BaseService{
	
	@Override
	protected String getResponce(String requestString, String fromUserName) {
		return TuLingRequest.getResponce(requestString, fromUserName);
	}
}
