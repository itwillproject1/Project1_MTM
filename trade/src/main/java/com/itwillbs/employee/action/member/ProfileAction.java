package com.itwillbs.employee.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dao.MemberDAO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;


/**
 	EmployeeProfileAction : 직원 프로필 조회
 * */

public class ProfileAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = new MemberDAO();
		
		// 세션에서 로그인 중인 아이디 불러오기
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("emp_id");
		
		ActionForward forward = new ActionForward();
		
		MemberDTO  dto = dao.loadProfile(id);
		// 프로필 정보를 request에 저장
		request.setAttribute("dto", dto);
		
		// profile.emp 이동
		forward.setPath("./employee/member/profileContent.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
}
