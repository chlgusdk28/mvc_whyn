package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AWLDao;
import com.jsplec.wp.dto.AWLDto;




public class AWineContentCommand implements ACommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String pno = request.getParameter("pno");
		AWLDao dao = new AWLDao();	
		AWLDto dto = dao.wineContentView(pno);
	
		
		request.setAttribute("wineContentView", dto);
		
		

	}
		


}
