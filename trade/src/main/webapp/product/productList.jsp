<%@page import="com.itwillbs.product.db.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.itwillbs.product.db.ProductDAO"%>
<%@page import="com.itwillbs.product.db.ProductDTO"%>
<% ProductDAO productDAO = new ProductDAO(); %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap">
<link href="../css/header.css" rel="stylesheet" />
<link href="../css/productList.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
 <script type="text/javascript">
$(document).ready(function () {

        // 각 링크에 대한 클릭 이벤트 리스너 추가
        $('.dealWayLink, .brandLink').on('click', function (event) {
            event.preventDefault(); // 기본 동작 중지 (링크 이동 방지)

            // 현재 URL 가져오기
            var currentUrl = window.location.href;

            // 클릭된 링크의 href 속성 가져오기
            var linkHref = $(this).attr('href');

            // 현재 URL에서 deal_way 또는 brand 매개변수 제거
            currentUrl = currentUrl.replace(/&deal_way=[^&]*/g, '');
            currentUrl = currentUrl.replace(/&brand=[^&]*/g, '');

            // 클릭된 링크의 href를 현재 URL에 추가하여 새로운 URL 생성
            var newUrl = currentUrl.indexOf('?') === -1 ? currentUrl + linkHref : currentUrl + '&' + linkHref;

            // 생성된 URL로 페이지 이동
            window.location.href = newUrl;
        });

    /////////////////////////////////////////////////////////////
	  
    // 페이지 이동 함수
    function changePage(pageNum, search, deal_way, category, brand) {
        var url = "./ProductList.com?pageNum=" + pageNum + "&search=" + search;

        if (deal_way) {
            url += "&deal_way=" + deal_way;
        }

        if (category) {
            url += "&category=" + category;
        }

        if (brand) {
            url += "&brand=" + brand;
        }

        window.location.href = url;
    }

    // 상세 페이지로 이동하는 함수
    function toProductContent(url) {
        window.location.href = url;
    }

    // 상세 페이지 이벤트
    $('.product').on('click', function () {
        var bno = $(this).data('bno');
        toProductContent('./ProductContent.com?bno=' + bno);
    });

    // 페이지 번호 클릭 시 이벤트 처리
    $('.page-number').on('click', function () {
        var pageNum = $(this).text();
        changePage(pageNum, '${param.search}', '${param.deal_way}', '${param.category}');
    });

    // 이전 페이지 클릭 시 이벤트 처리
    $('.prev-page').on('click', function () {
        var pageNum = parseInt('${startPage - pageBlock}');
        changePage(pageNum, '${param.search}', '${param.deal_way}', '${param.category}', '${param.brand}');
    });

    // 다음 페이지 클릭 시 이벤트 처리
    $('.next-page').on('click', function () {
        var pageNum = parseInt('${startPage + pageBlock}');
        changePage(pageNum, '${param.search}', '${param.deal_way}', '${param.category}', '${param.brand}');
    });
});
     

</script>
<title>상품 목록</title>
</head>
<body>

	<jsp:include page="../main/header.jsp" />
	
	<div class="title" id="product-list-title">상품 목록</div>
	
	<div id="allproduct">
	<div class ="prd-smenu">
	
	<dl class="cate-1">

		<dt class="blind">상품 분류 리스트</dt>
		<dd>
				<ul id="dealWayList">
				<c:forEach var="dealWay" items="${dealWayList}">
						<li><a href="../product/ProductList.com?category=${param.category}&deal_way=${dealWay}">${dealWay}</a></li>
				</c:forEach>
				</ul>
				

        <ul id="subCategory">
            <c:forEach var="brand" items="${brandList }">
                <li><a href="../product/ProductList.com?category=${param.category}&brand=${brand}">${brand}</a></li>
            </c:forEach>
        </ul>


				
		</dd>
	</dl>
	</div>
</div>


	<!-- 여기에 상품 목록 들어갈 부분 -->
	<div class="container">
		<c:forEach var="dto" items="${ProductList }">
			<!-- 상품들 -->
			<div class="product" data-bno="${dto.bno}">
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
        <a href="#" class="prev-page">이전 페이지</a>
    </c:if>

    <c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
        <c:choose>
            <c:when test="${i != 0}">
                <a href="#" class="page-number">${i }</a>
            </c:when>
        </c:choose>
    </c:forEach>

    <c:if test="${endPage < pageCount }">
        <a href="#" class="next-page">다음 페이지</a>
    </c:if>
</div>


	<footer>
		<p>&copy; 1조 전자기기 중고거래</p>
	</footer>

</body>
</html>