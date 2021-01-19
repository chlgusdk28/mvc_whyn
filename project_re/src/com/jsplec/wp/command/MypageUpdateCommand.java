package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AUserLDao;
import com.jsplec.wp.dao.MyPageDao;

public class MypageUpdateCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		

		int userno = (int)session.getAttribute("USERNO");
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String usertel = request.getParameter("usertel");
		String useraddress1 = request.getParameter("useraddress1");
		String useraddress2 = request.getParameter("useraddress2");
		String useraddress3 = request.getParameter("useraddress3");
		String usersubscribe =  request.getParameter("usersubscribe");
		
		
		String dusername = request.getParameter("dusername");
		String dtel = request.getParameter("dtel");
		String daddress1 = request.getParameter("daddress1");
		String daddress2 = request.getParameter("daddress2");
		String daddress3 = request.getParameter("daddress3");
		String dmsg = request.getParameter("dmsg");
		
		
		
		
		
		int usersub = 0;
		if (usersubscribe.equals("구독중")) {
			usersub=1; 
			
		}
		
		
		AUserLDao dao = new AUserLDao();
		dao.mypageUpdate(userno, username, usertel, useraddress1, useraddress2, useraddress3);
		
		
		MyPageDao dao2 = new MyPageDao();
		dao2.deliveryUpdate(userid, dusername, dtel, daddress1, daddress2, daddress3, dmsg);
		
		
		
		
		
	}

}
