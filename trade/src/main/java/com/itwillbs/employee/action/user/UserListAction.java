package com.itwillbs.employee.action.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dao.UserDAO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class UserListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String search = request.getParameter("search");
		int pageNum;
		if(request.getParameter("pageNum") == null) pageNum = 1;
		else pageNum = Integer.parseInt(request.getParameter("pageNum"));
		UserDAO dao = new UserDAO();
		ArrayList list = null;
		int userCount = dao.userCount();
		int columns = 8;
		int totalPage = userCount%columns == 0? userCount/columns : (userCount/columns)+1;
		// select * from Member limit pageNum, columns;
		if(search == null) {
			list = dao.userList();
		}
		else {
			list = dao.userSearch(search);
		}
		ActionForward forward = new ActionForward();
		request.setAttribute("dto", list);
		request.setAttribute("pageNum", pageNum);
		forward.setPath("./employee/user/userList.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
