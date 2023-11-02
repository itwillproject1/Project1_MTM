package com.itwillbs.employee.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.employee.db.EmployeeMemberDAO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

public class EmployeeListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String emp_id = (String)session.getAttribute("emp_id");
		ActionForward forward = new ActionForward();
		JSMoveFunction move = new JSMoveFunction();
		if(emp_id == null) {
			System.out.println("로그인 되어 있지 않음");
			move.alertLocation(response, "로그인이 되어있지 않습니다!", "./Login.empm");
		}
		
		EmployeeMemberDAO dao = new EmployeeMemberDAO();
		
		ArrayList dList = dao.loadEmployeeList(1);
		if(dList.size() == 0) {
			System.out.println("직원 목록 없음");
			move.alertLocation(response, "직원 목록 없음", "./Main.empm");
		}
		else {
			int count = dList.size();
			// 1 페이지당 8개 표시;
			int pageCount = count/8 + count % 8 == 0? 0 : 1;
			String currentPage = request.getParameter("currentPage");
			if(currentPage == null) currentPage = "1";
			request.setAttribute("dList", dList);
		}
		return null;
	}
}
