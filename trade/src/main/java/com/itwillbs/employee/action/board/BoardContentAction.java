package com.itwillbs.employee.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.BoardDAO;
import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dto.BoardDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** BoardContentAction : 게시판 정보 불러오기 **/
public class BoardContentAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao = new BoardDAO();
		int bno = Integer.parseInt(request.getParameter("bno"));
		BoardDTO dto = dao.boardContent(bno);
		request.setAttribute("dto", dto);
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/boardContent.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
