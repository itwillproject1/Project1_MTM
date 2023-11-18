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
		
		
		// 판매자 정보 업데이트
		MemberDTO memdto = new MemberDTO();
		memdto.setUser_id(seller_id);
		memdto.setPay(pay);		
		MemberDAO memdao = new MemberDAO();
		memdao.productpay(memdto);
		
		// 구매자 정보 업데이트
		memdto.setUser_id(buyer_id);
		memdao.buyer_productpay(memdto);
		
		// 판매완료 업데이트
		ProductDTO prodto = new ProductDTO();
		prodto.setDeal_user_id(buyer_id);
		prodto.setBno(bno);
		
		ProductDAO prodao = new ProductDAO();
		prodao.deal(prodto);
		
		
		
		// 거래 내역 전달
		TradeHistoryDTO historydto = new TradeHistoryDTO();
		historydto.setUser_id(buyer_id);
		historydto.setDeal_way(deal_way);
		historydto.setBno(bno);
		historydto.setTrader_id(seller_id);
		historydto.setPrice(pay);
		
		TradeHistoryDAO historydao = new TradeHistoryDAO();
		historydao.tradehistory(historydto);
		
		// 구매, 판매 제안 업데이트	
		SuggestSellDTO Suggest = new SuggestSellDTO();
		Suggest.setSell_bno(bno);		
		SuggestSellDAO Suggestdao = new SuggestSellDAO();
		
		Suggestdao.sell_bno(Suggest);

		// 판매자에게 이메일 보내기
		MemberDTO sellerDto = memdao.getMember(seller_id); // 판매자 모든 정보 가져옴
		request.setAttribute("seller_email", sellerDto.getEmail());
		SendMail smail = new SendMail();
		smail.execute(request, response);
		
		
		
		
		
		
		//페이지 이동
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
