package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class MemberPayAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		MemberDTO dto = new MemberDTO();
		dto.setPay(request.getParameter("pay"));
		dto.setPay(request.getParameter("user_id"));
		
		MemberDAO dao = new MemberDAO();
		dao.Pay(dto);
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(" <script> ");
		out.println("  alert('포인트 충전 완료'); ");
		out.println("location.href='../main/Main.com'");
		out.println(" </script> ");
		out.close();
		
		
		
		return null;
	}

}
