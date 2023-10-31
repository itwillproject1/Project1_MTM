<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>memberjoin.jsp</h1>
		
		<fieldset>
		<legend> 회원가입 페이지 </legend>
		<form action="./MemberJoinAction.com" method="post">
			아이디 : <input type="text" name="user_id"><br>
			
			비밀번호 : <input type="password" name="password"><br>
			비밀번호 확인 : <input type="password" name="passwordcheck"><br>
			
			이메일 : <input type="text" name="email"><br>
			이 름 : <input type="text" name="user_name"><br>
			주민번호 : <input type="text" name="jumin"><br>
			성별 : <input type="radio" name="gender" value="남" checked> 남
		 		   <input type="radio" name="gender" value="여"> 여<br>
			휴대폰 번호 : <input type="text" name="phone"><br>
			주 소 : <input type="text" name="address"><br>
			닉네임 : <input type="text" name="user_nickname"><br>
			프로필 : <input type="text" name="profile"><br>
			추천인 : <input type="text" name="recommend"><br>
			동 의 : <input type="text" name="agree"><br>
			
			
			
			<hr>
			<input type="button" value="로그인" onclick >
			<input type="submit" value="회원가입">		
		</form>	
	</fieldset>
		
		
		
		
</body>
</html>