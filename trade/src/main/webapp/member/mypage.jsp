<%@page import="com.itwillbs.product.db.ProductDAO"%>
<%@page import="com.itwillbs.product.db.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link href="../css/mypage.css" rel="stylesheet" />
<link href="../css/main_styles_mypage.css" rel="stylesheet" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

</head>
<body>
<%@ include file="../main/header.jsp"%>
<script type="text/javascript">

function pay() {
	
	let checkid = window.open("../member/MemberPayInfo.member","pay","width=600,height=650, scrollbars=yes, resizable=yes");
	
	
}




</script>


<br><br><br><br><br><br><br>



<div class="container">
		<div class="form-group h1">
			<label for="productName">${dto.user_id }님의 마이페이지입니당</label>
		</div>
		
		
		<!-- 본문 내용 시작 -->
		<div class="form-group2">
		
		<!-- 이미지 영역 시작 -->
			<div class="image-container">
				
				<div class="image-preview">
					<img src="<%=request.getContextPath() %>/uploadprofile/${dto.profile }"
						id="imagePreview" alt="미리보기" >
				</div>
			</div>
		<!-- 이미지 영역 종료 -->
			
			<!--  내 정보 영역 -->
			<div class="form-container">
				<h2>
					내 정보
					<div class="dropdown">
					<input class="submit-button" type="button" value="충전하기" onclick="pay();">
					</div>
				</h2>
			
				<div class="form-group">
					<label for="user">아이디  : ${dto.user_id }</label>
				</div>
				
				<div class="form-group">
					<label for="user">비밀번호 : <span id="passwordDisplay"></span></label>
				</div>
				
				<script>
				const dto = {
    				password: "${dto.password }" // DTO에서 비밀번호 가져오기
  					};

  				const passwordDisplay = document.getElementById("passwordDisplay");
  				const password = dto.password;

  				// 비밀번호를 '*'로 숨깁니다
				const hiddenPassword = '*'.repeat(password.length);

  				passwordDisplay.textContent = hiddenPassword;
				</script>
				
				<div class="form-group">
					<label for="user">회원이름: ${dto.user_name }</label>
				</div>
			
				<div class="form-group">
					<label for="user">닉네임  : ${dto.user_nickname }</label>
				</div>
				
				<div class="form-group">
					<label for="user">생년월일: ${dto.jumin }</label>
				</div>
				
				<div class="form-group">
					<label for="user">성별    : ${dto.gender }</label>
				</div>
				
				<div class="form-group">
					<label for="user">이메일  : ${dto.email }</label>
				</div>
				
				<div class="form-group">
					<label for="user">주소    : ${dto.address }</label>
				</div>
				
				<div class="form-group">
					<label for="user">전화번호: ${dto.phone }</label>
				</div>
				
				
				
					<div class="button-container">
						<button class="submit-button" type="button"
							onclick="window.location.href = '../member/Memberupdate.member'">정보수정</button>
						<button class="submit-button" type="button"
							onclick="window.location.href = '../member/removemember.member'">회원탈퇴</button>
					
					</div>
			
			</div>
			<!--  내 정보 영역 끝 -->
			
			
			
			
		</div>	
		<!-- 본문 내용 끝 -->
 </div>		
 
 
 
 
 <!--  내가 올린 상품  시작-->
 <div class="title1">내가 올린 상품</div>
 <div class="container1">
	
		<c:forEach var="product" items="${mpbdto}">
		<c:set var="fileNameArr" value="${fn:split(product.file_name, ',')}" />
			<div class="product1" onclick="toProductContent('../product/ProductContent.com?bno=${product.bno}')">				
			<img src="<%=request.getContextPath() %>/upload/${fileNameArr[0] }"
					alt="${product.title}">
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
			<!--   <script src="mainproductScript.js"></script> 몰라이거아직구현안함ㅋㅋㅋ -->
		</c:forEach>
</div>
 
 <script>
  function toProductContent(url) {
      window.location.href = url;
  }
</script>
 
 
 
 
 <!--  내가 올린 상품 끝 -->
 
 
 <!--  내가 찜한 상품 시작-->
 
  <div class="title1">내가 찜한 상품</div>
 <div class="container1">
	
		<c:forEach var="product" items="${productlikelist}">
		<c:set var="fileNameArr" value="${fn:split(product.file_name, ',')}" />
			<div class="product1" onclick="toProductContent('../product/ProductContent.com?bno=${product.bno}')">				
			<img src="<%=request.getContextPath() %>/upload/${fileNameArr[0] }"
					alt="${product.title}">
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
			<!--   <script src="mainproductScript.js"></script> 몰라이거아직구현안함ㅋㅋㅋ -->
		</c:forEach>
</div>
 
 <!--  내가 찜한 상품 끝 -->
 
 
 
 
 
 
 
 
 
 
 
 
 
 
</body>
</html>