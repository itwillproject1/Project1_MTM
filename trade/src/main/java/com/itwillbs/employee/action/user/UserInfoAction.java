package com.itwillbs.employee.action.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dao.TradeDAO;
import com.itwillbs.employee.dao.UserDAO;
import com.itwillbs.employee.dto.BoardDTO;
import com.itwillbs.employee.dto.UserDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class UserInfoAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDAO udao = new UserDAO();
		TradeDAO tdao = new TradeDAO();
		UserDTO udto = new UserDTO();
		BoardDTO bdto = new BoardDTO();
		udto = udao.userInfo(request.getParameter("user_id"));
		ArrayList bList = tdao.tradeSearch("user_id", udto.getUser_id(), 1, 3);
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/userInfo.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
