package com.happyheng.entity;

/**
 * 基础信息类
 * @author liuheng
 *
 */
public class BaseMessage {
	
	
	public static final String TYPE_TEXT = "text";
	
	private String ToUserName;
	private String FromUserName;
	//消息创建时间
	private long CreateTime;
	//消息创建类型
	private String MsgType;
	
	
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	
}
