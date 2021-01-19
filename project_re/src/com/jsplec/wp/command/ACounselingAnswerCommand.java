package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ACLDao;
import com.jsplec.wp.dao.ANLDao;

public class ACounselingAnswerCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String canswer = request.getParameter("canswer");
		String cno = request.getParameter("cno");
		System.out.println(canswer+"1");
		System.out.println(cno+"1");
		
		
		
		ACLDao dao = new ACLDao();
		dao.counselingAnswer(canswer,cno);
		
		
	}

}
