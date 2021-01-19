package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AWLDao;
import com.jsplec.wp.dto.AWLDto;

public class AWineSearchCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		AWLDao wdao = new AWLDao();
		String result1= (String)request.getParameter("wineSearchBox");
		String result2= (String) request.getParameter("wineSearchBar");
		System.out.println(result1+result2);
		ArrayList<AWLDto> dtos = wdao.wineSearch(result1,result2);
		AWLDto wdto = new AWLDto(result1, result2);
		request.setAttribute("setWineSearch", wdto);
		request.setAttribute("wineListShow", dtos);
	}

}
