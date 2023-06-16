package com.servlet.demo.manager;

import java.sql.*;

public class DBConnectionManager {

	private String driver;
	private String dbURL;
	private String user;
	private String password;
	private Connection con;
	
	public DBConnectionManager(String driver,String url, String u, String p){
		this.driver = driver;
		this.dbURL=url;
		this.user=u;
		this.password=p;
		try {
			//install driver
			Class.forName(driver);
			//create db connection now
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return this.con;
	}
	
	public void closeConnection(ResultSet rst, PreparedStatement pst,Connection con){
		if (rst != null){
			try {
				rst.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pst != null){
			try {
				pst.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}