package com.itwillbs.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class SuggestSellAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M: SellSuggestAction 호출");
		System.out.println("글 bno: " + request.getAttribute("bno"));
		System.out.println("판매제안 bno: " + request.getAttribute("sellCheckbox"));
		return null;
	}

}
