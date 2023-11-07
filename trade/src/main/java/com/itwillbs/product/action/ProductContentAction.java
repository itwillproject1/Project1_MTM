package com.itwillbs.product.action;

import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.LikeDAO;
import com.itwillbs.product.db.LikeDTO;
import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ProductContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M: ProductContentAction.execute() 호출");
		
		// 추후 로그인 정보 받아서 미로그인도 조회는 가능,
		// 나머지(구매, 판매, 찜 등)는 로그인페이지 이동
		
		
		// 전달정보 저장(bno, pageNum, search(생략))
		int bno = Integer.parseInt(request.getParameter("bno")); // 추후 수정
		String pageNum = request.getParameter("pageNum");

		// BoardDAO 객체 - 특정 글의 조회수 1 증가()
		ProductDAO dao = new ProductDAO();
		dao.updateReadcount(bno);

		// BoardDAO 객체 - 특정 글의 정보를 가져옴()
		ProductDTO dto = dao.getProduct(bno);
		request.setAttribute("dto", dto);
		
		// 찜
		LikeDTO ldto = new LikeDTO();
		LikeDAO ldao = new LikeDAO();
		int result = ldao.likeCheck(ldto); // 찜 여부(0 또는 1)
		System.out.println("찜 체크 결과: " + result);
		
		// ajax에 값 반환
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().write(result+""); // String으로 형 변환해서 전달
		request.setAttribute("result", result);

		// 페이지 이동 준비(./productContent.jsp)
		ActionForward forward = new ActionForward();
		forward.setPath("./productContent.jsp");
		forward.setRedirect(false);

		return forward;

	}

}
