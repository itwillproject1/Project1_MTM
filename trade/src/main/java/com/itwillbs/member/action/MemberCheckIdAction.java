package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class MemberCheckIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		MemberDTO dto = new MemberDTO();
		dto.setUser_id(request.getParameter("user_id"));
		
		MemberDAO dao = new MemberDAO();
		
		int result = dao.checkid(dto);
		System.out.println(" M : result : "+result);
		
		ActionForward forward = null;
		
		if(result == 1) {
		HttpSession session = request.getSession();
		session.setAttribute("user_id", dto.getUser_id());
		forward = new ActionForward();
		forward.setPath("");
		forward.setRedirect(true);
		
		return forward;		
		}
		return null;
}
}