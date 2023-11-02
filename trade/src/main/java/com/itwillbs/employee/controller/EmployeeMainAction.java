package com.itwillbs.employee.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.db.EmployeeBoardDAO;
import com.itwillbs.employee.db.EmployeeUserDAO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class EmployeeMainAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		EmployeeUserDAO udao = new EmployeeUserDAO();
		EmployeeBoardDAO bdao = new EmployeeBoardDAO();
		
		int userCount = udao.userCount();
		//ArrayList tradeList = bdao.
		return forward;
	}
}
