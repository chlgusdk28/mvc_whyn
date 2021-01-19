package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.jsplec.wp.dao.UloginDao;
import com.jsplec.wp.dto.LoginDto;

public class LoginCommand implements ACommand {



	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String loginCheck="ok";
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		UloginDao dao = new UloginDao();
		
		System.out.println("here"+dao.logincheck(userid, userpw));
		if(dao.logincheck(userid,userpw)==1) {
	
			LoginDto dto = dao.login(userid, userpw);
			session.setAttribute("USERNO", dto.getUserno());
			session.setAttribute("USERID", dto.getUserid());
			session.setAttribute("USERNAME", dto.getUsername());
			request.setAttribute("LOGIN",loginCheck);
		}else {
			loginCheck="no";
			request.setAttribute("LOGIN",loginCheck);
			
		}
		
		
	}

}
