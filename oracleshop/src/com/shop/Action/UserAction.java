package com.shop.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.shop.Bean.UserBean;
import com.shop.Dao.UserDao;

public class UserAction extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		String type = request.getParameter("type");
		
		if (type.equals("list")) {
			/**
			 * 获取用户列表
			 */
			ArrayList<UserBean> list = new ArrayList<UserBean>();
			UserDao userDao = new UserDao();
			list = userDao.getUserList();
			if (list.size()>0) {
				JSONObject js = new JSONObject();
				js.put("userlist", list);
				PrintWriter pw = response.getWriter();
				pw.print(js);
				pw.flush();
				pw.close();
			}
		}
		
		else if (type.equals("modify")) {
			/**
			 * 修改用户信息
			 */
			UserBean userBean = new UserBean();
			userBean.setT_userid(Integer.parseInt(request.getParameter("t_userid")));
			userBean.setT_name(request.getParameter("t_name"));
			userBean.setT_nickname(request.getParameter("t_nickname"));
			userBean.setT_tel(request.getParameter("t_tel"));
			userBean.setT_address(request.getParameter("t_address"));
			userBean.setT_name(request.getParameter("t_name"));
			UserDao userDao = new UserDao();
			int a = userDao.modifyUserInfoById(userBean);
			if (a>0) {
				PrintWriter pw = response.getWriter();
				pw.print("ok");
				pw.flush();
			}
		}else if (type.equals("del")) {
			/**
			 * 删除用户
			 */
			int t_userid = Integer.parseInt(request.getParameter("id"));
			//System.out.println(t_userid);
			UserDao userDao = new UserDao();
			int a = userDao.deleteUserById(t_userid);
			if (a>0) {
				/**
				 * 删除成功
				 * 
				 */
				PrintWriter pw = response.getWriter();
				pw.print("ok");
				pw.flush();
				
			}
			
			
		}
		
		
		
		


	}


	public void init() throws ServletException {
		// Put your code here
	}

}
