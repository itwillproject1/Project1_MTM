<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/removemember.css" rel="stylesheet" />
</head>
<body>
<%@ include file="../main/header.jsp"%>

<script>

function check() {
	
	// DB에서 받아온 DTO
	const dto = {
    			password: "${dto.password }" // DTO에서 비밀번호 가져오기
  				};
  					
	const pw = document.join.pw.value;
	const pw2 = document.join.pw2.value;
	if(pw != dto.password) {
		alert('비밀번호를 확인하세요');
		return false;
	}
	
	if(pw != pw2 ){
		alert('비밀번호가 일치하지 않습니다!')
		document.join.pw2.focus();
		return false;
	}
}


</script>



<br><br><br><br><br><br><br>
		<c:if test="${empty dto.user_id }">
			<c:redirect url="../main/login.member"/>
		</c:if>
		
		
		<fieldset>
			<legend> 회원정보 삭제(탈퇴) </legend>
			<form action="./MemberDeleteAction.member" method="post" name="join" onsubmit="return check();">
			    <input type="hidden" name="user_id" value="${dto.user_id }">
				
				비밀번호 : <input type="password" name="pw" id="pw"><br>
				비밀번호 확인 : <input type="password" name="pw2" id="pw2"><br>
				
				<input type="submit" value="삭제하기">			
			</form>			
		</fieldset>

</body>
</html>