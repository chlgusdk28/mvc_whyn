package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ANLDao;
import com.jsplec.wp.dto.ANLDto;

public class ANoticeViewCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
		
		
		
		String nno = request.getParameter("nno");
		
		ANLDao dao = new ANLDao();
		
		dao.nviewcount(nno);
		ANLDto dto = dao.noticeContentView(nno);
		int viewCount = dao.nviewSelect(nno);
		
		
		request.setAttribute("viewCount",viewCount );
		
		request.setAttribute("noticeContentView", dto);
	
		
		System.out.println(nno);
	}

}
