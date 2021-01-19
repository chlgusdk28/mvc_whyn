package com.jsplec.wp.controller;

import java.io.IOException;





import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsplec.wp.command.ACounselingDeleteCommand;
import com.jsplec.wp.command.ACounselingLCommand;
import com.jsplec.wp.command.ACounselingLPagingCommand;
import com.jsplec.wp.command.ACounselingNewListCommand;
import com.jsplec.wp.command.ACounselingSearchCommand;
import com.jsplec.wp.command.ACounselingTodayCommand;
import com.jsplec.wp.command.ACounselingViewCommand;
import com.jsplec.wp.command.ADeliveryLCommand;
import com.jsplec.wp.command.ADeliveryViewCommand;
import com.jsplec.wp.command.ANoticeDeleteCommand;
import com.jsplec.wp.command.ANoticeLCommand;
import com.jsplec.wp.command.ANoticeLPagingCommand;
import com.jsplec.wp.command.ANoticeSearchCommand;
import com.jsplec.wp.command.ANoticeUpdateCommand;
import com.jsplec.wp.command.ANoticeViewCommand;
import com.jsplec.wp.command.ANoticeWriteCommand;
import com.jsplec.wp.command.AReviewDeleteCommand;
import com.jsplec.wp.command.AReviewLCommand;
import com.jsplec.wp.command.AReviewLPagingCommand;
import com.jsplec.wp.command.AReviewNewListCommand;
import com.jsplec.wp.command.AReviewNewViewCommand;
import com.jsplec.wp.command.AReviewSearchCommand;
import com.jsplec.wp.command.AReviewTodayCommand;
import com.jsplec.wp.command.AReviewViewCommand;
import com.jsplec.wp.command.ASimpleConViewCommand;
import com.jsplec.wp.command.ASimpleDeleteCommand;
import com.jsplec.wp.command.ASimpleNewListCommand;
import com.jsplec.wp.command.ASubscribeNewListCommand;
import com.jsplec.wp.command.ASubscribeTodayListCommand;
import com.jsplec.wp.command.AUserDeleteCommand;
import com.jsplec.wp.command.AUserLCommand;
import com.jsplec.wp.command.AUserLPagingCommand;
import com.jsplec.wp.command.AUserSearchCommand;
import com.jsplec.wp.command.AUserUpdateCommand;
import com.jsplec.wp.command.AUserViewCommand;
import com.jsplec.wp.command.AWContentCommand;
import com.jsplec.wp.command.AWModifyCommand;
import com.jsplec.wp.command.AWWCommand;
import com.jsplec.wp.command.AWineDeleteCommand;
import com.jsplec.wp.command.AWineLCommand;
import com.jsplec.wp.command.AWineLPagingCommand;
import com.jsplec.wp.command.AWineSearchCommand;
import com.jsplec.wp.command.AdminCountCommand;
import com.jsplec.wp.command.AdminLoginCommand;
import com.jsplec.wp.command.AdminlonginchkCommand;
import com.jsplec.wp.command.CommentDeleteCommand;
import com.jsplec.wp.command.CommentWrite;
import com.jsplec.wp.command.ACommand;
import com.jsplec.wp.command.ACounselingAnswerCommand;
import com.jsplec.wp.command.ConCommand;
import com.jsplec.wp.command.FindUserIdCommand;
import com.jsplec.wp.command.FindUserPwCommand;
import com.jsplec.wp.command.JoinCheckCommand;
import com.jsplec.wp.command.JoinCommand;
import com.jsplec.wp.command.LoginCheckCommand;
import com.jsplec.wp.command.LoginCommand;
import com.jsplec.wp.command.LoginSubCommand;
import com.jsplec.wp.command.LogoutCommand;
import com.jsplec.wp.command.MyPageViewCommand;
import com.jsplec.wp.command.MypageUpdateCommand;
import com.jsplec.wp.command.NoticeCommand;
import com.jsplec.wp.command.NoticeLPagingCommand;
import com.jsplec.wp.command.NoticeSearchCommand;
import com.jsplec.wp.command.NoticeViewCommand;
import com.jsplec.wp.command.ReCommentDeleteCommand;
import com.jsplec.wp.command.ReCommentWrite;

import com.jsplec.wp.command.SessionCommand;
import com.jsplec.wp.command.SubCommand;
import com.jsplec.wp.command.SubCommand2;
import com.jsplec.wp.command.SubCommand3;
import com.jsplec.wp.command.frontReviewListCommand;
import com.jsplec.wp.command.frontReviewViewCommand;
import com.jsplec.wp.command.frontReviewViewCommandRe;
import com.jsplec.wp.command.frontReviewWriteCommand;


/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		ACommand  command = null;
		String viewPage = null;
		System.out.println(com);
		//System.out.println(request.getParameter("userid").length());
		//System.out.println(request.getParameter("userpw").length());
		switch(com) {
		case("/main.do"):
			viewPage="main.jsp";
			break;	
		case("/login.do"):
			command = new LoginCommand();
			command.execute(request, response, session);
			viewPage = "logincheck.do";
			break;
		case("/logincheck.do"):
			String loginCheck = (String)request.getAttribute("LOGIN");
			if(loginCheck.equals("ok")) {
				viewPage="loginAlert.jsp";
			}else {
				command = new LoginCheckCommand();
				command.execute(request, response, session);
				viewPage="login.jsp";
			}
			break;
		case("/adminlogin.do"): //어드민 로그인
			command = new  AdminLoginCommand();
			command.execute(request, response, session);
			viewPage="adminloginchk.do";
		break;
		
		case("/adminloginchk.do"):
			String adminloginCheck = (String)request.getAttribute("ADMINLOGIN");
			if(adminloginCheck.equals("ok")) {
				viewPage="adminloginAlert2.jsp";
			}else {
				command = new AdminlonginchkCommand();
				command.execute(request, response, session);
				viewPage="adminLogin.jsp";
			}
			break;
		case("/joincheck.do"):		
			command = new JoinCheckCommand();
			command.execute(request, response, session);
			viewPage="join.do";
			break;
		case("/join.do"):
			String joinCheck = (String)request.getAttribute("JOIN");
			if(joinCheck.equals("ok")) {	
				command = new JoinCommand();
				command.execute(request, response, session);
				viewPage = "login.jsp";
			}else {
			viewPage = "join.jsp";
			}
		break;
		case("/mypage.do"):
			command = new MyPageViewCommand();
			command.execute(request, response, session);
			viewPage = "mypage.jsp";
		break;
		case("/findId.do"):
			command = new FindUserIdCommand();
			command.execute(request, response, session);
			viewPage="findUserIdPw.jsp";
			break;
		
		case("/findPw.do"):
			command = new FindUserPwCommand();
			command.execute(request, response, session);
			viewPage="findUserIdPw.jsp";
			break;
		
		case("/logout.do"):
			command = new LogoutCommand();
			command.execute(request, response, session);
			viewPage="logout.jsp";
			break;	
		case("/mypageUpdate.do"): //유저정보  수정 
			command = new MypageUpdateCommand();
			command.execute(request, response, session);
			viewPage ="mypage.do";
			break;	
			//----------------------------------  구독      
		case("/subscribe02.do"): // 구독 정보 커맨드
			command = new SessionCommand(); 
			command.execute(request, response, session);
			viewPage="subscribe02.jsp";
			break;
			
		case("/subscribe03.do"): // 결제 완료창
			command = new SubCommand();
			command.execute(request, response, session);
			viewPage="subscribe03.jsp";
		break;	
		case("/subscribe04.do"):  //결과 페이지
			command = new SubCommand2();
			command.execute(request, response, session);
			viewPage="subscribe04.jsp";
		break;	
		case("/SubCommand3.do"):  //결과 페이지
			command = new SubCommand3();
			command.execute(request, response, session);
			viewPage="subAlert.jsp";
		break;				
		case("/LoginSubCommand.do"):  ///////////////////////////////1208추가 --------
			command = new LoginSubCommand();
			command.execute(request, response, session);
			viewPage="LoginSub2.jsp";
		break;		
		
		
		
////////////////////--------------------------------- ---------------------
		case("/con.do"):
			command = new ConCommand();
			command.execute(request, response, session);
			viewPage="con02.jsp";
		break;
		case("/notice.do"):
			command = new NoticeCommand();
			command.execute(request, response, session);
			viewPage="notice.jsp";
		break;
		
		case("/NoticeLPagingCommand.do"): // 공지 페이지넘김
			command = new NoticeLPagingCommand();
			command.execute(request, response, session);
			viewPage = "notice.jsp";
			break;
		case("/noticeContent.do"):
			command = new NoticeViewCommand();
			command.execute(request, response, session);
			viewPage = "noticeContent.jsp";
			break;
		case("/NoticeSearchCommand.do"): 
			command = new NoticeSearchCommand();
			command.execute(request, response, session);
			viewPage = "notice.jsp";
			break;	
		case("/frontReviewWrite.do"): 
			command = new frontReviewWriteCommand();
			command.execute(request, response, session);
			viewPage = "frontReviewlist.do";
			break;				
		case("/frontReviewlist.do"): 
			command = new frontReviewListCommand();
			command.execute(request, response, session);
			viewPage = "frontReviewlist.jsp";
			break;
		case("/frontReviewView.do"):
			command = new frontReviewViewCommand();
			command.execute(request, response, session);
			viewPage = "frontReviewView.jsp";
			break;
		case("/frontReviewViewRe.do"):
			command = new frontReviewViewCommandRe();
			command.execute(request, response, session);
			viewPage = "frontReviewView.jsp";
			break;
				// -- 댓글작성 --  //		
		case("/commentWrite.do"): 
			command = new CommentWrite();
			command.execute(request, response, session);
			viewPage="frontReviewView.do";
			break;

//		case("/recommentList.do"):
//			command = new RecommentListView();
//			command.execute(request, response, session);
//			viewPage="CommentTest.jsp";
//			break;
		case("/recommentWrite.do"):
			command = new ReCommentWrite();
			command.execute(request, response, session);
			viewPage="frontReviewViewRe.do";
			break;
		case("/CommentDelete.do"):
			command = new CommentDeleteCommand();
			command.execute(request, response, session);
			viewPage="frontReviewView.do";
			break;
		case("/reCommentDelete.do"):
			command = new ReCommentDeleteCommand();
			command.execute(request, response, session);
			viewPage="frontReviewViewRe.do";
			break;
		
			//--------------유저----------------
			case ("/AUserLCommand.do"): //유저게시판 보이기.
				command = new AUserLCommand();
				command.execute(request, response, session);
				viewPage = "userManagement.jsp";
				break;
			case("/AUserDeleteCommand.do"): //선택유저 삭제
				command = new AUserDeleteCommand();
				command.execute(request, response, session);
				viewPage = "AUserLCommand.do";
				break;
			case("/AUserSearchCommand.do"): // 유저검색
				command = new AUserSearchCommand();
				command.execute(request, response, session);
				viewPage = "userManagement.jsp";
				break;
			case("/userContentView.do"): //유저 클릭시 보이기
				command = new AUserViewCommand();
				command.execute(request, response, session);
				viewPage = "userView.jsp";
				break;
			case("/AUserLPagingCommand.do"): // 유저 페이지넘김
				command = new AUserLPagingCommand();
				command.execute(request, response, session);
				viewPage = "userManagement.jsp";
				break;
			case("/AUserUpdateCommand.do"): //유저정보  수정 
				command = new AUserUpdateCommand();
				command.execute(request, response, session);
				viewPage ="AUserLCommand.do";
				break;	
			case("/ASubscribeNewListCommand.do"): // 새로운  구독자 목록 
				command = new ASubscribeNewListCommand();
				command.execute(request, response, session);
				viewPage = "subscribeChk.jsp";
				break;	
			case("/newSubscribeList.do"): //유저 클릭시 보이기
				command = new AUserViewCommand();
				command.execute(request, response, session);
				viewPage = "newSubscribeView.jsp";
				break;
			case("/ASubscribeTodayListCommand.do"): // 오늘의  구독자 목록 
				command = new ASubscribeTodayListCommand();
				command.execute(request, response, session);
				viewPage = "todaySubscribe.jsp";
				break;	
			case("/userTodayContentView.do"): // 
				command = new AUserViewCommand();
				command.execute(request, response, session);
				viewPage = "todaySubscribeView.jsp";
				break;	
				
			//----------------리뷰---------------	
			case("/AReviewLCommand.do"): //리뷰게시판보이기
				command = new AReviewLCommand();
				command.execute(request, response, session);
				viewPage = "reviewManagement.jsp";
				break;
			case("/AReviewSearchCommand.do")://리뷰검색
				command = new AReviewSearchCommand();
				command.execute(request, response, session);
				viewPage = "reviewManagement.jsp";
				break;	
			case("/AReviewDeleteCommand.do"): //리뷰삭제
				command = new AReviewDeleteCommand();
				command.execute(request, response, session);
				viewPage = "AReviewLCommand.do";
				break;
			case("/reviewContentView.do"): //리뷰 클릭시 보이기 
				command = new AReviewViewCommand();
				command.execute(request, response, session);
				viewPage = "reviewView.jsp";
				break;
			case("/AReviewLPagingCommand.do"): //리뷰 페이지넘김
				command = new AReviewLPagingCommand();
				command.execute(request, response, session);
				viewPage = "reviewManagement.jsp";
				break;	
			case("/AReviewNewListCommand.do"): // 새로운 리뷰 목록 
				command = new AReviewNewListCommand();
				command.execute(request, response, session);
				viewPage = "newReviewList.jsp";
				break;
			case("/newReviewContentView.do"): // 새로운 리뷰 클릭시 
				command = new AReviewViewCommand();
				command.execute(request, response, session);
				viewPage = "newReviewView.jsp";
				break;
			case("/reviewTodayList.do"): // 오늘의 후기 클릭
				command = new AReviewTodayCommand();
				command.execute(request, response, session);
				viewPage="todayReviewList.jsp";
				break;
			case("/todayReviewContentView.do"):
				command = new AReviewViewCommand();
				command.execute(request, response, session);
				viewPage="todayReviewView.jsp";
				break;
				//---------------배송---------------
			case("/ADeliveryLCommand.do"):
				command = new ADeliveryLCommand();
				command.execute(request, response, session);
				viewPage="deliveryManagement.jsp";
				break;
			case("/fiveContentView.do"): //매달 5일인 유저 클릭
				command = new ADeliveryViewCommand();
				command.execute(request, response, session);
				viewPage = "deliveryView.jsp";
				break;
			case("/tenContentView.do"): //매달 10일인 유저 
				command = new ADeliveryViewCommand();
				command.execute(request, response, session);
				viewPage = "deliveryView10.jsp";
				break;
			case("/fifteenContentView.do"): //매달 10일인 유저 
				command = new ADeliveryViewCommand();
				command.execute(request, response, session);
				viewPage = "deliveryView15.jsp";
				break;
				
				//---------------문의---------------
			case("/ACounselingLCommand.do"): //문의 게시판 보이기 
				command = new ACounselingLCommand();
				command.execute(request, response, session);
				viewPage = "counselingManagement.jsp";
				break;
			case("/ACounselingSearchCommand.do"): //문의 검색
				command = new ACounselingSearchCommand();
				command.execute(request, response, session);
				viewPage = "counselingManagement.jsp";
				break;
			case("/ACounselingDeleteCommand.do"): //문의 삭제 
				command = new ACounselingDeleteCommand();
				command.execute(request, response, session);
				viewPage = "ACounselingLCommand.do";
				break;
			case("/counselingContentView.do"): //문의 클릭시 보이기 
				command = new ACounselingViewCommand();
				command.execute(request, response, session);
				viewPage = "counselingView.jsp";
				break;
			case("/ACounselingLPagingCommand.do"): // 문의 페이지넘김
				command = new ACounselingLPagingCommand();
				command.execute(request, response, session);
				viewPage = "counselingManagement.jsp";
				break;
			case("/ACounselingNewListCommand.do"): // 새로운 문의 목록 
				command = new ACounselingNewListCommand();
				command.execute(request, response, session);
				viewPage = "newCounselingList.jsp";
				break;
			case("/newcounseling.do"): //새로운 문의 클릭시 리스트출력
				command = new ACounselingViewCommand();
				command.execute(request, response, session);
				viewPage = "newCounselingView.jsp";
				break;
			case("/ASimpleNewListCommand.do"): //새로운 간편 문의 클릭시 리스트출력
				command = new ASimpleNewListCommand();
				command.execute(request, response, session);
				viewPage = "simpleNewList.jsp";
				break;
			case("/simpleContentView.do"): //새로운 간편문의 리스트
				command = new ASimpleConViewCommand();
				command.execute(request, response, session);
				viewPage = "simpleNewView.jsp";
				break;
			case("/counselingTodayList.do"): //오늘의 문의 리스트 출력
				command = new ACounselingTodayCommand();
				command.execute(request, response, session);
				viewPage = "todayCounselingList.jsp";
				break;
			case("/todayContentView.do"): //오늘의 문의 리스트클릭시 보이기
				command = new ACounselingViewCommand();
				command.execute(request, response, session);
				viewPage = "todayCounselingView.jsp";
				break;
			case("/simpleConList.do"): //간편문의 게시판 보이기 
				command = new ACounselingLCommand();
				command.execute(request, response, session);
				viewPage = "counselingManagement.jsp";
				break;
			case("/deleteSimple.do"): //문의 삭제 
				command = new ASimpleDeleteCommand();
				command.execute(request, response, session);
				viewPage = "ACounselingLCommand.do";
				break;
			case ("/ACounselingAnswerCommand.do"): // 문의 답변 작성 및 저장
				command = new ACounselingAnswerCommand();
				command.execute(request, response, session);
				viewPage = "ACounselingNewListCommand.do";
				break;
				
				
//				//--------------와인----------------
//			case("/AWineLCommand.do"): //와인리스트 보이기
//				command = new AWineLCommand();
//				command.execute(request, response, session);
//				viewPage = "wineList.jsp";
//				break;
//			case("/AWineDeleteCommand.do"): //와인 삭제 
//				command = new AWineDeleteCommand();
//				command.execute(request, response, session);
//				viewPage = "AWineLCommand.do";
//				break;
//			case("/AWineSearchCommand.do"): //와인 검색 
//				command = new AWineSearchCommand();
//				command.execute(request, response, session);
//				viewPage = "wineList.jsp";
//				break;
//			case("/AWineLPagingCommand.do"): // 와인 페이지넘김
//				command = new AWineLPagingCommand();
//				command.execute(request, response, session);
//				viewPage = "winelist.jsp";
//				break;
			case("/modify.do")://수정
				command = new AWModifyCommand();	
			command.execute(request, response, session);
			viewPage="AWineLCommand.do";
			break;
			
			case("/AWineLCommand.do"): //와인리스트 보이기
				command = new AWineLCommand();
				command.execute(request, response, session);
				viewPage = "wineList.jsp";
				break;
			case("/AWineDeleteCommand.do"): //와인 삭제 
				command = new AWineDeleteCommand();
				command.execute(request, response, session);
				viewPage = "AWineLCommand.do";
				break;
			case("/AWineSearchCommand.do"): //와인 검색 
				command = new AWineSearchCommand();
				command.execute(request, response, session);
				viewPage = "wineList.jsp";
				break;
			case("/AWineLPagingCommand.do"): // 와인 페이지넘김
				command = new AWineLPagingCommand();
				command.execute(request, response, session);
				viewPage = "wineList.jsp";
				break;
			case("/write_view.do")://입력화면
				viewPage = "write_view.jsp";
				break;
				
			case("/write.do")://입력저장
				command = new AWWCommand();
				command.execute(request, response, session);
				viewPage="write_view.jsp";
				break;
			case("/wineContent_View.do")://내용보기
				command = new AWContentCommand();
				command.execute(request, response, session);
				viewPage="wineContentView.jsp";
				break;

			
		
				
			
				//---------------공지---------------
			case("/ANoticeLCommand.do"): //공지 보이기
				command = new ANoticeLCommand();
				command.execute(request, response, session);
				viewPage = "noticeManagement.jsp";
				break;
			case("/ANoticeDeleteCommand.do"): //공지 삭제 
				command = new ANoticeDeleteCommand();
				command.execute(request, response, session);
				viewPage = "ANoticeLCommand.do";
				break;
			case("/ANoticeSearchCommand.do"): //공지 검색
				command = new ANoticeSearchCommand();
				command.execute(request, response, session);
				viewPage = "noticeManagement.jsp";
				break;
			case("/noticeContentView.do"): //공지 눌렀을때 내용 보여주기
				command = new ANoticeViewCommand();
				command.execute(request, response, session);
				viewPage = "noticeView.jsp";
				break;
			case("/ANoticeLPagingCommand.do"): // 공지 페이지넘김
				command = new ANoticeLPagingCommand();
				command.execute(request, response, session);
				viewPage = "noticeManagement.jsp";
				break;
			case ("/noticeWrite.do"): // 공지 입력및 저장
				command = new ANoticeWriteCommand();
				command.execute(request, response, session);
				viewPage = "ANoticeLCommand.do";
				break;
			case("/ANoticeUpdateCommand.do"): //공지 수정 
				command = new ANoticeUpdateCommand();
				command.execute(request, response, session);
				viewPage ="ANoticeLCommand.do";
				break;	
				
			//------------------메인화면-------------------------
			case("/AdmainCountCommand.do"): //
				command = new AdminCountCommand();
				command.execute(request, response, session);
				viewPage = "adminMain.jsp";
				break;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
