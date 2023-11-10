package com.itwillbs.employee.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** EmployeeChangePwAction : 관리자 비밀번호 변경 **/
/** 로그인 중이 아닐 때도 진행(request로 저장),
 *  로그인 되어 있을 경우, session으로 불러옴 **/

public class ChangePwAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDTO dto = new MemberDTO();
		HttpSession session = request.getSession();
		if(session.getAttribute("id") == null) {
			// 세션에 아이디가 없는 경우
			if(request.getParameter("id") == null) {
				// 아이디가 저장된 곳이 없을 때(session, request)
			}
			else {
				// request에 아이디가 저장되어 있을 때
				dto.setEmp_id(request.getParameter("id"));
			}
		}
		else {
			// 세션에 아이디가 있는 경우
			dto.setEmp_id((String)session.getAttribute("id"));
		}
		
		dto.setEmp_pw("current_pw");
		/*
		 비밀번호 변경 페이지에서 새로 변경할 비밀번호를
		 2번 입력할 때 일치하지 않을 시 넘어가지 않도록 함
		 */
		
		String new_pw = request.getParameter("new_pw");
		
		
		return null;
	}
}
