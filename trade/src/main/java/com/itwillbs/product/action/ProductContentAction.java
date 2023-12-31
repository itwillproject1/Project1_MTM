package com.itwillbs.product.action;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
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
	//	System.out.println("M: ProductContentAction.execute() 호출");
		
		// 로그인 아이디 받기
		HttpSession session = request.getSession();
		String login_id = (String) session.getAttribute("user_id");
		request.setAttribute("login_id", login_id);
		
		// 추후 로그인 정보 받아서 미로그인도 조회는 가능,
		// 나머지(구매, 판매, 찜 등)는 로그인페이지 이동		
		
		// 전달정보 저장(bno, pageNum, search(생략))
		String user_id = request.getParameter("user_id");
		int bno = Integer.parseInt(request.getParameter("bno")); // 추후 수정
		String pageNum = request.getParameter("pageNum");

		// BoardDAO 객체 - 특정 글의 조회수 1 증가()
		ProductDAO dao = new ProductDAO();
		dao.updateReadcount(bno);

		// BoardDAO 객체 - 특정 글의 정보를 가져옴()
		ProductDTO dto = dao.getProduct(bno);
		request.setAttribute("dto", dto);
		
		/* 글 작성자 정보 */
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = mdao.getMember(dto.getUser_id());
		request.setAttribute("mdto", mdto);
		
		/* 찜 여부 확인 */
		LikeDTO ldto = new LikeDTO();
		ldto.setBno(Integer.parseInt(request.getParameter("bno")));
		ldto.setUser_id(login_id);
		
		LikeDAO ldao = new LikeDAO();
		int likeResult = ldao.likeCheck(ldto); // 찜 여부(0 또는 1)
		//System.out.println("찜 체크 결과: " + likeResult);

		request.setAttribute("likeResult", likeResult);
		
		/* 카테고리 조회에 필요한 정보 */
		String[] catInfo = { "휴대폰&태블릿", "데스크탑", "노트북", "게임기기", "가전제품", "카메라", "음향기기", "기타" };
		int category = Arrays.asList(catInfo).indexOf(dto.getCategory());
		request.setAttribute("category", category);

		/* 프로필 조회에 필요한 정보 */
		List<ProductDTO> userProducts =  dao.getAllUserProducts(dto.getUser_id());
		request.setAttribute("userProducts", userProducts); // 전체 상품 목록
		int sellCount = 0;
		int buyCount = 0;
		
		for(int i = 0; i<userProducts.size(); i++) {
			ProductDTO d = userProducts.get(i);
			if(d.getDeal_way().equals("팝니다")) sellCount++;
			else buyCount++;
		}
		
		request.setAttribute("sellCount", sellCount);
		request.setAttribute("buyCount", buyCount);
		
		//System.out.println(userProducts);

		/* 판매하기 모달에 필요한 정보 */
		List<ProductDTO> sellProduct =  dao.getAllUserProducts(login_id, "팝니다");
		request.setAttribute("sellProduct", sellProduct);
		//System.out.println("sellProduct"+sellProduct);
		
		/* 거래 제안 현황 조회에 필요한 정보 */
		SuggestSellDAO ssdao = new SuggestSellDAO();
		ArrayList<SuggestSellDTO> suggestList = ssdao.getSuggestList(bno);
		request.setAttribute("suggestList", suggestList);
		//System.out.println("suggestList" + suggestList);
		
		ArrayList<ProductDTO> spdto = new ArrayList<ProductDTO>();
		
		for(int i=0; i<suggestList.size(); i++) {
			spdto.add(dao.getProduct(suggestList.get(i).getSell_bno()));
		}
		
		request.setAttribute("spdto", spdto);
		
		// 이미 제안된 상품의 목록을 가져오는 서비스 호출
		SuggestSellDAO  isOffered = new SuggestSellDAO();
		sellProduct = isOffered.getofferOK(sellProduct, bno);
		
		/* 판매 제안 리스트 조회에 필요한 정보 */
		ArrayList<Integer> suggestSellList = ssdao.getSuggestSellList(bno);        
		ArrayList<ProductDTO> ssldto = new ArrayList<ProductDTO>();
		
		for(int i=0; i<suggestSellList.size(); i++) {
			ssldto.add(dao.getProduct(suggestSellList.get(i)));
		}
		
		request.setAttribute("ssldto", ssldto);
		
		// 페이지 이동 준비(./productContent.jsp)
		ActionForward forward = new ActionForward();
		forward.setPath("./productContent.jsp");
		forward.setRedirect(false);

		return forward;
	}
	

}