package com.itwillbs.employee.action.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.BoardDAO;
import com.itwillbs.employee.dao.DAO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class BoardListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		BoardDAO dao = new BoardDAO();
		ArrayList bList = dao.boardList(Integer.parseInt(pageNum));
		
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/boardList.jsp");
		forward.setRedirect(false);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("list", bList);
		return forward;
	}
}
