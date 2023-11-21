package com.itwillbs.member.action;

import java.io.PrintWriter;

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
		
	//	System.out.println(" M : MemberCheckId_execute() 호출 ");
		request.setCharacterEncoding("UTF-8");
		
		MemberDTO dto = new MemberDTO();
		dto.setUser_id(request.getParameter("user_id"));
		
		MemberDAO dao = new MemberDAO();
		int result = dao.checkid(dto);
		// System.out.println(" M : 중복값 result : "+result);
		
		
		
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("user_id", dto.getUser_id());
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(" <script> ");
			out.println("  alert(' 사용중인 아이디 입니다. '); ");
			out.println("  history.back(); ");
			out.println(" </script> ");
			out.close();	
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(" <script> ");
			out.println("  alert(' 사용가능한 아이디 입니다. '); ");
			out.println("  history.back(); ");
			out.println(" </script> ");
			out.close();
		}
		return null;
}
}