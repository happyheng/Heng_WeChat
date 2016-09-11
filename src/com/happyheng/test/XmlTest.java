package com.happyheng.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import com.happyheng.entity.TextMessage;
import com.happyheng.service.SecretaryService;
import com.happyheng.utils.XmlUtils;

public class XmlTest {
	
	public static final String xmlStr = "<xml>"
			+ "<ToUserName>aaa</ToUserName>"
			+ "<FromUserName>bbb</FromUserName>"
			+ "<CreateTime>1348831860</CreateTime>"
			+ "<MsgType>text</MsgType>"
			+ "<Content>nihao</Content>"
			+ "<MsgId>1234567890123456</MsgId>"
			+ "</xml>";  

	public static void main(String[] args) {
		// xml请求解析
				Map<String, String> requestMap = null;
				
				
				InputStream inputStream = new ByteArrayInputStream(xmlStr.getBytes());
				
				try {
					requestMap = XmlUtils.parseXml(inputStream);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 发送方帐号（open_id）
				String fromUserName = requestMap.get("FromUserName");
				// 公众帐号
				String toUserName = requestMap.get("ToUserName");

				TextMessage requestMessage = new TextMessage();
				requestMessage.setFromUserName(fromUserName);
				requestMessage.setToUserName(toUserName);
				requestMessage.setContent(requestMap.get("Content"));
				
				SecretaryService service = new SecretaryService();
				TextMessage responceMessage = service.doResponce(requestMessage);
				
				
				String responceString = XmlUtils.textMessageToXml(responceMessage);
				System.out.println("结果为"+responceString);
				
	}

}
