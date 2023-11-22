package com.itwillbs.employee.action.complain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.action.JSConfirmMoveFunction;
import com.itwillbs.employee.dao.ComplainDAO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.employee.dto.UserDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

/** SuspendedCancelAction : 피신고자 정지 취소 **/

public class SuspendCancelAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 회원 정보 저장
		UserDTO udto = new UserDTO();
		udto.setUser_id(request.getParameter("user_id"));
		
		// 관리자 정보 저장(아이디 및 비밀번호 조회 -> 다를 시 false 처리)
		MemberDTO mdto = new MemberDTO();
		mdto.setEmp_id((String) request.getSession().getAttribute("emp_id"));
		mdto.setEmp_pw(request.getParameter("emp_pw"));

		ComplainDAO dao = new ComplainDAO();
		// 회원 정지 취소 처리
		int result = dao.userSuspendCancel(udto, mdto);
		if (result == 1) {
			// 정지 취소완료
			JSConfirmMoveFunction.moveLocation(response, "./UserSuspendCancelConfirm.emp?user_id=" + udto.getUser_id());
		} else {
			// 오류
			JSMoveFunction.alertBack(response, "오류 발생");
		}
		return null;
	}
}
