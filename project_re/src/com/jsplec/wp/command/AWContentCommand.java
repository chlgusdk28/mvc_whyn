package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AWLDao;
import com.jsplec.wp.dto.AWLDto;




public class AWContentCommand implements ACommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String pno = request.getParameter("pno");
		AWLDao dao = new AWLDao();	
		AWLDto dto = dao.wineContentView(pno);
	
		
		request.setAttribute("wineContent_View", dto);
		
		session.setAttribute("PNO", dto.getPno());
		session.setAttribute("PNAME", dto.getPname());
		session.setAttribute("PCOUNT", dto.getPcount());
		session.setAttribute("PCOUNTRY", dto.getPcountry());
		session.setAttribute("PCOLOR", dto.getPcolor());
		session.setAttribute("PTEXT", dto.getPtext());
		session.setAttribute("PCONTENT", dto.getPcontent());
		session.setAttribute("PIMAGE", dto.getPimage());
		request.setAttribute("wineContent_View", dto);

	}
		


}
