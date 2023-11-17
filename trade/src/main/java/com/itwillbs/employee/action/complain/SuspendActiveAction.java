package com.itwillbs.employee.action.complain;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.action.JSConfirmMoveFunction;
import com.itwillbs.employee.dao.ComplainDAO;
import com.itwillbs.employee.dto.ComplainDTO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.employee.dto.SuspendDTO;
import com.itwillbs.employee.dto.UserDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

/** SuspendedActiveAction : 피신고자 정지처리 **/

public class SuspendActiveAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDTO udto = new UserDTO();
		udto.setUser_id(request.getParameter("user_id"));
		MemberDTO mdto = new MemberDTO();
		mdto.setEmp_id((String) request.getSession().getAttribute("emp_id"));
		mdto.setEmp_pw(request.getParameter("emp_pw"));
		String[] checkComplain = request.getParameterValues("complainCheck");
		if (checkComplain == null) {
			JSMoveFunction move = new JSMoveFunction();
			move.alertBack(response, "선택된 신고 내역이 없습니다!");
		}
		ArrayList<Integer> complainIndex = new ArrayList<Integer>();
		for (int i = 0; i < checkComplain.length; i++) {
			complainIndex.add(Integer.parseInt(checkComplain[i]));
		}
		String suspendReason = request.getParameter("suspendReason");
		String susDays = request.getParameter("sus_days");
		int sus_days = 0;
		ComplainDAO dao = new ComplainDAO();
		if (suspendReason == null || susDays == null) {
			JSMoveFunction move = new JSMoveFunction();
			move.alertBack(response, "정지 일수 및 정지 사유 오류");
		} else {
			sus_days = Integer.parseInt(susDays);
		}
		int result = dao.userSuspendActive(udto, mdto, complainIndex, sus_days, suspendReason);
		if (result == 1) {
			JSConfirmMoveFunction move = new JSConfirmMoveFunction();
			move.moveLocation(response, "./UserSuspendActiveConfirm.emp?user_id=" + udto.getUser_id());
		} else {
			JSMoveFunction move = new JSMoveFunction();
			move.alertBack(response, "오류 발생");
		}
		return null;
	}
}
