package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ACLDao;
import com.jsplec.wp.dto.ACLDto;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

public class ACounselingViewCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		String cno = request.getParameter("cno");
		ACLDao dao = new ACLDao();
		ACLDto dto = dao.counselingContentView(cno);
		ACLDto dto1 = dao.todayContentView(cno);
		request.setAttribute("counselingContentView", dto);
		request.setAttribute("todayContentView", dto1);
		
		dao.cviewcount(cno);
		int cviewCount = dao.cviewSelect(cno);
		request.setAttribute("cviewCount",cviewCount );

		System.out.println(cno);
		
		String ans = dao.answer(cno);
		System.out.println(ans);
		request.setAttribute("answer", ans);
	}

}
