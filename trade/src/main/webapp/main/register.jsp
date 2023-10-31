<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<link rel="stylesheet" type="text/css" href="main_styles.css">
		<meta charset="UTF-8">
		<title>회원가입 페이지입니다.</title>
		 <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        
        h1 {
            text-align: center;
        }
        
        fieldset {
            width: 60%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
        }
        
        form {
            text-align: left;
        }
        
        label {
            display: block;
            margin-top: 10px;
        }
        
        input[type="text"],
        input[type="password"]
        {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        
        input[type="button"],
        input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            margin: 10px 0;
        }
        
        input[type="button"]:hover,
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
		
</head>
<body>
    <header>
        <h1>회원가입 하기</h1>
        <nav>
            <ul>
                <li><a href="#">카테고리</a></li>
                <li><a href="#">삽니다</a></li>
                <li><a href="#">팝니다</a></li>
                <li><a href="#">내 프로필</a></li>
                <li><a href="#">로그인</a></li>
                <li><a href="./register.jsp">회원가입</a></li>
					
            </ul>
        </nav>
    </header>
    
    <h1> 회원가입 하세욧</h1>
    
    		<h1>memberjoin.jsp</h1>
		
		<fieldset>
		<legend> 회원가입 페이지 </legend>
		<form action="./memberregisteraction.shop" method="post">
			아이디 : <input type="text" name="user_id"><br>
			
			비밀번호 : <input type="password" name="password"><br>
			비밀번호 확인 : <input type="password" name="passwordcheck"><br>
			
			이메일 : <input type="text" name="email"><br>
			이 름 : <input type="text" name="name"><br>
			주민번호 : <input type="text" name="jumin"><br>
			<br>성별 : <input type="radio" name="gender" value="남" checked>남
				       <input type="radio" name="gender" value="여">여<br><br>
			휴대폰 번호 : <input type="text" name="phone"><br>
			주 소 : <input type="text" name="address"><br>
			닉네임 : <input type="text" name="nickname"><br>
			추천인 : <input type="text" name="recommend"><br><br>
			
			
			개인정보보호 내용 ~~~~~~~~~~~~~~~~~~~<br>
			~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
			~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
			
			동 의 :<input type="radio" name="agree" value="동의" checked>동의
				       <input type="radio" name="agree" value="비동의">비동의<br><br>
			
			
			
			<hr>
			<input type="submit" value="회원가입">		
		</form>	
	</fieldset>
		
		
		
		
    
    <footer>
        <p>&copy; 1조 전자기기 중고거래</p>
    </footer>

</body>
</html>