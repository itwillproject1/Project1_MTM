package com.itwillbs.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.product.db.ComplainDAO;
import com.itwillbs.product.db.ComplainDTO;
import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.product.db.SuggestSellDAO;
import com.itwillbs.product.db.SuggestSellDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

public class ComplainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그인 아이디 받기
		HttpSession session = request.getSession();
		String login_id = (String) session.getAttribute("user_id");
		request.setAttribute("login_id", login_id);
		
		String[] postReasons = {"불법 상품 또는 서비스 판매",
								"불쾌한, 혐오스러운 내용이나 이미지 포함",
								"거짓 정보, 거짓 광고, 또는 과장된 설명",
								"저작권 침해 (타인의 이미지 또는 콘텐츠 무단 사용)", 
								"사기성 게시글 (실제로 판매되지 않는 상품)", 
								"개인 정보 침해 (타인의 개인 정보 공개)", 
								"광고 스팸 또는 중복 게시글",
								"기타"};
		String[] authorReasons = {"거래 사기 또는 부정행위 (송금 후 발송X)",
							      "거래 후 불만 및 환불 요청 무시",
							      "불쾌한 언행 또는 협상 방해", 
							      "거짓 프로필 정보 또는 사진 사용",
							      "반복적인 불법 행동 (여러 사용자를 속임)", 
							      "규정 위반 (중고거래 플랫폼의 규정을 어기는 행동)", 
							      "욕설, 혐오 내용 또는 괴롭힘", 
							      "기타"};
		
		// 전달정보 저장
		int bno = Integer.parseInt(request.getParameter("bno"));
	//	System.out.println("글 bno: " + bno);
		String complainReason = request.getParameter("reason");
	//	System.out.println("신고 사유: " + complainReason);
		
		int res = Integer.parseInt(request.getParameter("reason"));
		
		String reason = "";
		
		String reportType = request.getParameter("reportType");
		if(reportType.equals("postReport")) {
			reason = postReasons[res-1] ;
			if(reason.equals("기타")) reason = request.getParameter("otherReason");
		}
		else if(reportType.equals("authorReport")) {
			reason = authorReasons[res-1];
			if(reason.equals("기타")) reason = request.getParameter("otherReason2");
		}
		
		ProductDTO sp_dto = new ProductDTO();
		ProductDAO sp_dao = new ProductDAO();
		sp_dto = sp_dao.getProduct(bno);
		
		// 데이터베이스에 정보 입력
		ComplainDTO cdto = new ComplainDTO();
		cdto.setBno(bno);
		cdto.setComplainer_id(login_id);
		cdto.setUser_id(sp_dto.getUser_id());
		cdto.setComplainReason(reason);
		cdto.setUploadDate(cdto.getUploadDate());
		cdto.setEmp_id(cdto.getEmp_id());
		cdto.setCompleteDate(cdto.getCompleteDate());
				
		ComplainDAO cdao = new ComplainDAO();
		ComplainDTO write_bno = cdao.addComplain(cdto);
		
		request.setAttribute("complain", cdto);
		//System.out.println("complain: " + cdto);
		
		// 원래 페이지로 이동
		JSMoveFunction.alertLocation(response, "신고가 접수되었습니다", "./ProductContent.com?bno="+bno);
		return null;
	}

}
