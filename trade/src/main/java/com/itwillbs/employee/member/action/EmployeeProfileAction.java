package com.itwillbs.employee.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.employee.member.db.EmployeeMemberDAO;
import com.itwillbs.employee.member.db.EmployeeMemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;


/**
 	EmployeeProfileAction : 직원 프로필 조회
 * */

public class EmployeeProfileAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EmployeeMemberDAO dao = new EmployeeMemberDAO();
		
		// 세션에서 로그인 중인 아이디 불러오기
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		ActionForward forward = new ActionForward();
		
		// 로그인 중이 아닌 경우 로그인으로 이동
		if(id == null) {
			forward.setPath("./login.emp");
			forward.setRedirect(true);
			return forward;
		}
		
		EmployeeMemberDTO  dto = dao.loadProfile(id);
		// 프로필 정보를 request에 저장
		request.setAttribute("profile", dto);
		
		// profile.emp 이동
		forward.setPath("./profile.emp");
		forward.setRedirect(false);
		
		return null;
	}
}
