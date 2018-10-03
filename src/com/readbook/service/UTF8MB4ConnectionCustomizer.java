package com.readbook.service;

import com.mchange.v2.c3p0.AbstractConnectionCustomizer;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class UTF8MB4ConnectionCustomizer extends AbstractConnectionCustomizer {    
	public void onAcquire(Connection c, String parentDataSourceIdentityToken) throws java.lang.Exception {       
		Statement stmt = null;        
		try {           
			stmt = (Statement) c.createStatement();            
			stmt.executeUpdate("SET names utf8mb4");        
		 } 
		finally {            
			if (stmt != null) stmt.close();
		}
	}
}
