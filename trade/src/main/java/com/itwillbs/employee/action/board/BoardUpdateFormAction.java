package com.itwillbs.employee.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.BoardDAO;
import com.itwillbs.employee.dto.BoardDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** BoardDeleteFormAction : 게시판 수정 폼 **/

public class BoardUpdateFormAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int bno = Integer.parseInt(request.getParameter("bno"));
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.boardContent(bno);

		request.setAttribute("dto", dto);
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/boardUpdateForm.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
