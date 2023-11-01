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
<<<<<<< HEAD
<style>
.title {
=======
    <style>
    .title {
>>>>>>> b471e28de8cee8f9b7ca2ef74f08a45eabb3b2c4
	width: 100%;
	text-align: center;
	margin-bottom: 50px;
	margin-top: 150px;
	font-size: 30px;
	font-weight: bold;
}
<<<<<<< HEAD

.container {
	max-width: 1200px;
	margin: 150px auto;
	padding: 0 20px;
	display: flex;
	flex-wrap: wrap;
	justify-content: flex-start; /* 왼쪽으로 배치 */
	gap: 30px; /* 아이템 사이의 간격 */
}

#page_control {
=======
	
	#page_control {
>>>>>>> b471e28de8cee8f9b7ca2ef74f08a45eabb3b2c4
    display: flex;
    justify-content: center;
    align-items: center;
  }

  #page_control .prev-page,
  #page_control .page-number,
  #page_control .next-page {
    text-decoration: none;
    padding: 10px 15px;
    margin: 5px;
    background-color: white; /* 흰색 배경색 */
    color: #333; /* 텍스트 색상 설정 */
    border: 1px solid #ccc; /* 테두리 추가 */
    border-radius: 5px;
    transition: background-color 0.3s; /* hover 효과를 위한 전환 효과 */
  }

  #page_control .prev-page:hover,
  #page_control .page-number:hover,
  #page_control .next-page:hover {
    background-color: #333; /* hover 시 배경색 변경 */
    color: white; /* hover 시 텍스트 색상 변경 */
  
}
    
    </style>
</head>
<body>

	<jsp:include page="../main/header.jsp"/>
	
	
	<div class="title">상품 목록</div>
	
	 <!-- 여기에 상품 목록 들어갈 부분 -->
 <div class="container">
 <c:forEach var="dto" items="${ProductList }">

    <!-- 상품들 -->
    <div class="product">
    
    <div class="product.image">
        <img src="<%=request.getContextPath() %>/upload/${dto.file_name}" 
        alt="${dto.title}"> 
	</div>	
		
      <div class="product-info">
        <h3>[${dto.deal_way }]${dto.title }</h3>
      </div>     
            
         <div class="product-price">
            <p><fmt:formatNumber value="${dto.price }" />원</p>
         </div>
            
     </div>
        </c:forEach>
 </div>       

	<div id="page_control">
		<c:if test="${startPage > pageBlock }">
			<a
				href="./ProductList.com?pageNum=${startPage-pageBlock }&search=${param.search}"
				class="prev-page">이전 페이지</a>
		</c:if>

		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			<c:choose>
				<c:when test="${i != 0}">
					<a href="./ProductList.com?pageNum=${i }&search=${param.search}"
						class="page-number">${i }</a>
				</c:when>
			</c:choose>
		</c:forEach>

		<c:if test="${endPage < pageCount }">
			<a
				href="./ProductList.com?pageNum=${startPage+pageBlock }&search=${param.search}"
				class="next-page">다음 페이지</a>
		</c:if>
	</div>




    <!-- 추후 추가 가능 -->



    <footer>
        <p>&copy; 1조 전자기기 중고거래</p>
    </footer>

</body>
</html>