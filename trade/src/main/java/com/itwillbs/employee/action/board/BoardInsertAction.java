package com.itwillbs.employee.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.BoardDAO;
import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dto.BoardDTO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class BoardInsertAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDTO bdto = new BoardDTO();
		MemberDTO mdto = new MemberDTO();
		bdto.setCategory(request.getParameter("category"));
		bdto.setContent(request.getParameter("content"));
		bdto.setImage(request.getParameter("image"));
		bdto.setSubject(request.getParameter("subject"));
		
		mdto.setEmp_id((String)request.getSession().getAttribute("emp_id"));
		mdto.setEmp_pw(request.getParameter("emp_pw"));
		BoardDAO dao = new BoardDAO();
		int result = dao.insertBoard(bdto, mdto);
		return null;
	}
}
