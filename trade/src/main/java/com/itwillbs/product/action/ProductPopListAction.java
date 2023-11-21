package com.itwillbs.product.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ProductPopListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//	System.out.println("ProductPopListAction_execute() 실행");
		ProductDAO dao = new ProductDAO();
		ArrayList popList = new ArrayList();
		popList = dao.getPopularList();
		
		ArrayList recList = new ArrayList();
		recList = dao.getRecentList();
		
	//	System.out.println("popList" + popList);
	//	System.out.println("recList" + recList);
		
		// 전달정보 저장(deal_way, file_name, title, price)
        request.setAttribute("dto", popList);
        request.setAttribute("dto2", recList);
        
		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./realmain.jsp");
		forward.setRedirect(false);
	
		return forward;
	}

}
