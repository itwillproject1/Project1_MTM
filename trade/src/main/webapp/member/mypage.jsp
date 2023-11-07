<%@page import="com.itwillbs.product.db.ProductDAO"%>
<%@page import="com.itwillbs.product.db.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link href="../css/productContent.css" rel="stylesheet" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<body>
<%@ include file="../main/header.jsp"%>



<br><br><br><br><br><br><br>



<div class="container">
		<div class="form-group h1">
			<label for="productName">${dto.user_id }님의 마이페이지입니당</label>	
		</div>
		
		<!-- 이미지 영역 시작 -->
		
		<div class="form-group2">
			<div class="image-container">
				<!-- 이미지를 클릭하면 JavaScript로 크게 보이게 설정 -->
				<div class="image-preview">
					<img src="<%=request.getContextPath() %>/uploadprofile/${dto.profile }"
						id="imagePreview" alt="미리보기" >
				</div>
			</div>
			<div class="form-container">
				<h2>
					상세 페이지
					
				</div>
				</h2>
			</div>
			
			
		</div>	

 </div>		
</body>
</html>