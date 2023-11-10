package com.itwillbs.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.LikeDAO;
import com.itwillbs.product.db.LikeDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class LikeCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 찜
		LikeDTO ldto = new LikeDTO();
		LikeDAO ldao = new LikeDAO();
		int result = ldao.likeCheck(ldto); // 찜 여부(0 또는 1)
		System.out.println("찜 체크 결과: " + result);
	
		// ajax에 값 반환
		request.setAttribute("result", result);		
		
		return null;
	}

}
