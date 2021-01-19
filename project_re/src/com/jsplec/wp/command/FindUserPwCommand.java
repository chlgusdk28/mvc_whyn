package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.FindUserIdPwDao;

public class FindUserPwCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String userid = request.getParameter("userid");
		String usertel = request.getParameter("usertel");
		FindUserIdPwDao dao = new FindUserIdPwDao();
		
		String userpw = dao.findUserPw(userid, usertel);
		
		request.setAttribute("findUserPw", userpw);
	}

}
