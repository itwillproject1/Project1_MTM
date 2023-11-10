package com.itwillbs.employee.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.BoardDAO;
import com.itwillbs.employee.dto.BoardDTO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class BoardUpdateAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		BoardDTO bdto = new BoardDTO();
		bdto.setBno(Integer.parseInt(request.getParameter("bno")));
		bdto.setCategory(request.getParameter("category"));
		bdto.setContent(request.getParameter("content"));
		bdto.setSubject(request.getParameter("subject"));
		bdto.setImage(request.getParameter("image"));
		MemberDTO udto = new MemberDTO();
		udto.setEmp_pw(request.getParameter("emp_pw"));
		udto.setEmp_id((String)request.getSession().getAttribute("emp_id"));
		BoardDAO dao = new BoardDAO();
		int result = dao.updateBoard(bdto, udto);
		if(result == 1) {
			// 글 컨텐츠로 다시 이동
		}
		else {
			// history.back();
		}
		return null;
	}
}
