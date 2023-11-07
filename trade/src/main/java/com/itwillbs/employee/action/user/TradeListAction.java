package com.itwillbs.employee.action.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dao.TradeDAO;
import com.itwillbs.employee.dto.TradeDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class TradeListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		// all, buy, sell, complete
		String pageCategory = request.getParameter("pageCategory");
		if(pageCategory == null) pageCategory = "all";
		
		TradeDAO dao = new TradeDAO();
		ArrayList list = null;
		if(pageCategory == "all") {
			list = dao.tradeList(Integer.parseInt(pageNum));
		}
		
		else if(pageCategory == "buy") {
			list = dao.tradeList("삽니다", Integer.parseInt(pageNum));
		}
		
		else if(pageCategory == "sell") {
			list = dao.tradeList("팝니다", Integer.parseInt(pageNum));
		}
		
		else if(pageCategory == "complete") {
			list = dao.tradeSearch("deal_status", "0", Integer.parseInt(pageNum), 8);
		}
		if(list == null) list = new ArrayList();
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		forward.setPath("./employee/user/tradeList.jsp");
		System.out.println(list.size());
		forward.setRedirect(false);
		return forward;
	}
}
