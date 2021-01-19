package com.jsplec.wp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class frontReviewWriteDao {
	DataSource dataSource;
	
	public frontReviewWriteDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		
	public void frontReviewWrite(String userid, String starScore, String q1, String q2, String q3, String retitle, String rcontent, String reimage, String rerealimage) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "insert into review (reuserid, rescore, rq1, rq2, rq3, retitle, recontent, reimage, rereimage, reinsertdate) values (?, ?, ?, ?, ?, ?, ?, ?, ?, now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString (1, userid);
			preparedStatement.setInt (2, Integer.parseInt(starScore));
			preparedStatement.setString (3, q1);
			preparedStatement.setString (4, q2);
			preparedStatement.setString (5, q3);
			preparedStatement.setString (6, retitle);
			preparedStatement.setString (7, rcontent);
			preparedStatement.setString (8, reimage);
			preparedStatement.setString (9, rerealimage);
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
