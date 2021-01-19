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

public class ACLDao {		
		
		DataSource dataSource;
			
			public ACLDao(){
				
				try {
					Context context = new InitialContext();
					dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
					
					
				}catch (Exception e) {
					e.printStackTrace();
				}
		
		
			}
			
			
			
			
			public ArrayList<ACLDto> counselingManagementList(){ //문의 리스트 띄우기 
				ArrayList<ACLDto> dtos = new ArrayList<ACLDto>();
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				
				
				try {
					connection = dataSource.getConnection();
					String query = "select cno , cusername, cuserid, ctitle , ccontent, cdate from counseling ";
					preparedStatement = connection.prepareStatement(query);
					resultSet = preparedStatement.executeQuery();
					
					
					while (resultSet.next()) {
						int cno =  resultSet.getInt("cno");
						String cusername = resultSet.getString("cusername");
						String cuserid = resultSet.getString("cuserid");
						String ctitle= resultSet.getString("ctitle");
						String ccontent= resultSet.getString("ccontent");
						Timestamp cdate = resultSet.getTimestamp("cdate");
						
						ACLDto dto = new ACLDto(cno, cusername,cuserid, ctitle, ccontent, cdate);
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
			
			
			public ArrayList<ACLDto> counselingSearch(String result1, String result2){ // 문의 검색 
				
				ArrayList<ACLDto> dtos = new ArrayList<ACLDto>();
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				
				
				try {
					connection = dataSource.getConnection();
					String query = "select cno , cusername, cuserid, ctitle,ccontent, cdate from counseling ";
					String query2 = " where "+ result1 + " like '%"+ result2 +"%'"; 
					System.out.println(query+query2);
					preparedStatement = connection.prepareStatement(query+query2);
					resultSet = preparedStatement.executeQuery();
					
					
					while (resultSet.next()) {
						int cno =  resultSet.getInt("cno");
						String cusername = resultSet.getString("cusername");
						String cuserid = resultSet.getString("cuserid");
						String ctitle= resultSet.getString("ctitle");
						String ccontent= resultSet.getString("ccontent");
						Timestamp cdate = resultSet.getTimestamp("cdate");
						
						ACLDto dto = new ACLDto(cno, cusername,cuserid, ctitle, ccontent,cdate);
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
			
			public void counselingDelete(String cno) { //문의 삭제 
				
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				
				
				try {
					connection = dataSource.getConnection();
					String query = "delete  from counseling  where cno = ?";
					
					preparedStatement = connection.prepareStatement(query);
					
					preparedStatement.setInt(1, Integer.parseInt(cno));
					
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
			
			
			public ACLDto counselingContentView(String cno) { // 문의 눌렀을때 보이기
				
				ACLDto dto = null;
				Connection connection = null;
				PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
				ResultSet resultSet = null;
				
				
				try {
					connection = dataSource.getConnection();
					String query = "select * from counseling where cno= ?";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, Integer.parseInt(cno));
					resultSet = preparedStatement.executeQuery();
					
					
					if (resultSet.next()) {
						int cno1 =  resultSet.getInt("cno");
						String cusername = resultSet.getString("cusername");
						String cuserid = resultSet.getString("cuserid");
						String ctitle = resultSet.getString("ctitle");
						String ccontent = resultSet.getString("ccontent");
						Timestamp cdate = resultSet.getTimestamp("cdate");
						String canswer = resultSet.getString("canswer");
						
						dto = new ACLDto(cno1, cusername, cuserid, ctitle, ccontent, cdate, canswer);
						
						
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
			
			
			
			public int counselingViewRowCount() { //문의 행 갯수 구하기
				int rowCount=0;
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				
				
				try {
					connection = dataSource.getConnection();
					String query = "select count(*) from counseling ";
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
			
			public void cviewcount(String cno) { //문의 조회수 +1
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				
				
				try {
					connection = dataSource.getConnection();
					String query = "UPDATE Counseling SET cviewcount = cviewcount + 1 WHERE cno=? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cno);
					
					
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
			public int cviewSelect(String cno) { //문의  조회수 받아오기(출력)
				int cview=0;
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				
				
				try {
					connection = dataSource.getConnection();
					String query = "select cviewcount from Counseling where cno=?";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, cno);
					resultSet = preparedStatement.executeQuery();
					
					
					while (resultSet.next()) {
						cview=resultSet.getInt(1);
			
						
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
				return cview;
			}
			
			
	public ArrayList<ACLDto> newCounseling(){ 
				
				ArrayList<ACLDto> dtos = new ArrayList<ACLDto>();
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				
				
				try {
					connection = dataSource.getConnection();
					String query = "select cno , cusername, cuserid, ctitle,ccontent, cdate , cviewcount, canswer from counseling ";
					String query2 = " where canswer is null "; 
					System.out.println(query+query2);
					preparedStatement = connection.prepareStatement(query+query2);
					resultSet = preparedStatement.executeQuery();
					
					while (resultSet.next()) {
						int cno =  resultSet.getInt("cno");
						String cusername = resultSet.getString("cusername");
						String cuserid = resultSet.getString("cuserid");
						String ctitle= resultSet.getString("ctitle");
						String ccontent= resultSet.getString("ccontent");
						Timestamp cdate = resultSet.getTimestamp("cdate");
						int cviewcount= resultSet.getInt("cviewcount");
						String canswer = resultSet.getString("canswer");
						
						ACLDto dto = new ACLDto(cno, cusername, cuserid, ctitle, ccontent, cdate, cviewcount, canswer);
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
			
	public ACLDto todayContentView(String cno) { // 문의 눌렀을때 보이기
		
		ACLDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from counseling where cno= ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(cno));
			resultSet = preparedStatement.executeQuery();
			
			
			if (resultSet.next()) {
				int cno1 =  resultSet.getInt("cno");
				String cusername = resultSet.getString("cusername");
				String cuserid = resultSet.getString("cuserid");
				String ctitle = resultSet.getString("ctitle");
				String ccontent = resultSet.getString("ccontent");
				Timestamp cdate = resultSet.getTimestamp("cdate");
				String canswer = resultSet.getString("canswer");
				
				dto = new ACLDto(cno1, cusername, cuserid, ctitle, ccontent, cdate, canswer);
				
				
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
	
	
	
	public void counselingAnswer(String canswer,String cno) { //문의 답변작성
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		System.out.println(cno);
		System.out.println(canswer);
		
		try {
			connection = dataSource.getConnection();
			String query = "update counseling set canswer = ? where cno=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, canswer);
			preparedStatement.setInt(2,Integer.parseInt(cno));
			System.out.println(cno);
			System.out.println(canswer);
			
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
	
	
	public String answer(String cno) {
	String ans = null;
	Connection connection = null;
	PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
	ResultSet resultSet = null;
	
	
	try {
		connection = dataSource.getConnection();
		String query = "select canswer from counseling where cno= ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, Integer.parseInt(cno));
		resultSet = preparedStatement.executeQuery();
		
		
		if (resultSet.next()) {
			ans =  resultSet.getString(1);
		
			
			
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
	return ans;
	
	
	}
	
	
}//-----------------------------------------
