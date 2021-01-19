package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.FindUserIdPwDao;

public class FindUserIdCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String usertel = request.getParameter("usertel");
		String userbday = request.getParameter("userbday");
		
		FindUserIdPwDao dao = new FindUserIdPwDao();
		
		String userid = dao.findUserId(usertel, userbday);
		
		request.setAttribute("findUserId", userid);
		
		
		
		
		
		
	}

}
