package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class MemberLogoutAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : MemberLogoutAction_execute() 호출 ");
		
		// 로그아웃 처리 => 세션의 정보를 초기화
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		// 페이지 이동(js) -> 메인페이지로 이동
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print(" alert('회원님의 정보가 안전하게 로그아웃 되었습니다!'); ");
		out.print(" location.href='../main/Main.com'; ");
		out.print("</script>");
		out.close();
		
//		컨트롤러 이동방식		
//		ActionForward forward = new ActionForward();
//		forward.setPath("./Main.me");
//		forward.setRedirect(true);
//		return forward;
		
		return null; // 이미 JS 페이지 이동을 완료, 컨트롤러 사용해서 페이지이동X
	}

}
