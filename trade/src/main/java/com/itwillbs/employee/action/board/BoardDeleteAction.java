package com.itwillbs.employee.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.employee.dao.BoardDAO;
import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dto.BoardDTO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class BoardDeleteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao = new BoardDAO();
		BoardDTO bdto = new BoardDTO();
		int bno = Integer.parseInt(request.getParameter("bno"));
		bdto.setBno(bno);
		HttpSession session = request.getSession();
		MemberDTO mdto = new MemberDTO();
		mdto.setEmp_id((String)session.getAttribute("emp_id"));
		mdto.setEmp_pw(request.getParameter("emp_pw"));
		int result = dao.deleteBoard(bdto, mdto);
		if(result == 1) {
			// 삭제 완료
		}
		else {
			// 삭제 안 됨
		}
		return null;
	}
}
