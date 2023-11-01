<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<style>

#page_control {
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
	<%@ include file="../main/header.jsp"%>
	<div class="title">상품 목록</div>
	<div class="container">
	   <c:forEach var="product" items="${ProductList}">
	        <img src="<%=request.getContextPath() %>/upload/${file_name}" alt="${product.title}">
	        <div class="product-info">
	            <h3>${product.title}</h3>
	            </div>
	            <div class="product-price">
	            <p>${product.price}</p>
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
	<footer>
        <p>&copy; 1조 전자기기 중고거래</p>
    </footer>

</body>
</html>