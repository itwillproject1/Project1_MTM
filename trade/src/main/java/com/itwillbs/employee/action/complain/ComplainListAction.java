package com.itwillbs.employee.action.complain;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.EmployeeDAO;
import com.itwillbs.employee.dto.ComplainDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ComplainListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		EmployeeDAO dao = new EmployeeDAO();
		ArrayList compList = dao.complainList(Integer.parseInt(pageNum));
		
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/complainList.jsp");
		forward.setRedirect(false);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("list", compList);
		return forward;
	}
}
