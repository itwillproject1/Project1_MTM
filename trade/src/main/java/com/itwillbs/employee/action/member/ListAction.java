package com.itwillbs.employee.action.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dao.MemberDAO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

public class ListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/member/employeeList.jsp");
		forward.setRedirect(false);
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		
		MemberDAO dao = new MemberDAO();
		int count = dao.employeeCount();
		
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
		
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
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
		
		ArrayList list = dao.employeeList(startRow, pageSize);

		/******************* 페이징처리 2 *********************/
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		return forward;
	}
}
