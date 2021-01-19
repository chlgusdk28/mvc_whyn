package com.jsplec.wp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jsplec.wp.dto.NoticeDto;
import com.jsplec.wp.dto.frontReviewListDto;

public class frontReviewListDao {
	
DataSource dataSource;
	
	public frontReviewListDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<frontReviewListDto> list(){
		ArrayList<frontReviewListDto> frontReviewListDtos = new ArrayList<frontReviewListDto>();
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;	
		try {	
			connection = dataSource.getConnection();
			String query = "select reno, reuserid, retitle, recontent, rescore, reinsertdate, reimage, rq1, rq2, rq3, reviewcount from review";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int reno = resultSet.getInt("reno");
				String reuserid = resultSet.getString("reuserid");
				String retitle = resultSet.getString("retitle");
				String recontent = resultSet.getString("recontent");
				int rescore = resultSet.getInt("rescore");
				String reinsertdate = resultSet.getString("reinsertdate");
				String reimage = resultSet.getString("reimage");
				String rq1 = resultSet.getString("rq1");
				String rq2 = resultSet.getString("rq2");
				String rq3 = resultSet.getString("rq3");			
				int reviewcount = resultSet.getInt("reviewcount");
				frontReviewListDto frontReviewListDto = new frontReviewListDto(reno, reuserid, retitle, recontent, rescore, reinsertdate, reimage, rq1, rq2, rq3, reviewcount);
				frontReviewListDtos.add(frontReviewListDto);
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
		return frontReviewListDtos;
	}

}
