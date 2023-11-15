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
		
		
		// 전달정보 저장
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("글 bno: " + bno);
		String user_id = request.getParameter("user_id");
		System.out.println("글 작성자: " + user_id);
		String complainReason = request.getParameter("reason");
		System.out.println("신고 사유: " + complainReason);
		
		ProductDTO sp_dto = new ProductDTO();
		ProductDAO sp_dao = new ProductDAO();
		sp_dto = sp_dao.getProduct(bno);
		
		// 데이터베이스에 정보 입력
		ComplainDTO cdto = new ComplainDTO();
		cdto.setBno(bno);
		cdto.setComplainer_id(login_id);
		cdto.setUser_id(sp_dto.getUser_id());
		cdto.setComplainReason(complainReason);
		cdto.setUploadDate(cdto.getUploadDate());
		cdto.setEmp_id(cdto.getEmp_id());
		cdto.setCompleteDate(cdto.getCompleteDate());
				
		ComplainDAO cdao = new ComplainDAO();
		ComplainDTO write_bno = cdao.addComplain(cdto);
		
		request.setAttribute("complain", cdto);
		System.out.println("complain: " + cdto);
		
		// 원래 페이지로 이동
		JSMoveFunction.alertLocation(response, "신고가 접수되었습니다", "./ProductContent.com?bno="+bno);
		return null;
	}

}
