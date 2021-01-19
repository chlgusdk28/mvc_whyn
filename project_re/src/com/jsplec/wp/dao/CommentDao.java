package com.jsplec.wp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.wp.dto.CommentDto;
import com.jsplec.wp.dto.ReCommentDto;


public class CommentDao {
	DataSource dataSource;
	
	public CommentDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<CommentDto> commentListView(int reno){ 
		ArrayList<CommentDto> dtos = new ArrayList<CommentDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select seq,userid,content from commentq";
			String query2 = " where postno=? order by seq desc";
			preparedStatement = connection.prepareStatement(query+query2);
			preparedStatement.setInt(1, reno);
			resultSet = preparedStatement.executeQuery();
			
			int i =1;
			while (resultSet.next()) {
				int seq = resultSet.getInt(1);
				String userid = resultSet.getString(2);
				String content = resultSet.getString(3);		
				CommentDto dto = new CommentDto(seq,userid,content);
				dtos.add(dto);
				System.out.println(i);
				i++;
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
	
	
	public ArrayList<ReCommentDto> reCommentListView(int ppseq, int reno){ 
		ArrayList<ReCommentDto> redtos = new ArrayList<ReCommentDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select seq,pseq,userid,content from recomment";
			String query2 = " where pseq = ? and postno = ? order by seq desc";
			preparedStatement = connection.prepareStatement(query+query2);
			preparedStatement.setInt(1, ppseq);
			preparedStatement.setInt(2, reno);
			resultSet = preparedStatement.executeQuery();
			

			while (resultSet.next()) {
				int seq = resultSet.getInt(1);
				int pseq = resultSet.getInt(2);
				String userid = resultSet.getString(3);
				String content = resultSet.getString(4);		
				ReCommentDto redto = new ReCommentDto(seq,pseq,userid,content);
				redtos.add(redto);

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
		return redtos;
	}
	
	
	public void insertComment(int userno,String userid,String comment,int postno) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into commentq set userid=?,content=?,postno=?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, userid);
			preparedStatement.setString(2, comment);
			preparedStatement.setInt(3, postno);
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
	
	public void reCommentWrite(String userid,String pCommentNum,String recomment,int reno) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into recomment set pseq=?,userid=?,content=? ,postno = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, pCommentNum);
			preparedStatement.setString(2, userid);
			preparedStatement.setString(3, recomment);
			preparedStatement.setInt(4, reno);
			
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
	
	public int commentRow() {
		int row=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from commentq";
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			;
			while (resultSet.next()) {
				row=resultSet.getInt(1);
				
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
		return row;
		
	}
	
	public int recommentRow() {
		int row=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from recomment";
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			

			while (resultSet.next()) {
				 row = resultSet.getInt(1);
				

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
		return row;
	}
	



	public void CommentDelete(int seq) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "delete from commentq where seq = ?";
			preparedStatement = connection.prepareStatement(query);
			
			
			preparedStatement.setInt(1, seq);
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


	public void reCommentDelete(int seq) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "delete from recomment where seq = ?";
			preparedStatement = connection.prepareStatement(query);
			
			
			preparedStatement.setInt(1, seq);
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
	
	
	
	
	
	
	
	
}
