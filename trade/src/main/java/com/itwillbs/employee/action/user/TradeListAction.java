package com.itwillbs.employee.action.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.EmployeeDAO;
import com.itwillbs.employee.dto.TradeDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class TradeListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		EmployeeDAO dao = new EmployeeDAO();
		ArrayList sellList = dao.tradeList("팝니다");
		ArrayList buyList = dao.tradeList("삽니다");
		
		request.setAttribute("sellList", sellList);
		request.setAttribute("buyList", buyList);
		
		forward.setPath("./employee/user/tradeList.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
