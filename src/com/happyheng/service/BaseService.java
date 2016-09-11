package com.happyheng.service;

import com.happyheng.entity.TextMessage;

public abstract class BaseService {
	
	public TextMessage doResponce(TextMessage requestMessage) {
		
		String requestString = requestMessage.getContent();
		String responceString = getResponce(requestString, requestMessage.getFromUserName());
		
		//下为生成responce
		TextMessage responceMessage = new TextMessage();
		responceMessage.setFromUserName(requestMessage.getToUserName());
		responceMessage.setToUserName(requestMessage.getFromUserName());
		responceMessage.setContent(responceString);
		responceMessage.setCreateTime(System.currentTimeMillis());
		
		return responceMessage;
	}
	
	
	protected abstract String getResponce(String requestString, String fromUserName);
}
