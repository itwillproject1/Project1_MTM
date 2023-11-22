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

public class MemberPayAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		//System.out.println(request.getParameter("item"));
		//System.out.println(request.getParameter("id"));
		
		MemberDTO dto = new MemberDTO();
		dto.setUser_id(request.getParameter("id"));
		dto.setPay(Integer.parseInt(request.getParameter("item")));
		
		MemberDAO dao = new MemberDAO();
		dao.Pay(dto);

		JSMoveFunction.alertLocation(response, "포인트 충전 완료", "../main/Main.com");
		return null;
	}
}
