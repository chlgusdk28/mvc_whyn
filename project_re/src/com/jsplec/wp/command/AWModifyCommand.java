package com.jsplec.wp.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.dao.AWLDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class AWModifyCommand implements ACommand {
			
		
		public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
			
			
			//사용자가 전송한 파일 'upload '파일로 간다.
			String directory = request.getServletContext().getRealPath("/upload/"); 
	   		int maxSize = 300 * 300 * 10;
	   		String encoding = "UTF-8";
	   		
	   		MultipartRequest multi;
	   		System.out.println(directory);
	   		
			try {
				multi = new MultipartRequest(request, directory, maxSize, encoding, new DefaultFileRenamePolicy());
				String strpno = multi.getParameter("pno");
				String pname = multi.getParameter("pname");
				String strpcount = multi.getParameter("pcount");
				String pcountry = multi.getParameter("pcountry");
				String pcolor = multi.getParameter("pcolor");
				String ptext = multi.getParameter("ptext");
				String strpcontent = multi.getParameter("pcontent");
				String pimage1 = multi.getParameter("pimage");
				
				int pno = Integer.parseInt(strpno);
				int pcount = Integer.parseInt(strpcount);
				int pcontent = Integer.parseInt(strpcontent);
				
				//file 이란 이름은 wineList.jsp에 있는 name ="file" / DB에 넣기위해 스트링 변환
				
				String pimage = multi.getOriginalFileName("file");         // 실제 파일 이름
				String prealimage = multi.getFilesystemName ("file");      // 시스템상 파일 이름( 중복시 파일 명 자동 변경
				
				// 확장자 정해주기
				if(pimage.endsWith(".doc") && pimage.endsWith(".hwp") && 
						pimage.endsWith(".pdf") && pimage.endsWith(".xls")){
					File file = new File(directory + pimage1);
					file.delete(); 
					
					System.out.println("업로드할 수 없는 확장자 입니다.");
				}else{
					// DAO를 불러서 위에 불러온 값과 이미지를 저장 시킴
					AWLDao dao = new AWLDao();
					
					int modify = dao.modify(pno, pname, pcount, pcountry, pcolor, ptext, pcontent, pimage, prealimage);
					System.out.println("파일명 : " + pimage + "<br>"); 
					System.out.println("실제 파일명 : " + prealimage + "<br>"); 
					//session.setAttribute("CH", modify);
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

}
}
