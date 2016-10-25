package com.theo.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	static {
		try {
			Properties properties = new Properties();
			InputStream is = ConnectionFactory.class.getClassLoader()
					.getResourceAsStream("com/theo/utils/database.properties");
			properties.load(is);
			driver=properties.getProperty("driver");
			url=properties.getProperty("url");
			user=properties.getProperty("user");
			password=properties.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
			// 当捕获到异常，需要停止程�?
			System.exit(-1);
		}
	}
	
	public static Connection getCon() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

	public static void closeAll(Connection conn, PreparedStatement pst,
			ResultSet rs) {
		try {
			if (conn != null)
				conn.close();
			if (pst != null)
				pst.close();
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
