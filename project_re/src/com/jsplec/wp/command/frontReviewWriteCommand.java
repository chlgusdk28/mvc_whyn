package com.jsplec.wp.command;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AWLDao;
import com.jsplec.wp.dao.SubscribeDao;
import com.jsplec.wp.dao.frontReviewWriteDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class frontReviewWriteCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
			
		
		String directory = request.getServletContext().getRealPath("/upload/"); 
   		int maxSize = 300 * 300 * 10;
   		String encoding = "UTF-8";
   		
   		MultipartRequest multi;
   		
   		try {
   			multi = new MultipartRequest(request, directory, maxSize, encoding, new DefaultFileRenamePolicy());
		String userid = (String)session.getAttribute("USERID");
		String starScore = multi.getParameter("starScore"); //별점
		String q1 = multi.getParameter("q1"); 
		String q2 = multi.getParameter("q2");
		String q3 = multi.getParameter("q3"); 
		String retitle = multi.getParameter("retitle"); //글 내용
		String rcontent = multi.getParameter("rcontent"); //글 내용
		
		String reimage = multi.getOriginalFileName("file");         // 실제 파일 이름
		String rereimage = multi.getFilesystemName ("file"); 
		
		System.out.println(userid);
		
		if(reimage.endsWith(".doc") && reimage.endsWith(".hwp") && 
				reimage.endsWith(".pdf") && reimage.endsWith(".xls")){
			File file = new File(directory + rereimage);
			file.delete(); 
			
			System.out.println("업로드할 수 없는 확장자 입니다.");
			
		}else{
			// DAO를 불러서 위에 불러온 값과 이미지를 저장 시킴
			frontReviewWriteDao frontReviewWriteDao = new frontReviewWriteDao();
			frontReviewWriteDao.frontReviewWrite(userid, starScore, q1, q2, q3, retitle, rcontent, reimage, rereimage);
			System.out.println(userid);
		}
		
		
   		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
