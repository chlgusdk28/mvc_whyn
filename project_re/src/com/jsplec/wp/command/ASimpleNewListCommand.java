package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ASCDao;
import com.jsplec.wp.dto.ASCDto;

public class ASimpleNewListCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		ASCDao cdao = new ASCDao();
		ArrayList<ASCDto> dtos = cdao.newSimpleList();
		System.out.println(dtos);
		request.setAttribute("newSimpleList", dtos);
	}

}
