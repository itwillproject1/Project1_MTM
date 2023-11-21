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







  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="styles.css">





</head>
<body>
  <button onclick="scrollToTop()" id="scrollToTopBtn" title="맨 위로 이동">Top</button>
  <script src="../main/script.js"></script>
  <div class="footer">
    <div class="footer-info">
      <div class="contact-info">
      <br>
      <table>
      	<tr><th>손보성</th><td>qhtjd0812@naver.com</td><th>김영미</th><td>example@naver.com</td></tr>
      	<tr><th>이주현</th><td>example@example.com</td><th>변치욱</th><td>example@naver.com</td></tr>
      	<tr><th>정윤정</th><td>qjadj98@gmail.com</td><th>임소언</th><td>example@naver.com</td></tr>
      </table>
      </div>
      <div class="logo">
        <a href="../main/Main.com"><img src="../main/img/logo(MTM).png" alt="로고"></a>
      </div>
      <div class="customer-center">
        <p><img src="../main/address.png" width="20px">아이티윌 : 서울시 강남구 가로수길 123</p><p><strong>고객센터:</strong> 080-1234-5678</p><br>
        <form action="../product/ProductList.com" method="get" class="search">
               <input type="text" name="search" placeholder="검색어 입력">
               <button type="submit" value="search">검색</button>
            </form>
      </div>
    </div>
    <div class="copyright">
      <p>&copy; 1조 전자기기 중고거래</p>
    </div>
  </div>
  
</body>
</html>