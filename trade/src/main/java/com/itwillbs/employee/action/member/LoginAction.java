package com.itwillbs.employee.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dao.MemberDAO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

public class LoginAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		
		dto.setEmp_id(request.getParameter("emp_id"));
		dto.setEmp_pw(request.getParameter("emp_pw"));
		
		System.out.println(dto.getEmp_id() + ", " + dto.getEmp_pw());
		int result = dao.loginEmployee(dto);
		ActionForward forward = null;
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("emp_id", dto.getEmp_id());
			forward = new ActionForward();
			forward.setPath("./Main.emp");
			forward.setRedirect(true);
			return forward;
		}
		else {
			JSMoveFunction.alertBack(response, "아이디 또는 비밀번호 오류");
			return null;
		}
	}
}