package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AcountDao;
import com.jsplec.wp.dto.ACLDto;

public class ACounselingTodayCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
		AcountDao dao = new AcountDao();
		
		ArrayList<ACLDto> dtos = new ArrayList<ACLDto>();
		
		
		dtos = dao.counselingTodayList();
		
		request.setAttribute("counselingTodayList",dtos);
		
		
		System.out.println(dtos);
	}

}
