package com.comcast.crm.generic.databaseutility;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn = null;

	public void getDBConnection(String url, String username, String password) {

		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			DriverManager.getConnection(url, username, password);
		} catch (Exception e) {

		}
	}

	public void getDBConnection() {

		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			DriverManager.getConnection("jdbc:mySql://106.51.90.215:3333/projects", "root@%", "root");
		} catch (Exception e) {

		}
	}

	public void closeDBConnection() {
		try {
			conn.close();
		} catch (Exception e) {

		}
	}

	public ResultSet executeQuery(String query) {
		ResultSet result = null;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeQuery(query);
			System.out.println(result);
		} catch (Exception e) {

		}
		return result;
	}

	public int executeUpdate(String query) {
		int result = 0;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeUpdate(query);
			System.out.println(result);
		} catch (Exception e) {

		}
		return result;
	}

}
