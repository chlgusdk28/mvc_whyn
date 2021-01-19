package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AWLDao;
import com.jsplec.wp.dto.AWLDto;


public class AWLCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		AWLDao dao = new AWLDao();
		
		ArrayList<AWLDto> dtos = dao.wineListShow();
		
		request.setAttribute("wineList", dtos);
		
		

	}

}


