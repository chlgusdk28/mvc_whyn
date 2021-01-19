package com.jsplec.wp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.jsplec.wp.dto.MyPageDto;

public class MyPageDao {
	DataSource dataSource;
	
	public MyPageDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	// 유저정보
	public MyPageDto myPageUserinfoView(int userno) {
		MyPageDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select usertel,useraddress1, useraddress2,useraddress3,usergender,userjoindate,userbday,usersubscribe from userinfo where userno = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userno);
			resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.next()) {
				String usertel = resultSet.getString("usertel");
				String useraddress1 = resultSet.getString("useraddress1");			
				String useraddress2 = resultSet.getString("useraddress2");			
				String useraddress3 = resultSet.getString("useraddress3");			
				String usergender = resultSet.getString("usergender");
				String userjoindate = resultSet.getString("userjoindate");
				String userbday = resultSet.getString("userbday");
				int usersubscribe = resultSet.getInt("usersubscribe");
				
				dto = new MyPageDto(usertel,useraddress1,useraddress2, useraddress3,usergender,userjoindate,userbday,usersubscribe);
				
				
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
	
	
	// 내가쓴 후기글 정보
	public ArrayList<MyPageDto> myPageReviewView(String userid) {
		ArrayList<MyPageDto> dtos= new ArrayList<MyPageDto>();
		MyPageDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select reno,reuserid,retitle,rescore,reinsertdate,reviewcount from review where reuserid = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userid);
			resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.next()) {
				int reno = resultSet.getInt("reno");
				String reuserid = resultSet.getString("reuserid");			
				String retitle = resultSet.getString("retitle");
				int rescore = resultSet.getInt("rescore");
				String reinsertdate = resultSet.getString("reinsertdate");
				int reviewcount = resultSet.getInt("reviewcount");
				
				dto = new MyPageDto(reno,reuserid,retitle,rescore,reinsertdate,reviewcount);
				dtos.add(dto);
				
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
		
		
		
		
		return dtos;
	}
	
	
	// 내 구독 정보
	public MyPageDto myPageSubscribeView(int userno) {
		MyPageDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select ssubno,speriod,sbottle,senddate,suserno,startdate,enddate, sprice from subscribe where suserno = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userno);
			resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.next()) {
				int ssubno = resultSet.getInt("ssubno");
				String speriod = resultSet.getString("speriod");			
				String sbottle = resultSet.getString("sbottle");
				String senddate = resultSet.getString("senddate");
				int suserno = resultSet.getInt("suserno");
				String startdate = resultSet.getString("startdate");
				String enddate = resultSet.getString("enddate");
				String sprice = resultSet.getString("sprice");
				
				
				dto = new MyPageDto(ssubno,speriod,sbottle,senddate,suserno,startdate,enddate, sprice);
				
				
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
	
	
	
	
	public MyPageDto deliveryUserinfoView(String duserid) {
		MyPageDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select dtel, daddress1, daddress2,daddress3, dusername, dmsg from delivery where duserid = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, duserid);
			resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.next()) {
				String dtel = resultSet.getString("dtel");
				String daddress1 = resultSet.getString("daddress1");			
				String daddress2 = resultSet.getString("daddress2");			
				String daddress3 = resultSet.getString("daddress3");			
				String dusername1 = resultSet.getString("dusername");			
				String dmsg = resultSet.getString("dmsg");	
				
				dto = new MyPageDto(dtel,daddress1,daddress2, daddress3, dusername1, dmsg);
				
				
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
	
	
	public void deliveryUpdate(String duserid, String dusername,String dtel, String daddress1,String daddress2, String daddress3, String dmsg) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update delivery set dusername=?,dtel=?  , daddress1=?,daddress2=?,daddress3= ?, dmsg = ?   where duserid=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, dusername);
			preparedStatement.setString(2, dtel);
			preparedStatement.setString(3, daddress1);
			preparedStatement.setString(4, daddress2);
			preparedStatement.setString(5, daddress3);
			preparedStatement.setString(6, dmsg);
			preparedStatement.setString(7, duserid);
			
			
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
	
	
	
	
	
	
	
	
	
	
}//-------------------------end---------------------------------
