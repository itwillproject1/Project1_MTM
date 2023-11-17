package com.itwillbs.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.product.db.SuggestSellDAO;
import com.itwillbs.product.db.SuggestSellDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ProductTradeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		// 세션에 아이디
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		int buy_bno = Integer.parseInt(request.getParameter("buy_bno"));
		int sell_bno = Integer.parseInt(request.getParameter("sell_bno"));
		
		// System.out.println(user_id);
		
		// 구매자 정보를 가져옴
		MemberDAO memdao = new MemberDAO();
		MemberDTO membuyerdto = memdao.user_search(user_id);
		request.setAttribute("membuyerdto", membuyerdto);
		
		
		// 구매자의 글정보
		ProductDAO prodao = new ProductDAO();
		ProductDTO probuyerdto = prodao.getProduct(buy_bno);
		request.setAttribute("probuyerdto", probuyerdto);
		
		
		// 판매자의 글정보
		ProductDTO prosellerdto = prodao.getProduct(sell_bno);
		request.setAttribute("prosellerdto", prosellerdto);
		
		
		
		// 판매, 구매 제안 정보 삭제
		SuggestSellDAO Suggestdao = new SuggestSellDAO();
		SuggestSellDTO Suggestdto = Suggestdao.buyer_price(buy_bno, user_id);
		request.setAttribute("Suggestdto", Suggestdto);
		
		
		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("../pay/trade.jsp");
		forward.setRedirect(false);
		
		
		
		
		
		return forward;
	}

}
