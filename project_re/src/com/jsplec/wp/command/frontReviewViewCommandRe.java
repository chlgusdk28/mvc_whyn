package com.jsplec.wp.command;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.jsplec.wp.dao.CommentDao;
import com.jsplec.wp.dao.frontReviewViewDao;
import com.jsplec.wp.dto.CommentDto;
import com.jsplec.wp.dto.ReCommentDto;
import com.jsplec.wp.dto.frontReviewViewDto;

public class frontReviewViewCommandRe implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		int reno = Integer.parseInt(request.getParameter("reno"));
		
		
		//리뷰
		frontReviewViewDao fdao = new frontReviewViewDao();
		frontReviewViewDto fdto = fdao.reviewView(reno);	
		//댓글
		int seq = Integer.parseInt(request.getParameter("seq"));
		int index = Integer.parseInt(request.getParameter("index"));		
		CommentDao dao = new CommentDao();
		ArrayList<CommentDto> dtos =dao.commentListView(reno);	
		ArrayList<ReCommentDto> redtos = dao.reCommentListView(seq,reno);
		
		
		
		
		
		//리뷰
		request.setAttribute("reviewView", fdto);
		// 댓글
		request.setAttribute("ch",index );
		request.setAttribute("comment", dtos);
		request.setAttribute("recomment", redtos);
	}

}
