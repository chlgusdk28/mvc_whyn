package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.CommentDao;

public class CommentWrite implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		int userno = (int)session.getAttribute("USERNO");
		String username = (String)session.getAttribute("USERNAME");
		
		String comment = request.getParameter("commentWrite");
		int reno = Integer.parseInt(request.getParameter("reno"));
		
		CommentDao dao = new CommentDao();
		dao.insertComment(userno, username, comment,reno);
		
		
		
	}

}
