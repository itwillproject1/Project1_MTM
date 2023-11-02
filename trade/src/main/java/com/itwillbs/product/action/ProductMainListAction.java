package com.itwillbs.product.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ProductMainListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : ProductMainListAction_execute() 실행 ");
		ArrayList PopularProducts = null;

		ProductDAO dao = new ProductDAO();
		
		// BoardDAO 객체 - 특정 글의 정보를 가져옴()
		request.setAttribute("PopularProducts", PopularProducts);

		// 페이지 이동 준비(./Main.jsp)
		ActionForward forward = new ActionForward();
		forward.setPath("./Main.jsp");
		forward.setRedirect(false);

		return forward;
		
	}

}
