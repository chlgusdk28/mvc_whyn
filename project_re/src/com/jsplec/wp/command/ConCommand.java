package com.jsplec.wp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ConsultingDao;
import com.jsplec.wp.dao.SubscribeDao;

public class ConCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String c_no = request.getParameter("c_no");
		String con_info = request.getParameter("con_info");

		ConsultingDao ConsultingDao = new ConsultingDao();
		ConsultingDao.Consulting(c_no, con_info);

	}

}
