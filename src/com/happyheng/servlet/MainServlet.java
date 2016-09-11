package com.happyheng.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happyheng.dispatcher.ServiceDispatcher;
import com.happyheng.entity.TextMessage;
import com.happyheng.service.BaseService;
import com.happyheng.utils.SHA1;
import com.happyheng.utils.XmlUtils;

@WebServlet("/*")
public class MainServlet extends HttpServlet {

	private static final String TOKEN = "xxx";

	/**
	 * 
	 */
	private static final long serialVersionUID = -4514428326980674966L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");

		String[] str = { TOKEN, timestamp, nonce };
		Arrays.sort(str); // 字典序排序
		String bigStr = str[0] + str[1] + str[2];
		// SHA1加密
		String digest = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();

		// 确认请求来至微信
		if (digest.equals(signature)) {
			response.getWriter().print(echostr);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// xml请求解析
		Map<String, String> requestMap = null;
		try {
			requestMap = XmlUtils.parseXml(request.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 输入内容
		String content = "";
		if (requestMap.containsKey("Content")) {
			content = requestMap.get("Content").trim();
		}
		// 消息类型
		String messageType = requestMap.get("MsgType");
		// Event
		String event = requestMap.get("Event");

		TextMessage requestMessage = new TextMessage();
		requestMessage.setFromUserName(fromUserName);
		requestMessage.setToUserName(toUserName);
		requestMessage.setContent(content);
		
		System.out.println("输入内容为"+content);

		TextMessage responceMessage = null;
		ServiceDispatcher dispatcher = new ServiceDispatcher();
		BaseService service = dispatcher.getService(content, messageType, event);
		responceMessage = service.doResponce(requestMessage);

		String responceString = XmlUtils.textMessageToXml(responceMessage);
		response.getWriter().print(responceString);
	}

}
