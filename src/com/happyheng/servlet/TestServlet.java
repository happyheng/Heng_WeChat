package com.happyheng.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4356541239108791842L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("image/jpeg");
		
		ServletOutputStream outputStream = resp.getOutputStream();
		
		FileInputStream inputStream = new FileInputStream(new File("/Users/liuheng/Desktop/JavaWeb/test.jpg"));
		byte b[] = new byte[1000];
		int len;
		
		while((len = inputStream.read(b))!=-1){
			outputStream.write(b, 0, len);	
		}
		
		inputStream.close();
		outputStream.flush();
	}
}
