package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.NoticeDao;
import com.jsplec.wp.dao.frontReviewListDao;
import com.jsplec.wp.dto.NoticeDto;
import com.jsplec.wp.dto.frontReviewListDto;

public class frontReviewListCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		frontReviewListDao frontReviewListDao = new frontReviewListDao();
		ArrayList<frontReviewListDto> frontReviewListDtos = frontReviewListDao.list();	
		request.setAttribute("list", frontReviewListDtos);
		
	}

}
