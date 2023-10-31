package com.itwillbs.employee.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.member.db.EmployeeMemberDAO;
import com.itwillbs.employee.member.db.EmployeeMemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** EmployeeChangeProfileAction : 관리자(직원) 프로필 변경 **/

public class EmployeeChangeProfileAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		EmployeeMemberDTO dto = new EmployeeMemberDTO();
		EmployeeMemberDAO dao = new EmployeeMemberDAO();
		dto.setEmp_id(request.getParameter("emp_id"));
		dto.setEmp_pw(request.getParameter("emp_pw"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setAddress(request.getParameter("address"));
		dto.setTel(request.getParameter("tel"));
		dto.setImage(request.getParameter("image"));
		// 나중에 이미지 업로드 진행
		dao.changeProfile(dto);
		return null;
	}
}
