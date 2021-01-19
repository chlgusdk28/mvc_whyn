package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.CounselingDao;
import com.jsplec.wp.dto.CounselingDto;

public class CounselingSearchCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String userid = (String)session.getAttribute("USERID");
		String result1 = (String)request.getParameter("nSearchBox");
		String result2 = (String)request.getParameter("nSearchBar");
		
		
		System.out.println("hhhhhh"+result1+result2);
		CounselingDao dao = new CounselingDao();
		ArrayList<CounselingDto> dtos = dao.counselingListSearch(userid, result1, result2);
		int allcount = dao.allCount(userid);
		int answerCount = dao.answerCount(userid);
		
		
		
		
		request.setAttribute("counselingList", dtos);//검색 리스트
		request.setAttribute("allcount", allcount);//내가쓴 문의 카운트
		request.setAttribute("answerCount", answerCount);//답변받은 문의 카운트
		
		
	}

}
