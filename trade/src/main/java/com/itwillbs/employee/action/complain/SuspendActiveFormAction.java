package com.itwillbs.employee.action.complain;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.ComplainDAO;
import com.itwillbs.employee.dto.UserDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

/** SuspendActiveFormAction : 정지 처리 폼 페이지 **/

public class SuspendActiveFormAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDTO udto = new UserDTO();
		udto.setUser_id(request.getParameter("user_id"));
		ComplainDAO cdao = new ComplainDAO();
		boolean result = cdao.isSuspended(udto);

		if (result) {
			// 이미 정지 상태인 경우
			JSMoveFunction.alertBack(response, "이미 정지처리 된 계정입니다!");
		}

		ArrayList complainList = cdao.userInfoComplain(udto);
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/userSuspendActiveForm.jsp");
		forward.setRedirect(false);
		request.setAttribute("dto", udto);
		request.setAttribute("list", complainList);
		return forward;
	}
}
