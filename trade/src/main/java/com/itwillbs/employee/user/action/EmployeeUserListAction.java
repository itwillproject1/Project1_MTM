package com.itwillbs.employee.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class EmployeeUserListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNum = request.getParameter("pageNum") == null? request.getParameter("pageNum") : "1";
		
		
		ActionForward forward = new ActionForward();
		return forward;
	}
}
