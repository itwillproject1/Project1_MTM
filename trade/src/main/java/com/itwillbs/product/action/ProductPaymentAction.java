package com.itwillbs.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ProductPaymentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 세션에 아이디, 판매상품 전달
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// System.out.println(user_id);

		// 구매자 정보를 가져옴
		ProductDAO dao = new ProductDAO();
		MemberDTO dto = dao.buyer(user_id);
		request.setAttribute("dto", dto);		
		
		//판매자 글의 정보를 가져옴
		ProductDTO dto1 = dao.getProduct(bno);
		request.setAttribute("dto1", dto1);
		
		
		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("../pay/payment.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
