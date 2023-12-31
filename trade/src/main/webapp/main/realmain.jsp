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
<link href="../css/mainSlider.css" rel="stylesheet" />
<title>Modern Tech Market</title>
<link rel="stylesheet" href="https://unpkg.com/swiper">
<link rel="icon" href="../main/img/16px.ico" type="image/x-icon">
</head>
<body>

<div id="all">
   <%@ include file="../main/header.jsp"%>

<div class="swiper-container">
    <div class="swiper-wrapper">
        <div class="swiper-slide">
            <img src="../main/img/event111.png" alt="이미지1">
        </div>
        <div class="swiper-slide">
            <img src="../main/img/event222.png" alt="이미지2">
        </div>
        <div class="swiper-slide">
            <img src="../main/img/event333.png" alt="이미지3">
        </div>
        <div class="swiper-slide">
            <img src="../main/img/event444.png" alt="이미지4">
        </div>
         <div class="swiper-slide">
            <img src="../main/img/event555.png" alt="이미지4">
        </div>
    </div>
    <!-- 페이지네이션 -->
    <div class="swiper-pagination"></div>
</div>

<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script>
/* 슬라이더 */
    var swiper = new Swiper('.swiper-container', {
        // 수평 넘기기
        direction: 'horizontal',
        // 슬라이드 전환 속도
        speed: 1500,
        // 자동 재생 설정 (3초마다)
        autoplay: {
            delay: 2000,
            disableOnInteraction: false,
        },
        // 페이지네이션 추가
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        }
        
    });
</script>

<!-- 추천상품 -->
   <div class="title"><img src="../main/img/producttop.gif" alt="추천상품"></div>
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
   <div class="title"><img src="../main/img/producttopp.gif" alt="추천상품"></div>
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