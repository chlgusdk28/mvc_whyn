package com.jsplec.wp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.wp.dto.CounselingDto;


public class CounselingDao {
	DataSource dataSource;
	
	
	// 내가쓴 문의 리스트
	public CounselingDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<CounselingDto> counselingList(String userid){
		ArrayList<CounselingDto> dtos = new ArrayList<CounselingDto>();
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;

		
		try {	
			connection = dataSource.getConnection();
			String query = "select * from Counseling where cuserid = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userid);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int cno = resultSet.getInt("cno");
				String cusername = resultSet.getString("cusername");
				String cuserid = resultSet.getString("cuserid");
				String ctitle = resultSet.getString("ctitle");
				String ccontent = resultSet.getString("ccontent");
				String cdate = resultSet.getString("cdate");
				int cviewcount = resultSet.getInt("cviewcount");
				String canswer = resultSet.getString("canswer");
				String canswerdate = resultSet.getString("canswerdate");
				
				CounselingDto dto = new CounselingDto(cno, cusername, cuserid, ctitle, ccontent, cdate, cviewcount, canswer, canswerdate);
				dtos.add(dto);
				
			}
			
		}catch (Exception e) {
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
		return dtos;
	}
	
	public ArrayList<CounselingDto> counselingListSearch(String userid,String result1, String result2){
		ArrayList<CounselingDto> dtos = new ArrayList<CounselingDto>();
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		
		
		try {	
			connection = dataSource.getConnection();
			String query = "select * from Counseling where cuserid = ?";
			String query2 = " and "+ result1 + " like '%"+ result2 +"%'"; 
			System.out.println("-------------------------");
			System.out.println(query+query2);
			preparedStatement = connection.prepareStatement(query+query2);
			preparedStatement.setString(1, userid);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int cno = resultSet.getInt("cno");
				String cusername = resultSet.getString("cusername");
				String cuserid = resultSet.getString("cuserid");
				String ctitle = resultSet.getString("ctitle");
				String ccontent = resultSet.getString("ccontent");
				String cdate = resultSet.getString("cdate");
				int cviewcount = resultSet.getInt("cviewcount");
				String canswer = resultSet.getString("canswer");
				String canswerdate = resultSet.getString("canswerdate");
				
				CounselingDto dto = new CounselingDto(cno, cusername, cuserid, ctitle, ccontent, cdate, cviewcount, canswer, canswerdate);
				dtos.add(dto);
				
			}
			
		}catch (Exception e) {
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
		return dtos;
	}
	//내가 쓴 문의 총 갯수
	
	public int allCount(String userid){ 

		int allcount = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from Counseling where cuserid = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userid);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				allcount = resultSet.getInt(1);
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
		return allcount;
	
	}	
	
	
	
	
	public int answerCount(String userid){ 
		
		int answercount = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from Counseling where cuserid = ? and canswer is not null;";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userid);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				answercount = resultSet.getInt(1);
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
		return answercount;
		
	}	
	
	
	public int counselingListCount(String userid) {
		int count = 0;
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		
		
		try {	
			connection = dataSource.getConnection();
			String query = "select count(*) from Counseling where cuserid = ?";
			
		
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userid);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				count=resultSet.getInt(1);
				
				
			}
			
		}catch (Exception e) {
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
		return count;
	}
	
	
	public void counselingWrite(String cusername,String cuserid,String ctitle,String ccontent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into Counseling (cusername,cuserid,ctitle,ccontent,cdate)";
			String query2 = " values (?,?,?,?,now())";
			preparedStatement = connection.prepareStatement(query+query2);
			preparedStatement.setString(1, cusername);
			preparedStatement.setString(2, cuserid);
			preparedStatement.setString(3, ctitle);
			preparedStatement.setString(4, ccontent);
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
	
	
	
	
	
	
}//--------------------------------------------------------------------
