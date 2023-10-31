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
<link href="../css/productList.css" rel="stylesheet" />
    <title>상품 목록</title>
</head>
<body>

	<%@ include file="../main/header.jsp"%>
<div class="container">

	<div class="title">상품 목록</div>
	
	
    <!-- 여기에 상품 목록 들어갈 부분 -->

    <!-- 상품들 -->
    
    <div class="product">
        <img src="chun.png" alt="상품1">
        <div class="product-info">
            <h3>춘식이 노트북</h3>
            </div>
            <div class="product-price">
            <p>500,000</p>
        </div>
    </div>

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
    
        	<div class="product">
        <img src="chun6.jpg" alt="상품 6">
        <div class="product-info">
            <h3>닥터드레 춘식</h3>
            </div>
            <div class="product-price">
            <p>800,000</p>
        </div>
    </div>
    

    <!-- 추후 추가 가능 -->

</div>

</body>
</html>