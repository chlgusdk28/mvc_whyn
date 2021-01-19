package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ARLDao;
import com.jsplec.wp.dto.ARLDto;

public class AReviewViewCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
		String reno = request.getParameter("reno");
		ARLDao dao = new ARLDao();
		ARLDto dto = dao.reviewContentView(reno);
		ARLDto dto1 = dao.newReviewContentView(reno);
		ARLDto dtotoday = dao.todayReviewContentView(reno);
		request.setAttribute("reviewContentView", dto);
		request.setAttribute("newReviewContentView", dto1);
		request.setAttribute("todayReviewContentView", dtotoday);
		
		
		
		dao.reviewCount(reno);
		int reviewCount = dao.reviewSelect(reno);
		request.setAttribute("reviewCount",reviewCount );
		System.out.println(reno);
	}

}
