package com.jsplec.wp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.wp.dto.AWLDto;

public class AWLDao {
	
	
	DataSource dataSource;
	
	public AWLDao(){
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}


	}//--

	public ArrayList<AWLDto> wineListShow(){ //와인 리스트 보여주기 (띄우기)
		ArrayList<AWLDto> dtos = new ArrayList<AWLDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select pno, pimage, pname, pcountry, pcolor, ptext from productlist";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int pno = resultSet.getInt("pno");
				String pimage = resultSet.getString("pimage");
				String pname = resultSet.getString("pname");
				String pcountry = resultSet.getString("pcountry");
				String pcolor = resultSet.getString("pcolor");
				String ptext = resultSet.getString("ptext");
			
				
				AWLDto dto = new AWLDto(pno, pimage, pname, pcountry, pcolor, ptext);
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
	
	public void wineDelete(String pno) { //와인 삭제 
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "delete  from productlist  where pno = ?";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, Integer.parseInt(pno));
			
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
	
	public ArrayList<AWLDto> wineSearch(String result1, String result2){ // 와인 검색 
		
		ArrayList<AWLDto> dtos = new ArrayList<AWLDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select pno , pname,pcountry,pcolor, ptext from productlist ";
			String query2 = " where "+ result1 + " like '%"+ result2 +"%'"; 
			System.out.println(query+query2);
			preparedStatement = connection.prepareStatement(query+query2);
			resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {
				int pno =  resultSet.getInt("pno");
				String pname = resultSet.getString("pname");
				String pcountry = resultSet.getString("pcountry");
				String pcolor= resultSet.getString("pcolor");
				String ptext= resultSet.getString("ptext");
				
				AWLDto dto = new AWLDto(pno, pname,pcountry, pcolor, ptext);
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
	
	
	public int wineViewRowCount() { //와인 페이지 넘기기
		int rowCount=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select count(*) from productlist ";
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
	
	

public int Upload(String pname, String pcount, String pcountry, String pcolor, String ptext, String pcontent, String pimage, String prealimage) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//--->
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into productlist (pname, pcount, pcountry, pcolor, ptext, pcontent, pimage, prealimage) values(?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pname);
			preparedStatement.setString(2, pcount);
			preparedStatement.setString(3, pcountry);
			preparedStatement.setString(4, pcolor);
			preparedStatement.setString(5, ptext);
			preparedStatement.setString(6, pcontent);
			preparedStatement.setString(7, pimage);
			preparedStatement.setString(8, prealimage);

			return preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			
		}
	return -1;
}
	
public AWLDto wineContentView(String strPno) {
	AWLDto dto = null;
	Connection connection = null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet = null;
	
	try {
		connection = dataSource.getConnection();
		String query = "select * from productlist where pno = ?";
		
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, Integer.parseInt(strPno));
		resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			int pno = resultSet.getInt("pno");
			String pname = resultSet.getString("pname");
			int pcount = resultSet.getInt("pcount");
			String pcountry = resultSet.getString("pcountry");
			String pcolor = resultSet.getString("pcolor");
			String ptext = resultSet.getString("ptext");
			int pcontent = resultSet.getInt("pcontent");
			String pimage = resultSet.getString("pimage");
			
			
			dto = new AWLDto(pno, pname, pcount, pcountry, pcolor, ptext, pcontent, pimage);
			
			
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
	return dto;
}

public int modify(int pno, String pname, int pcount, String pcountry, String pcolor, String ptext, int pcontent, String pimage, String prealimage) {
	Connection connection = null;
	PreparedStatement preparedStatement=null;
	try {
		connection = dataSource.getConnection();
		String query = "update productlist set pname = ?, pcount = ?, pcountry = ?, pcolor = ?, ptext = ?, pcontent = ?, pimage = ?, prealimage = ? where pno = ?";
		
		preparedStatement = connection.prepareStatement(query);		
		
		preparedStatement.setString(1, pname);
		preparedStatement.setInt(2, pcount);
		preparedStatement.setString(3, pcountry);
		preparedStatement.setString(4, pcolor);
		preparedStatement.setString(5, ptext);
		preparedStatement.setInt(6, pcontent);
		preparedStatement.setString(7, pimage);
		preparedStatement.setString(8, prealimage);
		preparedStatement.setInt(9, pno);
	
		preparedStatement.executeUpdate();
		
	}catch (Exception e) {
		e.printStackTrace();
		return 0;
	}finally {
		try {
			
			if(preparedStatement!=null) preparedStatement.close();
			if(connection!=null) connection.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	return 1;
}
}//----------------------------------
