package com.itwillbs.employee.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class BoardDeleteConfirmAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String bno = request.getParameter("bno");
		String subject = request.getParameter("subject");
		
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/boardDeleteConfirm.jsp");
		forward.setRedirect(false);
		request.setAttribute("subject", subject);
		request.setAttribute("bno", bno);
		return forward;
	}
}
