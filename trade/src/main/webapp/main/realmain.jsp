<%@page import="com.itwillbs.product.db.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.itwillbs.product.db.ProductDAO"%>
<%@page import="com.itwillbs.product.db.ProductDTO"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap">
<link href="../css/header.css" rel="stylesheet" />
<link href="../css/main_styles.css" rel="stylesheet" />
<title>쇼핑몰 메인 페이지</title>
</head>
<body>
	<%@ include file="../main/header.jsp"%>

	<!-- 이벤트 슬라이더 -->

	<div class="slider-container">
		<div class="slider">
			<img src="event1.jpg" alt="이미지 1"> <img src="event2.jpg"
				alt="이미지 2"> <img src="event3.jpg" alt="이미지 3">
		</div>
	</div>
	<script src="maineventScript.js"></script>

<!-- 추천상품 -->
	<div class="title">추천 상품</div>
	<div class="container">
		<c:forEach var="product" items="${dto}">

	<div class="product" onclick="toProductContent('../product/ProductContent.com?bno=${product.bno}')">				
			<img src="<%=request.getContextPath() %>/upload/${product.file_name}"
					alt="${product.title}">
				<div class="product-info">
					<h3>[${product.deal_way }]${product.title }</h3>
				</div>
				<div class="product-price">
					<p>
						<fmt:formatNumber value="${product.price }" />
						원
					</p>
				</div>
			</div>
			<!--   <script src="mainproductScript.js"></script> 몰라이거아직구현안함ㅋㅋㅋ -->
		</c:forEach>
	</div>
	
<script>
  function toProductContent(url) {
      window.location.href = url;
  }
</script>
	
	<footer>
		<p>&copy; 1조 전자기기 중고거래</p>
	</footer>
</body>
</html>