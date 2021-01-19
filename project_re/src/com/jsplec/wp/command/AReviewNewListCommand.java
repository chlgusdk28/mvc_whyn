package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ARLDao;
import com.jsplec.wp.dto.ARLDto;

public class AReviewNewListCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		ARLDao cdao = new ARLDao();
		ArrayList<ARLDto> dtos = cdao.newReview();
		System.out.println(dtos);
		request.setAttribute("newReview", dtos);
	}

}
