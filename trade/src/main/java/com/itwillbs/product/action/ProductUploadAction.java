package com.itwillbs.product.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.mysql.cj.Session;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@MultipartConfig(fileSizeThreshold = 0)
public class ProductUploadAction implements Action {
	private static final long serialVersionUID = 1L;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M: ProductUploadAction.execute() 호출");
		
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

		Enumeration<String> files = multi.getFileNames();
		List<String> fileList = new ArrayList<>();

		while (files.hasMoreElements()) {
		    String fieldName = files.nextElement();
		    String fName = multi.getFilesystemName(fieldName);
		    if (fName != null) {
		        fileList.add(fName);
		        System.out.println("fName: " + fName);
		    }
		}

		String file_name = String.join(",", fileList);
		System.out.println("file_name: " + file_name);

		// 전달정보 저장(DTO)
		ProductDTO dto = new ProductDTO();

		dto.setUser_id(user_id);
		dto.setDeal_way(multi.getParameter("deal_way"));
		dto.setTitle(multi.getParameter("title"));
		dto.setCategory(multi.getParameter("category"));
		dto.setBrand(multi.getParameter("brand"));
		dto.setPrice(Integer.parseInt(multi.getParameter("price")));
		dto.setProduct_status(multi.getParameter("product_status"));
		dto.setContent(multi.getParameter("content"));
		dto.setFile_name(file_name);

		System.out.println("M: " + dto);

		// DAO 글작성 수행 메서드
		ProductDAO dao = new ProductDAO();

		int bno = dao.uploadProduct(dto);

		// 페이지 이동 준비
		

		forward.setPath("./ProductContent.com?bno=" + bno);
		forward.setRedirect(true);

		return forward;
	}

//	private String getFileName(Part part) {
//		String fileName = "";
//		String contentDisposition = part.getHeader("content-disposition");
//
//		String[] items = contentDisposition.split(";");
//		for (String item : items) {
//			if (item.trim().startsWith("filename")) {
//				// filename="test1.txt" ==> item변수값
//				fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
//			}
//		}
//
//		// file이 아닐 경우 => ""이 반환됨, file일 경우 => file명이 반환됨
//
//		return fileName;
//	}
}
