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
		
		// category 값 배열에 저장
		String[] cg = {"휴대폰%26태블릿", "데스크탑", "노트북", "게임기기", "가전제품", "카메라", "음향기기", "기타"};
		request.setAttribute("cg", cg);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./productUpdate.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
