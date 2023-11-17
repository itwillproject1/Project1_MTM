package com.itwillbs.employee.action.complain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.ComplainDAO;
import com.itwillbs.employee.dto.UserDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

public class SuspendCancelFormAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDTO udto = new UserDTO();
		udto.setUser_id(request.getParameter("user_id"));
		request.setAttribute("dto", udto);
		ComplainDAO cdao = new ComplainDAO();
		boolean result = cdao.isSuspended(udto);

		if (!result) {
			// 정지처리되지 않은 경우
			JSMoveFunction move = new JSMoveFunction();
			move.alertBack(response, "정지처리 되지 않은 계정입니다!");
		}

		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/userSuspendCancelForm.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
