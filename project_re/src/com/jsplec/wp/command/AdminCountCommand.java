package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AcountDao;

public class AdminCountCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		
		//new현황 count
		AcountDao acountDao = new AcountDao();
		int sCount = acountDao.sCount();
		int cCount = acountDao.cCount(); 
		int reCount = acountDao.reCount();
		int simCount = acountDao.simCount();
		
		request.setAttribute("SCOUNT", sCount);
		request.setAttribute("CCOUNT", cCount);
		request.setAttribute("RECOUNT", reCount);
		request.setAttribute("SIMCOUNT", simCount); // 간단 상담 문의 조회수 count
		
		
		//오늘의 현황 count
		int sTodayCount = acountDao.sTodayCount();
		int cTodayCount = acountDao.cTodayCount();
		int reTodayCount = acountDao.reTodayCount();
		
		System.out.println(sTodayCount);
		System.out.println(cTodayCount);
		request.setAttribute("STODAYCOUNT", sTodayCount);
		request.setAttribute("CTODAYCOUNT", cTodayCount);
		request.setAttribute("RETODAYCOUNT", reTodayCount);

		
		
		
		
		
		
	}

}
