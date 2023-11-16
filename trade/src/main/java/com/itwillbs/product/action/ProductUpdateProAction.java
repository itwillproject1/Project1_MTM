package com.itwillbs.product.action;

import java.io.File;
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
		
		// 서버에 올라가있는데 수정해서 필요 없어진 파일 어떻게 지울 건지?
		
		// 로그인 한 유저 아이디 세션에서 가져오기
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		
		String before_file_name = request.getParameter("before_file_name");
		
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
		
		// 원래 이미지 
		String[] bFile_name = before_file_name.split(",");
		File file = null;
		
		// 기존 이미지와 fileList 비교해서 없는 이미지는 삭제
		for(String bFileName : bFile_name) {
			boolean found = false;

		    for (String fileName : fileList) {
		        if (bFileName.equals(fileName)) {
		            found = true;
		            break;
		        }
		    }

		    if (!found) {
		        // bFileName 파일 삭제 수행
		    	file = new File(realPath+"/upload/"+bFileName);
		    	file.delete();
		    }
		}

		// 페이지 이동 준비
		forward.setPath("./ProductContent.com?bno=" + bno);
		forward.setRedirect(true);

		return forward;
	}

}
