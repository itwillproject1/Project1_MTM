<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>checkid.jsp</h1>
		<%
		String user_id = request.getParameter("user_id");
		%>
<script type="text/javascript">
 
 		window.onload=function() {    // 창 실행시 자동실행 현재 text = memberjsp user_id 넣기
 		document.getElementById("user_id").value = opener.document.getElementById("user_id").value;

 		}
 		
 		function check() {
			// 유효성검사
			var id = document.check_id.user_id.value;
			if (id == "") {
				alert(' 아이디를 입력하세요! ');
				document.check_id.user_id.focus();
				return false;
			}
			if(document.check_id.user_id.value.length < 5 || document.check_id.user_id.value.length > 12) {
				alert("아이디는 5자 이상 12자 이하로 작성해주세요");
				document.check_id.user_id.focus();
				return false;
 		
			}
 		}
 		
 		function sendid(){ // 사용하기 버튼 클릭시 창 닫기	
 			var id = document.check_id.user_id.value;
			if (id == "") {
				alert(' 아이디를 입력하세요! ');
				document.check_id.user_id.focus();
				return false;
			}
			if(document.check_id.user_id.value.length < 5 || document.check_id.user_id.value.length > 12) {
				alert("아이디는 5자 이상 12자 이하로 작성해주세요");
				document.check_id.user_id.focus();
				return false;
			}
 			
 		opener.document.getElementById("user_id").value = document.getElementById("user_id").value;
 		
 		
 		window.close();
    	}
 		
</script>

<form action="./MemberCheckIdAction.member" method="post" name="check_id" onsubmit="return check();">
<input type="text" name="user_id" id="user_id">
<input type="submit" value="중복확인"> 
<input type="button" value="사용하기" name="use_id" onclick="sendid();">
</form>
 
</body>
</html>