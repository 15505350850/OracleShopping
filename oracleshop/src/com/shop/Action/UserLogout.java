package com.shop.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLogout extends HttpServlet {



	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);


	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session= request.getSession();//取得Session的值
		session.invalidate();//使Session的值失效
		response.sendRedirect(request.getContextPath()+"/index.jsp");//退出登录到login界面


	}


	public void init() throws ServletException {
		// Put your code here
	}

}
