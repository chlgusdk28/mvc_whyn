package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AcountDao;
import com.jsplec.wp.dto.ARLDto;

public class AReviewTodayCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		AcountDao dao = new AcountDao();
		
		ArrayList<ARLDto> dtos = new ArrayList<ARLDto>();
		
		
		dtos = dao.reviewTodayList();
		
		request.setAttribute("reviewTodayList",dtos);
		
		
		System.out.println(dtos);
	}

}
