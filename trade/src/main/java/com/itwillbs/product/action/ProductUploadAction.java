package com.itwillbs.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ProductUploadAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M: ProductUploadAction.execute() 호출");
		
		// 전달정보 저장(DTO)
		ProductDTO dto = new ProductDTO();
		
		dto.setUser_id(null);
		dto.setDeal_way(request.getParameter("deal_way"));
		dto.setTitle(request.getParameter("title"));
		dto.setCategory(request.getParameter("category"));
		dto.setBrand(request.getParameter("brand"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		dto.setProduct_status(request.getParameter("product_status"));
		dto.setContent(request.getParameter("content"));
		dto.setFile_name(request.getParameter("file_name"));
		
		System.out.println("M: " + dto);
		
		// DAO 글작성 수행 메서드
		ProductDAO dao = new ProductDAO();
		
		dao.uploadProduct(dto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./product/ProductContent.com");
		forward.setRedirect(true);
		
		
		
		
		
		return null;
	}

}
