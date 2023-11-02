<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../header.css">


<title>쇼핑몰</title>
</head>
<body>

	<header>
		<span class="logo"> <img src="logo.png" alt="로고">
		</span>
		
		<span class="category-a"> <a href="#">삽니다</a> <a href="#">팝니다</a>
		</span>
		
        <span class="category-b">
            <a href="./ProductList.com?category=휴대폰&태블릿">휴대폰&태블릿</a>
            <a href="#">데스크탑</a>
            <a href="#">노트북</a>
            <a href="#">게임기기</a>
            <a href="#">가전제품</a>
            <a href="#">카메라</a>
            <a href="#">음향기기</a>
            <a href="#">기타</a>
        </span>

		<form action="./ProductList.com" method="get" class="search">
			<input type="text" name="search" placeholder="검색어 입력">
			<button type="submit" value="search">검색</button>
		</form>


		<span class="user-menu">
            <a href="../member/login.com">로그인</a>
            <a href="../product/ProductUpload.com">글등록</a>
            <a href="#">찜</a>
            <a href="#">마이페이지</a>
        </span>
        
    </header>
    <!-- 나머지 콘텐츠 -->
</body>
</html>
