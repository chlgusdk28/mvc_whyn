package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ALoginDao;
import com.jsplec.wp.dao.UloginDao;

public class AdminLoginCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String loginCheck="ok";
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		ALoginDao dao = new ALoginDao();
		int alogin = dao.adminlogincheck(userid, userpw);
		int seq = 0;
		int dateseq = 0;
		System.out.println("here"+alogin);
		if(alogin==1) {
			session.setAttribute("ADMINUSERNO",userid);
			session.setAttribute("seq", seq);
			session.setAttribute("dateseq", dateseq);
			
			request.setAttribute("ADMINLOGIN",loginCheck);
			System.out.println("here123"+alogin);
			
		}else {
			loginCheck="no";
			request.setAttribute("ADMINLOGIN",loginCheck);
			
		}
		
		
	}

}
