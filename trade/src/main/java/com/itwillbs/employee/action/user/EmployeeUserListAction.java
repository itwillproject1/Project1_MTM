package com.itwillbs.employee.action.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.db.dao.EmployeeDAO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class EmployeeUserListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String search = request.getParameter("search");
		String pageNum = request.getParameter("pageNum") == null? request.getParameter("pageNum") : "1";
		EmployeeDAO dao = new EmployeeDAO();
		ArrayList list = dao.userList();
		if(search == null) {
			list = dao.userList();
		}
		else {
			list = dao.userSearch(search);
		}
		ActionForward forward = new ActionForward();
		request.setAttribute("dto", list);
		forward.setPath("./employee/user/userList.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
