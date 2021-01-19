package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ARLDao;
import com.jsplec.wp.dto.ARLDto;

public class AReviewSearchCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		ARLDao reviewdao = new ARLDao();
		String result1= (String)request.getParameter("reviewSearchBox");
		String result2= (String) request.getParameter("reviewSearchBar");
		System.out.println(result1+result2);
		ArrayList<ARLDto> dtos = reviewdao.reviewSearch(result1, result2);
		ARLDto searchdto = new ARLDto(result1,result2);
		request.setAttribute("setReviewSearch", searchdto);
		request.setAttribute("reviewManagementList", dtos);
		
	}

}
