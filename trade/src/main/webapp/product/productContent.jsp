<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap">
<link href="../css/header.css" rel="stylesheet" />
<link href="../css/productContent.css" rel="stylesheet" />
<style>
</style>

<title>상세페이지</title>
</head>

<body>

	<%@ include file="../main/header.jsp"%>
	<%
		String filename = request.getParameter("fileName");
		String savePath = "upload";
		String realPath = request.getContextPath() + "/" + savePath;
	%>
	<div class="container">

		<div class="form-group h1">
			<label for="productName">[${dto.deal_way }]${dto.title }</label>
		</div>
		<div class="form-group2">
			<div class="image-container">
				<img src="<%=request.getContextPath() %>/upload/${dto.file_name }" id="imagePreview" alt="미리보기">
			</div>
			<div class="form-container">
				<h2>상세 페이지</h2>
				<div class="form-group">
					<label for="user"><a href="작성자프로필">작성자: ${dto.user_id }</a></label>
				</div>
				
				<div class="form-group">
					<label for="user">조회수: ${dto.views }</label>
				</div>

				<div class="form-group">
					<label for="productCategory">카테고리: <a href="카테고리 검색결과">${dto.category }</a></label>
				</div>

				<div class="form-group">
					<label for="productBrand">브랜드: <a href="브랜드 검색결과">${dto.brand }</a></label>
				</div>
				
				<c:if test="${dto.deal_way.equals('팝니다') }">
				<div class="form-group">
					<label for="productCondition">상품 상태: ${dto.product_status }</label>
				</div>
				</c:if>

				<div class="form-group">
					<label for="productPrice">가격(원): <fmt:formatNumber
							value="${dto.price }" /></label>
				</div>
				<c:if test="${dto.deal_way.equals('팝니다') }">
					<input class="submit-button" type="button" value="구매하기" onclick="location.href='결제페이지';">
				</c:if>
				<c:if test="${dto.deal_way.equals('삽니다') }">
					<input class="submit-button" type="button" value="판매하기" onclick="location.href='물건 고르는 페이지';">
				</c:if>
			</div>
		</div>
			<div class="form-group">
				<label for="productDescription">상품 설명: </label> ${dto.content }
			</div>
	</div>

</body>
</html>