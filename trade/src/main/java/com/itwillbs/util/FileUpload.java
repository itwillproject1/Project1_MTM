package com.itwillbs.util;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUpload {
	@SuppressWarnings("deprecation")
	public MultipartRequest fileUpload(HttpServletRequest request) throws Exception {
		String realPath = request.getRealPath("upload");
		System.out.println("realPath = " + realPath);
		
		//파일 크기 제한(5MB)
		int maxSize = 5 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(
				request,
				realPath, 
				maxSize, 
				"UTF-8", 
				new DefaultFileRenamePolicy());
		System.out.println("파일 업로드 성공!");

		return multi;
	}
}
