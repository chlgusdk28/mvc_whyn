package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AcountDao;
import com.jsplec.wp.dto.AUserLDto;

public class ASubscribeTodayListCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
		
		AcountDao dao = new AcountDao();
		
		ArrayList<AUserLDto> dtos = new ArrayList<AUserLDto>();
		
		
		dtos = dao.userTodayList();
		
		request.setAttribute("userTodayList",dtos);
		
		
		System.out.println("11"+dtos);
	}

}
