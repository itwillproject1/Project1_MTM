package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.InquiryDAO;
import com.itwillbs.member.db.InquiryDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class QnaContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//	System.out.println("QnaContentAction.execute() 호출");
		
		// 전달정보 저장
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		ActionForward forward = new ActionForward();

		// DB에서 글 정보 가져오기
		InquiryDAO idao = new InquiryDAO();
		InquiryDTO idto = idao.getQna(bno);
		
		request.setAttribute("idto", idto);
		
		forward.setPath("./qnaContent.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
