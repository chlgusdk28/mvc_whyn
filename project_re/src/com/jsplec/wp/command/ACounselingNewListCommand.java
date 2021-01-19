package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ACLDao;
import com.jsplec.wp.dto.ACLDto;

public class ACounselingNewListCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		ACLDao cdao = new ACLDao();
		ArrayList<ACLDto> dtos = cdao.newCounseling();
		request.setAttribute("newcounseling", dtos);
		
	}

}
