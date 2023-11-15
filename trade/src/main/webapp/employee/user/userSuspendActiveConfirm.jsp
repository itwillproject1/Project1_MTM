<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="UTF-8">
  <head>
  	<jsp:include page="../../employee/inn/login/head.jsp"/>
  	<title>유저 정지 확인</title>
  </head>
  <body class="light ">
  <c:if test="${sessionScope.emp_id == null}">
  	<c:redirect url="./Main.emp"/>
  </c:if>
    <div class="wrapper vh-100">
      <div class="row align-items-center h-100">
        <a class="navbar-brand mx-auto mt-2 flex-fill text-center" href="./Main.emp">
            <svg version="1.1" id="logo" class="navbar-brand-img brand-md" xmlns="http://www.w3.org/2000/svg" shape-rendering="geometricPrecision" text-rendering="geometricPrecision" image-rendering="optimizeQuality" fill-rule="evenodd" clip-rule="evenodd" viewBox="0 0 512 331.617">
				<path fill-rule="nonzero" d="M271.099 21.308C274.787 6.304 289.956-2.873 304.96.815c15.005 3.688 24.181 18.857 20.493 33.862l-68.491 275.632c-3.689 15.005-18.857 24.181-33.862 20.493-15.005-3.688-24.181-18.857-20.493-33.862l68.492-275.632zm-118.45 224.344c11.616 10.167 12.795 27.834 2.628 39.45-10.168 11.615-27.835 12.794-39.45 2.627L9.544 194.604C-2.071 184.437-3.25 166.77 6.918 155.155c.873-.997 1.8-1.912 2.767-2.75l106.142-93.001c11.615-10.168 29.282-8.989 39.45 2.626 10.167 11.616 8.988 29.283-2.628 39.45l-82.27 72.086 82.27 72.086zm243.524 42.077c-11.615 10.167-29.282 8.988-39.45-2.627-10.167-11.616-8.988-29.283 2.628-39.45l82.27-72.086-82.27-72.086c-11.616-10.167-12.795-27.834-2.628-39.45 10.168-11.615 27.835-12.794 39.45-2.626l106.142 93.001a28.366 28.366 0 012.767 2.75c10.168 11.615 8.989 29.282-2.626 39.449l-106.283 93.125z"/>
            </svg>
          </a>
          <h1 class="h1 mb-3">유저 정지 확인</h1>
          <div class="alert alert-success" role="alert"><strong>${dto.user_id}</strong>의 정지가 ${requestScope.suspendDays}일 실시되었습니다.<br>유저 정보에서 확인 바랍니다.</div>
          <button class="btn btn-lg btn-primary btn-block" type="button" onclick="./Main.emp">확인</button>
          <p class="mt-5 mb-3 text-muted">© 2023</p>
      </div>
    </div>
    <jsp:include page="../../employee/inn/login/script.jsp"/>
  </body>
</html>
</body>
</html>