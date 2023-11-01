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
	
	
    <!-- 여기에 상품 목록 들어갈 부분 -->

    <!-- 상품들 -->
    
    <% for (ProductDTO dao : list) { %>
    <div class="product">
        <img src=""<%=request.getContextPath() %>/upload/${file_name}"
						id="productimage">
        <div class="product-info">
            <h3>[${dto.deal_way }]${dto.title }</h3>
            </div>
            <div class="product-price">
            <p><fmt:formatNumber value="${dto.price}" />원</p>
            
            <% } %>
<%
String user_id = request.getParameter("user_id"); // 사용자 아이디 값 설정
ProductDAO dao = new ProductDAO();
ProductDTO dto = dao.ProductInfo(user_id); // ProductInfo는 상품 정보를 가져오는 메서드

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