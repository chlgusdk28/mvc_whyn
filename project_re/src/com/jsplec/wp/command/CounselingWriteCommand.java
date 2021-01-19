package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.CounselingDao;

public class CounselingWriteCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String cusername = (String)session.getAttribute("USERNAME");
		String cuserid = (String)session.getAttribute("USERID");
		String ctitle = request.getParameter("ctitle");
		String ccontent = request.getParameter("ccontent");
		
		CounselingDao dao = new CounselingDao();
		dao.counselingWrite(cusername, cuserid, ctitle, ccontent);
	
		

	}

}
