package com.jsplec.wp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.wp.dto.ARLDto;
import com.jsplec.wp.dto.ASCDto;

public class ASCDao {
	
	DataSource dataSource;
	
	
	
	public ASCDao(){
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}


	}
	
	public ArrayList<ASCDto> simpleConList(){ //문의 리스트 띄우기 
		ArrayList<ASCDto> dtos = new ArrayList<ASCDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select *  from simplecon ";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				int scno =  resultSet.getInt("scno");
				String sctype = resultSet.getString("sctype");
				String scuserinfo = resultSet.getString("scuserinfo");
				Timestamp sdate = resultSet.getTimestamp("sdate");
				
				ASCDto dto = new ASCDto(scno, sctype,scuserinfo, sdate);
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
	
	public ASCDto simpleContentView(String scno) { //간편상담문의 눌렀을때 보이기
			
			ASCDto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
			ResultSet resultSet = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "select * from simplecon where scno =? ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(scno));
				resultSet = preparedStatement.executeQuery();
				
				
				if (resultSet.next()) {
					int scno1 =  resultSet.getInt("scno");
					String sctype = resultSet.getString("sctype");
					String scuserinfo = resultSet.getString("scuserinfo");
					Timestamp sdate = resultSet.getTimestamp("sdate");
					
					dto = new ASCDto(scno1,sctype,scuserinfo,sdate);
					
					
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

	public void scviewcount(String scno) { // 조회수 +1
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "UPDATE simplecon SET sviewcount = sviewcount + 1 WHERE scno=? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, scno);
			
			
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
	public int sviewSelect(String scno) { // 조회수값 가져오기
		int scview=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select sviewcount from simplecon where nno=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, scno);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				scview=resultSet.getInt(1);
	
				
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
		return scview;
	}
	
	
	public ArrayList<ASCDto> newSimpleList(){ // 메인리뷰 리스트 띄우기
		ArrayList<ASCDto> dtos = new ArrayList<ASCDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select scno , sctype,scuserinfo,sdate from simplecon ";
			String query2 = " where sviewcount = 0 "; 
			preparedStatement = connection.prepareStatement(query+query2);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				int scno =  resultSet.getInt("scno");
				String sctype = resultSet.getString("sctype");
				String scuserinfo = resultSet.getString("scuserinfo");
				Timestamp sdate = resultSet.getTimestamp("sdate");
				
				ASCDto dto = new ASCDto(scno, sctype,scuserinfo, sdate);
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
	
	
	public void simpleDelete(String scno) { //문의 삭제 
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "delete  from simplecon  where scno = ?";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, Integer.parseInt(scno));
			
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
	
}//----------------------------
