package com.itwillbs.member.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class MemberInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	//	System.out.println(" M : MemberInfoAction_execute() 호출 ");
		
		// 로그인한 유저의 아이디
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		ActionForward forward = new ActionForward();
		if( user_id == null ) {
			forward.setPath("../main/login.member");
			forward.setRedirect(true);
			return forward;
		}
		
		// 디비에 저장 되어있는 회원정보를 가져오기
		// MemberDAO 객체를 생성
		MemberDAO dao = new MemberDAO();
		
		// 회원정보 가져오는 메서드 호출
		MemberDTO dto = dao.getMember(user_id);
	//	System.out.println(" M : 조회결과 "+dto);
		
// 		화면에 직접출력 X		
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.print(" <h1> 아이디 : "+dto.getId()+"</h1>");
//		out.close();
		
		
		// 화면(view)에 출력 -> 출력정보를 전달하고 뷰페이지로 이동
		
		// request 영역에 정보를 저장
		session.setAttribute("dto", dto);
		
		/*
		 * response.setContentType("text/html; charset=utf-8"); PrintWriter out =
		 * response.getWriter(); out.println(" <script> ");
		 * out.println("location.href='../member/MypageProductboardAction.member'");
		 * out.println("  window.close(); "); out.println(" </script> "); out.close();
		 */
		ArrayList MPBlist = new ArrayList();
		
		
		
		MPBlist = dao.getMPBlist(user_id);
		
	//	System.out.println("mpblist" + MPBlist);

		// 전달정보 저장(deal_way, file_name, title, price)
        request.setAttribute("mpbdto", MPBlist);
        
		// 페이지 이동
		
		forward.setPath("/MypageLikeboardAction.member");
		forward.setRedirect(false);
	
		return forward;
	}
	
	


}
