<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="com.itwillbs.product.db.ProductDAO"%>
<%@page import="com.itwillbs.product.db.ProductDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="../css/memberupdate.css" rel="stylesheet" />
</head>
<body>
<%@ include file="../main/header.jsp"%>
<br><br><br><br><br><br>

<script type="text/javascript">


function goPopup(){
	console.log("goPopup 함수가 호출되었습니다.");
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("./jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}


function jusoCallBack(address){
	console.log("콜백 함수가 호출되었습니다.");
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.join.address.value = address;
		
}

function passwordcheck() {
	
	// DB에서 받아온 DTO
	const dto = {
    			password: "${dto.password }" // DTO에서 비밀번호 가져오기
  				};
  					
	const nowpassword = document.join.nowpassword.value;
	if(nowpassword != dto.password) {
		alert('현재 비밀번호를 확인하세요');
		return false;
	}
}


</script>

<form action="./MemberUpdateProAction.member" method="post" onsubmit="return passwordcheck();" name="join" class="ff">
	
	현재 비밀번호 :<input type="password" name="nowpassword" id=nowpassword class="in"><br>
	
	수정할 비밀번호 : <input type="password" name="password" class="in"> <br>
	
	닉네임 : <input type="text" value="${dto.user_nickname }" name="user_nickname" class="in"> <br>
	
	이메일 : <input type="text" name="email" value="${dto.email }" class="in"> <br>
				
	<div id="callBackDiv">
	주소 : <br><input type="text" id="add" name="address" value="${dto.address }" class="in"> <input type="button" value="검색하기" onclick="goPopup()" class="in"> <br>
	</div>
	
	전화번호 : <input type="text" name="phone" value="${dto.phone }" class="in"><br>
	
	<input type="submit" value="정보수정하기" class="in">
	
	<input type="button" value="돌아가기" class="in" onclick="location.href='../member/MemberInfo.member'">
	
</form>	

</body>
</html>