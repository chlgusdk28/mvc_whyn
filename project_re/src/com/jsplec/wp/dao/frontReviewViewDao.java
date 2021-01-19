package com.jsplec.wp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.wp.dto.ACLDto;
import com.jsplec.wp.dto.frontReviewViewDto;

public class frontReviewViewDao {
	DataSource dataSource;
	
	public frontReviewViewDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public frontReviewViewDto reviewView(int rreno) {
		frontReviewViewDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from review where reno= ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, rreno);
			resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.next()) {
				int reno = resultSet.getInt(1);
				String reuserid= resultSet.getString(2); 
				String retitle  =resultSet.getString(3);
				String recontent = resultSet.getString(4);
				int rescore = resultSet.getInt(5);
				String reinsertdate=resultSet.getString(6);
				String reimage=resultSet.getString(7);
				int reviewcount=resultSet.getInt(8);
				String rq1 = resultSet.getString(9);
				String rq2 = resultSet.getString(10);
				String rq3 = resultSet.getString(11);
				
				dto = new frontReviewViewDto(reno, reuserid, retitle, recontent, rescore, reinsertdate, reimage, reviewcount, rq1, rq2, rq3);
				
				
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
		
		
		
		
		
		return dto;
	}
	
	
	
	
	
	
}
