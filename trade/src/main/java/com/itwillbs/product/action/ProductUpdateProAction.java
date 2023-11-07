package com.itwillbs.product.action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M: ProductUpdateProAction.execute 호출");
		
		// 나중에 실제 서버에 올라간 없어진 파일 지우기, 
		// DefaultFileRenamePolicy로 바뀐 파일 이름 어떻게 할지 생각해야할듯 
		
		// 로그인 한 유저 아이디 세션에서 가져오기
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("id");
		System.out.println("user_id: " + user_id);		
		
		ActionForward forward = new ActionForward();
		
		// 로그인 제어
//		if(id == null) {
//			forward.setPath("./Main.me");
//			forward.setRedirect(true);
//			return forward;
//		}

		// 첨부이미지
		String realPath = request.getRealPath("upload");
		int maxSize = 5 * 1024 * 1024; // 파일 크기 byte * kb * mb(5MB)
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());

		List<String> fileList = new ArrayList<>();
		
		for(int i=1; i<=5;i++) {
			if(!multi.getParameter("file_name"+i).equals("")) {
				fileList.add(multi.getParameter("file_name"+i));
			} else {
				break;
			}
		}

		String file_name = String.join(",", fileList);
		System.out.println("file_name: " + file_name);

		// 전달정보 저장(DTO)
		ProductDTO dto = new ProductDTO();
		
		dto.setBno(Integer.parseInt(multi.getParameter("bno")));
		dto.setDeal_way(multi.getParameter("deal_way"));
		dto.setTitle(multi.getParameter("title"));
		dto.setCategory(multi.getParameter("category"));
		dto.setBrand(multi.getParameter("brand"));
		dto.setPrice(Integer.parseInt(multi.getParameter("price")));
		dto.setProduct_status(multi.getParameter("product_status"));
		dto.setContent(multi.getParameter("content"));
		dto.setFile_name(file_name);

		System.out.println("M: " + dto);

		// DAO 글 수정 수행 메서드
		ProductDAO dao = new ProductDAO();

		int bno = dao.updateProduct(dto);

		// 페이지 이동 준비
		forward.setPath("./ProductContent.com?bno=" + bno);
		forward.setRedirect(true);

		return forward;
	}

}
