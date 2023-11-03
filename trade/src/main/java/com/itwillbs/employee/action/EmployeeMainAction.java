package com.itwillbs.employee.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.db.dao.EmployeeDAO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class EmployeeMainAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		EmployeeDAO dao = new EmployeeDAO();
		
		int userCount = dao.userCount();
		int tradeCount = dao.tradeCount();
		ArrayList tradeList = dao.tradeList(10);
		request.setAttribute("userCount", userCount);
		request.setAttribute("tradeCount", tradeCount);
		request.setAttribute("tradeList", tradeList);
		System.out.println(tradeList.size());
		forward.setPath("./employee/main.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
