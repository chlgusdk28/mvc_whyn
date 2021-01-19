package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ACLDao;
import com.jsplec.wp.dto.ACLDto;

public class ACounselingSearchCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		ACLDao cdao = new ACLDao();
		String result1= (String)request.getParameter("counselingSearchBox");
		String result2= (String) request.getParameter("counselingSearchBar");
		System.out.println(result1+result2);
		ArrayList<ACLDto> dtos = cdao.counselingSearch(result1, result2);
		ACLDto searchdto = new ACLDto(result1, result2);
		request.setAttribute("setCounselingSearch", searchdto);
		request.setAttribute("counselingManagementList", dtos);
		
		
		
	
	}

}
