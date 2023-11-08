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
		//request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		// all, buy, sell, complete
		String pageCategory = request.getParameter("pageCategory");
		if(pageCategory == null) pageCategory = "all";
		
		String search = request.getParameter("search");
		String searchKeyword = request.getParameter("searchKeyword");
		
		String category = request.getParameter("category");
		String checkComplete = request.getParameter("checkComplete");
		
		TradeDAO dao = new TradeDAO();
		ArrayList list = null;
		
		// pageCategory (전체, 구매, 판매, 거래 완료)
		// category (물품 종류)
		// search/searchKeyword 컬럼 = '값'
		// checkComplete deal_status = 0 포함
		
		if(searchKeyword == null && category == null && checkComplete == null) {
			list = dao.tradeList(pageCategory);
		}
		
		else {
			list = dao.tradeList(pageCategory, category, search, searchKeyword, checkComplete);
		}
		
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCategory", pageCategory);
		forward.setPath("./employee/user/tradeList.jsp");
		System.out.println(list.size());
		forward.setRedirect(false);
		return forward;
	}
}
