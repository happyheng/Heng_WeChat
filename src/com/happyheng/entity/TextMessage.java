package com.happyheng.entity;

/**
 * 文本信息类
 * @author liuheng
 *
 */
public class TextMessage extends BaseMessage {
	//文本内容
	private String Content;
	//消息id
	private String MsgId;
	
	public TextMessage(){
		setMsgType(TYPE_TEXT);
	}
	
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	@Override
	public String toString() {
		return "TextMessage [Content=" + Content + ", MsgId=" + MsgId + ", getCreateTime()=" + getCreateTime()
				+ ", getToUserName()=" + getToUserName() + ", getFromUserName()=" + getFromUserName()
				+ ", getMsgType()=" + getMsgType() + "]";
	}
	
	
	
	
}
