package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ANLDao;

public class ANoticeWriteCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String ntitle = request.getParameter("ntitle");
		String ncontent = request.getParameter("ncontent");
		
		ANLDao dao = new ANLDao();
		dao.noticeWrite(ntitle, ncontent);
	}

}
