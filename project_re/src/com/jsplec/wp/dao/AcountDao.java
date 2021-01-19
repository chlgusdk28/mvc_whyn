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

public class AcountDao {
	DataSource dataSource;
	public AcountDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int sCount() {
		int sCount=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from userinfo where uviewcount =0 and usersubscribe =1 ";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
			sCount=resultSet.getInt(1);
	
				
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
		
		return sCount;
	}
	
	public int cCount() {
		int cCount=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from Counseling where canswer is null";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				cCount=resultSet.getInt(1);
				
				
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
		
		return cCount;
	}
	
	
	public int reCount() { //리뷰 조회수 
		int reCount=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from review where reviewcount = 0";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			
			
			
			while (resultSet.next()) {
				reCount=resultSet.getInt(1);
				
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
		
		return reCount;
	}
	
	public int sTodayCount() { //오늘의 구독자 수 
		int sCount=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
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
		
		System.out.println(today);
		
		System.out.println("RI");
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from userinfo where usersubscribe =1 and userjoindate = '"+today+"' ";
			preparedStatement = connection.prepareStatement(query);
			System.out.println(query);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				sCount=resultSet.getInt(1);

				
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
		
		return sCount;
	}
	
	
	
	
	
	public int cTodayCount() { //오늘의 문의 조회수 
		int cCount=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
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
		
			String query = "select count(*) from counseling where cdate ='" +today+"'";
			System.out.println(query);
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				cCount=resultSet.getInt(1);
	
				
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
		System.out.println("hh" + cCount);
		return cCount;
	}
	
	
	public int simCount() { // 간편상담 조회수 
		int reCount=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from simplecon where sviewcount = 0";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			
			
			
			while (resultSet.next()) {
				reCount=resultSet.getInt(1);
				
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
		
		return reCount;
	}
	
	public ArrayList<ACLDto> counselingTodayList(){ //문의 리스트 띄우기 
		ArrayList<ACLDto> dtos = new ArrayList<ACLDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
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
			String query = "select cno , cusername, cuserid, ctitle , ccontent, cdate from counseling  where cdate ='"+today +"'";
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
	public ArrayList<AUserLDto> userTodayList(){ //구독자 리스트 띄우기 
		ArrayList<AUserLDto> dtos = new ArrayList<AUserLDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
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
			String query = "select * from userinfo where userjoindate ='"+today +"'";
			preparedStatement = connection.prepareStatement(query);
			System.out.println(query);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				int userno = resultSet.getInt("userno");
				String username = resultSet.getString("username");
				String userid = resultSet.getString("userid");
				String usertel = resultSet.getString("usertel");
				int usersubscribe = resultSet.getInt("usersubscribe");
				Timestamp userjoindate = resultSet.getTimestamp("userjoindate");
				
				
				
				AUserLDto dto = new AUserLDto(userno,username, userid, usertel, usersubscribe, userjoindate);
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
	
	
	public int reviewTodayCount() { //오늘의 리뷰 
		int sCount=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
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
		
		System.out.println(today);
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from review where reinsertdate = '"+today+"' ";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
			sCount=resultSet.getInt(1);
	
				
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
		
		return sCount;
	}
	
	public ArrayList<ARLDto> reviewTodayList(){ //문의 리스트 띄우기 
		ArrayList<ARLDto> dtos = new ArrayList<ARLDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
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
			String query = "select * from review  where reinsertdate ='"+today +"'";
			preparedStatement = connection.prepareStatement(query);
			System.out.println(query);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				int reno =  resultSet.getInt("reno");
				String reuserid = resultSet.getString("reuserid");
				String retitle= resultSet.getString("retitle");
				String recontent= resultSet.getString("recontent");
				Timestamp reinsertdate = resultSet.getTimestamp("reinsertdate");
				
				ARLDto dto = new ARLDto(reno, reuserid, retitle, recontent, reinsertdate);
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
	
	
	public int reTodayCount() { //오늘의 문의 조회수 
		int cCount=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
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
		
			String query = "select count(*) from review where reinsertdate ='" +today+"'";
			System.out.println(query);
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				cCount=resultSet.getInt(1);
	
				
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
		return cCount;
	}
	
}//----------------------------
