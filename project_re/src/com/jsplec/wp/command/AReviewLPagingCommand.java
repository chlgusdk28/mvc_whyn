package com.jsplec.wp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.ARLDao;
import com.jsplec.wp.dto.ARLDto;

public class AReviewLPagingCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		ARLDao ndao = new ARLDao();
		ArrayList<ARLDto> dtos = ndao.reviewManagementList();
		int reviewViewRowCount = ndao.reviewViewRowCount();
		int RowCount = reviewViewRowCount;
		
		// paging start
		
		
		int nowPage = Integer.parseInt(request.getParameter("page"));
		int pageRow=10;
		int beginNum=(nowPage*pageRow)-pageRow;
		int endNum=(nowPage*pageRow)-1;
		int totalPage=(RowCount/pageRow);
		if(RowCount%10!=0) {
			totalPage++;
		}
		
//		for(int i=1;i<=totalPage;i++) {
//			if(nowPage==i) {
//				beginNum=(i*pageRow)-pageRow;
//				endNum=(i*pageRow)-1;
//			}
//		}
		
		System.out.println("bNUM = "+beginNum);
		System.out.println("nNum = "+endNum);
		
		// 리스트
		request.setAttribute("reviewManagementList", dtos);
		//페이지
		request.setAttribute("beginNum", beginNum);
		request.setAttribute("endNum", endNum);
		request.setAttribute("totalPage", totalPage);

		
		
	}

}
