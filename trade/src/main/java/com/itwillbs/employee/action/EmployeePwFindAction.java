package com.itwillbs.employee.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.db.dao.EmployeeDAO;
import com.itwillbs.employee.db.dto.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class EmployeePwFindAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDTO dto = new MemberDTO();
		EmployeeDAO dao = new EmployeeDAO();
		
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
