package com.itwillbs.employee.action.inquiry;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dao.InquiryDAO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class InquiryListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		InquiryDAO dao = new InquiryDAO();
		ArrayList iList = dao.inquiryList(Integer.parseInt(pageNum));
		
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/inquiryList.jsp");
		forward.setRedirect(false);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("list", iList);
		return forward;
	}
}
