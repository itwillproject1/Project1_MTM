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
		// 정지 처리할 유저 정보 저장
		udto.setUser_id(request.getParameter("user_id"));
		
		MemberDTO mdto = new MemberDTO();
		// 정지 처리 진행하는 직원 정보 저장
		mdto.setEmp_id((String) request.getSession().getAttribute("emp_id"));
		mdto.setEmp_pw(request.getParameter("emp_pw"));
		
		// 처리 완료될 신고 개수 계산
		String[] checkComplain = request.getParameterValues("complainCheck");
		if (checkComplain == null) {
			JSMoveFunction.alertBack(response, "선택된 신고 내역이 없습니다!");
		}
		
		// 처리 완료될 신고 정보 저장
		ArrayList<Integer> complainIndex = new ArrayList<Integer>();
		for (int i = 0; i < checkComplain.length; i++) {
			complainIndex.add(Integer.parseInt(checkComplain[i]));
		}
		
		// 정지 사유
		String suspendReason = request.getParameter("suspendReason");
		
		// 정지 기간
		String susDays = request.getParameter("sus_days");
		int sus_days = 0;
		
		ComplainDAO dao = new ComplainDAO();
		if (suspendReason == null || susDays == null) {
			// 만약 정지 일수나 정지 사유가 입력이 되지 않았을 때
			JSMoveFunction.alertBack(response, "정지 일수 및 정지 사유 오류");
		} else {
			// 정지 일수 int로 저장
			sus_days = Integer.parseInt(susDays);
		}
		
		// 정지 결과
		int result = dao.userSuspendActive(udto, mdto, complainIndex, sus_days, suspendReason);
		
		if (result == 1) {
			// 정지 완료 처리
			JSConfirmMoveFunction.moveLocation(response, "./UserSuspendActiveConfirm.emp?user_id=" + udto.getUser_id());
		} else {
			// 오류
			JSMoveFunction.alertBack(response, "오류 발생");
		}
		return null;
	}
}
