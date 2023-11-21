package com.itwillbs.member.action;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.product.db.LikeDAO;
import com.itwillbs.product.db.LikeDTO;
import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.product.db.SuggestSellDAO;
import com.itwillbs.product.db.SuggestSellDTO;
import com.itwillbs.product.db.TradeHistoryDAO;
import com.itwillbs.product.db.TradeHistoryDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class MypageLikeboardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//System.out.println("M: MypageLikeboardAction.execute() 호출");
		
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		
		
		
		// 마이페이지 - 내가 찜한 상품 목록
		LikeDAO likedao = new LikeDAO();
		ArrayList<LikeDTO> likedtoList = likedao.getlikeList(user_id);
		
		ProductDAO PLdao = new ProductDAO();
		ArrayList<ProductDTO> productlikelist = new ArrayList<ProductDTO>();
		
		for(int i=0; i<likedtoList.size(); i++) {
		productlikelist.add(PLdao.getProduct(likedtoList.get(i).getBno()));
		}
		
		request.setAttribute("productlikelist", productlikelist);
		
		
		
		// 마이페이지 - 내가 구매한 상품 목록
		TradeHistoryDAO thdao = new TradeHistoryDAO();
		ProductDTO pdto = new ProductDTO();
	    pdto.setDeal_user_id(user_id);

	    ProductDAO tdao = new ProductDAO();
	    List<TradeHistoryDTO> tradeOkList = thdao.getTradeOkList(user_id);
	    request.setAttribute("tradeOkList", tradeOkList);
	    
	    List<ProductDTO> buyList = new ArrayList<ProductDTO>();
	    
	    for(int i=0; i<tradeOkList.size(); i++) {
	    	pdto = PLdao.getProduct(tradeOkList.get(i).getBno());
	   // 	System.out.println(tradeOkList.get(i).getBno());
	   // 	System.out.println(pdto);
	    	buyList.add(pdto);
	    }
	    request.setAttribute("buyList", buyList);
	  //  System.out.println("buyList: " + buyList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/member/mypage.jsp");
		forward.setRedirect(false);
	//	System.out.println("mypage 루트 지정성공!");
		return forward;
		
	}

}		
		
		
		
		
