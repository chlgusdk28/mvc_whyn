package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AUserLDao;
import com.jsplec.wp.dto.AUserLDto;

public class AUserSearchCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		AUserLDao userdao = new AUserLDao();
		String result1= (String)request.getParameter("userSelectBox");
		String result2= (String) request.getParameter("userSearchBar");
		ArrayList<AUserLDto> dtos = userdao.userSearch(result1,result2);
		AUserLDto dto = new AUserLDto(result1,result2);
		request.setAttribute("setSearch", dto);
		request.setAttribute("userManagementList", dtos);
		
	}

}
