package com.itwillbs.employee.action.mail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class EmployeeMailSendConfirm implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String result = request.getParameter("result");
		request.setAttribute("result", result);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/mail/mailSendConfirm.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
