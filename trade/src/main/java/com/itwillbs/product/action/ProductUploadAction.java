package com.itwillbs.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductUploadAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M: ProductUploadAction.execute() 호출");

		// 첨부이미지
		String realPath = request.getRealPath("upload"); // 파일이 저장되는 장소(가상주소)
		System.out.println(realPath);
		int maxSize = 5 * 1024 * 1024; // 파일 크기 byte * kb * mb(5MB)
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "UTF-8", new DefaultFileRenamePolicy());

		// 전달정보 저장(DTO)
		ProductDTO dto = new ProductDTO();

		dto.setUser_id(null);
		dto.setDeal_way(multi.getParameter("deal_way"));
		dto.setTitle(multi.getParameter("title"));
		dto.setCategory(multi.getParameter("category"));
		dto.setBrand(multi.getParameter("brand"));
		dto.setPrice(Integer.parseInt(multi.getParameter("price")));
		dto.setProduct_status(multi.getParameter("product_status"));
		dto.setContent(multi.getParameter("content"));
		dto.setFile_name(multi.getFilesystemName("file_name"));

		System.out.println("M: " + dto);

		// DAO 글작성 수행 메서드
		ProductDAO dao = new ProductDAO();

		dao.uploadProduct(dto);
		int bno = dto.getBno();
		ActionForward forward = new ActionForward();

		forward.setPath("./product/ProductContent.com?bno="+bno);
		forward.setRedirect(true);

		return forward;
	}

}
