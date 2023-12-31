package com.itwillbs.employee.action.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.TradeDAO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class TradeHistory implements Action {
	/** TradeHistory : 거래 내역 **/
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null)
			pageNum = "1";
		// all, buy, sell, complete
		String search = request.getParameter("search");
		if (search == null || search.equals("선택"))
			search = null;
		String searchKeyword = request.getParameter("searchKeyword");

		String category = request.getParameter("category");
		String[] catInfo = { "휴대폰&태블릿", "데스크탑", "노트북", "게임기기", "가전제품", "카메라", "음향기기", "기타" };
		if (category == null || category.equals("선택"))
			category = null;
		else {
			int i = Integer.parseInt(category);
			category = catInfo[i];
		}

		TradeDAO dao = new TradeDAO();

		/********************* 페이징처리 1 *******************/
		// 한 페이지에 출력할 글의 개수 설정
		int pageSize = 12;

		// 시작행 번호 계산하기
		// 1 11 21 31 41 .....
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize;

		/********************* 페이징처리 1 *******************/

		/******************* 페이징처리 2 *********************/
		// 페이지 블럭(1,2,3,.....,10) 생성

		// 전체 페이지수
		// 글 15 / 페이지당 10 => 2개
		// 글 78 / 페이지당 10 => 8개
		int count = dao.tradeHistoryCount();

		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);

		// 한 화면에 보여줄 페이지 블럭개수
		int pageBlock = 5;

		// 페이지 블럭의 시작번호 계산
		// 1페이지 => 1 , 11페이지 => 11
		// 5페이지 => 1 , 25페이지 => 21
		int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;

		// 페이지 블럭의 마지막번호 계산
		// 1페이지 => 10, 13페이지 => 20
		int endPage = startPage + pageBlock - 1;
		// 페이지의 글이 없는경우
		if (endPage > pageCount) {
			endPage = pageCount;
		}

		/******************* 페이징처리 2 *********************/

		ArrayList list;
		if (search == null && searchKeyword == null && category == null)
			list = dao.tradeHistory(startRow, pageSize);
		else
			list = dao.tradeHistorySearch(category, search, searchKeyword, startRow, pageSize);

		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("search", search);
		request.setAttribute("searchKeyword", searchKeyword);
		request.setAttribute("category", category);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/tradeHistory.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
