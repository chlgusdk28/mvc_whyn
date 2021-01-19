package com.jsplec.wp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ALoginDao {
	DataSource dataSource;
	public ALoginDao() {
		try {
			Context context= new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	//admin 로그인 체크
	public int adminlogincheck(String userid,String userpw) {
		int loginCheck=0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
		     connection = dataSource.getConnection();
		     String query = "select count(*) from userinfo where userid = ? and userpw = ? and userno = 1";
		     preparedStatement = connection.prepareStatement(query);
		     System.out.println(query);
		     preparedStatement.setString(1, userid);
		     preparedStatement.setString(2, userpw);
		     resultSet = preparedStatement.executeQuery();
		     
		     if(resultSet.next()) {
		    	loginCheck=resultSet.getInt(1);
		     }
		     
		       
		    }catch(Exception e) {
		    	e.printStackTrace();
   
		    }finally {
				try {
					if(resultSet!=null) resultSet.close();
					if(preparedStatement!=null) preparedStatement.close();
					if(connection!=null) connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}

		return loginCheck;
	}
}
