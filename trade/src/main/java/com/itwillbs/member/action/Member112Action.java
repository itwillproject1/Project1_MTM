package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** Member112Action() : 회원의 고객센터, 간단한 Q&A(자주 묻는 질문) 리스트 **/

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
