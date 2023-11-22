package com.itwillbs.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.InquiryDAO;
import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class QnaListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// System.out.println("QnaListAction.execute() 호출");

		// 아이디 저장
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");

		ActionForward forward = new ActionForward();

		// 로그인 제어
		if (user_id == null) {
			forward.setPath("./Main.me");
			forward.setRedirect(true);
			return forward;
		}

		// 기존에 저장된 글정보를 가져와서 화면에 출력
		InquiryDAO idao = new InquiryDAO();

		int count = idao.getQnaCount(user_id);
//		System.out.println(" M : 글 개수 : " + count);

		/********************* 페이징처리 1 *******************/
		// 한 페이지에 출력할 글의 개수 설정
		int pageSize = 10;

		// 현 페이지가 몇페이지 인지확인
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}

		// 시작행 번호 계산하기
		// 1 11 21 31 41 .....
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;

		// 끝행 번호 계산
		// 10 20 30 40 50 .....
		int endRow = currentPage * pageSize;

		/********************* 페이징처리 1 *******************/

		// DAO - 글정보 모두(list)를 가져오는 메서드 호출
		ArrayList qnaList = new ArrayList();
		qnaList = idao.getQnaList(startRow, pageSize, user_id);

		// System.out.println(" M : size :" + qnaList.size());

		// 리스트를 출력 => 연결된 뷰페이지에서 출력하도록 정보 전달
		request.setAttribute("qnaList", qnaList);

		/******************* 페이징처리 2 *********************/
		// 전체 페이지수
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);

		// 한 화면에 보여줄 페이지 블럭개수
		int pageBlock = 8;

		// 페이지 블럭의 시작번호 계산
		int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;

		// 페이지 블럭의 마지막번호 계산
		int endPage = startPage + pageBlock - 1;
		// 페이지의 글이 없는경우
		if (endPage > pageCount) {
			endPage = pageCount;
		}

		/******************* 페이징처리 2 *********************/

		// 페이징 처리에 필요한 정보 모두를 request영역에 저장해서 전달
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

		// 페이지 이동준비
		forward = new ActionForward();
		forward.setPath("./qnaList.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
