package com.itwillbs.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ProductUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 전달정보 저장
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// bno에 해당하는 글 불러오기(DAO)
		ProductDAO pdao = new ProductDAO();
		ProductDTO pdto = pdao.getProduct(bno);
		
		// 정보 전달
		request.setAttribute("pdto", pdto);
		
		System.out.println(pdto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./productUpdate.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
