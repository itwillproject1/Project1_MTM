package com.itwillbs.employee.action.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.EmployeeDAO;
import com.itwillbs.employee.dto.BoardDTO;
import com.itwillbs.employee.dto.UserDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class UserInfoAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		UserDTO udto = new UserDTO();
		BoardDTO bdto = new BoardDTO();
		udto = dao.userInfo(request.getParameter("user_id"));
		ArrayList bList = dao.tradeSearch("user_id", udto.getUser_id(), 1, 3);
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/userInfo.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
