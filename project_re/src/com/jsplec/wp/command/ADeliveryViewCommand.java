package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AUserLDao;
import com.jsplec.wp.dao.DeliveryDao;
import com.jsplec.wp.dto.AUserLDto;
import com.jsplec.wp.dto.DeliveryDto;

public class ADeliveryViewCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub

		
		
		String duserid = request.getParameter("duserid");
		DeliveryDao dao = new DeliveryDao();
		DeliveryDto dto = dao.fiveContentView(duserid);
		
		
		
		//request.setAttribute("newSubscribeContentView",dto1 );

		request.setAttribute("fiveContentView", dto);
		
		
	}

}
