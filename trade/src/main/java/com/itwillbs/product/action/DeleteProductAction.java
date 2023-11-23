package com.itwillbs.product.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

public class DeleteProductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 전달 정보 저장
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// 글 삭제 메서드
		ProductDAO dao = new ProductDAO();
		
		// 등록된 이미지 삭제
		ProductDTO pdto = dao.getProduct(bno);
		String file_name = pdto.getFile_name();
//		String realPath = request.getRealPath("/upload");
//		String realPath = request.getSession().getServletContext().getRealPath("/upload");
		String realPath = request.getRealPath("upload");
		System.out.println("realPath: "+realPath);
		System.out.println(request.getSession().getServletContext().getRealPath("/upload"));
		
		if(!file_name.equals("default_product_image.png")) {
			
		String[] dFile_name = file_name.split(",");
			File file = null;
			
			for(String dFileName : dFile_name) {
				// dFileName 파일 삭제 수행
//				file = new File(realPath + "\\" + dFileName);
				file = new File("/usr/local/tomcat/webapps/trade/upload/"+dFileName);
				file.delete();
			}
		}
		
		int result = dao.deleteProduct(bno);
		
		if(result == 1) {
			// 글 삭제 성공
			JSMoveFunction.alertLocation(response, "글 삭제를 성공적으로 완료하였습니다", "../main/Main.com");
			return null;
		} else {
			JSMoveFunction.alertHistory(response, "글 삭제에 실패하였습니다");
			return null;
		}
	}
}
