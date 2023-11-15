package com.itwillbs.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.SuggestSellDAO;
import com.itwillbs.product.db.SuggestSellDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

public class CancleSuggestAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CancleSuggestAction.execute() 호출");
		// 전달정보 저장
		int bno = Integer.parseInt(request.getParameter("bno"));
		String[] cancle_bnoList = request.getParameterValues("cancle_bno");
//		int[] cancle_bno2 = request.getParameterValues("cancle_bno");
		String cancle_bno = String.join(",", cancle_bnoList);
				
		// cancle 수행하는 메서드(SuggestSell 테이블 행 삭제) 실행
		SuggestSellDAO ssdao = new SuggestSellDAO();
		int result = ssdao.cancleSuggest(bno, cancle_bno);
		
		if(result == 1) {			
			// 페이지 이동
			JSMoveFunction.alertLocation(response, "판매 제안이 취소되었습니다.", "./ProductContent.com?bno="+bno);
		}
		
		return null;
	}

}
