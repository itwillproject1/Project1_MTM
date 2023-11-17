package com.itwillbs.employee.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.action.JSConfirmMoveFunction;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class LogoutAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().removeAttribute("emp_id");

		JSConfirmMoveFunction.moveLocation(response, "./Main.emp");
		return null;
	}
}
