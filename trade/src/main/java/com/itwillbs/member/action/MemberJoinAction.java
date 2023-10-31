package com.itwillbs.member.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;


public class MemberJoinAction implements Action  {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println(" M : MemberJoinAction_execute() 실행 ");
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		// 전달정보
		MemberDTO dto = new MemberDTO();
		dto.setUser_id(request.getParameter("user_id"));
		dto.setPassword(request.getParameter("password"));
		dto.setPasswordcheck(request.getParameter("passwordcheck"));
		dto.setEmail(request.getParameter("email"));
		dto.setUser_name(request.getParameter("user_name"));
		dto.setJumin(request.getParameter("jumin"));
		dto.setGender(request.getParameter("gender"));
		dto.setPhone(request.getParameter("phone"));
		dto.setAddress(request.getParameter("address"));
		dto.setUser_nickname(request.getParameter("user_nickname"));
		dto.setProfile(request.getParameter("profile"));
		dto.setRecommend(request.getParameter("recommend"));
		dto.setAgree(request.getParameter("agree"));
		
		System.out.println(" M : "+dto);
		MemberDAO dao = new MemberDAO();
		dao.insertMember(dto);
		
		// 페이지 이동(로그인페이지) => 컨트롤러에서만 가능
		ActionForward forward = new ActionForward();
		forward.setPath("./MemberMain.com");
		forward.setRedirect(true);	
		
		System.out.println(" M : "+forward);
		
		return forward;
		
	}

	

	
	
}
