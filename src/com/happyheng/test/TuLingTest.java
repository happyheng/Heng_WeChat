package com.happyheng.test;

public class TuLingTest {
	
	public static final String TULING_KEY = "6cc5357b84ce5bf24a784370fb491557";

	public static void main(String[] args) {
		//String responceString = TuLingRequest.getResponce("今天北京天气", "1");
		
		//String responceString = LocationRequest.getReponce("13315257169");
		
		//String responceString = SharesRequest.getReponce("601009");
		String request = "股票 134";
		String subString = request.substring(3);
		System.out.println("结果为"+subString);
	}

}
