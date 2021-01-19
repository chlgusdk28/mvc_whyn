package com.jsplec.wp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConsultingDao {


	DataSource dataSource;
	
	public ConsultingDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void Consulting(String c_no,String con_info) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "insert into simplecon (sctype, scuserinfo, cdate) values (?, ?, now())";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString (1, c_no);
			preparedStatement.setString (2, con_info);
			preparedStatement.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	
	
	
}
