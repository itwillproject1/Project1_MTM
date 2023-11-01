package com.itwillbs.product.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : ProductListAction_execute() 실행 ");

		// 전달정보 검색어 정보 저장
		String search = request.getParameter("search");
		System.out.println(" M : 검색어 : "+search );
		
		// 기존에 저장된 글정보를 가져와서 화면에 출력
		ProductDAO dao = new ProductDAO();
		
		int count = 0;
		if(search == null) { // 검색어 X
			System.out.println(" M : 검색어 없음! ");
			count = dao.getProductCount();
			/////////////////////////////////////////////////////////
		}else{ // 검색어 O - 검색결과O/X 
			System.out.println(" M : 검색어 있음! ("+search+")");
			count = dao.getProductCount(search);
		}		
		System.out.println(" M : 글 개수 : " + count);
		
		/********************* 페이징처리 1 *******************/
		// 한 페이지에 출력할 글의 개수 설정
		int pageSize = 3;

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
		ArrayList ProductList = null;
		if (count > 0 && search == null) {
			ProductList = dao.getProductList(startRow, pageSize);
		}else if(count > 0 && search != null ) {
			ProductList = dao.getProductList(startRow, pageSize,search);
		}else {
			// 글이 없는경우
		}
		System.out.println(" M : size :" + ProductList.size());

		// 리스트를 출력 => 연결된 뷰페이지에서 출력하도록 정보 전달
		request.setAttribute("boardList", ProductList);

		/******************* 페이징처리 2 *********************/
		// 페이지 블럭(1,2,3,.....,10) 생성

		// 전체 페이지수
		// 글 15 / 페이지당 10 => 2개
		// 글 78 / 페이지당 10 => 8개
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);

		// 한 화면에 보여줄 페이지 블럭개수
		int pageBlock = 3;

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

		// 페이징 처리에 필요한 정보 모두를 request영역에 저장해서 전달
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		// 페이지 이동준비 
		ActionForward forward = new ActionForward();
		forward.setPath("./product/ProductList.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
