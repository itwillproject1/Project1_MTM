package com.itwillbs.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;

public class deleteFile{
	
	public void dFile(HttpServletRequest request, HttpServletResponse response, int bno) throws Exception {
		
		// 글 삭제 메서드
		ProductDAO pdao = new ProductDAO();

		// 등록된 이미지 삭제
		ProductDTO pdto = pdao.getProduct(bno);
		String file_name = pdto.getFile_name();
		String realPath = request.getRealPath("upload");

		if(!file_name.equals("default_product_image.png"))
		{

			String[] dFile_name = file_name.split(",");
			File file = null;

			for (String dFileName : dFile_name) {
				// dFileName 파일 삭제 수행
				// System.out.println("삭제 실행");
				file = new File(realPath + "\\" + dFileName);
				file.delete();
			}
		}

		pdao.deleteProduct(bno);

	}
	
}
