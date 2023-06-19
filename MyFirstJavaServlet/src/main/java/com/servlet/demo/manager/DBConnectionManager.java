package com.servlet.demo.manager;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.*;

public class DBConnectionManager {

	private String driver;
	private String dbURL;
	private String user;
	private String password;
	//private Connection con;
	private BasicDataSource dataSource;

	/**
	 * In Java, the database connection pool is written to implement java.sql.DataSource interface.
	 * Every database connection pool is implemented by DataSource interface.
	 * The DBCP connection pool is a concrete implementation of the java.sql.DataSource interface.
	 */
	private int initSize = 100;//initialSize connection num
	private int maxActive = 1000;//max connection num
	private int maxIdle = 20;//Maximum idle connection
	private int minIdle = 5;//Minimum idle connection
	private int maxWait = 60000;//timeout waiting time in milliseconds of 6000 milliseconds /1000 equal to 60 seconds
	
	public DBConnectionManager(String driver,String url, String u, String p){
		this.driver = driver;
		this.dbURL=url;
		this.user=u;
		this.password=p;
		try {
			//install driver
//			Class.forName(driver);
			//create db connection now
//			con = DriverManager.getConnection(url, user, password);

			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(dbURL);
			dataSource.setUsername(user);
			dataSource.setPassword(password);
			dataSource.setInitialSize(initSize);
			dataSource.setMaxActive(maxActive);
			dataSource.setMaxIdle(maxIdle);
			dataSource.setMinIdle(minIdle);
			dataSource.setMaxWait(maxWait);
			//for test fix time_out bug
			dataSource.setTestWhileIdle(true);
			dataSource.setTimeBetweenEvictionRunsMillis(3600000);
			dataSource.setValidationQuery("select 1");
			dataSource.setNumTestsPerEvictionRun(maxActive);
			dataSource.setValidationQueryTimeout(60000);
			this.dataSource = dataSource;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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