package com.itwillbs.employee.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** DeleteConfirmAction : 직원 계정 비활성화 확인 **/

public class DeleteConfirmAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String emp_id = request.getParameter("emp_id");
		request.setAttribute("emp_id", emp_id);

		ActionForward forward = new ActionForward();
		forward.setPath("./employee/member/deleteConfirm.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
