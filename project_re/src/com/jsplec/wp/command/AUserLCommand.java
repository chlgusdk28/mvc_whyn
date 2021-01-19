package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AUserLDao;
import com.jsplec.wp.dto.AUserLDto;

public class AUserLCommand implements ACommand {



	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		AUserLDao userdao = new AUserLDao();
		ArrayList<AUserLDto> dtos = userdao.userManagementList();
		int userViewRowCount = userdao.userViewRowCount();
		int RowCount = userViewRowCount;
		
		
		
		
		
		
		int totalPage=(RowCount/10);
		if(RowCount%10!=0) {
			totalPage++;
		}

		int beginNum=0;
		int endNum=9;
		
		// 리스트
		request.setAttribute("beginNum", beginNum);
		request.setAttribute("endNum", endNum);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("userManagementList", dtos);
		
		
	}

}
