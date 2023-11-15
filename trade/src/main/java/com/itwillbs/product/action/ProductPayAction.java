package com.itwillbs.product.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ProductPayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String buyer_id = (String)session.getAttribute("user_id");
		
		
		String seller_id = request.getParameter("seller_id");
		int pay = Integer.parseInt(request.getParameter("price"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// System.out.println(seller_id);
		// System.out.println(buyer_id);
		// System.out.println(pay);
		
		MemberDTO dto = new MemberDTO();
		dto.setUser_id(seller_id);
		dto.setPay(pay);
		
		MemberDAO dao = new MemberDAO();
		dao.productpay(dto);
		
		// 
		dto.setUser_id(buyer_id);
		dao.buyer_productpay(dto);
		
		//
		ProductDTO dto1 = new ProductDTO();
		dto1.setDeal_user_id(buyer_id);
		dto1.setBno(bno);
		
		ProductDAO dao1 = new ProductDAO();
		dao1.deal(dto1);
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(" <script> ");
		out.println("  alert('결제가 완료 되었습니다.'); ");
		// out.println("location.href='../main/Main.com'");
		out.println("  window.close(); ");
		out.println(" </script> ");
		out.close();
		
		
		return null;
	}

}
