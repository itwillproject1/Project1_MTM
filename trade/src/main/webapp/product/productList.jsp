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
<body>

	<%@ include file="../main/header.jsp"%>
<div class="container">

	<div class="title">상품 목록</div>
	
	<%
        // 액션 페이지에서 설정한 boardList 가져오기
        ArrayList<ProductDTO> productList = (ArrayList<ProductDTO>) request.getAttribute("boardList");

        if (productList != null && !productList.isEmpty()) {
            // productList가 비어 있지 않은 경우에만 처리
            for (ProductDTO product : productList) {
    %>
	
	
    <!-- 여기에 상품 목록 들어갈 부분 -->

    <!-- 상품들 -->
    
    <div class="product-list">
    
    <div class="product">
        <img src="<%= request.getContextPath() %>/upload/${file_name}"
        		alt="Product Image">
			
        <div class="product-info">
            <h3>[${dto.deal_way }]${dto.title }</h3>
            </div>
            
            <div class="product-price">
            <p><fmt:formatNumber value="${dto.price}" />원</p>
            
        </div>
            <%
            }
        } else {
    %>
            <p>No products found.</p>
    <%
        }
    %>
        

        
    </div>
 </div>

    <!-- 추후 추가 가능 -->

</div>
    <footer>
        <p>&copy; 1조 전자기기 중고거래</p>
    </footer>

</body>
</html>