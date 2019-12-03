/**
 * 
 */
package com.cognizant.truyum.dao;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Created By Saranya 760862
 *
 */
public class ConnectionHandler {
	public static Connection getConnection() {
		Connection con = null;
		try {
			URL resource = Thread.currentThread().getContextClassLoader()
					.getResource("connection.properties");
			Properties prop = new Properties();
			File file = new File(resource.toURI());
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			String dbDriverName = prop.getProperty("driver");
			String jdbcUrl = prop.getProperty("connection-url");
			String dbUsername = prop.getProperty("user");
			String dbPassword = prop.getProperty("password");
			Class.forName(dbDriverName);
			con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
