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

import com.jsplec.wp.dto.ANLDto;
import com.jsplec.wp.dto.NoticeDto;

import sun.util.calendar.BaseCalendar.Date;

public class NoticeDao {

	DataSource dataSource;
	
	public NoticeDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<NoticeDto> list(){
		ArrayList<NoticeDto> NoticeDtos = new ArrayList<NoticeDto>();
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;

		
		try {	
			connection = dataSource.getConnection();
			String query = "select nno, ntitle, ncontent, ninsertdate, nviewcount from notice ORDER BY nno DESC";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int nno = resultSet.getInt("nno");
				String ntitle = resultSet.getString("ntitle");
				String ncontent = resultSet.getString("ncontent");
				String ninsertdate = resultSet.getString("ninsertdate");
				int nviewcount = resultSet.getInt("nviewcount");
				NoticeDto NoticeDto = new NoticeDto(nno, ntitle, ncontent, ninsertdate, nviewcount);
				NoticeDtos.add(NoticeDto);
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
		return NoticeDtos;
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

	public ArrayList<NoticeDto> noticeSearch(String result1, String result2){ // 공지 검색 
		
		ArrayList<NoticeDto> NoticeDtos = new ArrayList<NoticeDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select nno , ntitle, ncontent, ninsertdate, nviewcount from notice";
			String query2 = " where "+ result1 + " like '%"+ result2 +"%'"; 
			System.out.println(query+query2);
			preparedStatement = connection.prepareStatement(query+query2);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				int nno =  resultSet.getInt("nno");
				String ntitle = resultSet.getString("ntitle");
				String ncontent = resultSet.getString("ncontent");
				String ninsertdate = resultSet.getString("ninsertdate");
				int nviewcount = resultSet.getInt("nviewcount");
				
				NoticeDto NoticeDto = new NoticeDto(nno, ntitle, ncontent, ninsertdate, nviewcount);
				NoticeDtos.add(NoticeDto);
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
		
		return NoticeDtos;	
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
	
	
	public NoticeDto noticeContentView(String nno) { // 공지 눌렀을때 보이기
	
		NoticeDto NoticeDto = null;
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
				String ninsertdate = resultSet.getString("ninsertdate");
				int nviewcount = resultSet.getInt("nviewcount");
				NoticeDto = new NoticeDto(nno1, ntitle,ncontent ,ninsertdate, nviewcount);

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
		return NoticeDto;
	}
	
	public int todayCount(){ // 오늘쓴글 카운트
		
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
		
		//System.out.println(today);
		
		
		int todaycount = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from notice where";
			String query2 =" ninsertdate like '%"+today+"%'";
			preparedStatement = connection.prepareStatement(query+query2);
			
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				todaycount = resultSet.getInt(1);
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
		return todaycount;
	
	}	

	public int allCount(){ // 오늘쓴글 카운트

		int allcount = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from notice";
			preparedStatement = connection.prepareStatement(query);
			
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
	
	
	
	public String beforeNotice(String nno){ // 전글 title 

		String beforenotice = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		try {
			connection = dataSource.getConnection();
			String query = "SELECT ntitle FROM notice WHERE nno < ? ORDER BY nno DESC LIMIT 1";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(nno));
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				beforenotice = resultSet.getString(1);
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
		return beforenotice;
		
	}	
	public String afterNotice(String nno){ // 다음글 title

		String afterNotice = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		try {
			connection = dataSource.getConnection();
			String query = "SELECT ntitle FROM notice WHERE nno > ? ORDER BY nno LIMIT 1";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(nno));
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				afterNotice = resultSet.getString(1);
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
		return afterNotice;
		
	}	
	public String beforeNoticeno(String nno){ // 전글 no 

		String beforenoticeno = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		try {
			connection = dataSource.getConnection();
			String query = "SELECT nno FROM notice WHERE nno < ? ORDER BY nno DESC LIMIT 1";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(nno));
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				beforenoticeno = resultSet.getString(1);
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
		return beforenoticeno;
		
	}	
	public String afterNoticeno(String nno){ // 다음글 nno

		String afterNoticeno = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		try {
			connection = dataSource.getConnection();
			String query = "SELECT nno FROM notice WHERE nno > ? ORDER BY nno LIMIT 1";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(nno));
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				afterNoticeno = resultSet.getString(1);
				
				
				
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
		return afterNoticeno;
		
	}			
			
}
