package com.itwillbs.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ProductPopularListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ProductPopularListAction_execute() 실행");
		
		// 전달정보 저장(bno, file_name, title, price)
		ProductDTO dto = new ProductDTO();
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setFile_name(request.getParameter("file_name"));
		dto.setTitle(request.getParameter("title"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		
		// 페이지 이동
		ActionForward forward = new ActionForward();
	
		forward.setPath("/main/Main.com");
		forward.setRedirect(true);
	
		return forward;
	}

}
