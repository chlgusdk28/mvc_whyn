package com.jsplec.wp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DeliveryUpdateDao {
	DataSource dataSource;
	
	public DeliveryUpdateDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void deliveryUpdate(String duserid , String dusername, String dtel, String daddress1, String daddress2, String daddress3) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "UPDATE delivery SET dusername=?,dtel=?,daddress1=?,daddress2=?,daddress3=? where duserid=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, dusername);
			preparedStatement.setString(2, dtel);
			preparedStatement.setString(3, daddress1);
			preparedStatement.setString(4, daddress2);
			preparedStatement.setString(5, daddress3);
			preparedStatement.setString(6, duserid);
			preparedStatement.executeUpdate();

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
