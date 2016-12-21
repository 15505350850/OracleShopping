package com.shop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.Bean.ProductBean;
import com.shop.Bean.UserBean;
import com.shop.util.ConnectionPool;

public class UserDao {
	public boolean userLogin(String username , String password){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		
		try {
			conn = ConnectionPool.getConnection();
			String sql = "select count(*) from t_users where t_name=? and t_userpsw=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()){
				if (rs.getInt("count(*)")>0) {
					result = true;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int registerUser(UserBean userBean){
		return 0;
		
	}
	
	/**
	 * 获取用户列表
	 * @return
	 */
	public ArrayList<UserBean> getUserList(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		try {
			conn = ConnectionPool.getConnection();
			String sql = " select * from t_users order by t_userid asc ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				UserBean userBean = new UserBean();
				userBean.setT_userid(Integer.parseInt(rs.getString("t_userid")));
				userBean.setT_name(rs.getString("t_name"));
				userBean.setT_nickname(rs.getString("t_nickname"));
				userBean.setT_tel(rs.getString("t_tel"));
				userBean.setT_address(rs.getString("t_address"));
				userBean.toString();
				list.add(userBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	/**
	 * 修改用户信息  通过user id
	 * @param userBean
	 * @return
	 */
	public int modifyUserInfoById(UserBean userBean){
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try {
			conn = ConnectionPool.getConnection();
			String sql = "update t_users set t_nickname=? , t_tel=? , t_address=? where t_userid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,userBean.getT_nickname());
			ps.setString(2, userBean.getT_tel());
			ps.setString(3, userBean.getT_address());
			ps.setInt(4, userBean.getT_userid());
			rs = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	
	/**
	 * 删除单个用户，根据用户ID
	 * @param t_userid
	 * @return
	 */
	public int deleteUserById(int t_userid){
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try {
			conn = ConnectionPool.getConnection();
			String sql = "delete t_users where t_userid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,t_userid);
			rs = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	

}
