<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../employee/inn/login/head.jsp" />
<title>비밀번호 초기화</title>
</head>
<body>
	<!-- 비밀번호 찾기(로그인 할 때), 사번 및 이메일 입력 후  -->
<body class="light ">
	<div class="wrapper vh-100">
		<div class="row align-items-center h-100">
			<form action="./ResetPwAction.emp" method="post"
				class="col-lg-3 col-md-4 col-10 mx-auto text-center">
				<div class="mx-auto text-center my-4">
					<h2 class="my-3">비밀번호 초기화</h2>
				</div>
				<div class="form-group">
					<label for="inputId" class="sr-only">사번</label> <input type="text"
						name="emp_id" id="inputId" class="form-control form-control-lg"
						placeholder="사번" required autofocus>
				</div>
				<div class="form-group">
					<label for="inputEmail" class="sr-only">이메일</label> <input
						type="email" name="email" id="inputEmail"
						class="form-control form-control-lg" placeholder="이메일" required
						autofocus>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">검색</button>
				<button class="btn btn-lg btn-secondary btn-block" type="button"
					onclick="history.back();">뒤로가기</button>
				<p class="mt-5 mb-3 text-muted">© 2023</p>
			</form>
		</div>
	</div>
	<jsp:include page="../../employee/inn/login/script.jsp" />
</body>
</html>