package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AUserLDao;
import com.jsplec.wp.dto.AUserLDto;

public class AUserViewCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		
		String userno = request.getParameter("userno");
		System.out.println(userno);
		
		AUserLDao dao = new AUserLDao();
		dao.uviewcount(userno);
		AUserLDto dto = dao.userContentView(userno);
		//AUserLDto dto1 = dao.newSubscribeContentView(userno);
		//AUserLDto dto2 = dao.todaySubscribeContentView(userno);
		
		int viewCount = dao.uviewSelect(userno);
		
		
		request.setAttribute("viewCount",viewCount );
		//request.setAttribute("newSubscribeContentView",dto1 );

		request.setAttribute("userContentView", dto);
		
	}

}
