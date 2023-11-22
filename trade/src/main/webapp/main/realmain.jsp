<%-- <%@page import="com.itwillbs.product.db.ProductDTO"%> --%>
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
<link href="../css/main_styles.css" rel="stylesheet" />
<link href="../css/swiper-bundle.min.css" rel="stylesheet" />
<title>쇼핑몰 메인 페이지</title>
    <link rel="stylesheet" href="https://unpkg.com/swiper">
     <style>
        /* 슬라이드 컨테이너 스타일 */
        .swiper-container {
            width: 100%;
            height: 100%;
        }
        /* 각 슬라이드 아이템 스타일 */
        .swiper-slide img {
            margin-top: 9rem;
            width: 800px;
            height: auto;
            object-fit: cover; /* 이미지 비율 유지 */
        }
        
.swiper-horizontal>.swiper-pagination-bullets,.swiper-pagination-bullets.swiper-pagination-horizontal,.swiper-pagination-custom,.swiper-pagination-fraction {
    bottom: var(--swiper-pagination-bottom,8px);
    top: var(--swiper-pagination-top,auto);
    left: 0;
    width: 100%;
    top: 38rem;
}


.swiper-button-prev,
.swiper-button-next {
    bottom: auto !important;
    top: 23rem !important;
}

.swiper-button-prev {
    left: 8rem !important;
}

.swiper-button-next {
    right: 8rem !important;
}

    </style>

</head>
<body>
<div id="all">
   <%@ include file="../main/header.jsp"%>

<div class="swiper-container">
    <div class="swiper-wrapper">
        <div class="swiper-slide">
            <img src="../main/img/event1.png" alt="이미지 1">
        </div>
        <div class="swiper-slide">
            <img src="../main/img/event2.png" alt="이미지 2">
        </div>
        <div class="swiper-slide">
            <img src="../main/img/event3.png" alt="이미지 3">
        </div>
    </div>
    <!-- 이전, 다음 버튼 -->
<!--     <div class="swiper-button-prev"></div> -->
<!--     <div class="swiper-button-next"></div> -->
    <!-- 페이지네이션 -->
    <div class="swiper-pagination"></div>
</div>

<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script>
    var swiper = new Swiper('.swiper-container', {
        // 슬라이드 방향 지정 (수평 슬라이드)
        direction: 'horizontal',
        // 슬라이드 전환 속도 (밀리초)
        speed: 600,
        // 자동 재생 설정 (3초마다)
        autoplay: {
            delay: 3000,
            disableOnInteraction: false,
        },
        // 이전/다음 버튼 추가
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
        // 페이지네이션 추가
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
    });
</script>

<!-- 추천상품 -->
   <div class="title">추천 상품</div>
   <div class="container">
      <c:forEach var="product" items="${dto}">
      <c:set var="fileNameArr" value="${fn:split(product.file_name, ',')}" />
         <div class="product  
         <c:if test="${product.deal_status == 0 }">
            disabled
         </c:if>"
         onclick="toProductContent('../product/ProductContent.com?bno=${product.bno}')" >            
         <img src="<%=request.getContextPath() %>/upload/${fileNameArr[0] }"
         	  onerror="this.onerror=null; this.src='../product/img/default_product_image.png';"
              alt="${product.title}" >
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
      </c:forEach>
   </div>
   
<!-- 최신상품 -->
   <div class="title">최신 상품</div>
   <div class="container">
   
      <c:forEach var="product" items="${dto2}">
      <c:set var="fileNameArr" value="${fn:split(product.file_name, ',')}" />
         <div class="product
         <c:if test="${product.deal_status == 0 }">
            disabled
         </c:if>"
         onclick="toProductContent('../product/ProductContent.com?bno=${product.bno}')">            
         <img src="<%=request.getContextPath() %>/upload/${fileNameArr[0]}" 
         	  onerror="this.onerror=null; this.src='../product/img/default_product_image.png';"
              alt="${product.title}" >
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
      </c:forEach>
   </div>
   
<script>
  function toProductContent(url) {
      window.location.href = url;
  }
</script>
   
  <%@ include file="../main/footer.jsp"%>
   </div>
</body>
</html>