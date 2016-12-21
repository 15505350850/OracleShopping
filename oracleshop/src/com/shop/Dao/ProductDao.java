package com.shop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.Bean.ProductBean;
import com.shop.util.ConnectionPool;

public class ProductDao {
	
	public int addProduct(ProductBean productBean){
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = ConnectionPool.getConnection();
			String sql = "insert into product values(t_productid.nextval,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, productBean.getT_productname());
			ps.setInt(2, productBean.getT_price());
			ps.setInt(3, productBean.getT_num());
			ps.setString(4, productBean.getT_productdate());
			ps.setInt(5, productBean.getT_postage());
			ps.setString(6, productBean.getT_comment());			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public ArrayList<ProductBean> getProductList(){
		ArrayList<ProductBean> list = new ArrayList<ProductBean>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ConnectionPool.getConnection();
			String sql = "select * from product order by t_productid asc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				ProductBean productBean = new ProductBean();
				productBean.setT_productid(rs.getInt("t_productid"));
				productBean.setT_productname(rs.getString("t_productname"));
				productBean.setT_price(rs.getInt("t_price"));
				productBean.setT_num(rs.getInt("t_num"));
				productBean.setT_productdate(rs.getString("t_productdate"));
				productBean.setT_postage(rs.getInt("t_postage"));
				productBean.setT_comment(rs.getString("t_comment"));
				//System.out.println(productBean.toString());
				list.add(productBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * ��ѯ������Ʒ��Ϣ��ͨ��ID
	 * @param id ��ƷID
	 * @return
	 */
	public ProductBean  queryProductById(int id){
		ProductBean productBean = new ProductBean();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ConnectionPool.getConnection();
			String sql = "select * from product where t_productid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				productBean.setT_productid(rs.getInt("t_productid"));
				productBean.setT_productname(rs.getString("t_productname"));
				productBean.setT_price(rs.getInt("t_price"));
				productBean.setT_num(rs.getInt("t_num"));
				productBean.setT_productdate(rs.getString("t_productdate"));
				productBean.setT_postage(rs.getInt("t_postage"));
				productBean.setT_comment(rs.getString("t_comment"));
				//System.out.println(productBean.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productBean;
	}

	
	/**
	 * �޸���Ʒ��Ϣ
	 * @param productBean
	 * @return ����ֵ>1ʱ  �޸ĳɹ�
	 */
	public int modifyProductInfo(ProductBean productBean){
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = ConnectionPool.getConnection();
			String sql = "update product set t_productname=?,t_price=?,t_num=?,t_productdate=?,t_postage=?,t_comment=? where t_productid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, productBean.getT_productname());
			ps.setInt(2, productBean.getT_price());
			ps.setInt(3, productBean.getT_num());
			ps.setString(4, productBean.getT_productdate());
			ps.setInt(5, productBean.getT_postage());
			ps.setString(6, productBean.getT_comment());
			ps.setInt(7, productBean.getT_productid());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * �����ƷIDɾ����Ʒ
	 * @param t_productid  ��ƷID
	 * @return
	 */
	public int deleteProductById(int t_productid){
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			conn = ConnectionPool.getConnection();
			String sql = "delete product where t_productid = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, t_productid);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<ProductBean> searchProductByWord(String word){
		ArrayList<ProductBean> list = new ArrayList<ProductBean>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ConnectionPool.getConnection();
			String sql = "select * from product where t_productname like ? order by t_productid asc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + word + "%");
			rs = ps.executeQuery();
			while(rs.next()){
				ProductBean productBean = new ProductBean();
				productBean.setT_productid(rs.getInt("t_productid"));
				productBean.setT_productname(rs.getString("t_productname"));
				productBean.setT_price(rs.getInt("t_price"));
				productBean.setT_num(rs.getInt("t_num"));
				productBean.setT_productdate(rs.getString("t_productdate"));
				productBean.setT_postage(rs.getInt("t_postage"));
				productBean.setT_comment(rs.getString("t_comment"));
				System.out.println(productBean.toString());
				list.add(productBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	
	

}
