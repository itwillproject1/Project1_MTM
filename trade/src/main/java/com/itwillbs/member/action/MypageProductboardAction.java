package com.itwillbs.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class MypageProductboardAction implements Action {

	
	// 안쓰는 파일!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! memberinfoaction에 합쳤음!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MypageProductboardAction_execute() 실행");
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		MemberDAO dao = new MemberDAO();
		ArrayList MPBlist = new ArrayList();
		
		
		
		MPBlist = dao.getMPBlist(user_id);
		
		System.out.println("mpblist" + MPBlist);

		// 전달정보 저장(deal_way, file_name, title, price)
        request.setAttribute("mpbdto", MPBlist);
        
		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./mypage.jsp");
		forward.setRedirect(false);
	
		return forward;
		
	}

}
