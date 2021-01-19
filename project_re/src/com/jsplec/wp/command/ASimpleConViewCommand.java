package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ASCDao;
import com.jsplec.wp.dto.ASCDto;

public class ASimpleConViewCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String scno = request.getParameter("scno");
		ASCDao dao = new ASCDao();
		ASCDto dto = dao.simpleContentView(scno);
		request.setAttribute("simpleContentView", dto);
	
		
		
		dao.scviewcount(scno); //조회수 +1
		int scCount = dao.sviewSelect(scno); //조회수 값 가져오기
		request.setAttribute("scCount",scCount ); // 보내주기
		System.out.println(scno);
		
	}

}
