package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

public class findidAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// System.out.println(" M : findidAction_execute() 호출");

		// 로그인 세션제어 HttpSession session = request.getSession();

		String jumin = request.getParameter("jumin1") + "-" + request.getParameter("jumin2") + "-"
				+ request.getParameter("jumin3");
		String phone = request.getParameter("phone1") + "-" + request.getParameter("phone2") + "-"
				+ request.getParameter("phone3");

		// 전달정보 저장(id,pw) -> DTO에 저장
		MemberDTO iddto = new MemberDTO();

		iddto.setUser_name(request.getParameter("user_name"));
		iddto.setJumin(jumin);
		iddto.setPhone(phone);

		// MemberDAO 객체 생성 - 회원정보 삭제 메서드
		MemberDAO dao = new MemberDAO();

		iddto = dao.findidmember(iddto);
		int result = dao.findidmember2(iddto);

		HttpSession session = request.getSession();
		session.setAttribute("iddto", iddto);

		if (result == 2) {

			JSMoveFunction.alertLocation(response, "아이디찾기 성공!", "../member/findidsuccess.jsp");
			return null;
		} else if (result == 1) {
			// 비밀번호 오류 실패
			JSMoveFunction.alertBack(response, "전화번호 오류");
			return null;
		} else if (result == 0) {
			// 비밀번호 오류 실패
			JSMoveFunction.alertBack(response, "생년월일 오류");
			return null;
		} else {
			// 아이디 없음
			JSMoveFunction.alertBack(response, "아이디 없음");
		}

		return null;
	}
}