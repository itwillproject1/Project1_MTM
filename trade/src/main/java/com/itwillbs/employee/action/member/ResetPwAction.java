package com.itwillbs.employee.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.employee.dao.MemberDAO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** EmployeeChangePwAction : 관리자 비밀번호 변경 **/
/** 로그인 중이 아닐 때도 진행(request로 저장),
 *  로그인 되어 있을 경우, session으로 불러옴 **/

public class ResetPwAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDTO dto = new MemberDTO();
		dto.setEmp_id(request.getParameter("emp_id"));
		dto.setEmail(request.getParameter("email"));
		MemberDAO dao = new MemberDAO();
		int result = dao.resetPw(dto);
		if(result == 1) {
			
		}
		else {
			
		}
		return null;
	}
}
