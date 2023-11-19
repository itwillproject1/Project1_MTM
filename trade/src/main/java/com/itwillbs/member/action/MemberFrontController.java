package com.itwillbs.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.action.ProductPopListAction;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

@WebServlet("*.member")
public class MemberFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/************************1. 가상주소 계산 시작************************/
		//System.out.println("\n---------------1. 가상주소 계산 시작---------------");
		String requestURI = request.getRequestURI(); // 가상주소
		System.out.println("\tC: requestURI: " + requestURI);
		
		String CTXPath = request.getContextPath(); // 프로젝트 이름
		//System.out.println("\tC: CTXPath: " + CTXPath);
		
		String command = requestURI.substring(CTXPath.length());
		System.out.println("\tC: command: " + command);
		//System.out.println("---------------1. 가상주소 계산 종료---------------");
		/************************1. 가상주소 계산 종료************************/	
	
	
		/************************2. 가상주소 매핑 시작************************/
		//System.out.println("\n---------------2. 가상주소 매핑 시작---------------");
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/main/login.member")) {
			//System.out.println("\tC: /Main.com 호출");
			//System.out.println("\tC: 패턴1 - DB 사용 X, 뷰페이지 출력");
			
			forward = new ActionForward();

			forward.setPath("./login.jsp");
			forward.setRedirect(false);
		}
		else if(command.equals("/member/memberjoin.member")) {
			//System.out.println("\tC: /Main.com 호출");
			//System.out.println("\tC: 패턴1 - DB 사용 X, 뷰페이지 출력");
			
			forward = new ActionForward();

			forward.setPath("./memberjoin.jsp");
			forward.setRedirect(false);
		}
		else if(command.equals("/member/memberjoin.member")) {
			//System.out.println("\tC: /Main.com 호출");
			//System.out.println("\tC: 패턴1 - DB 사용 X, 뷰페이지 출력");
			
			forward = new ActionForward();

			forward.setPath("./memberjoin.jsp");
			forward.setRedirect(false);
		}
		else if(command.equals("/member/MemberJoinAction.member")){
			
			action = new MemberJoinAction();
						
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
		else if(command.equals("/main/MemberLoginAction.member")) {
			//System.out.println(" C : /MemberLoginAction.mem 호출 ");
			//System.out.println(" C : 패턴 2 - DB사용O, 페이지이동");
			
			// MemberLoginAction() 객체생성
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 처리결과를 가지고 이동
		}
		else if(command.equals("/main/MemberLogout.member")) {
			//System.out.println(" C : /MemberLogout.me 호출 ");
			//System.out.println(" C : 패턴 2 - 데이터처리O, 페이지로 이동");
			
			// MemberLogoutAction() 객체 생성
			action = new MemberLogoutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/member/Membercheckid.member")) {
			forward = new ActionForward();
			forward.setPath("./checkid.jsp");
			forward.setRedirect(false);
			
		}
		else if(command.equals("/member/MemberCheckIdAction.member")){
				
			action = new MemberCheckIdAction();
			try {
			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}
		
		else if(command.equals("/member/MemberInfo.member")) {
			System.out.println(" C : /MemberInfo.me 호출 ");
			System.out.println(" C : 패턴 3 - DB사용O, 페이지 출력 ");
			
			// MemberInfoAction() 객체생성
			action = new MemberInfoAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//마이페이지 내가 올린 글
		else if(command.equals("/member/MypageProductboardAction.member")) {
			System.out.println(" C : /MypageProductboardAction.member 호출 ");
			System.out.println(" C : 패턴 3 - DB사용O, 페이지 출력 ");
			
			// MemberInfoAction() 객체생성
			action = new MypageProductboardAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

			
		else if(command.equals("/member/MemberPayInfo.member")) {
			
			action = new MemberPayInfoAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/member/MemberPayAction.member")){
			action = new MemberPayAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/member/Memberupdate.member")) {
			//System.out.println("\tC: /Main.com 호출");
			//System.out.println("\tC: 패턴1 - DB 사용 X, 뷰페이지 출력");
			
			forward = new ActionForward();
			forward.setPath("./memberupdate.jsp");
			forward.setRedirect(false);
		}
		
		else if(command.equals("/member/MemberUpdateProAction.member")){
			
			action = new MemberUpdateProAction();
			try {
			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}
		
		else if(command.equals("/member/removemember.member")) {
			//System.out.println("\tC: /Main.com 호출");
			//System.out.println("\tC: 패턴1 - DB 사용 X, 뷰페이지 출력");
			
			forward = new ActionForward();
			forward.setPath("./removemember.jsp");
			forward.setRedirect(false);
		}
		
		else if(command.equals("/member/MemberDeleteAction.member")){
			
			action = new MemberDeleteAction();
			try {
			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}
		
		else if(command.equals("/MypageLikeboardAction.member")){
			
			action = new MypageLikeboardAction();
			try {
			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}
		else if(command.equals("/TradeOkAction.member")){
			
			action = new TradeOkAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		else if(command.equals("/member/findid.member")){
			
			forward = new ActionForward();
			forward.setPath("./findid.jsp");
			forward.setRedirect(false);
		}
		
		else if(command.equals("/member/findidAction.member")){
			
			System.out.println(" C : /member/findidAction.member 호출 ");
			
			action = new findidAction();
			try {
			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}else if(command.equals("/member/Member112.member")) {
			
			
			action = new Member112Action();
			try {
			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		else if(command.equals("/member/findpw.member")){
			
			forward = new ActionForward();
			forward.setPath("./findpw.jsp");
			forward.setRedirect(false);
		}
		

		else if(command.equals("/member/AdjustSmtp.member")){
			
			System.out.println("/member/AdjustSmtp.member 호출 ");
			
			action = new AdjustSmtp();
			try {
			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}
		
		else if(command.equals("/member/findpwAction.member")){
			System.out.println("/findpwAction.member 호출 ");
			action = new findpwAction();
			try {
			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}
		
		else if(command.equals("/member/Qna.member")){
			System.out.println("/Qna.member 호출 ");
			
			forward = new ActionForward();

			forward.setPath("./qna.jsp");
			forward.setRedirect(false);
		}
		
		else if(command.equals("/member/QnaAction.member")){
			System.out.println("/QnaAction.member 호출 ");
			action = new QnaAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/member/QnaContent.member")){
			System.out.println("/QnaContent.member 호출 ");
			action = new QnaContentAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		//System.out.println("---------------2. 가상주소 매핑 종료---------------");
		/************************2. 가상주소 매핑 종료************************/
		
		/************************3. 가상주소 이동 시작************************/
		//System.out.println("\n---------------3. 가상주소 이동 시작---------------");
		if(forward != null) {
			if(forward.isRedirect()) {
				// true
				//System.out.println("\tC: 이동주소: " + forward.getPath());
				//System.out.println("\tC: 이동방법: sendRedirect() 방식");
				response.sendRedirect(forward.getPath());
			} else {
				// false
				//System.out.println("\tC: 이동주소: " + forward.getPath());
				//System.out.println("\tC: 이동방법: forward() 방식");
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
		//System.out.println("---------------3. 가상주소 이동 종료---------------");
		/************************3. 가상주소 이동 종료************************/
	
	
	
	
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
}
