<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap">
<link href="../css/header.css" rel="stylesheet" />
<link href="../css/login.css" rel="stylesheet" />
    <title>로그인 페이지</title>
</head>
<body>
<%@ include file="../main/header.jsp"%>
    <div class="login-container">
        <form id="login-form">
            <label for="username">아이디</label>
            <input type="text" id="username" name="username" required>
            
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" required>
            
            <button type="button" onclick="login()">로그인</button>
            <button type="button" onclick="redirectToSignUp()">회원가입</button>
        </form>
    </div>

    <script src="script.js"></script>
</body>
</html>
