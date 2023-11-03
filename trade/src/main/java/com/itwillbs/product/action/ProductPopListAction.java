package com.itwillbs.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ProductPopListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ProductPopListAction_execute() 실행");
		ProductDAO dao = new ProductDAO();
		dao.getPopularList();
		
		// 전달정보 저장(deal_way, file_name, title, price)
		ProductDTO dto = new ProductDTO();
		dto.setDeal_way(request.getParameter("deal_way"));
		dto.setFile_name(request.getParameter("file_name"));
		dto.setTitle(request.getParameter("title"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));

        request.setAttribute("dto", dto);
        
		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./realmain.jsp");
		forward.setRedirect(false);
	
		return forward;
	}

}
