package com.jsplec.wp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.wp.dto.AUserLDto;
import com.jsplec.wp.dto.DeliveryDto;

public class DeliveryDao {


	DataSource dataSource;
	
	
	public DeliveryDao(){
		
	try {
		Context context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}


}
	
	
	
	
	//매달 5일
	public ArrayList<DeliveryDto> fivedate(){ 
		ArrayList<DeliveryDto> dtos = new ArrayList<DeliveryDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select speriod,sbottle , startdate, enddate, sprice,daddress1,daddress2,daddress3,dusername,duserid,dtel from subscribe, delivery where dsubno=ssubno and senddate='매달5일' ";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println(query);
			
			while (resultSet.next()) {
				String speriod =  resultSet.getString("speriod");
				String sbottle = resultSet.getString("sbottle");
				String startdate = resultSet.getString("startdate");
				String enddate = resultSet.getString("enddate");
				String sprice = resultSet.getString("sprice");
				String daddress1 = resultSet.getString("daddress1");
				String daddress2 = resultSet.getString("daddress2");
				String daddress3 = resultSet.getString("daddress3");
				String dusername = resultSet.getString("dusername");
				String duserid = resultSet.getString("duserid");
				String dtel = resultSet.getString("dtel");
				
					
				
				
				
					DeliveryDto dto = new DeliveryDto(dtel, daddress1, daddress2, daddress3, dusername, duserid, speriod, sbottle,  startdate, enddate, sprice);
				dtos.add(dto);
			};
			
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
	
	
	
	
	
	
	//매달 10일
	public ArrayList<DeliveryDto> tendate(){ 
		ArrayList<DeliveryDto> dtos = new ArrayList<DeliveryDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select speriod,sbottle , startdate, enddate, sprice,daddress1,daddress2,daddress3,dusername,duserid,dtel from subscribe, delivery where dsubno=ssubno and senddate='매달10일' ";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println(query);
			
			while (resultSet.next()) {
				String speriod =  resultSet.getString("speriod");
				String sbottle = resultSet.getString("sbottle");
				String startdate = resultSet.getString("startdate");
				String enddate = resultSet.getString("enddate");
				String sprice = resultSet.getString("sprice");
				String daddress1 = resultSet.getString("daddress1");
				String daddress2 = resultSet.getString("daddress2");
				String daddress3 = resultSet.getString("daddress3");
				String dusername = resultSet.getString("dusername");
				String duserid = resultSet.getString("duserid");
				String dtel = resultSet.getString("dtel");
				
				
				
				
				
				DeliveryDto dto = new DeliveryDto(dtel, daddress1, daddress2, daddress3, dusername, duserid, speriod, sbottle,  startdate, enddate, sprice);
				dtos.add(dto);
			};
			
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
	
	
	
	
	
	
	//매달 15일 
	public ArrayList<DeliveryDto> fifteen(){ 
		ArrayList<DeliveryDto> dtos = new ArrayList<DeliveryDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select speriod,sbottle , startdate, enddate, sprice,daddress1,daddress2,daddress3,dusername,duserid,dtel from subscribe, delivery where dsubno=ssubno and senddate='매달15일' ";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println(query);
			
			while (resultSet.next()) {
				String speriod =  resultSet.getString("speriod");
				String sbottle = resultSet.getString("sbottle");
				String startdate = resultSet.getString("startdate");
				String enddate = resultSet.getString("enddate");
				String sprice = resultSet.getString("sprice");
				String daddress1 = resultSet.getString("daddress1");
				String daddress2 = resultSet.getString("daddress2");
				String daddress3 = resultSet.getString("daddress3");
				String dusername = resultSet.getString("dusername");
				String duserid = resultSet.getString("duserid");
				String dtel = resultSet.getString("dtel");
				
				
				
				
				
				DeliveryDto dto = new DeliveryDto(dtel, daddress1, daddress2, daddress3, dusername, duserid, speriod, sbottle,  startdate, enddate, sprice);
				dtos.add(dto);
			};
			
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
	
	
	
	
	//매달5일 리스트 클릭시 뷰
	public DeliveryDto fiveContentView(String duserid) { 
		
			DeliveryDto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null; //검색하는거 pre이거있어야됨
			ResultSet resultSet = null;
			
			
			try {
				connection = dataSource.getConnection();
				String query = "select speriod,sbottle , startdate, enddate, sprice,daddress1,daddress2,daddress3,dusername,duserid,dtel ";
				String query1 = "from subscribe, delivery where dsubno=ssubno and duserid = ? ";
				
				
				
				preparedStatement = connection.prepareStatement(query+query1);
				preparedStatement.setString(1, duserid);
				resultSet = preparedStatement.executeQuery();
				
				
				if (resultSet.next()) {
					String speriod =  resultSet.getString("speriod");
					String sbottle = resultSet.getString("sbottle");
					String startdate = resultSet.getString("startdate");
					String enddate = resultSet.getString("enddate");
					String sprice = resultSet.getString("sprice");
					String daddress1 = resultSet.getString("daddress1");
					String daddress2 = resultSet.getString("daddress2");
					String daddress3 = resultSet.getString("daddress3");
					String dusername = resultSet.getString("dusername");
					String duserid1 = resultSet.getString("duserid");
					String dtel = resultSet.getString("dtel");
					
					
					
					
					
					dto = new DeliveryDto(dtel, daddress1, daddress2, daddress3, dusername, duserid1, speriod, sbottle,  startdate, enddate, sprice);
				
					
					
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
	
	
	
	
	
	
	
	
	
	
	
	
	
}//------------------------------------------
