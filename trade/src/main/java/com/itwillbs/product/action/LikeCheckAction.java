package com.itwillbs.product.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.product.db.LikeDAO;
import com.itwillbs.product.db.LikeDTO;
import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class LikeCheckAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LikeCheckAction.execute() 호출");
		// 로그인 아이디 받기
		HttpSession session = request.getSession();
		String login_id = (String) session.getAttribute("user_id");
		
		
		int bno =Integer.parseInt(request.getParameter("bno"));
		// 찜
		LikeDTO ldto = new LikeDTO();
		ldto.setBno(bno);
		ldto.setUser_id(login_id);
	
		LikeDAO ldao = new LikeDAO();
		int result = ldao.likeAction(ldto);
		
		// 총 찜 수
		ProductDAO pdao = new ProductDAO();
		ProductDTO pdto = pdao.getProduct(bno);
		int like_count = pdto.getLike_count();
	
		// ajax에 값 반환
		PrintWriter pw = response.getWriter();
		pw.println(result);
		pw.println(like_count);
		pw.flush();
		
		return null;
	}

}
