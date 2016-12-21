package com.shop.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ConnectionPool {
	private static String DRIVER=null;
	private static String URL=null;
	private static String PASSWORD=null;
	private static String USER=null;
	
	static{
		DRIVER=ResourceBundle.getBundle("dbconfig").getString("driver");
		URL=ResourceBundle.getBundle("dbconfig").getString("url");
		PASSWORD=ResourceBundle.getBundle("dbconfig").getString("password");
		USER=ResourceBundle.getBundle("dbconfig").getString("user");
	}
	
	public static Connection getConnection() {
		Connection conn=null;
		//1、加载数据库驱动
		try {
			Class.forName(DRIVER);
			//2、获取链�?
			conn=DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(ResultSet rs,PreparedStatement ps,Connection conn){//【查询�?关闭资源
		try{
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(ps!=null){
				ps.close();
				ps=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void close(PreparedStatement ps,Connection conn){//【增】�?删�?【改】关闭资�?
		try{
			
			if(ps!=null){
				ps.close();
				ps=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
