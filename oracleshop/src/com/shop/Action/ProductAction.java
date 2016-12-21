package com.shop.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.shop.Bean.ProductBean;
import com.shop.Dao.ProductDao;

public class ProductAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// response.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");

		String type = request.getParameter("type");
		if (type.equals("add")) {
			/**
			 * ������Ʒ��Ϣ����
			 */
			ProductBean productBean = new ProductBean();
			productBean.setT_productname(request.getParameter("t_productname"));
			productBean.setT_price(Integer.parseInt(request
					.getParameter("t_price")));
			productBean
					.setT_num(Integer.parseInt(request.getParameter("t_num")));
			productBean.setT_productdate(request.getParameter("t_productdate"));
			productBean.setT_postage(Integer.parseInt(request
					.getParameter("t_postage")));
			productBean.setT_comment(request.getParameter("t_comment"));
			// System.out.println(productBean.toString());
			ProductDao productDao = new ProductDao();
			int a = productDao.addProduct(productBean);
			if (a > 0) {
				PrintWriter pw = response.getWriter();
				pw.print("ok");
				pw.flush();
			}

		} else if (type.equals("show")) {
			/**
			 * չʾ��Ʒ �б�
			 */
			ProductDao productDao = new ProductDao();
			ArrayList<ProductBean> list = productDao.getProductList();
			// System.out.println(list.size());
			JSONObject js = new JSONObject();
			js.put("list", list);
			PrintWriter pw = response.getWriter();
			pw.print(js);
			pw.flush();
			pw.close();
		} else if (type.equals("id")) {
			/**
			 * ��ȡ������Ʒ��Ϣ������ID
			 */
			request.getParameter("id");
			ProductDao productDao = new ProductDao();
			int id = Integer.parseInt(request.getParameter("id"));
			ProductBean productBean = productDao.queryProductById(id);
			// System.out.println(productBean.toString());
			HttpSession session = request.getSession();// ��ȡsession��ֵ
			session.setAttribute("productBean", productBean);
			request.getRequestDispatcher("admin/productinfo.jsp").forward(
					request, response);//
		} else if (type.equals("modify")) {
			/**
			 * �޸���Ʒ��Ϣ
			 */
			ProductBean productBean = new ProductBean();
			productBean.setT_productid(Integer.parseInt(request.getParameter("t_productid")));
			productBean.setT_productname(request.getParameter("t_productname"));
			productBean.setT_price(Integer.parseInt(request.getParameter("t_price")));
			productBean.setT_num(Integer.parseInt(request.getParameter("t_num")));
			productBean.setT_productdate(request.getParameter("t_productdate"));
			productBean.setT_postage(Integer.parseInt(request.getParameter("t_postage")));
			productBean.setT_comment(request.getParameter("t_comment"));
			System.out.println(productBean.toString());
			ProductDao productDao = new ProductDao();
			int a = productDao.modifyProductInfo(productBean);
			if (a > 0) {
				PrintWriter pw = response.getWriter();
				pw.print("ok");
				pw.flush();
			}

		} else if (type.equals("del")) {
			/**
			 * ɾ����Ʒ��Ϣ
			 */
			ProductDao productDao = new ProductDao();
			int a = productDao.deleteProductById(Integer.parseInt(request
					.getParameter("t_productid")));
			if (a > 0) {
				/**
				 * ɾ���ɹ�
				 */
				PrintWriter pw = response.getWriter();
				pw.print("ok");
				pw.flush();

			}

		}else if (type.equals("search")) {
			//System.out.println("@@@@@@@@@");
			String word = request.getParameter("product_like");
			System.out.println(word);
			ProductDao productDao = new ProductDao();
			ArrayList<ProductBean> list = productDao.searchProductByWord(word);
			System.out.println(list.size());
			
				JSONObject js = new JSONObject();
				js.put("list", list);
				PrintWriter pw = response.getWriter();
				pw.print(js);
				pw.flush();
				pw.close();
			


		}
		
		

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
