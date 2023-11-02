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
		
		// 드롭다운 전달정보 (생년월일, 휴대폰번호, 이메일)
		String jumin = request.getParameter("jumin1")+"-"+request.getParameter("jumin2")+"-"+request.getParameter("jumin3");
		String phone = request.getParameter("phone1")+"-"+request.getParameter("phone2")+"-"+request.getParameter("phone3");
		String email = request.getParameter("email1")+request.getParameter("email2");
		
		
		
		
		// 전달정보
		MemberDTO dto = new MemberDTO();
		dto.setUser_id(request.getParameter("user_id"));
		dto.setPassword(request.getParameter("password"));
		dto.setPasswordcheck(request.getParameter("passwordcheck"));
		dto.setEmail(email);
		dto.setUser_name(request.getParameter("user_name"));
		dto.setJumin(jumin);
		dto.setGender(request.getParameter("gender"));
		dto.setPhone(phone);
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
