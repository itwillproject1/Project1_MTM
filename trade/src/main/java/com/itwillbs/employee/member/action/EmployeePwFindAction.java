package com.itwillbs.employee.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.member.db.EmployeeMemberDAO;
import com.itwillbs.employee.member.db.EmployeeMemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class EmployeePwFindAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EmployeeMemberDTO dto = new EmployeeMemberDTO();
		EmployeeMemberDAO dao = new EmployeeMemberDAO();
		
		dto.setEmp_id(request.getParameter("emp_id"));
		dto.setEmail(request.getParameter("email"));
		
		int result = dao.employePwFind(dto);
		ActionForward forward = null;
		if(result ==  1) {
			// 비밀번호 변경 페이지로 이동
			request.setAttribute("emp_id", dto.getEmp_id());
			request.setAttribute("emp_pw", dto.getEmp_pw());
		}
		else {
			// 비밀번호 찾기 페이지로 다시 이동
		}
		return null;
	}
}
