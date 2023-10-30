package com.itwillbs.product.action;

import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class ProductContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M: ProductContentAction.execute() 호출");

		// 전달정보 저장(bno, pageNum, fileName)
		int bno = 10; // 추후 수정
		String pageNum = request.getParameter("pageNum");
		String fileName = "file1";

		// BoardDAO 객체 - 특정 글의 조회수 1 증가()
		ProductDAO dao = new ProductDAO();
		dao.updateReadcount(bno);

		// BoardDAO 객체 - 특정 글의 정보를 가져옴()
		ProductDTO dto = dao.getProduct(bno);
		
		// BoardDAO 객체 - 이미지 파일명 가져옴()
		
		// 이미지 파일명 가져오기
		fileName = dao.getProduct(fileName); 

		// 최종적으로 다운로드할 파일의 위치 가져오기
		String savePath = "upload";
		String dFilePath = request.getServletContext().getRealPath(savePath) + "/" + fileName;

		// MIME 타입 설정
		String mimeType = request.getServletContext().getMimeType(dFilePath);
		if (mimeType == null) {
		    mimeType = "application/octet-stream";
		}
		System.out.println("mimeType: " + mimeType);

		// 파일을 열어서 읽을 수 있는 객체
		FileInputStream fis = new FileInputStream(dFilePath);

		// 파일명을 request에 설정
		request.setAttribute("fileName", fileName);

		// 나머지 부분은 그대로 유지
		// ...

		// 페이지 이동 준비(./productContent.jsp)
		ActionForward forward = new ActionForward();
		forward.setPath("./productContent.jsp");
		forward.setRedirect(false);

		return forward;

	}

}
