<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../css/footer.css" rel="stylesheet" />
<title>푸터</title>
</head>
<body>
<footer>
<div id="footerAll">
  <button onclick="scrollToTop()" id="scrollToTopBtn" title="맨 위로 이동">
  <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-arrow-up-circle" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-7.5 3.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V11.5z"/>
</svg>
  </button>
  <script src="../main/script.js"></script>
  <div class="footer">
    <div class="footer-info">
      <div class="contact-info">
      <br>
      <table id="team">
      	<tr><th>손보성</th><td>qhtjd0812@naver.com</td><th>김영미</th><td>010829mii@gmail.com</td></tr>
      	<tr><th>이주현</th><td>zugusdl@gmail.com</td><th>변치욱</th><td>imrealtwinkle@naver.com</td></tr>
      	<tr><th>정윤정</th><td>qjadj98@gmail.com</td><th>임소언</th><td>mtpcyuil@gmail.com</td></tr>
      </table>
      </div>
      <div class="logo1">
        <a href="../main/Main.com"><img src="../main/img/logo(MTM).png" alt="로고"></a>
      </div>
      <div class="customer-center">
        <p><img src="../main/img/address.png" width="20px">아이티윌 : 부산광역시 부산진구 동천로 109 삼한골든게이트빌딩 7층</p><p><strong>고객센터:</strong> 080-1234-5678</p><br>
        <form action="../product/ProductList.com" method="get" class="search">
               <input type="text" id="sear"name="search" placeholder="검색어 입력">
               <button type="submit" value="search">검색</button>
            </form>
      </div>
    </div>
    <div class="copyright">
      <p>&copy; 1조 전자기기 중고거래</p>
    </div>
  </div>
  </div>
</footer>
</body>
</html>