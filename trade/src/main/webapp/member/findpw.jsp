<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"">
<title>MTM | 비밀번호 찾기</title>
<link rel="icon" href="../main/img/16px.ico" type="image/x-icon">title>
<link href="../css/findpw.css" rel="stylesheet" />
</head>
<body>
<%@ include file="../main/header.jsp"%>
<br><br><br><br><br><br><br>

<script type="text/javascript">
	function check() {
		
		var number = document.join.number.value;
		var email = document.em.email.value;
		
		if (email == "") {
			//event.preventDefault();
			alert(' 이메일을 입력하세용 ');
			document.em.email.focus();
			return false;
		}
		
		else if (number != "${sessionScope.random }" | number == "") {
			alert(' 인증번호를 확인하세요. ');
			document.join.number.focus();
			return false;
		}
		else if(number == "${sessionScope.random }"){
			alert(' 회원인증되었습니다. ');
			return true;
		}
	
	}
	
	function check2() {
		
		var number = document.join.number.value;
		var email = document.em.email.value;
	
		if (email == "") {
			//event.preventDefault();
			alert(' 이메일을 입력하세용 ');
			document.em.email.focus();
			return false;
		}
		
		else if (number != "${sessionScope.random }" || number == "") {
			alert(' 인증번호를 확인해주세요. ');
			document.join.number.focus();
			return false;
		}
		else if(number == "${sessionScope.random }"){
			alert(' 회원인증되었습니다. ');
			return true;
		}
		
		
	
	}
	
	 function emailcheck() {
		
		var email = document.em.email.value;
		if (email == "") {
			//event.preventDefault();
			alert(' 이메일을 입력하세용 ');
			document.em.email.focus();
			return false;
		}
	
	} 
		
</script>




${sessionScope.random }
<fieldset>
<!--  ${sessionScope.random } -->
<legend>비밀번호 찾기</legend>
<form action="../member/AdjustSmtp.member" name="em">
이메일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name="email" id="a" value="${sessionScope.rcemail }">		
<input type="submit" value="인증번호 받기" onclick="return emailcheck();"><br>
</form>


<form action="./findpwAction.member" name="join">
인증번호&nbsp;&nbsp;: <input type="text" name="number" id="b">
<input type="button" value="인증번호 확인" onclick="return check();"><br>


이름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  : <input type="text" name="user_name" id="c"><br>
아이디&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  : <input type="text" name="user_id" id="d"><br>
<hr> 
<input type="submit" value="비밀번호 찾기" onclick="return check2();" >		
<input type="button" value="돌아가기" id="e" onclick="location.href='../main/login.member'">
</form>

<% session.removeAttribute("random");%>
<% session.removeAttribute("rcemail"); %>
</fieldset>
 <%@ include file="../main/footer.jsp"%>
</body>
</html>