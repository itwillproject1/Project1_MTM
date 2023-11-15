<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/findid.css" rel="stylesheet" />
</head>
<body>
<%@ include file="../main/header.jsp"%>

<br><br><br><br><br><br><br>
<fieldset>
<legend> 아이디 찾기 </legend>
<form action="./findidAction.member" id="fo" >
		

			이름       :     <input type="text" name="user_name" class="in" id="na"><br>
			
			
			생년월일   :		
			 <select id="jumin" name="jumin1" class="in">
				<option value="년">년</option>
				<c:forEach var="j" begin="0" end="${2023-1900}">
					<c:set var="i" value="${2023-j}" />
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>
			-
			<select id="jumin2" name="jumin2" class="in">
				<option value="월">월</option>
				<c:forEach var="i" begin="1" end="12">
					<c:choose>
						<c:when test="${i lt 10 }">
							<option value="0${i}">0${i}</option>
						</c:when>
						<c:otherwise>
							<option value="${i}">${i}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
			-
			<select id="jumin3" name="jumin3" class="in">
				<option value="일">일</option>
				<c:forEach var="i" begin="1" end="31">
					<c:choose>
						<c:when test="${i lt 10 }">
							<option value="0${i}">0${i}</option>
						</c:when>
						<c:otherwise>
							<option value="${i}">${i}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select> <br> 
			   
			휴대폰 번호 :      <select name="phone1" class="in" id="num">
						 <option value="010">010</option>
						 <option value="011">011</option>
						 <option value="017">017</option>
						 <option value="031">031</option>
						 </select> -
						 <input type="text" name="phone2" class="in" id="num2"> -
						 <input type="text" name="phone3" class="in" id="num3"><br>
			
			<hr>
			<input type="submit" value="아이디 찾기" class="in">		
			<input type="button" value="돌아가기" class="in" id="bu">
		</form>	
	</fieldset>
</body>
</html>