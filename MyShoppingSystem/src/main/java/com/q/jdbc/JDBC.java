package com.q.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBC {
	
	private static String driver_p;
	private static String username_p;
	private static String password_p;
	private static String url_p;
	
	//静态语句块
	static {
		//JDBCUtils.class获得对象
		//getClassLoader()类加载器
		//getResourceAsStream("rs.properties")加载资源文件放到输入流中
		InputStream is = JDBC.class.getClassLoader().getResourceAsStream("configuration_files/rs.properties");
		
		//创建Properties类型的对象
		Properties p = new Properties();
		
		//加载流文件
		try {
			p.load(is);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		driver_p = p.getProperty("driver");
		username_p = p.getProperty("mysql_username");
		password_p = p.getProperty("mysql_password");
		url_p = p.getProperty("mysql_url");
		
		try {
			//加载MySQL驱动
			Class.forName(driver_p);
			System.out.println("驱动加载成功");
			//System.out.println(url_p+username_p+password_p);//检验连接
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//获得连接对象
	//连接数据库
	public static Connection getConnection() {
		Connection connection_mq = null;
		try {
			connection_mq = DriverManager.getConnection(url_p, username_p, password_p);
			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("查看数据库连接");
		}
		return connection_mq;
	}
	
	//释放资源的方法
	public static void close_rele_all(Connection connection, Statement statement,ResultSet result){
		try {
			if(connection!=null) {
				connection.close();
				connection = null;
			}
			if(statement!=null) {
				statement.close();
				statement = null;
			}
			if(result!=null) {
				result.close();
				result = null;
			}
			System.out.println("释放");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
