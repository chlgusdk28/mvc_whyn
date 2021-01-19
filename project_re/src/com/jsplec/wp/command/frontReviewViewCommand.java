package com.jsplec.wp.command;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.CommentDao;

import com.jsplec.wp.dao.frontReviewViewDao;

import com.jsplec.wp.dto.CommentDto;
import com.jsplec.wp.dto.frontReviewViewDto;

public class frontReviewViewCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		//리뷰
		int reno = Integer.parseInt(request.getParameter("reno"));
		//int userno = (int)session.getAttribute("USERNO");
		frontReviewViewDao fdao = new frontReviewViewDao();
		frontReviewViewDto fdto = fdao.reviewView(reno);	
		System.out.println("qq"+reno);
		int likecheck=0;
		
		// 댓글
		CommentDao dao = new CommentDao();
		ArrayList<CommentDto> dtos =dao.commentListView(reno);	
		int commentRow=dao.commentRow();
	
		int ch = -1;
		
		
		
		//댓글
		request.setAttribute("comment", dtos);
		request.setAttribute("commentRow", commentRow);
		//대댓글
		//request.setAttribute("recomment", redtos);
		//request.setAttribute("recommentRow", recommentRow);
		request.setAttribute("ch",ch);
		
		
		// 리뷰 출력
		request.setAttribute("reviewView", fdto);
		
		//ReviewLikeDao likedao = new ReviewLikeDao();
		//likecheck = likedao.likeCheck(reno, userno);
		
		request.setAttribute("lch", likecheck);
		
	}

}
