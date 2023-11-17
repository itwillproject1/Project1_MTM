package com.itwillbs.employee.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.MemberDAO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

/** 관리자 회원가입(admin만 가능) **/

public class RegisterAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDTO dto = new MemberDTO();
		request.setCharacterEncoding("UTF-8");
		dto.setEmp_id(request.getParameter("emp_id"));
		dto.setEmp_pw(request.getParameter("emp_pw"));
		dto.setEmail(request.getParameter("email"));
		dto.setAddress(request.getParameter("address"));
		dto.setTel(request.getParameter("tel"));
		dto.setName(request.getParameter("name"));

		MemberDAO dao = new MemberDAO();
		dao.employeeRegister(dto);
		JSMoveFunction move = new JSMoveFunction();
		move.alertLocation(response, "직원 추가 완료", "./Main.emp");
		return null;
	}
}
