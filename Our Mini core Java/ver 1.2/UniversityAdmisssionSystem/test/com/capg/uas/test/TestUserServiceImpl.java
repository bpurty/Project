package com.capg.uas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capg.uas.dao.MacDaoImpl;
import com.capg.uas.exception.UASException;
import com.capg.uas.service.MacServiceImpl;
import com.capg.uas.util.ConnectionProvider;


public class TestUserServiceImpl {
	
	
	
	@Before
	public void setUp() throws Exception {
		Connection con = ConnectionProvider.DEFAULT_INSTANCE.getConnection();
		PreparedStatement st = con.prepareStatement("INSERT INTO Users values(?,?,?)");
		st.setString(1,"dummy");
		st.setString(2, "p@ss");
		st.setString(3, "MAC");
		st.executeQuery();
		if(con!=null && !con.isClosed())
			con.close();
	}

	@After
	public void tearDown() throws Exception {
		Connection con = ConnectionProvider.DEFAULT_INSTANCE.getConnection();
		PreparedStatement st = con.prepareStatement("DELETE FROM Users WHERE login_id=?");
		st.setString(1,"dummy");
		st.executeQuery();
		if(con!=null && !con.isClosed())
			con.close();
	}

	@Test
	public void testGetRole() throws UASException {
		MacServiceImpl userService = new MacServiceImpl();
		try {
			Boolean role = userService.validateMac("dummy","p@ss");
			assertEquals(true,role);
			MacDaoImpl.logger.info("1");
			
		} catch (UASException e) {
			MacDaoImpl.logger.error("0");
			throw new UASException("USER Not validated");
		}		
		
	}

}
