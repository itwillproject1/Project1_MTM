package com.itwillbs.employee.action.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dao.TradeDAO;
import com.itwillbs.employee.dto.TradeDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** TradeListAction : 거래 목록 **/

public class TradeListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		// request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null)
			pageNum = "1";
		// all, buy, sell, complete
		String pageCategory = request.getParameter("pageCategory");
		if (pageCategory == null)
			pageCategory = "all";

		String search = request.getParameter("search");
		String searchKeyword = request.getParameter("searchKeyword");

		String category = request.getParameter("category");
		String[] catInfo = { "휴대폰&태블릿", "데스크탑", "노트북", "게임기기", "가전제품", "카메라", "음향기기", "기타" };
		if (category == null || category.equals("선택"))
			;
		else {
			int i = Integer.parseInt(category);
			category = catInfo[i];
		}
		String checkComplete = request.getParameter("checkComplete");

		TradeDAO dao = new TradeDAO();
		ArrayList list = null;

		// pageCategory (전체, 구매, 판매, 거래 완료)
		// category (물품 종류)
		// search/searchKeyword 컬럼 = '값'
		// checkComplete deal_status = 0 포함

		int[] count = new int[4];
		if (search == null && category == null && searchKeyword == null) {
			if (checkComplete == null) {
				count[0] = dao.tradeCount("all", checkComplete);
				count[1] = dao.tradeCount("buy", checkComplete);
				count[2] = dao.tradeCount("sell", checkComplete);
				count[3] = dao.tradeCount("complete", checkComplete);
			} else {
				count[0] = dao.tradeCount("all", checkComplete);
				count[1] = dao.tradeCount("buy", checkComplete);
				count[2] = dao.tradeCount("sell", checkComplete);
				count[3] = dao.tradeCount("complete", checkComplete);
			}
		} else {
			if (checkComplete == null) {
				count[0] = dao.tradeCount("all", category, search, searchKeyword, checkComplete);
				count[1] = dao.tradeCount("buy", category, search, searchKeyword, checkComplete);
				count[2] = dao.tradeCount("sell", category, search, searchKeyword, checkComplete);
				count[3] = dao.tradeCount("complete", category, search, searchKeyword, checkComplete);
			} else {
				count[0] = dao.tradeCount("all", category, search, searchKeyword, checkComplete);
				count[1] = dao.tradeCount("buy", category, search, searchKeyword, checkComplete);
				count[2] = dao.tradeCount("sell", category, search, searchKeyword, checkComplete);
				count[3] = dao.tradeCount("complete", category, search, searchKeyword, checkComplete);
			}
		}

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
		int c = 0;
		if (pageCategory.equals("all"))
			c = count[0];
		else if (pageCategory.equals("buy"))
			c = count[1];
		else if (pageCategory.equals("sell"))
			c = count[2];
		else if (pageCategory.equals("complete"))
			c = count[3];

		int pageCount = c / pageSize + (c % pageSize == 0 ? 0 : 1);

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

		if (search == null && category == null && searchKeyword == null)
			list = dao.tradeList(pageCategory, startRow, pageSize);
		else
			list = dao.tradeList(pageCategory, category, search, searchKeyword, checkComplete, startRow, pageSize);
		
		if(list.size() == 0) list = new ArrayList();
		
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageCategory", pageCategory);
		request.setAttribute("checkComplete", checkComplete);
		request.setAttribute("search", search);
		request.setAttribute("searchKeyword", searchKeyword);
		request.setAttribute("category", category);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		forward.setPath("./employee/user/tradeList.jsp");
		//System.out.println(list.size());
		forward.setRedirect(false);
		return forward;
	}
}
