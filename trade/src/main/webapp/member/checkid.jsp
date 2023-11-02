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
		
<script type="text/javascript">
 
 		window.onload=function() {    // 창 실행시 자동실행
 		document.getElementById("id").value = opener.document.getElementById("user_id").value;

 }
    	function sendid(){ // 사용하기 버튼 클릭시 창 닫기
    		
		    		
 		window.close();
    	}
 		
</script>

<form action="use_id">
<input type="text" name="id" id="id">
<input type="button" value="중복확인" onclick=""> 
<input type="button" value="사용하기" name="use_id" onclick="sendid();">
</form>
 
</body>
</html>