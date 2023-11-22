package com.itwillbs.employee.action.complain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dto.UserDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** SuspendCancelConfirmAction : 피신고자 정지 취소 확인 **/

public class SuspendCancelConfirmAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDTO dto = new UserDTO();
		dto.setUser_id(request.getParameter("user_id"));

		request.setAttribute("dto", dto);
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/userSuspendCancelConfirm.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
