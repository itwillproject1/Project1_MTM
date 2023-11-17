package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class Member112Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("../member/member112.jsp");
		forward.setRedirect(false);
		
		
		
		
		return forward;
	}

}
