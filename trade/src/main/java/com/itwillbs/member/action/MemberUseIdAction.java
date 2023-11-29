package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

public class MemberUseIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");

		MemberDTO dto = new MemberDTO();
		dto.setUser_id(request.getParameter("user_id"));
		
		MemberDAO dao = new MemberDAO();
		int result = dao.checkid(dto);
		//System.out.println(" M : 중복값 result : "+result);
		//System.out.println(user_id);
		
		
		if(result == 1) {

			session.setAttribute("user_id", dto.getUser_id());
			JSMoveFunction.alertHistory(response, "사용중인 아이디 입니다.");	
		}else {
			JSMoveFunction.close2(response);
		}
		return null;
}

}
