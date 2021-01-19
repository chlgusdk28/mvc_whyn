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

public class ARLDao {

	DataSource dataSource;
	
	public ARLDao(){
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}


	}
	
	public ArrayList<ARLDto> reviewManagementList(){ // 리뷰 리스트 띄우기
		ArrayList<ARLDto> dtos = new ArrayList<ARLDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select reno , reuserid, retitle, recontent , reinsertdate from review ";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				int reno =  resultSet.getInt("reno");
				String reuserid = resultSet.getString("reuserid");
				String retitle = resultSet.getString("retitle");
				String recontent= resultSet.getString("recontent");
				Timestamp reinsertdate = resultSet.getTimestamp("reinsertdate");
				
				ARLDto dto = new ARLDto(reno, reuserid,retitle, recontent, reinsertdate);
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
	
	
	public ArrayList<ARLDto> reviewSearch(String result1, String result2){ // 리뷰 검색
		
		ArrayList<ARLDto> dtos = new ArrayList<ARLDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select reno , reuserid, retitle, recontent,reinsertdate from review ";
			String query2 = " where "+ result1 + " like '%"+ result2 +"%'"; 
			System.out.println(query+query2);
			preparedStatement = connection.prepareStatement(query+query2);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				int reno =  resultSet.getInt("reno");
				String reuserid = resultSet.getString("reuserid");
				String retitle = resultSet.getString("retitle");
				String recontent= resultSet.getString("recontent");
				Timestamp reinsertdate = resultSet.getTimestamp("reinsertdate");
				
				ARLDto dto = new ARLDto(reno, reuserid,retitle, recontent, reinsertdate);
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
	
	public void reviewDelete(String reno) { //리뷰삭제 
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "delete  from review  where reno = ?";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, Integer.parseInt(reno));
			
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
	
	
	public ARLDto reviewContentView(String reno) { // 리뷰 눌렀을때 보이기
		
		ARLDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from review where reno= ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(reno));
			resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.next()) {
				int reno1 =  resultSet.getInt("reno");
				String reuserid = resultSet.getString("reuserid");
				String retitle = resultSet.getString("retitle");
				String recontent = resultSet.getString("recontent");
				int rescore = resultSet.getInt("rescore");
				Timestamp reinsertdate = resultSet.getTimestamp("reinsertdate");
				System.out.println(rescore);
				dto = new ARLDto(reno1,reuserid,retitle,recontent , rescore,reinsertdate);
				
				
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
	
	public int reviewViewRowCount() { //페이징 갯수 
		int rowCount=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from review ";
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
	
	public void reviewCount(String reno) { //리뷰 조회수 +1
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "UPDATE review SET reviewcount = reviewcount + 1 WHERE reno=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, reno);
			
			
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
	
	
	public int reviewSelect(String reno) { //리뷰  조회수 받아오기(출력)
		int review=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select reviewcount from review where reno=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, reno);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				review=resultSet.getInt(1);
	
				
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
		return review;
	}
	
	public ArrayList<ARLDto> newReview(){ // 메인리뷰 리스트 띄우기
		ArrayList<ARLDto> dtos = new ArrayList<ARLDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select reno , reuserid, retitle, recontent , reinsertdate from review ";
			String query2 = " where reviewcount = 0 "; 
			preparedStatement = connection.prepareStatement(query+query2);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				int reno =  resultSet.getInt("reno");
				String reuserid = resultSet.getString("reuserid");
				String retitle = resultSet.getString("retitle");
				String recontent= resultSet.getString("recontent");
				Timestamp reinsertdate = resultSet.getTimestamp("reinsertdate");
				
				ARLDto dto = new ARLDto(reno, reuserid,retitle, recontent, reinsertdate);
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
	
public ARLDto newReviewContentView(String reno) { // 리뷰 눌렀을때 보이기
		
		ARLDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from review where reviewcount = 0 ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(reno));
			resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.next()) {
				int reno1 =  resultSet.getInt("reno");
				String reuserid = resultSet.getString("reuserid");
				String retitle = resultSet.getString("retitle");
				String recontent = resultSet.getString("recontent");
				int rescore = resultSet.getInt("rescore");
				Timestamp reinsertdate = resultSet.getTimestamp("reinsertdate");
				
				dto = new ARLDto(reno1,reuserid,retitle,recontent , rescore,reinsertdate);
				
				
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
	public ARLDto todayReviewContentView(String reno) { // 리뷰 눌렀을때 보이기
	
	ARLDto dto = null;
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
		String query = "select * from review where reinsertdate = '"+today+"'";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, Integer.parseInt(reno));
		resultSet = preparedStatement.executeQuery();
		
		
		if (resultSet.next()) {
			int reno1 =  resultSet.getInt("reno");
			String reuserid = resultSet.getString("reuserid");
			String retitle = resultSet.getString("retitle");
			String recontent = resultSet.getString("recontent");
			int rescore = resultSet.getInt("rescore");
			Timestamp reinsertdate = resultSet.getTimestamp("reinsertdate");
			
			dto = new ARLDto(reno1,reuserid,retitle,recontent , rescore,reinsertdate);
			
			
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

}//----------------------------------------
