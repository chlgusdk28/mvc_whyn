package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.SubscribeDao;
import com.jsplec.wp.dto.SubDto;


public class SubCommand2 implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		String sitem = (String) session.getAttribute("sitem");
		String userno = (String) session.getAttribute("userno");
		int userno1 = Integer.parseInt(userno);

		System.out.println(sitem);
		System.out.println(userno);
		SubscribeDao subscribeDao = new SubscribeDao();
		subscribeDao.SubscribeModi(sitem, userno);
		
		ArrayList<SubDto> SubDtoDtos = SubscribeDao.productItem(userno1);
		int rowCount=SubDtoDtos.size();
		System.out.println(rowCount);
		request.setAttribute("productItem", SubDtoDtos);
		
		request.setAttribute("rowcount", rowCount);
		
	}

}
