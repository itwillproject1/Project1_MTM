package com.itwillbs.employee.action.complain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.ComplainDAO;
import com.itwillbs.employee.dto.ComplainDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ComplainContentAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int bno = Integer.parseInt(request.getParameter("bno"));
		ComplainDAO dao = new ComplainDAO();
		ComplainDTO dto = dao.complainContent(bno);
		request.setAttribute("content", dto);
		request.setAttribute("pageNum", request.getParameter("pageNum"));
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/complainContent.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
