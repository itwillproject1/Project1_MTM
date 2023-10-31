<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../employee/inn/login/head.jsp"/>
<title>비밀번호 변경</title>
</head>
<body>
<!-- 비밀번호 찾기(로그인 할 때), 사번 및 이메일 입력 후  -->
	<body class="light ">
    <div class="wrapper vh-100">
      <div class="row align-items-center h-100">
        <form action="./ChangePwAction.empm" method="post" class="col-lg-3 col-md-4 col-10 mx-auto text-center">
          <div class="mx-auto text-center my-4">
            <h2 class="my-3">비밀번호 변경</h2>
          </div>
          <c:if test="${requestScope.emp_id != null}">          
          	<input type="hidden" name="emp_id" value="${requestScope.emp_id}">
          	<input type="hidden" name="emp_pw" value="${requestScope.emp_pw}">
          </c:if>
          <c:if test="${sessionScope.emp_id != null}">
          	<input type="hidden" name="emp_id" value="${sessionScope.emp_id}">
          	<div class="form-group">
            	<label for="inputPPw" class="sr-only">새 비밀번호</label>
            	<input type="password" name="past_pw" id="inputPPw" class="form-control form-control-lg" placeholder="새 비밀번호" required autofocus>
          	</div>
          </c:if>
          <div class="form-group">
            <label for="inputNPw" class="sr-only">새 비밀번호</label>
            <input type="password" name="new_pw" id="inputNPw" class="form-control form-control-lg" placeholder="새 비밀번호" required autofocus>
          </div>
          <div class="form-group">
            <label for="inputCf" class="sr-only">새 비밀번호 확인</label>
            <input type="password" name="confirm" id="inputCf" class="form-control form-control-lg" placeholder="비밀번호 재 입력" required autofocus>
          </div>
          <button class="btn btn-lg btn-primary btn-block" type="submit">검색</button>
          <p class="mt-5 mb-3 text-muted">© 2023</p>
        </form>
      </div>
    </div>
	<jsp:include page="../../employee/inn/login/script.jsp"/>
</body>
</html>