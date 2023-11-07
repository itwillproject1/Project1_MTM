<%@page import="com.itwillbs.product.db.ProductDAO"%>
<%@page import="com.itwillbs.product.db.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link href="../css/productContent.css" rel="stylesheet" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<body>
<%@ include file="../main/header.jsp"%>



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
					<input class="update-button" type="button" value="넣을거 있으면">
					</div>
				</h2>
			
				<div class="form-group">
					<label for="user">아이디  : ${dto.user_id }</label>
				</div>
			
				<div class="form-group">
					<label for="user">비밀번호: ${dto.password }</label>
				</div>
			
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
						<input class="submit-button" type="button" value="정보수정"
							onclick="">
						<input class="submit-button" type="button" value="회원탈퇴"
							onclick="">
					
					</div>
			
			</div>
			<!--  내 정보 영역 끝 -->
			
			
			
			
		</div>	
		<!-- 본문 내용 끝 -->
 </div>		
</body>
</html>