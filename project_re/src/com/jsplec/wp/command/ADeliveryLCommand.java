package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ACLDao;
import com.jsplec.wp.dao.ASCDao;
import com.jsplec.wp.dao.DeliveryDao;
import com.jsplec.wp.dto.ACLDto;
import com.jsplec.wp.dto.ASCDto;
import com.jsplec.wp.dto.DeliveryDto;

public class ADeliveryLCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
		
		DeliveryDao dao = new DeliveryDao();
		
		//매달 5일마다
		ArrayList<DeliveryDto> dtos = dao.fivedate();
		request.setAttribute("fivedate", dtos);
		
		//매달 10일마다
		ArrayList<DeliveryDto> dto = dao.tendate();
		request.setAttribute("tendate", dto);
		
		//매달 15일마다 
		ArrayList<DeliveryDto> dtod = dao.fifteen();
		request.setAttribute("fifteen", dtod);
		
	}

}
