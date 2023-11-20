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
		String size = request.getParameter("size");
		if(size == null);
		else result += " 외 " + (Integer.parseInt(size) - 1) + "명";
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/mail/mailSendConfirm.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
