package com.shop.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.Bean.UserBean;
import com.shop.Dao.UserDao;

public class UserRegister extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserRegister() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		
		UserBean userBean = new UserBean();
		userBean.setT_name(request.getParameter("username"));

		userBean.setT_userpsw(request.getParameter("password1"));
		userBean.setT_nickname(request.getParameter("nickname"));
		userBean.setT_tel(request.getParameter("tel"));
		userBean.setT_address(request.getParameter("address"));
		//userBean.setT_name(request.getParameter("t_name"));
		System.out.println(userBean.toString());
		/**
		 * 调用Dao层方法，执行注册用户操作
		 */
		UserDao userDao = new UserDao();
		int a = userDao.registerUser(userBean);
		if (a>0) {//注册成功
			//request.setAttribute("errMsg", "注册成功！请登录！");//置errmsg的值
			//request.getRequestDispatcher("index.jsp").forward(request,response);//返回到login登录界面
			PrintWriter pw = response.getWriter();
			pw.print("ok");
			pw.flush();
		}else {//注册失败
			//request.setAttribute("errMsg", "注册失败！请重新注册");//置errmsg的值
			//request.getRequestDispatcher("register.jsp").forward(request,response);//返回到login登录界面
			PrintWriter pw = response.getWriter();
			pw.print("error");
			pw.flush();
		}

		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
