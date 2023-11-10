package com.itwillbs.employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.action.EmployeeMainAction;
import com.itwillbs.employee.action.complain.ComplainAction;
import com.itwillbs.employee.action.complain.ComplainContentAction;
import com.itwillbs.employee.action.complain.ComplainListAction;
import com.itwillbs.employee.action.inquiry.InquiryAction;
import com.itwillbs.employee.action.inquiry.InquiryContentAction;
import com.itwillbs.employee.action.inquiry.InquiryListAction;
import com.itwillbs.employee.action.member.ChangeProfileAction;
import com.itwillbs.employee.action.member.ChangePwAction;
import com.itwillbs.employee.action.member.DeleteAction;
import com.itwillbs.employee.action.member.ListAction;
import com.itwillbs.employee.action.member.LoginAction;
import com.itwillbs.employee.action.member.ProfileAction;
import com.itwillbs.employee.action.member.RegisterAction;
import com.itwillbs.employee.action.user.TradeContentAction;
import com.itwillbs.employee.action.user.TradeListAction;
import com.itwillbs.employee.action.user.UserInfoAction;
import com.itwillbs.employee.action.user.UserListAction;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

@WebServlet("*.emp")
public class EmployeeFrontController extends HttpServlet{
	
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
		
		if(command.equals("/Main.emp")) {
			// 메인 페이지(관리자)
			// 추가 정보 표시(1일당 접속자(기간), 거래 목록, 최근 신고목록, 문의사항 표시)
			action = new EmployeeMainAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// -- 관리자 정보 관련
		else if(command.equals("/Login.emp")) {
			// 로그인 페이지(처음 이동할 때 session 조회하고 이동 예정)
			forward = new ActionForward();
			forward.setPath("./employee/member/login.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		
		else if(command.equals("/LoginAction.emp")) {
			// 로그인 액션(DB 사용 및 메인 페이지 이동 진행)
			action = new LoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if(command.equals("/ChangePwForm.emp")) {
			// 비밀번호 변경 페이지(관리자)
			forward = new ActionForward();
			forward.setPath("./employee/member/changePwForm.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		
		else if(command.equals("/ChangePwAction.emp")) {
			// 비밀번호 변경 실행(로그인 페이지로 이동)
			action = new ChangePwAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/EmployeeList.emp")) {
			action = new ListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/MemberProfile.emp")) {
			// 프로필 상세 보기(직원)
			action = new ProfileAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/ProfileChangeForm.emp")) {
			// 프로필 편집 페이지(관리자)
			action = new ProfileAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/ProfileChangeAction.emp")) {
			// 프로필 편집 실행(관리자)
			action = new ChangeProfileAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if(command.equals("/EmployeeRegisterForm.emp")) {
			// 직원 추가 폼
			forward = new ActionForward();
			forward.setPath("./employee/member/registerForm.jsp");
			forward.setRedirect(false);
		}
		
		else if(command.equals("/EmployeeRegisterAction.emp")) {
			// 직원 추가 진행
			action = new RegisterAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/EmployeeDeleteForm.emp")) {
			// 직원 삭제 폼
			forward = new ActionForward();
			forward.setPath("./employee/member/deleteForm.jsp");
			forward.setRedirect(false);
		}
		
		else if(command.equals("/EmployeeDeleteAction.emp")) {
			// 직원 삭제 진행
			action = new DeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// -- 관리자 정보 관련
		
		// -- 회원 정보 조회 및 관리
		else if(command.equals("/UserList.emp")) {
			action = new UserListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/UserInfo.emp")) {
			action = new UserInfoAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/InquiryList.emp")) {
			// 문의 신청한 회원 목록(완료 및 미완료 표시)
			// 검색 기능 필요
			// 클릭 시 상세 페이지 이동
			action = new InquiryListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/InquiryContent.emp")) {
			// 문의 신청 글 조회, 답글 작성 가능
			action = new InquiryContentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/InquiryAction.emp")) {
			action = new InquiryAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/ComplainList.emp")) {
			// 신고한 회원 목록(처리 완료 및 미완료 표시)
			// 클릭 시 상세 페이지 이동
			action = new ComplainListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/ComplainContent.emp")) {
			action = new ComplainContentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/ComplainAction.emp")) {
			action = new ComplainAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/TradeList.emp")) {
			// 거래 현황 표시
			// 클릭 시 상세 페이지 이동
			action = new TradeListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/TradeContent.emp")) {
			action = new TradeContentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/BoardList.emp")) {
			forward = new ActionForward();
			forward.setPath("./employee/user/boardList.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		
		else if(command.equals("/BoardContent.emp")) {
			forward = new ActionForward();
			forward.setPath("./employee/user/boardContent.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		
		else if(command.equals("/BoardWrite.emp")) {
			forward = new ActionForward();
			forward.setPath("./employee/user/boardWrite.jsp");
			forward.setRedirect(false);
			System.out.println("C : " + forward);
		}
		
		else if(command.equals("/BoardWriteAction.emp")) {
			
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
	protected void doGet
	(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	@Override
	protected void doPost
	(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}
}
