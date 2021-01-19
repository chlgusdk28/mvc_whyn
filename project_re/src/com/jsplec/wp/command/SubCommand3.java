package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.SubscribeDao;

public class SubCommand3 implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String pno = (String)request.getParameter("pno");
		int userno = (Integer)session.getAttribute("USERNO");
		SubscribeDao subscribeDao = new SubscribeDao();
		System.out.println(pno+"출력출");
		subscribeDao.Subscribe_pro(pno, userno);
		
	}

}
