package com.itwillbs.employee.action.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.employee.dao.MemberDAO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

/** 관리자 로그인 액션 **/

public class LoginAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		
		// 관리자 정보 저장
		dto.setEmp_id(request.getParameter("emp_id"));
		dto.setEmp_pw(request.getParameter("emp_pw"));
		
		// 쿠키 등록 및 삭제
		String remember = request.getParameter("remember");
		Cookie[] cookies = request.getCookies();
		Cookie cookie;
		if (remember == null) {	// 사번 기억하기가 체크 해제된 경우
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("emp_id")) {
					// 쿠키의 시간 만료 시키기
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
					break;
				}
			}
		} else if (remember.equals("remember-me")) {
			// 사번 기억하기 체크된 경우
			cookie = new Cookie("emp_id", dto.getEmp_id());
			cookie.setMaxAge(60 * 60 * 24 * 365); // 1년동안 기억하기
			// 쿠키 등록
			response.addCookie(cookie);
		}
		
		// 데이터 조회
		int result = dao.loginEmployee(dto);
		ActionForward forward = null;
		if (result == 1) {
			// 아이디, 비밀번호 일치하는 경우
			HttpSession session = request.getSession();
			session.setAttribute("emp_id", dto.getEmp_id());
			forward = new ActionForward();
			forward.setPath("./Main.emp");
			forward.setRedirect(true);
			return forward;
		} else {
			// 아이디 또는 비밀번호가 다른 경우
			JSMoveFunction.alertBack(response, "아이디 또는 비밀번호 오류");
			return null;
		}
	}
}