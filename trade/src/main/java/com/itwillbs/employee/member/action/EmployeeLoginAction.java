package com.itwillbs.employee.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.employee.member.db.EmployeeMemberDAO;
import com.itwillbs.employee.member.db.EmployeeMemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

public class EmployeeLoginAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EmployeeMemberDAO dao = new EmployeeMemberDAO();
		EmployeeMemberDTO dto = new EmployeeMemberDTO();
		
		dto.setEmp_id(request.getParameter("emp_id"));
		dto.setEmp_pw(request.getParameter("emp_pw"));
		
		System.out.println(dto.getEmp_id() + ", " + dto.getEmp_pw());
		int result = dao.loginEmployee(dto);
		ActionForward forward = null;
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", dto.getEmp_id());
			forward = new ActionForward();
			forward.setPath("./main.empm");
			forward.setRedirect(true);
			return forward;
		}
		else {
			JSMoveFunction.alertHistory(response, "아이디 또는 비밀번호 오류");
			return null;
		}
	}
}