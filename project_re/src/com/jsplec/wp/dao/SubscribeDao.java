package com.jsplec.wp.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.sql.DataSource;

import com.jsplec.wp.dto.NoticeDto;
import com.jsplec.wp.dto.SubDto;


public class SubscribeDao {

	static DataSource dataSource;
	
	public SubscribeDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
public void Subscribe_pro(String pno, int userno) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "update subscribe set psitem = ? where suserno = ?";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, pno);
			preparedStatement.setInt(2, userno);
			preparedStatement.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}	
	
	public void Subscribe(String speriod,String sbottle, 
			String senddate,String sq1, String sq2, String sq3, String sq4,String sq5,String sq6,String sq7, 
			String sprice, String startdate, String enddate, int userno) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "insert into subscribe (speriod,sbottle,senddate,sq1,sq2,sq3,sq4,sq5,sq6,sq7,sprice,sinsertdate,startdate,enddate,suserno) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(),?,?,?)";
			//System.out.println(sbottle);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString (1, speriod);
			preparedStatement.setString (2, sbottle);
			preparedStatement.setString (3, senddate);
			preparedStatement.setString (4, sq1);
			preparedStatement.setString (5, sq2);
			preparedStatement.setString (6, sq3);
			preparedStatement.setString (7, sq4);
			preparedStatement.setString (8, sq5);
			preparedStatement.setString (9, sq6);
			preparedStatement.setString (10, sq7 );
			preparedStatement.setString (11, sprice);
			preparedStatement.setString (12, startdate);
			preparedStatement.setString (13, enddate);
			preparedStatement.setInt(14, userno);
			preparedStatement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void Subscribe2(int userno) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String query = "update userinfo set usersubscribe ='1' where userinfo.userno = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userno);
			preparedStatement.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}	
	
	
	public  SubDto list(String userid){
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		SubDto SubDto = null;
		
		try {	
			connection = dataSource.getConnection();
			String query = "select duserid,dno, duserno, dsubno, daddress1, daddress2, daddress3, dusername, dtel from delivery where duserid ='"+userid+"'";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String duserid = resultSet.getString("duserid");
				int dno = resultSet.getInt("dno");
				int duserno = resultSet.getInt("duserno");
				int dsubno = resultSet.getInt("dsubno");
				String daddress1 = resultSet.getString("daddress1");
				String daddress2 = resultSet.getString("daddress2");
				String daddress3 = resultSet.getString("daddress3");
				String dusername = resultSet.getString("dusername");
				String dtel = resultSet.getString("dtel");


				SubDto = new SubDto(duserid,dno, duserno, dsubno, daddress1, daddress2, daddress3, dusername, dtel);
	
			
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
		return SubDto;
	}
	
	public void SubscribeModi(String sitem, String userno) {
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		try {
			connection = dataSource.getConnection();
			String query = "update subscribe set sitem = ? where suserno = ?";
			
			preparedStatement = connection.prepareStatement(query);		
			
			
			preparedStatement.setString(1, sitem);
			preparedStatement.setString(2, userno);
		
			preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			try {
				
				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static ArrayList<SubDto> productItem(int userno){
		ArrayList<SubDto> SubDtos = new ArrayList<SubDto>();
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		
		try {	
			connection = dataSource.getConnection();
			String query = "select p.pno, p.pname, p.pcount, p.pcountry, p.pcolor, p.ptext, p.pcontent, p.pimage from productlist as p, subscribe as s "
							+ "where s.suserno = " +userno+ " and s.sitem = p.psno "
							+ "group by pno;";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int pno = resultSet.getInt("pno");
				String pname = resultSet.getString("pname");
				int pcount = resultSet.getInt("pcount");
				String pcountry = resultSet.getString("pcountry");
				String pcolor = resultSet.getString("pcolor");
				String ptext = resultSet.getString("ptext");
				int pcontent = resultSet.getInt("pcontent");
				String pimage = resultSet.getString("pimage");

				SubDto SubDto = new SubDto(pno, pname, pcount, pcountry, pcolor, ptext, pcontent, pimage);
				SubDtos.add(SubDto);
			
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
		return SubDtos;
	}
	


	
}
