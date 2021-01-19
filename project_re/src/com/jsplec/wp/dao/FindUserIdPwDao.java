package com.jsplec.wp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class FindUserIdPwDao {
	DataSource dataSource;
	public FindUserIdPwDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	// 아이디 찾기
	public String findUserId(String usertel,String userbday) {
		String userid=null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select userid from userinfo where usertel = ? and userbday = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, usertel);
			preparedStatement.setString(2, userbday);
			resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.next()) {
				userid = resultSet.getString(1);
	
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
		
		
		
		
		
		return userid;
	}
	
	
	// 비밀번호 찾기
	public String findUserPw(String userid,String usertel) {
		String userpw=null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select userpw from userinfo where userid = ? and usertel = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userid);
			preparedStatement.setString(2, usertel);
			resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.next()) {
				userpw = resultSet.getString(1);
	
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
		
		
		
		
		
		return userpw;
	}
}
