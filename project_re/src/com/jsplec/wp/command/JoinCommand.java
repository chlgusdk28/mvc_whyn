package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.jsplec.wp.dao.AUserLDao;
import com.jsplec.wp.dao.UloginDao;

public class JoinCommand implements ACommand {



	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String usergender = request.getParameter("usergender");
		String userage = request.getParameter("userage");
		String usertel = request.getParameter("usertel");
		String useraddress = request.getParameter("useraddress");
		String userbday = request.getParameter("userbday");
		
		
		UloginDao dao = new UloginDao();
		//dao.join( userid,userpw,username,usergender,userage,usertel,useraddress,userbday);
		

	}

}
