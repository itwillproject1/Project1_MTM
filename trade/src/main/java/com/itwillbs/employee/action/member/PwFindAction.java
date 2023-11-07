package com.itwillbs.employee.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dao.MemberDAO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class PwFindAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		
		dto.setEmp_id(request.getParameter("emp_id"));
		dto.setEmail(request.getParameter("email"));
		
		int result = dao.employePwFind(dto);
		ActionForward forward = null;
		if(result ==  1) {
			// 비밀번호 초기화 진행, 전화번호 뒷자리 4개
			// pw
			request.setAttribute("emp_id", dto.getEmp_id());
			request.setAttribute("emp_pw", dto.getEmp_pw());
			
		}
		else {
			// 비밀번호 찾기 페이지로 다시 이동
		}
		return null;
	}
}
