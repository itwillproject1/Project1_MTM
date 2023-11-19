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
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
 <script type="text/javascript">
 $(document).ready(function () {
	 
	 function getBrandListFromServer(category, callback) {
		  var xhr = new XMLHttpRequest();
		  var url = '../your-server-endpoint?category=' + encodeURIComponent(category);

		  xhr.onreadystatechange = function () {
		    if (xhr.readyState === XMLHttpRequest.DONE) {
		      if (xhr.status === 200) {
		        // 성공적으로 데이터를 받아왔을 때 콜백 함수 호출
		        var brandList = JSON.parse(xhr.responseText);
		        callback(brandList);
		      } else {
		        // 에러 처리
		        console.error('브랜드 목록을 가져오는 중 에러 발생');
		      }
		    }
		  };

		  xhr.open('GET', url, true);
		  xhr.send();
		}

	  // 브랜드 목록을 동적으로 생성하는 함수
	  function createBrandList(category) {
	    // 브랜드 목록 가져오기
	    var brandList = getBrandList(category);

	    // ul 요소 가져오기
	    var ul = document.getElementById('subCategory');

	    // 기존 목록 초기화
	    ul.innerHTML = '';

	    // 브랜드 목록을 li 요소로 동적 생성하여 ul에 추가
	    for (var i = 0; i < brandList.length; i++) {
	      var brand = brandList[i];
	      var li = document.createElement('li');
	      var a = document.createElement('a');
	      a.href = '../product/ProductList.com?category=' + category + '&brand=' + encodeURIComponent(brand);
	      a.textContent = brand;
	      li.appendChild(a);
	      ul.appendChild(li);
	    }
	  }

	  // 페이지 로드 시 초기 브랜드 목록 생성 (여기에서는 휴대폰&태블릿으로 초기화)
	  createBrandList('휴대폰%26태블릿');
		  
		  
     // 페이지 번호 클릭 시 이벤트 처리
     $('.page-number').on('click', function () {
         var pageNum = $(this).text();
         changePage(pageNum, '${param.search}', '${param.deal_way}', '${param.category}');
     });

     // 이전 페이지 클릭 시 이벤트 처리
     $('.prev-page').on('click', function () {
         var pageNum = parseInt('${startPage - pageBlock}');
         changePage(pageNum, '${param.search}', '${param.deal_way}', '${param.category}','${param.brand}');
     });

     // 다음 페이지 클릭 시 이벤트 처리
     $('.next-page').on('click', function () {
         var pageNum = parseInt('${startPage + pageBlock}');
         changePage(pageNum, '${param.search}', '${param.deal_way}', '${param.category}','${param.brand}');
     });
     
     function toProductContent(url) {
 	    window.location.href = url;
 	}
     
 	 // 상세 페이지 이벤트
     $('.product').on('click', function () {
         var bno = $(this).data('bno');
         toProductContent('./ProductContent.com?bno=' + bno);
     });
 	 

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
				<ul>
					<li><a href="../product/ProductList.com?deal_way=삽니다">삽니다</a></li>
					<li><a href="../product/ProductList.com?deal_way=팝니다">팝니다</a></li>
				</ul>
				
				<ul id="subCategory">
					<li><a href="../product/ProductList.com?category=휴대폰%26태블릿&brand=삼성">삼성</a></li>
					<li><a href="../product/ProductList.com?category=휴대폰%26태블릿&brand=애플">애플</a></li>
					<li><a href="../product/ProductList.com?category=휴대폰%26태블릿&brand=기타">기타</a></li>
					
					<li><a href="../product/ProductList.com?category=데스크탑&brand=삼성">삼성</a></li>
					<li><a href="../product/ProductList.com?category=데스크탑&brand=엘지">엘지</a></li>
					<li><a href="../product/ProductList.com?category=데스크탑&brand=애플">애플</a></li>
					<li><a href="../product/ProductList.com?category=데스크탑&brand=HP">HP</a></li>
					<li><a href="../product/ProductList.com?category=데스크탑&brand=기타">기타</a></li>
					
					<li><a href="../product/ProductList.com?category=노트북brand=삼성">삼성</a></li>
					<li><a href="../product/ProductList.com?category=노트북&brand=엘지">엘지</a></li>
					<li><a href="../product/ProductList.com?category=노트북&brand=애플">애플</a></li>
					<li><a href="../product/ProductList.com?category=노트북&brand=HP">HP</a></li>
					<li><a href="../product/ProductList.com?category=노트북&brand=레노버">레노버</a></li>
					<li><a href="../product/ProductList.com?category=노트북&brand=기타">기타</a></li>
					
					<li><a href="../product/ProductList.com?category=게임기기&brand=플레이스테이션">PS</a></li>
					<li><a href="../product/ProductList.com?category=게임기기&brand=닌텐도">닌텐도</a></li>
					<li><a href="../product/ProductList.com?category=게임기기&brand=기타">기타</a></li>
					
					<li><a href="../product/ProductList.com?category=가전제품&brand=삼성">삼성</a></li>
					<li><a href="../product/ProductList.com?category=가전제품&brand=엘지">엘지</a></li>
					<li><a href="../product/ProductList.com?category=가전제품&brand=기타">기타</a></li>
					
					<li><a href="../product/ProductList.com?category=카메라&brand=캐논">캐논</a></li>
					<li><a href="../product/ProductList.com?category=카메라&brand=니콘">니콘</a></li>
					<li><a href="../product/ProductList.com?category=카메라&brand=소니">소니</a></li>
					<li><a href="../product/ProductList.com?category=카메라&brand=라이카">라이카</a></li>
					<li><a href="../product/ProductList.com?category=카메라&brand=코닥">코닥</a></li>
					<li><a href="../product/ProductList.com?category=카메라&brand=기타">기타</a></li>
					
					<li><a href="../product/ProductList.com?category=음향기기&brand=소니">소니</a></li>
					<li><a href="../product/ProductList.com?category=음향기기&brand=보스">보스</a></li>
					<li><a href="../product/ProductList.com?category=음향기기&brand=마샬">마샬</a></li>
					<li><a href="../product/ProductList.com?category=음향기기&brand=기타">기타</a></li>
				</ul>
				
<!-- 				<form action="../product/ProductList.com" method="get" class="search"> -->
<!-- 				<input type="text" name="searchPart" placeholder="카테고리 내 검색어 입력"> -->
<!-- 				<button type="submit" value="search">검색</button> -->
<!-- 				</form> 카테고리별 검색 보류	 -->
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