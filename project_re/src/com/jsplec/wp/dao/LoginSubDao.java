package com.jsplec.wp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LoginSubDao {

	static DataSource dataSource;
	
	public LoginSubDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public int subjud(int userno) {
		int subjud=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from subscribe where suserno =?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userno);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				subjud=resultSet.getInt(1);
	
				
			}
		}catch (Exception e) {
		e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return subjud;
	}
	
	
	
	
	
}
