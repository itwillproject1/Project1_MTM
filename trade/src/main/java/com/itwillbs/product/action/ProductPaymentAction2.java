package com.itwillbs.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.product.db.SuggestSellDAO;
import com.itwillbs.product.db.SuggestSellDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ProductPaymentAction2 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		// 세션에 아이디, 판매상품 전달
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		int bno = Integer.parseInt(request.getParameter("sell_bno"));
		
		System.out.println(user_id);
		
		// 구매자 정보를 가져옴
		ProductDAO dao = new ProductDAO();
		MemberDTO dto = dao.buyer(user_id);
		request.setAttribute("dto", dto);
		
		
		// 거래 제안사용자의 정보를 가져옴
		ProductDTO dto1 = dao.getProduct(bno);
		request.setAttribute("dto1", dto1);
		
		// 판매 제안의 정보를 가져옴
		SuggestSellDAO dao2 = new SuggestSellDAO();
		SuggestSellDTO dto2 = dao2.buyer_price(bno, user_id);
		request.setAttribute("dto2", dto2);
		
		
		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("../pay/payment2.jsp");
		forward.setRedirect(false);
		
		
		
		
		
		return forward;
	}

}
