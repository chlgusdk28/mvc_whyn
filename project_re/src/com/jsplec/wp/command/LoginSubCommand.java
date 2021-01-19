package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.LoginSubDao;
import com.jsplec.wp.dao.NoticeDao;
import com.sun.corba.se.spi.activation.Repository;

public class LoginSubCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session){

		//String id = (String)session.getAttribute("USERID");
			int userno = (Integer)session.getAttribute("USERNO");

			LoginSubDao LoginSubDao = new LoginSubDao();
			int subjud = LoginSubDao.subjud(userno);
			session.setAttribute("subjud", subjud);			


	}


};