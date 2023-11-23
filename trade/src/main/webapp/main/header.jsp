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
<link href="../css/header.css?S" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
   
</script>
<title>헤더</title>
</head>
<body>
<header>
   <nav id="navbar">
   <img alt="헤더사진" src="../main/img/headerimage.png" id="headerimage">
      <div class="rgt">
         <div class="logo">
            <a href="../main/Main.com"><img alt="로고" src="../main/img/logosero.png" id="logo"> </a>
         </div>
         <div id="search">
            <div class="rgt1">
               <form action="../product/ProductList.com" method="get" class="search">
                  <input type="text" name="search" placeholder="중고 전자기기는 MTM에서!">
                  <button type="submit" value="search">검색</button>
               </form>
            </div>
         </div>
         
         <div id="user-menu">
            <span class="user-menu">
            
               <span>
               <c:if test="${empty user_id }">
                     <a href="../main/login.member" id="loginLink"><img alt="로그인" src="../main/img/login.png" id="login"></a>
               </c:if> 
               
               <c:if test="${!empty user_id }">
                  <div id="loginname">ㅣ${user_id }님ㅣ</div>
                  <a href="../main/MemberLogout.member" id="logoutLink"><img alt="로그아웃" src="../main/img/logout.png" id="logout"></a>
               </c:if>
               
               </span>
               <!-- 아이디x 글등록 => 로그인창 -->
               <span>
               <c:if test="${empty user_id }">
                  <a href="../main/login.member" id="loginLink"><img alt="글등록" src="../main/img/edit.png" id="write"></a>
               </c:if>
               </span>
               <span>
               <c:if test="${!empty user_id }">
                  <a href="../product/ProductUpload.com"><img alt="글등록" src="../main/img/edit.png" id="write"></a>
               </c:if>
               </span>
               <span>
               <a href="../member/MemberInfo.member"><img alt="마이페이지" src="../main/img/user.png" id="mypage"></a>
               </span>
               <span>
               <c:if test="${user_id == 'admin' }">
                  <a href="../Main.emp"><img alt="관리자페이지" src="../main/img/admin2.png" id="admin"></a>
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
            <a href="../member/Member112.member">고객센터</a>
         </span>
      </div>

   </nav>
</header>
</body>
</html>