package com.itwillbs.product.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.employee.dto.SuggestDTO;
import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.product.db.SuggestSellDAO;
import com.itwillbs.product.db.SuggestSellDTO;
import com.itwillbs.product.db.TradeHistoryDAO;
import com.itwillbs.product.db.TradeHistoryDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ProductPayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String buyer_id = (String)session.getAttribute("user_id");
		
		
		String seller_id = request.getParameter("seller_id");
		String deal_way = request.getParameter("deal_way");
		int pay = Integer.parseInt(request.getParameter("price"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// System.out.println(seller_id);
		// System.out.println(buyer_id);
		// System.out.println(pay);
		
		MemberDTO dto = new MemberDTO();
		dto.setUser_id(seller_id);
		dto.setPay(pay);
		
		// 구매자 정보 업데이트
		MemberDAO dao = new MemberDAO();
		dao.productpay(dto);
		
		// 판매자 정보 업데이트
		dto.setUser_id(buyer_id);
		dao.buyer_productpay(dto);
		
		// 글정보 업데이트
		ProductDTO dto1 = new ProductDTO();
		dto1.setDeal_user_id(buyer_id);
		dto1.setBno(bno);
		
		ProductDAO dao1 = new ProductDAO();
		dao1.deal(dto1);
		
		
		
		// 거래 내역 전달
		TradeHistoryDTO dto2 = new TradeHistoryDTO();
		dto2.setUser_id(buyer_id);
		dto2.setDeal_way(deal_way);
		dto2.setBno(bno);
		dto2.setTrader_id(seller_id);
		dto2.setPrice(pay);
		
		TradeHistoryDAO dao2 = new TradeHistoryDAO();
		dao2.tradehistory(dto2);
		
		// 구매, 판매 제안 업데이트
		
		SuggestSellDTO dto3 = new SuggestSellDTO();
		dto3.setSell_bno(bno);		
		SuggestSellDAO dao3 = new SuggestSellDAO();
		dao3.sell_bno(dto3);
		
		
		
		
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(" <script> ");
		out.println("  alert('결제가 완료 되었습니다.'); ");
		// out.println("location.href='../main/Main.com'");
		out.println("location.href='../main/Main.com'");
		out.println(" </script> ");
		out.close();
		
		
		return null;
	}

}
