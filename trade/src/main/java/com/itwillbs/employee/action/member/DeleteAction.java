package com.itwillbs.employee.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.action.JSConfirmMoveFunction;
import com.itwillbs.employee.dao.MemberDAO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

/** EmployeeDeleteAction : 퇴사자 계정 삭제 **/

public class DeleteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDTO emp = new MemberDTO();
		MemberDTO ad = new MemberDTO();
		emp.setEmp_id(request.getParameter("emp_id"));
		ad.setEmp_id((String)request.getSession().getAttribute("emp_id"));
		ad.setEmp_pw(request.getParameter("emp_pw"));
		MemberDAO dao = new MemberDAO();
		int result = dao.employeeInactive(emp, ad);
		if(result == 1) {
			JSConfirmMoveFunction move = new JSConfirmMoveFunction();
			move.moveLocation(response, "./EmployeeDeleteConfirm.emp?emp_id=" + emp.getEmp_id());
		}
		else {
			JSMoveFunction move = new JSMoveFunction();
			move.alertBack(response, "오류 발생");
		}
		return null;
	}
}
