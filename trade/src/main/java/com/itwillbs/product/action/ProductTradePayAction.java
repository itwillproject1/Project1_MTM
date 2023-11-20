package com.itwillbs.product.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

public class ProductTradePayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 세션에 저장된 값 가져오기
		HttpSession session = request.getSession();
		String buyer_id = (String) session.getAttribute("user_id");
		String seller_id = request.getParameter("seller_id");
		String buy_deal_way = request.getParameter("buy_deal_way");
		String sell_deal_way = request.getParameter("sell_deal_way");
		int buy_pay = Integer.parseInt(request.getParameter("price"));
		int buy_bno = Integer.parseInt(request.getParameter("buy_bno"));
		int sell_bno = Integer.parseInt(request.getParameter("sell_bno"));

		// System.out.println(buyer_id);
		// System.out.println(seller_id);
		// System.out.println(buy_deal_way);
		// System.out.println(sell_deal_way);
		// System.out.println(buy_pay);
		// System.out.println(buy_bno);
		// System.out.println(sell_bno);

		// 판매자 정보 업데이트
		MemberDTO memdto = new MemberDTO();
		memdto.setUser_id(seller_id);
		memdto.setPay(buy_pay);
		MemberDAO memdao = new MemberDAO();
		memdao.productpay(memdto);

		// 구매자 정보 업데이트
		memdto.setUser_id(buyer_id);
		memdao.buyer_productpay(memdto);

		// 판매완료 업데이트
		ProductDTO prodto = new ProductDTO();
		prodto.setDeal_user_id(buyer_id);
		prodto.setBno(sell_bno);

		ProductDAO prodao = new ProductDAO();
		prodao.deal(prodto);

		// 구매완료 업데이트
		prodto.setDeal_user_id(seller_id);
		prodto.setBno(buy_bno);
		prodao.deal(prodto);

		// 거래 내역 전달 // 삽니다
		TradeHistoryDTO historydto = new TradeHistoryDTO();
		historydto.setUser_id(buyer_id);
		historydto.setDeal_way(buy_deal_way);
		historydto.setBno(buy_bno);
		historydto.setTrader_id(seller_id);
		historydto.setPrice(buy_pay);
		historydto.setAddress(request.getParameter("address"));

		TradeHistoryDAO historydao = new TradeHistoryDAO();
		historydao.tradehistory(historydto);

		// 팝니다.
		historydto.setUser_id(buyer_id);
		historydto.setTrader_id(seller_id);
		historydto.setDeal_way(sell_deal_way);
		historydto.setBno(sell_bno);

		// 구매, 판매 제안 업데이트
		SuggestSellDTO Suggest = new SuggestSellDTO();
		Suggest.setSell_bno(buy_bno);
		SuggestSellDAO Suggestdao = new SuggestSellDAO();

		// 구매
		Suggestdao.sell_bno(Suggest);

		// 판매
		Suggest.setBuy_bno(buy_bno);
		Suggestdao.sell_bno(Suggest);

		// 판매자에게 이메일 보내기
		MemberDTO sellerDto = memdao.getMember(seller_id); // 판매자 모든 정보 가져옴
		request.setAttribute("seller_email", sellerDto.getEmail());
		SendMail smail = new SendMail();
		smail.execute(request, response);

		// 페이지 이동
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
