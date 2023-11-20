<%@page import="com.itwillbs.product.db.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link href="../css/productList.css" rel="stylesheet" />
<title>상품 목록</title>
</head>
<style>



</style>
<body>

	<jsp:include page="../main/header.jsp" />
	
	<div class="title" id="product-list-title">상품 목록</div>
	
<!-- 	<script src="listJS.js"></script> -->
<!-- 이거 그거임 상품목록 카테고리별로 바꾸는 자스 근데 아직 
구현 못해서 냅둘게요 -->
	
	<div id="allproduct">
	<div class ="prd-smenu">
	
	<dl class="cate-1">

		<dt class="blind">상품 분류 리스트</dt>
		<dd>
				<ul>
					<li><a href="../product/ProductList.com?deal_way=삽니다">삽니다</a></li>
					<li><a href="../product/ProductList.com?deal_way=팝니다">팝니다</a></li>
				</ul>
				
				<ul>
					<li><a href="../product/ProductList.com?category=휴대폰%26태블릿&brand=삼성">삼성</a></li>
					<li><a href="../product/ProductList.com?category=휴대폰%26태블릿&brand=애플">애플</a></li>
					<li><a href="../product/ProductList.com?category=휴대폰%26태블릿&brand=엘지">엘지</a></li>
				</ul>
		</dd>
	</dl>
	</div>
</div>

	<!-- 여기에 상품 목록 들어갈 부분 -->
	<div class="container">
		<c:forEach var="dto" items="${ProductList }">
			<!-- 상품들 -->
			<div class="product 
			<c:if test="${dto.deal_status == 0 }">
            disabled
         </c:if>"
			 onclick="toProductContent('./ProductContent.com?bno=${dto.bno}')">
				<div class="product.image">
					<img src="<%=request.getContextPath() %>/upload/${dto.file_name}"
						alt="${dto.title}">
				</div>

				<div class="product-info">
					<h3>[${dto.deal_way }]${dto.title }</h3>
				</div>

				<div class="product-price">
					<p>
						<fmt:formatNumber value="${dto.price }" /> 원
					</p>
				</div>
			</div>
		</c:forEach>
	</div>

	<div id="page_control">
		<c:if test="${startPage > pageBlock }">
			<a
				href="./ProductList.com?pageNum=${startPage-pageBlock }&search=${param.search}&category=${param.category}"
				class="prev-page">이전 페이지</a>
		</c:if>

		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			<c:choose>
				<c:when test="${i != 0}">
					<a href="./ProductList.com?pageNum=${i }&search=${param.search}&category=${param.category}"
						class="page-number">${i }</a>
				</c:when>
			</c:choose>
		</c:forEach>

		<c:if test="${endPage < pageCount }">
			<a
				href="./ProductList.com?pageNum=${startPage+pageBlock }&search=${param.search}&category=${param.category}"
				class="next-page">다음 페이지</a>
		</c:if>
	</div>


<script>
    function toProductContent(url) {
        window.location.href = url;
    }
</script>

	<!-- 추후 추가 가능 -->

<%@ include file="../main/footer.jsp"%>

</body>
</html>