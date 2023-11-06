<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<%@ include file="../main/header.jsp"%>

<% String User_id = (String) session.getAttribute("id"); %>

<br><br><br><br><br><br><br>


<form action="" method="post">
아이디 : <%= User_id %>






</form>




</body>
</html>