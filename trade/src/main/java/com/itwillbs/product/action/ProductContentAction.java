package com.itwillbs.product.action;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.product.db.LikeDAO;
import com.itwillbs.product.db.LikeDTO;
import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.product.db.SuggestSellDAO;
import com.itwillbs.product.db.SuggestSellDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ProductContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M: ProductContentAction.execute() 호출");
		
		// 로그인 아이디 받기
		HttpSession session = request.getSession();
		String login_id = (String) session.getAttribute("user_id");
		request.setAttribute("login_id", login_id);
		
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
		
		/* 찜 여부 확인 */
		LikeDTO ldto = new LikeDTO();
		ldto.setBno(Integer.parseInt(request.getParameter("bno")));
		ldto.setUser_id(login_id);
		
		LikeDAO ldao = new LikeDAO();
		int likeResult = ldao.likeCheck(ldto); // 찜 여부(0 또는 1)
		System.out.println("찜 체크 결과: " + likeResult);

		request.setAttribute("likeResult", likeResult);

		/* 프로필 조회에 필요한 정보 */
		List<ProductDTO> userProducts =  dao.getAllUserProducts(dto.getUser_id());
		request.setAttribute("userProducts", userProducts);
		System.out.println(userProducts);

		/* 판매하기 모달에 필요한 정보 */
		List<ProductDTO> sellProduct =  dao.getAllUserProducts(login_id, "팝니다");
		request.setAttribute("sellProduct", sellProduct);
		System.out.println("sellProduct"+sellProduct);
		
		/* 거래 제안 현황 조회에 필요한 정보 */
		SuggestSellDAO ssdao = new SuggestSellDAO();
		ArrayList<SuggestSellDTO> suggestList = ssdao.getSuggestList(bno);
		request.setAttribute("suggestList", suggestList);
		System.out.println("suggestList" + suggestList);
		
		ArrayList<ProductDTO> spdto = new ArrayList<ProductDTO>();
		
		for(int i=0; i<suggestList.size(); i++) {
			spdto.add(dao.getProduct(suggestList.get(i).getSell_bno()));
		}
		
		request.setAttribute("spdto", spdto);
		
		
		
		// 페이지 이동 준비(./productContent.jsp)
		ActionForward forward = new ActionForward();
		forward.setPath("./productContent.jsp");
		forward.setRedirect(false);

		return forward;
	}
	

}