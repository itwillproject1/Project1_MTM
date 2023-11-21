package com.itwillbs.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.product.db.SuggestSellDAO;
import com.itwillbs.product.db.SuggestSellDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

public class SuggestSellAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//	System.out.println("M: SellSuggestAction 호출");
		int buy_bno = Integer.parseInt(request.getParameter("bno"));
	//	System.out.println("글 bno: " + buy_bno);
		int sell_bno = Integer.parseInt(request.getParameter("sellProductBno"));
	//	System.out.println("판매제안 bno: " + sell_bno);
		
		ProductDAO pdao = new ProductDAO();
		ProductDTO buy_pdto = new ProductDTO();
		ProductDTO sell_pdto = new ProductDTO();
		
		// 구매글 정보 불러오기(구매글 bno 사용해서 불러오기)
		buy_pdto = pdao.getProduct(buy_bno);
		
		// 판매글 정보 불러오기(판매제안 bno 사용해서 불러오기)
		sell_pdto = pdao.getProduct(sell_bno);
		
		// 데이터베이스에 정보 입력
		SuggestSellDTO ssdto = new SuggestSellDTO();
		ssdto.setBuy_bno(buy_bno);
		ssdto.setSell_bno(sell_bno);
		ssdto.setBuyer_user_id(buy_pdto.getUser_id());
		ssdto.setSeller_user_id(sell_pdto.getUser_id());
		ssdto.setBuyer_price(buy_pdto.getPrice());
		ssdto.setSeller_price(sell_pdto.getPrice());
		
		SuggestSellDAO ssdao = new SuggestSellDAO();
		int bno = ssdao.suggestSell(ssdto);
		
		// 원래 페이지로 이동
		JSMoveFunction.alertLocation(response, "판매 제안이 완료되었습니다", "./ProductContent.com?bno="+bno);
		
		return null;
	}

}
