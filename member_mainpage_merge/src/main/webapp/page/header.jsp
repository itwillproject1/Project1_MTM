<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

	<header>
		<span class="logo" >
		<a href="./realmain.member">
		<img src="/member_mainpage_merge/page/chun.png" alt="로고" >
		</a>
		</span>
		
		<span class="category-a"> <a href="#">삽니다</a> <a href="#">팝니다</a>
		</span>
		
        <span class="category-b">
            <a href="#">휴대폰&태블릿</a>
            <a href="#">데스크탑</a>
            <a href="#">노트북</a>
            <a href="#">게임기기</a>
            <a href="#">가전제품</a>
            <a href="#">카메라</a>
            <a href="#">음향기기</a>
            <a href="#">기타</a>
        </span>

		<form action="./productList.product" method="get" class="search">
			<input type="text" name="search" placeholder="검색어 입력">
			<button type="submit" value="search">검색</button>
		</form>


<%String id = (String) session.getAttribute("id"); %>

		<span class="user-menu">
            <% if (id == null) { %>
            <a href="./login.member" id="loginLink">로그인</a>
            <% } else { %>
            <%= session.getAttribute("id") %>님   |   
            <a href="./MemberLogout.member" id="logoutLink">로그아웃</a>
            <% } %>
            <a href="./productUpload.product">글등록</a>
            <a href="#">찜</a>
            <a href="#">마이페이지</a>
        </span>
        
    </header>
    <!-- 나머지 콘텐츠 -->
    

</body>
</html>
