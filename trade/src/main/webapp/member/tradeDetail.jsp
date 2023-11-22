<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap">
<link href="../css/tradeDetail.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../main/header.jsp"%>
	<div class="container">
		<div class="form-container">
			<h2>주문 내역</h2>
			<div class="form-group">
				<label class="h3">주문일시</label>
				<label for="tradeDate">${thdto.tradeDate }</label>
			</div>

			<div class="form-group">
				<label class="h3">상품 정보</label>
				<c:set var="fileNameArr" value="${fn:split(pdto.file_name, ',')}" />
				<div class="product-group" onclick="location.href='../product/ProductContent.com?bno=${pdto.bno}';">
					<img src="<%=request.getContextPath() %>/upload/${fileNameArr[0]}" 
						onerror="this.onerror=null; this.src='../product/img/default_product_image.png';" 
						id="imagePreview" alt="상품사진">
					<div class="product-detail">
					상품명: ${pdto.title }
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label class="h3">결제 금액</label>
				<label><fmt:formatNumber value="${thdto.price}" />원</label>
			</div>

			<div class="form-group">
				<label class="h3">배송지 정보</label>
				<label>수령인: ${mdto.user_name }</label>
				<label>연락처: ${mdto.phone }</label>
				<label>배송지: ${thdto.address }</label>
			</div>


			<div class="center-btn">
				<button class="submit-button" onclick="location.href='';">목록으로</button>
			</div>
		</div>
	</div>
</body>
</html>