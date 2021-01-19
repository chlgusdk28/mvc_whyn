package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AUserLDao;

public class AUserUpdateCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
		
		String userno = request.getParameter("userno");
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String usertel = request.getParameter("usertel");
		String useraddress1 = request.getParameter("useraddress1");
		String useraddress2 = request.getParameter("useraddress2");
		String useraddress3 = request.getParameter("useraddress3");
		String admincomment = request.getParameter("admincomment");
		String usersubscribe =  request.getParameter("usersubscribe");
		
		
		int usersub = 0;
		if (usersubscribe.equals("구독중")) {
			usersub=1; 
			
		}
		

		
		AUserLDao dao = new AUserLDao();
		dao.userUpdate(userno, userid, username,usertel, useraddress1, useraddress2, useraddress3, admincomment ,usersub);
	
	}
	
	
	

}
