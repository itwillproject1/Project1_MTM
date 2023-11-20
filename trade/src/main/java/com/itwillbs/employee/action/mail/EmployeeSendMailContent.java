package com.itwillbs.employee.action.mail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.MailDAO;
import com.itwillbs.employee.dto.MailDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** EmployeeSendMailContent() : 발송된 메일 컨텐츠 불러오기 **/

public class EmployeeSendMailContent implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int bno = Integer.parseInt(request.getParameter("bno"));
		MailDAO dao = new MailDAO();
		MailDTO dto = dao.mailContent(bno);
		
		request.setAttribute("dto", dto);
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/mail/mailContent.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
