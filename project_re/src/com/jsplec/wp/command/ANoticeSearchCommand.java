package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ANLDao;
import com.jsplec.wp.dto.ANLDto;

public class ANoticeSearchCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		ANLDao ndao = new ANLDao();
		String result1= (String)request.getParameter("nSearchBox");
		String result2= (String) request.getParameter("nSearchBar");
		System.out.println(result1+result2);
		
		ArrayList<ANLDto> dtos = ndao.noticeSearch(result1, result2);
		
		ANLDto searchdto = new ANLDto(result1, result2);
		
		request.setAttribute("setNoticeSearch", searchdto);
		request.setAttribute("noticeManagementList", dtos);
	}

}
