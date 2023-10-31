package com.itwillbs.employee.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/**
 * EmployeeFrontController
 * 		직원(Employee)과 관련한 모든 작업을 수행하는 컨트롤러
 * */

//@WebServlet("*.empm")
public class EmployeeMemberFrontController extends HttpServlet{
	
	// HttpServlet 진행 함수
	protected void doProcess
	(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
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
		
		// -- 메인 페이지
		if(command.equals("/main.empm")) {
			// 메인 페이지(관리자)
			// 추가 정보 표시(1일당 접속자(기간), 거래 목록, 최근 신고목록, 문의사항 표시)
			forward = new ActionForward();
			forward.setPath("./employee/main.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		
		// -- 관리자 정보 관련
		else if(command.equals("/login.empm")) {
			// 로그인 페이지(처음 이동할 때 session 조회하고 이동 예정)
			forward = new ActionForward();
			forward.setPath("./employee/member/login.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		
		else if(command.equals("/loginAction.empm")) {
			// 로그인 액션(DB 사용 및 메인 페이지 이동 진행)
			action = new EmployeeLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/findPwForm.empm")) {
			// 비밀번호 찾기 폼
			forward = new ActionForward();
			forward.setPath("./employee/member/findPwForm.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		
		else if(command.equals("/findPwAction.empm")) {
			// 비밀번호 찾기 실행
			// 이메일과 아이디 조회 후 
			// 일치하지 않으면 이전 페이지로 이동
			action = new EmployeePwFindAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/changePwForm.empm")) {
			// 비밀번호 변경 페이지(관리자)
			forward = new ActionForward();
			forward.setPath("./emloyee/member/findPwForm.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		
		else if(command.equals("/changePwAction.empm")) {
			// 비밀번호 변경 실행(로그인 페이지로 이동)
			action = new EmployeeChangePwAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/profile.empm")) {
			// 프로필 조회(관리자)
			forward = new ActionForward();
			forward.setPath("./employee/member/profile.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		
		else if(command.equals("/profileChangeForm.empm")) {
			// 프로필 편집 페이지(관리자)
			action = new EmployeeProfileAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/profileChangeAction.empm")) {
			// 프로필 편집 실행(관리자)
			action = new EmployeeChangeProfileAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// -- 관리자 정보 관련
		
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
	
	// HttpServlet 기본(doPost, doGet)
	
	@Override
	protected void doPost
	(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	@Override
	protected void doGet
	(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}
}
