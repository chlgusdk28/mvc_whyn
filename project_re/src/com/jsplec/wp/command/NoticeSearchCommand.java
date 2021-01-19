package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ANLDao;
import com.jsplec.wp.dao.NoticeDao;
import com.jsplec.wp.dto.ANLDto;
import com.jsplec.wp.dto.NoticeDto;

public class NoticeSearchCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		NoticeDao NoticeDao = new NoticeDao();

		String result1 = (String)request.getParameter("nSearchBox");
		String result2 = (String)request.getParameter("nSearchBar");

		ArrayList<NoticeDto> NoticeDaos = NoticeDao.noticeSearch(result1, result2);
		
		request.setAttribute("list", NoticeDaos);
		System.out.println(NoticeDao.noticeSearch(result1, result2));
		//request.setAttribute("noticeManagementList", NoticeDaos);

	}

}
