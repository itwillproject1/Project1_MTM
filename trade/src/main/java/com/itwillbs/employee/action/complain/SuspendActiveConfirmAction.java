package com.itwillbs.employee.action.complain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dto.UserDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** SuspendActiveConfirmAction : 정지처리 완료 페이지 **/

public class SuspendActiveConfirmAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDTO dto = new UserDTO();
		dto.setUser_id(request.getParameter("user_id"));

		request.setAttribute("dto", dto);
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/userSuspendActiveConfirm.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
