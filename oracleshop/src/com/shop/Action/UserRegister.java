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
		UserBean userBean = new UserBean();
		userBean.setT_name(request.getParameter("t_name"));
		/**
		 * 密码没做统一性验证，默认插入密码数据为第一次输入的密码
		 */
		userBean.setT_userpsw(request.getParameter("t_userpsw"));
		userBean.setT_nickname(request.getParameter("t_nickname"));
		userBean.setT_tel(request.getParameter("t_tel"));
		userBean.setT_address(request.getParameter("t_address"));
		userBean.setT_name(request.getParameter("t_name"));
		System.out.println(userBean.toString());
		/**
		 * 调用Dao层方法，执行注册用户操作
		 */
		UserDao userDao = new UserDao();
		int a = userDao.registerUser(userBean);
		if (a>0) {//注册成功
			request.setAttribute("errMsg", "注册成功！请登录！");//置errmsg的值
			request.getRequestDispatcher("index.jsp").forward(request,response);//返回到login登录界面
		}else {//注册失败
			request.setAttribute("errMsg", "注册失败！请重新注册");//置errmsg的值
			request.getRequestDispatcher("register.jsp").forward(request,response);//返回到login登录界面
		}

		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
