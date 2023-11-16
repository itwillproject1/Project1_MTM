package com.itwillbs.employee.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.action.JSConfirmMoveFunction;
import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dao.MemberDAO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

/** EmployeeChangeProfileAction : 관리자(직원) 프로필 변경 **/

public class ProfileChangeAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		dto.setEmp_id((String)request.getSession().getAttribute("emp_id"));
		dto.setEmp_pw(request.getParameter("past_pw"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setAddress(request.getParameter("address"));
		dto.setTel(request.getParameter("tel"));
		
		String new_pw = request.getParameter("new_pw");
		String confirm_pw = request.getParameter("confirm_pw");
		
		int result = dao.changeProfile(dto, new_pw, confirm_pw);
		
		if(result == 1) {
			JSConfirmMoveFunction move = new JSConfirmMoveFunction();
			move.moveLocation(response, "./ProfileContent.emp?emp_id=" + dto.getEmp_id());
		}
		else {
			JSMoveFunction move = new JSMoveFunction();
			move.alertBack(response, "오류 발생");
		}
		return null;
	}
}
