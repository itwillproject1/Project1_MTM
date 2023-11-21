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

public class findpwAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//	System.out.println(" M : findpwAction() 호출");

		
		  // 로그인 세션제어 HttpSession session = request.getSession();

		String user_name = request.getParameter("user_name");
		String user_id = request.getParameter("user_id");
	//	System.out.println("설마 너" + user_name);
		// 전달정보 저장(id,pw) -> DTO에 저장
		MemberDTO pwdto = new MemberDTO();
		
		pwdto.setUser_name(user_name);
		pwdto.setUser_id(user_id);

		// MemberDAO 객체 생성 - 회원정보 삭제 메서드
		MemberDAO dao = new MemberDAO();

		pwdto = dao.findpwmember(pwdto);
		int result= dao.findpwmember2(pwdto);
		
		HttpSession session = request.getSession();
		session.setAttribute("pwdto", pwdto);
		
		
		
		
		if(result == 1) {
			
			JSMoveFunction.alertLocation(response, "비밀번호찾기 성공!", "../member/findpwsuccess.jsp");
			return null;
		}else if(result == 0) {
			// 비밀번호 오류 실패
			JSMoveFunction.alertBack(response, "아이디가 맞지않습니다");
			return null;
		}else if(result == -1) {
			// 비밀번호 오류 실패
			JSMoveFunction.alertBack(response, "이름이 맞지않습니다.");
			return null;
		}
		
		
		
		return null;
		

	}
	
}