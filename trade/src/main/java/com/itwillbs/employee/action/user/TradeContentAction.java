package com.itwillbs.employee.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.EmployeeDAO;
import com.itwillbs.employee.dto.TradeDTO;
import com.itwillbs.employee.dto.UserDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class TradeContentAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		int bno = Integer.parseInt(request.getParameter("bno"));
		EmployeeDAO dao = new EmployeeDAO();
		TradeDTO tdto = dao.tradeContent(bno);
		request.setAttribute("tdto", tdto);
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/tradeContent.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
