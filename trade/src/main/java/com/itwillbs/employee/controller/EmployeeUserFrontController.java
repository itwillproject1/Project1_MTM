package com.itwillbs.employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.action.EmployeeUserListAction;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

@WebServlet("*.empu")
public class EmployeeUserFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("C : EmployeeFrontController doProcess() 실행");
		System.out.println("C : GET/POST 동작 모두 처리");
		// ------------------가상주소 계산----------------
		System.out.println("\n1. 가상주소 계산 시작");
		// System.out.println(request.getRequestURL());
		String requestURI = request.getRequestURI();
		System.out.println("C : requestURI : " + requestURI);
		String CTXPath = request.getContextPath();
		System.out.println("C : CTXPath : " + CTXPath);
		String command = requestURI.substring(CTXPath.length());
		System.out.println("C : command : " + command);
		System.out.println("\n1. 가상주소 계산 끝");
		// ------------------가상주소 계산----------------
		
		// ------------------가상주소 매핑----------------
		System.out.println("\n2. 가상주소 매핑 시작");
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/UserList.empu")) {
			action = new EmployeeUserListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/UserInfo.empu")) {
			forward = new ActionForward();
			forward.setPath("./employee/user/userInfo.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		
		else if(command.equals("/InquiryList.empu")) {
			// 문의 신청한 회원 목록(완료 및 미완료 표시)
			// 검색 기능 필요
			// 클릭 시 상세 페이지 이동
			forward = new ActionForward();
			forward.setPath("./employee/user/inquiryList.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		else if(command.equals("/InquiryContent.empu")) {
			forward = new ActionForward();
			forward.setPath("./employee/user/inquiryContent.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		
		else if(command.equals("/InquiryAction.empu")) {
			
		}
		
		else if(command.equals("/ComplainList.empu")) {
			// 신고한 회원 목록(처리 완료 및 미완료 표시)
			// 클릭 시 상세 페이지 이동
			forward = new ActionForward();
			forward.setPath("./employee/user/complainList.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		
		else if(command.equals("/ComplainContent.empu")) {
			forward = new ActionForward();
			forward.setPath("./employee/user/complainContent.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		
		else if(command.equals("/ComplainAction.empu")) {
			
		}
		
		else if(command.equals("/TradeList.empu")) {
			// 거래 현황 표시
			// 클릭 시 상세 페이지 이동
			forward = new ActionForward();
			forward.setPath("./employee/user/tradeList.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		
		else if(command.equals("/TradeContent.empu")) {
			forward = new ActionForward();
			forward.setPath("./employee/user/tradeContent.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		
		else if(command.equals("/BoardList.empu")) {
			forward = new ActionForward();
			forward.setPath("./employee/user/boardList.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		else if(command.equals("/BoardContent.empu")) {
			forward = new ActionForward();
			forward.setPath("./employee/user/boardContent.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		else if(command.equals("/BoardWrite.empu")) {
			forward = new ActionForward();
			forward.setPath("./employee/user/boardWrite.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		else if(command.equals("/BoardWriteAction.empu")) {
			
		}
		// -- 회원 정보 조회 및 관리
				
		// ------------------가상주소 매핑----------------
		
		// ------------------가상주소 이동----------------
		System.out.println("\n3. 가상주소 이동 시작");
		if(forward != null) { // 이동 정보가 존재할 때
			if(forward.isRedirect()) {
				System.out.println("C : " + forward.getPath() + "로, 이동방식 : " + forward.isRedirect());
				response.sendRedirect(forward.getPath());
			}
			else {
				System.out.println("C : " + forward.getPath() + "로, 이동방식 : " + forward.isRedirect());
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
		System.out.println("\n3. 가상주소 이동 끝");
		// ------------------가상주소 이동----------------
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
