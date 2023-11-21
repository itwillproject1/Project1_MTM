package com.itwillbs.member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.product.db.TradeHistoryDAO;
import com.itwillbs.product.db.TradeHistoryDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class TradeOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	 //   System.out.println("M: TradeOkAction_execute() 호출");
	    
	    HttpSession session = request.getSession();
	    String user_id = (String) session.getAttribute("user_id");

	    ProductDTO tdto = new ProductDTO();
	    tdto.setDeal_user_id(user_id);
	    tdto.setBno(Integer.parseInt(request.getParameter("bno")));

	    TradeHistoryDAO thdao = new TradeHistoryDAO();
	    List<TradeHistoryDTO> tradeOkList = thdao.getTradeOkList(user_id);

	 //   System.out.println("TradeOkList Size: " + tradeOkList.size());

	    request.setAttribute("tradeOkList", tradeOkList);

		ActionForward forward = new ActionForward();
	    forward.setPath("/member/mypage.jsp"); 
	    forward.setRedirect(false);
	    return forward;
	}
}
