package com.jsplec.wp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.wp.dto.ACLDto;
import com.jsplec.wp.dto.ARLDto;
import com.jsplec.wp.dto.AUserLDto;

public class AUserLDao {
	
	DataSource dataSource;
	
	
	public AUserLDao(){
		
	try {
		Context context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}


}
	
	
	public ArrayList<AUserLDto> userManagementList(){ //유저 리스트 
		ArrayList<AUserLDto> dtos = new ArrayList<AUserLDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select userno , userid, username, usertel ,usersubscribe,userjoindate from userinfo where userno >1 ";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				int userno =  resultSet.getInt("userno");
				String userid = resultSet.getString("userid");
				String username = resultSet.getString("username");
				String usertel= resultSet.getString("usertel");
				int usersubscribe= resultSet.getInt("usersubscribe");
				Timestamp userjoindate = resultSet.getTimestamp("userjoindate");
		
					
					AUserLDto dto = new AUserLDto(userno, userid,username, usertel,usersubscribe,  userjoindate);
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
	
	
	public void userDelete(String userno) { //유저삭제 
		
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "delete  from userinfo  where userno = ?";
				
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setInt(1, Integer.parseInt(userno));
				
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
	public ArrayList<AUserLDto> userSearch(String result1, String result2){ //유저검색 
	
		ArrayList<AUserLDto> dtos = new ArrayList<AUserLDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select userno , userid, username, usertel,usersubscribe ,userjoindate from userinfo where userno >1  ";
			String query2 = " and "+ result1 + " like '%"+ result2 +"%'"; 
			System.out.println(query+query2);
			preparedStatement = connection.prepareStatement(query+query2);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				int userno =  resultSet.getInt("userno");
				String userid = resultSet.getString("userid");
				String username = resultSet.getString("username");
				String usertel= resultSet.getString("usertel");
				int usersubscribe = resultSet.getInt("usersubscribe");
				Timestamp userjoindate = resultSet.getTimestamp("userjoindate");
				
				AUserLDto dto = new AUserLDto(userno, userid,username, usertel,usersubscribe ,userjoindate);
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
	
	public AUserLDto userContentView(String userno) { // 유저 눌렀을때 보이기
		
		AUserLDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from userinfo where userno= ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(userno));
			resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.next()) {
				int userno1 =  resultSet.getInt("userno");
				String username = resultSet.getString("username");
				String userid = resultSet.getString("userid");
				String usertel = resultSet.getString("usertel");
				String useraddress1 = resultSet.getString("useraddress1");
				String useraddress2 = resultSet.getString("useraddress2");
				String useraddress3 = resultSet.getString("useraddress3");
				String usergender = resultSet.getString("usergender");
				int usersubscribe = resultSet.getInt("usersubscribe");
				Timestamp userjoindate = resultSet.getTimestamp("userjoindate");
				Timestamp userbday = resultSet.getTimestamp("userbday");
				String admincomment = resultSet.getString("admincomment");
				
				dto = new AUserLDto(userno1,username,userid,usertel,useraddress1,useraddress2,useraddress3,usergender,usersubscribe,userjoindate, userbday,admincomment);
				
				
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
	
	
	
	public int userViewRowCount() { // 유저 페이지 넘기기
		int rowCount=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from userinfo ";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				rowCount=resultSet.getInt(1);
	
				
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
		return rowCount;
	}
	
	
	
	//유저 정보 수정 
	public void userUpdate(String userno,String userid,String username,String usertel, String useraddress1,String useraddress2, String useraddress3, String admincomment, int usersubscribe) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "update userinfo set userid =?,username=?,usertel=?  , useraddress1=?,useraddress2=?,useraddress3= ? ,admincomment=?, usersubscribe= ?  where userno=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userid);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, usertel);
			preparedStatement.setString(4, useraddress1);
			preparedStatement.setString(5, useraddress2);
			preparedStatement.setString(6, useraddress3);
			preparedStatement.setString(7, admincomment);
			preparedStatement.setInt(8, usersubscribe);
			
			preparedStatement.setInt(9, Integer.parseInt(userno));
			
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
	public ArrayList<AUserLDto> newSubscribeList(){ //  조회수 0인거 고르기 
		
		ArrayList<AUserLDto> dtos = new ArrayList<AUserLDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select  * from userinfo ";
			String query2 = " where userno >1 and uviewcount = 0 and usersubscribe = 1  "; 
			System.out.println(query+query2);
			preparedStatement = connection.prepareStatement(query+query2);
			System.out.println(query+query2);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int userno =  resultSet.getInt("userno");
				String userid = resultSet.getString("userid");
				String username = resultSet.getString("username");
				String usertel= resultSet.getString("usertel");
				int usersubscribe = resultSet.getInt("usersubscribe");
				Timestamp userjoindate = resultSet.getTimestamp("userjoindate");
				
				AUserLDto dto = new AUserLDto(userno, userid, username, usertel, usersubscribe, userjoindate);
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
	public void uviewcount(String userno) { // 조회수 +1
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "UPDATE userinfo SET uviewcount = uviewcount + 1 WHERE userno=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userno);
			
			
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
	public int uviewSelect(String userno) { // 조회수값 가져오기
		int uview=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select uviewcount from userinfo where userno=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userno);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				uview=resultSet.getInt(1);
	
				
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
		return uview;
	}
		public AUserLDto newSubscribeContentView(String userno) { // 유저 눌렀을때 보이기
		
		AUserLDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from userinfo where uviewcount =0 and userno =? and usersubscribe =1 ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(userno));
			
			resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.next()) {
				int userno1 =  resultSet.getInt("userno");
				String username = resultSet.getString("username");
				String userid = resultSet.getString("userid");
				String usertel = resultSet.getString("usertel");
				String useraddress1 = resultSet.getString("useraddress1");
				String useraddress2 = resultSet.getString("useraddress2");
				String useraddress3 = resultSet.getString("useraddress3");
				String usergender = resultSet.getString("usergender");
				int usersubscribe = resultSet.getInt("usersubscribe");
				Timestamp userjoindate = resultSet.getTimestamp("userjoindate");
				Timestamp userbday = resultSet.getTimestamp("userbday");
				String admincomment = resultSet.getString("admincomment");
				
				dto = new AUserLDto(userno1,username,userid,usertel,useraddress1,useraddress2,useraddress3,usergender,usersubscribe,userjoindate, userbday,admincomment);
				
				
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
		
		public AUserLDto subscribeContentView(String userno) { // 유저 눌렀을때 보이기
			
			AUserLDto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
			ResultSet resultSet = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "select * from userinfo where userno= ? and uviewcount =0	";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(userno));
				resultSet = preparedStatement.executeQuery();
				
				
				if (resultSet.next()) {
					int userno1 =  resultSet.getInt("userno");
					String username = resultSet.getString("username");
					String userid = resultSet.getString("userid");
					String usertel = resultSet.getString("usertel");
					String useraddress1 = resultSet.getString("useraddress1");
					String useraddress2 = resultSet.getString("useraddress2");
					String useraddress3 = resultSet.getString("useraddress3");
					String usergender = resultSet.getString("usergender");
					int usersubscribe = resultSet.getInt("usersubscribe");
					Timestamp userjoindate = resultSet.getTimestamp("userjoindate");
					Timestamp userbday = resultSet.getTimestamp("userbday");
					String admincomment = resultSet.getString("admincomment");
					
					dto = new AUserLDto(userno1,username,userid,usertel,useraddress1,useraddress2 ,useraddress3,usergender,usersubscribe,userjoindate, userbday,admincomment);
					
					
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
	
		public AUserLDto todaySubscribeContentView(String userno) { // 리뷰 눌렀을때 보이기
			
			AUserLDto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
			ResultSet resultSet = null;
			SimpleDateFormat format1 = new SimpleDateFormat ("yyyy");	
			SimpleDateFormat format2 = new SimpleDateFormat ("MM");	
			SimpleDateFormat format3 = new SimpleDateFormat ("dd");	
			
			String format_time1 = format1.format (System.currentTimeMillis());      
			String format_time2 = format2.format (System.currentTimeMillis());
			String format_time3 = format3.format (System.currentTimeMillis());
			
			int time2 = Integer.parseInt(format_time2);
			if (time2 < 10) {	
				format_time2 = "0"+format_time2;
			}
			
			String today = format_time1+"-"+format_time2+"-"+format_time3;
			
			try {
				connection = dataSource.getConnection();
				String query = "select * from userinfo where userjoindate = '"+today+"'";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(userno));
				resultSet = preparedStatement.executeQuery();
				
				
				if (resultSet.next()) {
					int userno1 =  resultSet.getInt("userno");
					String username = resultSet.getString("username");
					String userid = resultSet.getString("userid");
					String usertel = resultSet.getString("usertel");
					String useraddress1 = resultSet.getString("useraddress1");
					String useraddress2 = resultSet.getString("useraddress2");
					String useraddress3 = resultSet.getString("useraddress3");
					String usergender = resultSet.getString("usergender");
					int usersubscribe = resultSet.getInt("usersubscribe");
					Timestamp userjoindate = resultSet.getTimestamp("userjoindate");
					Timestamp userbday = resultSet.getTimestamp("userbday");
					String admincomment = resultSet.getString("admincomment");
					
					dto = new AUserLDto(userno1, username, userid, usertel, useraddress1,useraddress2,useraddress3, usergender, usersubscribe, userjoindate,userbday ,admincomment);
					
					
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
		
		
		public void mypageUpdate(int userno,String username,String usertel, String useraddress1,String useraddress2, String useraddress3) {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "update userinfo set username=?,usertel=?  , useraddress1=?,useraddress2=?,useraddress3= ?   where userno=?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, usertel);
				preparedStatement.setString(3, useraddress1);
				preparedStatement.setString(4, useraddress2);
				preparedStatement.setString(5, useraddress3);
				
				preparedStatement.setInt(6, userno);
				
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
		
		
}//---------------------------