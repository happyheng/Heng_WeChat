package com.happyheng.service;

import com.happyheng.entity.TextMessage;

public class NewUserService extends BaseService{
	
	//关注时自动回复的数据
	public static final String FOLLOW_MESSAGE = "谢谢关注小恒管家!\n"
			+ "输入'天气+地名'可以查询所在天气\n"
			+ "输入'归属地+手机号码'可以查询手机号码归属地\n"
			+ "输入'快递+单号'可以查询快递状态\n"
			+ "输入'股票+股票编号'可以查询对应股票的信息\n"
			+ "输入其它感兴趣的内容，可直接与我聊天哦";
	
	@Override
	protected String getResponce(String requestString, String fromUserName) {
		return FOLLOW_MESSAGE;
	}
}
