package com.itwillbs.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;

public class deleteFile {

	public static void dFile(HttpServletRequest request, int bno) throws Exception {

		// 등록된 이미지 삭제
		ProductDAO pdao = new ProductDAO();
		ProductDTO pdto = pdao.getProduct(bno);
		String file_name = pdto.getFile_name();
		String realPath = request.getRealPath("upload");

		if (!file_name.equals("default_product_image.png")) {

			String[] dFile_name = file_name.split(",");
			File file = null;

			for (String dFileName : dFile_name) {
				// dFileName 파일 삭제 수행
				// System.out.println("삭제 실행");
//				file = new File(realPath + "\\" + dFileName);
//				file = new File("../upload"+"\\"+dFileName);
				file = new File("/usr/local/tomcat/webapps/trade/upload/"+dFileName);
				file.delete();
			}
		}

		pdao.deleteProduct(bno);

	}

}
