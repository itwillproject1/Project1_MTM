package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class MemberPayAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		request.setCharacterEncoding("UTF-8");
		
		MemberDTO dto = new MemberDTO();
		dto.setUser_id(user_id);
		dto.setPay(request.getParameter("item"));
		
		MemberDAO dao = new MemberDAO();
		dao.Pay(dto);
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(" <script> ");
		out.println("  alert('포인트 충전 완료'); ");
		out.println("location.href='../main/Main.com'");
		out.println("  window.close(); ");
		out.println(" </script> ");
		out.close();
		
		
		
		return null;
	}

}
