<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.itwillbs.product.db.ProductDAO"%>
<%@page import="com.itwillbs.product.db.ProductDTO"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap">
<link href="../css/header.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
	
</script>
<title>헤더</title>
</head>
<body>

	<header>
		<nav id="navbar">
			<div class="rgt">
				<div class="logo">
					<a href="../main/Main.com"><img alt="로고" src="../main/img/logo(MTM).png" id="logo"> </a>
				</div>
				<div id="search">
					<div class="rgt1">
						<form action="../product/ProductList.com" method="get" class="search">
							<input type="text" name="search" placeholder="검색어 입력">
							<button type="submit" value="search">검색</button>
						</form>
					</div>
				</div>
				
				<div id="user-menu">
					<span class="user-menu">
						<span>
						<c:if test="${empty user_id }">
								<a href="../main/login.member" id="loginLink">로그인</a>
						</c:if> 
						<c:if test="${!empty user_id }">
							${user_id }님   |   
							<a href="../main/MemberLogout.member" id="logoutLink">로그아웃</a>
						</c:if>
						</span>
						<!-- 아이디x 글등록 => 로그인창 -->
						<span>
						<c:if test="${empty user_id }">
							<a href="../main/login.member" id="loginLink">글등록</a>
						</c:if>
						</span>
						<span>
						<c:if test="${!empty user_id }">
							<a href="../product/ProductUpload.com">글등록</a>
						</c:if>
						</span>
						<span>
						<a href="../member/MemberInfo.member">마이페이지</a>
						</span>
						<span>
						<a href="../member/Member112.member">고객센터</a>
						</span>
						<span>
						<c:if test="${user_id == 'admin' }">
							<a href="../Main.emp">관리자페이지</a>
						</c:if>
						</span>
					</span>
				</div>
			</div>

			<div id="category">
				<span class="category-a" id="category-aa">
					<a href="../product/ProductList.com?deal_way=삽니다">삽니다</a>
					<a href="../product/ProductList.com?deal_way=팝니다">팝니다</a>
				</span>
				<span class="category-b">
					<a href="../product/ProductList.com?category=0">휴대폰&태블릿</a>
					<a href="../product/ProductList.com?category=1">데스크탑</a>
					<a href="../product/ProductList.com?category=2">노트북</a>
					<a href="../product/ProductList.com?category=3">게임기기</a>
					<a href="../product/ProductList.com?category=4">가전제품</a>
					<a href="../product/ProductList.com?category=5">카메라</a>
					<a href="../product/ProductList.com?category=6">음향기기</a>
					<a href="../product/ProductList.com?category=7">기타</a>
				</span>
			</div>

		</nav>
	</header>
	<!-- 나머지 콘텐츠 -->
</body>
</html>