package com.jsplec.wp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.wp.dto.ACLDto;
import com.jsplec.wp.dto.ANLDto;

public class ANLDao {
	
	DataSource dataSource;
	
		public ANLDao(){
			
			try {
				Context context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
	
	
		}
		public ArrayList<ANLDto> noticeManagementList(){ //문의 리스트 띄우기 
			ArrayList<ANLDto> dtos = new ArrayList<ANLDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "select nno , ntitle, ncontent, ninsertdate, nviewcount from notice ";
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				
				
				while (resultSet.next()) {
					int nno =  resultSet.getInt("nno");
					String ntitle = resultSet.getString("ntitle");
					String ncontent = resultSet.getString("ncontent");
					Timestamp ninsertdate = resultSet.getTimestamp("ninsertdate");
					int nviewcount = resultSet.getInt("nviewcount");
					
					ANLDto dto = new ANLDto(nno,ntitle,ncontent,ninsertdate,nviewcount);
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
		
		public void noticeDelete(String nno) { //공지 삭제 
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "delete  from notice  where nno = ?";
				
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setInt(1, Integer.parseInt(nno));
				
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
		
		public ArrayList<ANLDto> noticeSearch(String result1, String result2){ // 공지 검색 
			
			ArrayList<ANLDto> dtos = new ArrayList<ANLDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "select nno , ntitle,ncontent, ninsertdate from notice ";
				String query2 = " where "+ result1 + " like '%"+ result2 +"%'"; 
				System.out.println(query+query2);
				preparedStatement = connection.prepareStatement(query+query2);
				resultSet = preparedStatement.executeQuery();
				
				
				while (resultSet.next()) {
					int nno =  resultSet.getInt("nno");
					String ntitle= resultSet.getString("ntitle");
					String ncontent= resultSet.getString("ncontent");
					Timestamp ninsertdate = resultSet.getTimestamp("ninsertdate");
					
					ANLDto dto = new ANLDto(nno, ntitle, ncontent , ninsertdate);
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
		
		
		public ANLDto noticeContentView(String nno) { // 공지 눌렀을때 보이기
			
			ANLDto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
			ResultSet resultSet = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "select * from notice where nno= ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(nno));
				resultSet = preparedStatement.executeQuery();
				
				
				if (resultSet.next()) {
					int nno1 =  resultSet.getInt("nno");
					String ntitle = resultSet.getString("ntitle");
					String ncontent = resultSet.getString("ncontent");
					Timestamp ninsertdate = resultSet.getTimestamp("ninsertdate");
					
					dto = new ANLDto(nno1, ntitle,ncontent ,ninsertdate);
					
					
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
		
		
		
		public void noticeWrite(String ntitle,String ncontent) { //공지 작성
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "insert into notice (ntitle,ncontent,ninsertdate) values (?,?,now()) ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, ntitle);
				preparedStatement.setString(2, ncontent); 
				
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
		public int noticeViewRowCount() { // 페이징 갯수 세어주기 
			int rowCount=0;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "select count(*) from notice ";
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
		
		public void nviewcount(String nno) { // 조회수 +1
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "UPDATE notice SET nviewcount = nviewcount + 1 WHERE nno=? ";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, nno);
				
				
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
		public int nviewSelect(String nno) { // 조회수값 가져오기
			int nview=0;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "select nviewcount from notice where nno=?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, nno);
				resultSet = preparedStatement.executeQuery();
				
				
				while (resultSet.next()) {
					nview=resultSet.getInt(1);
		
					
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
			return nview;
		}
		
		public void noticeUpdate(String nno,String ntitle,String ncontent) { //공지 수정
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "update notice set ntitle =?, ncontent =? where nno=?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1,ntitle);
				preparedStatement.setString(2, ncontent);
				preparedStatement.setInt(3, Integer.parseInt(nno));
				
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
		

		
		
		
}//------------------
