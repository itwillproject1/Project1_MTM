package com.itwillbs.employee.action.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.BoardDAO;
import com.itwillbs.employee.dao.DAO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** BoardListAction() : 게시판 목록 불러오기 **/

public class BoardListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		String pageCategory = request.getParameter("pageCategory");
		if(pageCategory == null) pageCategory = "notice";
		
		String search = request.getParameter("search");
		String searchKeyword = request.getParameter("searchKeyword");
		
		BoardDAO dao = new BoardDAO();
		int[] count = new int[2];
		count[0] = dao.boardCount("notice");
		count[1] = dao.boardCount("event");
		
		/********************* 페이징처리 1 *******************/
		// 한 페이지에 출력할 글의 개수 설정
		int pageSize = 8;

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
		
		int c = 0;
		
		if(pageCategory.equals("notice")) c = count[0];
		else if(pageCategory.equals("event")) c = count[1];
		
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
		
		ArrayList list = null;
		if(search == null || searchKeyword == null)
			list = dao.boardList(pageCategory, startRow, pageSize);
		else list = dao.boardList(pageCategory, search, searchKeyword, startRow, pageSize);
		
		
		System.out.println(list.size());
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/boardList.jsp");
		forward.setRedirect(false);
		request.setAttribute("pageCategory", pageCategory);
		request.setAttribute("count", count);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("list", list);
		request.setAttribute("search", search);
		request.setAttribute("searchKeyword", searchKeyword);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		return forward;
	}
}
