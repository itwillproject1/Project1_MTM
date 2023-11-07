package com.itwillbs.employee.action.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dao.MemberDAO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

public class ListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/member/employeeList.jsp");
		forward.setRedirect(false);
		
		MemberDAO dao = new MemberDAO();
		ArrayList empList = dao.loadEmployeeList(1);
		return forward;
	}
}
