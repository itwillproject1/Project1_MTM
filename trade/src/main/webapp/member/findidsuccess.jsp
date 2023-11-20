<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="../css/findidsuccess.css" rel="stylesheet" />

</head>
<body>
<%@ include file="../main/header.jsp"%>
<br><br><br><br><br><br><br>





		<fieldset>
			<legend> 아이디 찾기 </legend>
			<form method="post" name="join">
			   
				찾은 아이디 : <a>${iddto.user_id }</a><br>
				
				<input type="button" value="로그인하기" class="in" onclick="location.href='../main/login.member'">
				<input type="button" value="메인가기" class="in" onclick="location.href='../main/Main.com'">		
			</form>			
		</fieldset>
		
		 <%@ include file="../main/footer.jsp"%>