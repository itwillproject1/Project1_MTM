<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 프로필 변경 페이지 -->
	<!-- 프로필 변경 및 취소 버튼 클릭,  -->
	<form action="./profileChangeAction.emp" method="post">
		<!-- 사번/이메일 고정, 주소, 전화번호 편집 가능, 비밀번호 편집 가능 -->
		<input type="text" readonly name="emp_id" value="${dto.id}">
		<input type="text"  name="name" value="${dto.name}">
		<input type="email" readonly name="email" value="${dto.email}">
		<input type="tel" name="tel" value="${dto.tel}">
		<input type="radio" name="pw_change" value="on">
		<input type="radio" name="pw_change" value="off" checked>
		<input type="submit" value="수정">
	</form>
</body>
</html>