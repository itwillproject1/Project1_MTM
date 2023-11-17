package com.itwillbs.employee.action.inquiry;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.InquiryDAO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** InquiryListAction : 문의 게시글 리스트 **/

public class InquiryListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null)
			pageNum = "1";

		// all, 0, 1
		String pageCategory = request.getParameter("pageCategory");
		if (pageCategory == null)
			pageCategory = "all";

		InquiryDAO dao = new InquiryDAO();

		String search = request.getParameter("search");
		if (search == null || search.equals("선택"))
			search = null;
		String searchKeyword = request.getParameter("searchKeyword");
		String category = request.getParameter("category");
		if (category == null || category.equals("선택"))
			category = null;

		int[] count = new int[3];

		count[0] = dao.inquiryCount();
		count[1] = dao.inquiryCount(true);
		count[2] = dao.inquiryCount(false);

		int c = 0;
		if (pageCategory.equals("all"))
			c = count[0];
		else if (pageCategory.equals("1"))
			c = count[1];
		else if (pageCategory.equals("0"))
			c = count[2];

		/********************* 페이징처리 1 *******************/
		// 한 페이지에 출력할 글의 개수 설정
		int pageSize = 12;

		// 시작행 번호 계산하기
		// 1 11 21 31 41 .....
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize;

		// 끝행 번호 계산
		// 10 20 30 40 50 .....
		int endRow = currentPage * pageSize;

		/********************* 페이징처리 1 *******************/

		/******************* 페이징처리 2 *********************/
		// 페이지 블럭(1,2,3,.....,10) 생성

		// 전체 페이지수
		// 글 15 / 페이지당 10 => 2개
		// 글 78 / 페이지당 10 => 8개

		int pageCount = c / pageSize + (c % pageSize == 0 ? 0 : 1);
		System.out.println(pageCount);
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

		ArrayList iList = dao.inquiryList(pageCategory, search, searchKeyword, category, startRow, pageSize);

		String[] inquiryReason = { "계정", "이용", "거래", "결제", "기타" };
		ActionForward forward = new ActionForward();
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("count", count);
		request.setAttribute("list", iList);
		request.setAttribute("pageCategory", pageCategory);
		request.setAttribute("category", category);
		request.setAttribute("search", search);
		request.setAttribute("searchKeyword", searchKeyword);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("inquiryReason", inquiryReason);
		forward.setPath("./employee/user/inquiryList.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
