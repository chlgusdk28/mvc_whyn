package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.CommentDao;

public class ReCommentWrite implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		String username = (String)session.getAttribute("USERNAME");
		int reno = Integer.parseInt(request.getParameter("reno"));
		String pCommentNum = request.getParameter("pCommentNum");
		String recomment = request.getParameter("recomment");
		
		
		
		
		CommentDao dao = new CommentDao();
		dao.reCommentWrite(username,pCommentNum,recomment,reno);
		
		
		
		
	}

}
