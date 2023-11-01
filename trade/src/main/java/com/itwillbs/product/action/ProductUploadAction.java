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
import javax.servlet.http.Part;

import com.itwillbs.product.db.ProductDAO;
import com.itwillbs.product.db.ProductDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@MultipartConfig(fileSizeThreshold = 0)
public class ProductUploadAction implements Action {
	private static final long serialVersionUID = 1L;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M: ProductUploadAction.execute() 호출");

		// 첨부이미지
		String realPath = request.getRealPath("upload"); // 실제로 파일이 저장되는 장소(가상주소)
		System.out.println(realPath);
		int maxSize = 5 * 1024 * 1024; // 파일 크기 byte * kb * mb(5MB)
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());

//        String uploadPath = request.getServletContext().getRealPath("upload");
//
//        Collection<Part> parts = request.getParts(); // 업로드된 파일과 폼 필드를 모두 가져와 parts에 저장
//        StringBuilder fileNames = new StringBuilder(); // 업로드된 파일 이름을 저장할 변수
//        
//        for (Part part : parts) {
//        	 if (part.getContentType() != null) { // 파일인 경우
//                 String fileName = getSubmittedFileName(part);
//                 if (!fileName.isEmpty()) {
//                     if (fileNames.length() > 0) {
//                         fileNames.append(",");
//                     }
//                     fileNames.append(fileName);
//                 }
//             }
//        }

//		List<String> fileNames = new ArrayList<String>(); // 파일명을 저장할 리스트
//
//        Collection<Part> parts = request.getParts();
//        for (Part part : parts) {
//            if (part.getContentType() != null) { // 파일인 경우
//                String fileName = getSubmittedFileName(part);
//                if (!fileName.isEmpty()) {
//                    fileNames.add(fileName); // 파일명을 리스트에 추가
//                }
//            }
//        }

//		PrintWriter out = response.getWriter();
//		String file_name = "";
//		for (Part part : request.getParts()) {
//			String contentDisposition = part.getHeader("content-diposition");
//			String uploadFileName = getUploadFileName(contentDisposition);
//			part.write(uploadFileName);
//			file_name += uploadFileName;
//		}

//		Part part = request.getPart("files");

//		String fileName = "";
//		List fileList = new ArrayList();
//
//		Enumeration<String> fieldNames = multi.getFileNames();
//
//		while (fieldNames.hasMoreElements()) {
//			String fieldName = fieldNames.nextElement();
//			Part part = request.getPart(fieldName);// 서버에 저장된 파일 이름
//
//			// 파일명 구하기
//			fileName = getFileName(part);
//
//			// 파일명이 공백("")이면 이것은 파일이 아닌 일반 파라미터라는 의미
//			if (!("".equals(fileName))) {
//				fileList.add(fileName);
//				System.out.println("file_name: " + fileName);
//			}
//		}

//ㅇㅇ		String fileName = "";
//		
//		List fileList = new ArrayList();
//		
//		for(Part part : request.getParts()) { // 여기가 잘못된듯,.?
//			// 파일명 구하기
//			fileName = getFileName(part);
//			
//			// 파일명이 공백("")이면 이것은 파일이 아닌 일반 파라미터라는 의미
//			if(!("".equals(fileName))) {
//				fileList.add(fileName);
//				System.out.println("file_name: " + fileName);
//			}
//		}
//		
//		String file_name = "";
//		
//		for(int i=0; i<fileList.size(); i++) {
//			if(i != fileList.size() - 1) {
//				file_name += (fileList.get(i) + ",");				
//			} else {
//				file_name += fileList.get(i);
//			}
//ㅇㅇ		}

		String fileName = "";
		

		List fileList = new ArrayList();

		Enumeration<String> fNames = multi.getFileNames();

		while (fNames.hasMoreElements()) {
			String fName = fNames.nextElement();

			// 파일명 구하기
			fileName = multi.getFilesystemName("file_name");

			// 파일명이 공백("")이면 이것은 파일이 아닌 일반 파라미터라는 의미
			if (!("".equals(fileName))) {
				fileList.add(fileName);
				System.out.println("file_name: " + fileName);
			}
		}

		String file_name = "";

		for (int i = 0; i < fileList.size(); i++) {
			if (i != fileList.size() - 1) {
				file_name += (fileList.get(i) + ",");
			} else {
				file_name += fileList.get(i);
			}
		}

//		String realPath = request.getRealPath("upload");
//		int maxSize = 5 * 1024 * 1024; // 파일 크기 byte * kb * mb(5MB)
//		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
//
//		Enumeration<String> fieldNames = multi.getFileNames();
//		List fileList = new ArrayList();
//		
//		while (fieldNames.hasMoreElements()) {
//		    String fieldName = fieldNames.nextElement();
//		    String fileName = multi.getFilesystemName(fieldName);
//		    if (fileName != null) {
//		        // 파일 업로드가 성공한 경우
//		    	
//		    	fileList.add(fileName);
//		        System.out.println("Uploaded file: " + fileName);
//		    }
//		}

//		Enumeration<String> files = multi.getFileNames();
//		List<String> fileList = new ArrayList<String>();
//
//		while (files.hasMoreElements()) {
//		    String fileName = files.nextElement();
//		    String fName = multi.getFilesystemName(fileName);
//		    if (fName != null) {
//		    	fileList.add(fName);
//		    	System.out.println("fName: " + fName);
//		    }
//		}
//
//		String file_name = "";
//		
//		for(int i=0; i<fileList.size(); i++) {
//			if(i != fileList.size() - 1) {
//				file_name += (fileList.get(i) + ",");				
//			} else {
//				file_name += fileList.get(i);
//			}
//		}

//		String file_name = String.join(",", fileList);

		System.out.println("file_name: " + file_name);

		// 전달정보 저장(DTO)
		ProductDTO dto = new ProductDTO();

		dto.setUser_id(null);
		dto.setDeal_way(request.getParameter("deal_way"));
		dto.setTitle(request.getParameter("title"));
		dto.setCategory(request.getParameter("category"));
		dto.setBrand(request.getParameter("brand"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		dto.setProduct_status(request.getParameter("product_status"));
		dto.setContent(request.getParameter("content"));
		dto.setFile_name(file_name);

		System.out.println("M: " + dto);

		// DAO 글작성 수행 메서드
		ProductDAO dao = new ProductDAO();

		int bno = dao.uploadProduct(dto);

		// 페이지 이동 준비
		ActionForward forward = new ActionForward();

		forward.setPath("./ProductContent.com?bno=" + bno);
		forward.setRedirect(true);

		return forward;
	}

//	private String getSubmittedFileName(Part part) {
//        for (String cd : part.getHeader("content-disposition").split(";")) {
//            if (cd.trim().startsWith("filename")) {
//                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
//                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // 파일 이름 추출
//            }
//        }
//        return null;
//    }

//	private String getUploadFileName(String contentDisposition) {
//		String uploadFileName = null;
//		String[] contentSplitStr = contentDisposition.split(";");
//		int firstQutosIndex = contentSplitStr[2].indexOf("\"");
//		int lastQutosIndex = contentSplitStr[2].lastIndexOf("\"");
//		uploadFileName = contentSplitStr[2].substring(firstQutosIndex, lastQutosIndex);
//
//		return uploadFileName;
//	}

	private String getFileName(Part part) {
		String fileName = "";
		String contentDisposition = part.getHeader("content-disposition");

		String[] items = contentDisposition.split(";");
		for (String item : items) {
			if (item.trim().startsWith("filename")) {
				// filename="test1.txt" ==> item변수값
				fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
			}
		}

		// file이 아닐 경우 => ""이 반환됨, file일 경우 => file명이 반환됨

		return fileName;
	}
}
