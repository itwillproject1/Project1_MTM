<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap">
<link href="../css/header.css" rel="stylesheet" />
<link href="../jsp__/main_styles.css" rel="stylesheet" />
    <title>쇼핑몰 메인 페이지</title>
</head>
<body>
<%@ include file="../main/header.jsp"%>

	<!-- 이벤트 슬라이더 -->

    <div class="slider-container">
    <div class="slider">
      <img src="event1.jpg" alt="이미지 1">
      <img src="event2.jpg" alt="이미지 2">
      <img src="event3.jpg" alt="이미지 3">
    </div>
  </div>
  <script src="maineventScript.js"></script>
  
  
    <!-- 추천상품 -->
    
<div class="container">

   <div class="title">추천 상품</div>
  
   <div class="product">
        <img src="chun2.png" alt="상품2">
        <div class="product-info">
            <h3>춘식이 아몰레드 TV</h3>
            </div>
            <div class="product-price">
            <p>2,000,000</p>
        </div>
            </div>
        
            <div class="product">
        <img src="chun3.jpg" alt="상품 3">
        <div class="product-info">
            <h3>갤럭시 춘식이 에디션</h3>
            </div>
            <div class="product-price">
            <p>2,000,000</p>
        </div>
            </div>
        
            <div class="product">
        <img src="chun4.jpg" alt="상품 4">
        <div class="product-info">
            <h3>아이폰 춘식이 에디션</h3>
            </div>
            <div class="product-price">
            <p>3,000,000</p>
        </div>
    </div>
    
    		<div class="product">
        <img src="chun.png" alt="상품 5">
        <div class="product-info">
            <h3>한정판 춘식맥</h3>
            </div>
            <div class="product-price">
            <p>4,000,000</p>
        </div>
  </div>
  
  <script src="mainproductScript.js"></script> <!-- 몰라이거아직구현안함ㅋㅋㅋ -->
</div>
    <footer>
        <p>&copy; 1조 전자기기 중고거래</p>
    </footer>
</body>
</html>