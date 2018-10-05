package com.capg.uas.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.capg.uas.exception.UASException;

public enum ConnectionProvider {

	DEFAULT_INSTANCE;

	private String driver;
	private String username;
	private String password;
	private String url;

	private Logger log = Logger.getLogger("DB");

	private ConnectionProvider() {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("resources/db.properties"));
			username = props.getProperty("db.username");
			driver = props.getProperty("db.driver");
			password = props.getProperty("db.password");
			url = props.getProperty("db.url");
			Class.forName(driver);
			log.info("Driver Loaded");
		} catch (ClassNotFoundException | IOException e) {
			log.error(e);
		}
	}

	public Connection getConnection() throws UASException {
		Connection con = null;

		try {
			if (url != null && username != null && password != null) {
				con = DriverManager.getConnection(url, username, password);
			}else
				throw new UASException("Connection Configuaration Not Loaded!");
		} catch (SQLException e) {
			log.error(e);
			throw new UASException("Connection is not established!");
		}
		return con;
	}
}
