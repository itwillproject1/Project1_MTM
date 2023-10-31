<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="UTF-8">
  <head>
  	<jsp:include page="../../employee/inn/login/head.jsp"/>
  	<title>로그인</title>
  </head>
  <body class="light ">
    <div class="wrapper vh-100">
      <div class="row align-items-center h-100">
        <form action="./loginAction.empm" method="post" class="col-lg-3 col-md-4 col-10 mx-auto text-center">
          <h1 class="h1 mb-3">로그인</h1>
          <div class="form-group">
            <label for="inputId" class="sr-only">사번</label>
            <input type="text" name="emp_id" id="inputId" class="form-control form-control-lg" placeholder="사번" required>
          </div>
          <div class="form-group">
            <label for="inputPassword" class="sr-only">비밀번호</label>
            <input type="password" name="emp_pw" id="inputPassword" class="form-control form-control-lg" placeholder="비밀번호" required>
          </div>
          <div class="checkbox mb-3">
            <label>
              <input type="checkbox" value="remember-me"> 사번 기억하기 </label>
          </div>
          <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
          <button class="btn btn-lg btn-primary btn-block" type="button" onclick="location.href='./findPwForm.empm'">비밀번호 찾기</button>
          <p class="mt-5 mb-3 text-muted">© 2023</p>
        </form>
      </div>
    </div>
    <jsp:include page="../../employee/inn/login/script.jsp"/>
  </body>
</html>
</body>
</html>