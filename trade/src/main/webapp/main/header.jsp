<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/header.css">


<title>쇼핑몰</title>
</head>
<body>

	<header>
		<span class="logo"> <a href="../main/Main.com"><img src="chun.png" alt="로고" width="60px"></a>
		</span>
		
		<span class="category-a"> <a href="#">삽니다</a> <a href="#">팝니다</a>
		</span>
		
        <span class="category-b">
            <a href="../product/ProductList.com?category=휴대폰%26태블릿">휴대폰&태블릿</a>
            <a href="../product/ProductList.com?category=데스크탑">데스크탑</a>
            <a href="../product/ProductList.com?category=노트북">노트북</a>
            <a href="../product/ProductList.com?category=게임기기">게임기기</a>
            <a href="../product/ProductList.com?category=가전제품">가전제품</a>
            <a href="../product/ProductList.com?category=카메라">카메라</a>
            <a href="../product/ProductList.com?category=음향기기">음향기기</a>
            <a href="../product/ProductList.com?category=기타">기타</a>
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
