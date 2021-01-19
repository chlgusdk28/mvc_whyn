package com.jsplec.wp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.wp.dto.LoginDto;

public class UloginDao {
	DataSource dataSource;
	
	public UloginDao() {
		try {
			Context context= new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public LoginDto login(String userid, String userpw) {
		int rsuserno=0;
		String rsuserid = null;
		String rsusername = null;
		String rsuseremail = null;
		LoginDto dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
		     connection = dataSource.getConnection();
		     String query = "select userno,userid,username from userinfo where userid = ? and userpw = ?";
		     preparedStatement = connection.prepareStatement(query);
		     preparedStatement.setString(1, userid);
		     preparedStatement.setString(2, userpw);
		     resultSet = preparedStatement.executeQuery();
		     
		     if(resultSet.next()) {
		    	rsuserno=resultSet.getInt(1);
		    	rsuserid=resultSet.getString(2);
		    	rsusername=resultSet.getString(3);
		    
		    	dto = new LoginDto(rsuserno,rsuserid,rsusername,rsuseremail);
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
		return dto;
	}
	
	
	public int logincheck(String userid,String userpw) {
		int loginCheck=0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
		     connection = dataSource.getConnection();
		     String query = "select count(*) from userinfo where userid = ? and userpw = ?";
		     preparedStatement = connection.prepareStatement(query);
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
	


	public void join(String username, String userid, String userpw, String usergender, String userage, String usertel,
			 String address1, String address2, String address3) {
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
		     connection = dataSource.getConnection();	     
		     String query1 = "insert into userinfo(username,userid,userpw,usergender,userbday,usertel,useraddress1,useraddress2,useraddress3,userjoindate) ";
		     String query2 = " values (?,?,?,?,?,?,?,?,?,now())";
		     preparedStatement = connection.prepareStatement(query1+query2);
		     preparedStatement.setString(1, username);
		     preparedStatement.setString(2, userid);
		     preparedStatement.setString(3, userpw);
		     preparedStatement.setString(4, usergender);
		     preparedStatement.setString(5, userage);
		     preparedStatement.setString(6, usertel);
		     preparedStatement.setString(7, address1);
		     preparedStatement.setString(8, address2);
		     preparedStatement.setString(9, address3);
		     preparedStatement.execute();
		     System.out.println(query1+query2);
    
		    }catch(Exception e) {
		    	e.printStackTrace();
   
		    }finally {
				try {
					
					if(preparedStatement!=null) preparedStatement.close();
					if(connection!=null) connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	}
	public void d_join(String userid, String daddress1, String daddress2, String daddress3) {
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
		     connection = dataSource.getConnection();	     
		     String query1 = "insert into procject.delivery(duserid,daddress1,daddress2,daddress3)";
		     String query2 = " values (?,?,?,?)";
		     preparedStatement = connection.prepareStatement(query1+query2);
		     preparedStatement.setString(1, userid);
		     preparedStatement.setString(2, daddress1);
		     preparedStatement.setString(3, daddress2);
		     preparedStatement.setString(4, daddress3);
		     preparedStatement.execute();
		     System.out.println(query1+query2);
   
		    }catch(Exception e) {
		    	e.printStackTrace();
  
		    }finally {
				try {
					
					if(preparedStatement!=null) preparedStatement.close();
					if(connection!=null) connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	}	

	public int joinIdCheck(String userid) {
		int loginCheck=0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
		     connection = dataSource.getConnection();
		     String query = "select count(*) from userinfo where userid = ?";
		     preparedStatement = connection.prepareStatement(query);
		     preparedStatement.setString(1, userid);
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
