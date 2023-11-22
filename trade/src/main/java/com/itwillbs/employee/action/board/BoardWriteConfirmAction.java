package com.itwillbs.employee.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dto.BoardDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** BoardWriteConfirmAction : 작성 확인 페이지 **/

public class BoardWriteConfirmAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDTO dto = new BoardDTO();
		dto.setSubject(request.getParameter("subject"));

		request.setAttribute("dto", dto);

		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/boardWriteConfirm.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
