package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class MemberLoginAction implements Action {

	// alt + shift + s + v
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println(" M : MemberLoginAction_execute() 호출 ");
		// 한글처리 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 전달정보 저장(id,pw)
		//String id = request.getParameter("id");
		//String pw = request.getParameter("pw");
		MemberDTO dto = new MemberDTO();
		dto.setUser_id(request.getParameter("user_id"));
		dto.setPassword(request.getParameter("password"));
		
		// DAO객체 생성 -> 로그인 체크 메서드
		MemberDAO dao = new MemberDAO();
		
		int result = dao.loginMember(dto);
		System.out.println(" M : result : "+result);
		
		ActionForward forward = null;
		if(result == 1) {
			// 페이지 이동(JSP)
			// 아이디 정보를 세션에 저장
			HttpSession session = request.getSession();
			session.setAttribute("id", dto.getUser_id());
			
			//response.sendRedirect(null);
			forward = new ActionForward();
			forward.setPath("./realmain.member");
			forward.setRedirect(true);
			
			return forward;			
		}else if(result == 0) {
			// 페이지 이동(JS)
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(" <script> ");
			out.println("  alert(' 사용자 비밀번호 오류! '); ");
			out.println("  history.back(); ");
			out.println(" </script> ");
			out.close();
			
			return null; // ActionForward정보가 null=>컨트롤러 페이지이동X
		}else { //result == -1
			// 페이지 이동(JS)
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(" <script> ");
			out.println("  alert('회원정보 없음!!'); ");
			out.println("  history.back(); ");
			out.println(" </script> ");
			out.close();
		}
		
		return null;
	}//execute

}
