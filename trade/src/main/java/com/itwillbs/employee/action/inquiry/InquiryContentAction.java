package com.itwillbs.employee.action.inquiry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.InquiryDAO;
import com.itwillbs.employee.dao.UserDAO;
import com.itwillbs.employee.dto.InquiryDTO;
import com.itwillbs.employee.dto.UserDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** InquiryContentAction : 문의글 조회 **/

public class InquiryContentAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		InquiryDAO idao = new InquiryDAO();
		InquiryDTO idto = idao.inquiryContent(Integer.parseInt(request.getParameter("bno")));
		UserDAO udao = new UserDAO();
		UserDTO udto = udao.userInfo(idto.getUser_id());
		request.setAttribute("udto", udto);
		request.setAttribute("idto", idto);
		request.setAttribute("pageNum", request.getParameter("pageNum"));
		request.setAttribute("complete", request.getParameter("complete"));
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/inquiryContent.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
