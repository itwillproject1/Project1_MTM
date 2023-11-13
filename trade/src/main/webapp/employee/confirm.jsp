<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./inn/login/head.jsp"/>
<title>비밀번호 초기화 완료</title>
</head>
<body>
<!-- 비밀번호 변경 완료  -->
<body class="light ">
    <div class="wrapper vh-100">
      <div class="row align-items-center h-100">
        <form class="col-lg-3 col-md-4 col-10 mx-auto text-center">
          <div class="mx-auto text-center my-4">
            <h4 class="my-3">${title}</h4>
          </div>
          <div class="alert alert-success" role="alert">${msg}</div>
          <a href="./Main.emp" class="btn btn-lg btn-primary btn-block">돌아가기</a>
          <p class="mt-5 mb-3 text-muted">© 2023</p>
        </form>
      </div>
    </div>
	<jsp:include page="./inn/login/script.jsp"/>
</body>
</html>