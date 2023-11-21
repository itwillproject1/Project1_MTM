package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.product.db.TradeHistoryDAO;
import com.itwillbs.product.db.TradeHistoryDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

public class tradeDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//System.out.println("tradeDetailAction.execute() 호출");
		// 아이디 저장
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");

		ActionForward forward = new ActionForward();

		// 전달정보 저장
		int order_id = Integer.parseInt(request.getParameter("order_id")); // 주문번호 저장
		
		// 주문내역 조회
		TradeHistoryDAO thdao = new TradeHistoryDAO();
		TradeHistoryDTO thdto = thdao.getDetail(order_id);
		request.setAttribute("thdto", thdto);
		
		// 상품정보 조회
		ProductDAO pdao = new ProductDAO();
		ProductDTO pdto = pdao.getProduct(thdto.getBno());
		request.setAttribute("pdto", pdto);
		
		// 멤버 정보 조회
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = mdao.getMember(user_id);
		request.setAttribute("mdto", mdto);
		
		forward.setPath("./tradeDetail.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
