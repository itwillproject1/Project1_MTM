package com.itwillbs.employee.action.inquiry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.InquiryDAO;
import com.itwillbs.employee.dto.InquiryDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class InquiryContentAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		InquiryDAO dao = new InquiryDAO();
		InquiryDTO dto = dao.inquiryContent(Integer.parseInt(request.getParameter("bno")));
		request.setAttribute("pageNum", request.getParameter("pageNum"));
		request.setAttribute("complete", request.getParameter("complete"));
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/inquiryContent.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
