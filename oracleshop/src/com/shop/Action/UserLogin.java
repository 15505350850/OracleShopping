package com.shop.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.Dao.UserDao;

public class UserLogin extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// response.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDao();
		if (userDao.userLogin(username, password)) {
			HttpSession session = request.getSession();// 获取session的值
			session.setAttribute("username", username);
			request.getRequestDispatcher("admin/main.jsp").forward(
					request, response);
		}else {
			request.setAttribute("errMsg", "用户名或密码错误，请重试！");
			
		}
		
		

		
		
	}

}
