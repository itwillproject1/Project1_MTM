<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/memberjoin.css" rel="stylesheet" />
</head>
<body>
		<%@ include file="../main/header.jsp"%>
		
		<br><br>
		<br><br>
		
	<br>	
		<script type="text/javascript">
  
			function check() {
				// 유효성검사, 비밀번호 정규식
				var id = document.join.user_id.value;
				if (id == "") {
					alert(' 아이디를 입력하세요! ');
					document.join.user_id.focus();
					return false;
				}
				if(document.join.user_id.value.length < 5 || document.join.user_id.value.length > 12) {
					alert("아이디는 5자 이상 12자 이하로 작성해주세요");
					document.join.user_id.focus();
					return false;
				}				
				var password = document.join.password.value;
				if(password == ""){
					alert('비밀번호를 입력하세요!');
					document.join.password.focus();
					return false;
				}
				if(document.join.password.value.length < 6 || document.join.password.value.length > 15) {
					alert("비밀번호는 6자 이상 15자 이하로 작성해주세요");
					document.join.password.focus();
					return false;
				}				
				
				
				if(password != passwordcheck ){
					alert('비밀번호가 일치하지 않습니다!')
					document.join.password.focus();
					return false;
				}
				
				var email1 = document.join.email1.value;
				if (email1 == "") {
					alert(' 이메일 주소를 입력하세요! ');
					document.join.email1.focus();
					return false;
				}
				var email2 = document.join.email2.value;	
				if(email2 == "선택하세요"){
					alert(' 도메인 주소를 입력하세요! ');
					document.join.email2.focus();
					return false;
				}
				var user_name = document.join.user_name.value;
				if (user_name == "") {
					alert(' 이름을 입력하세요! ');
					document.join.user_name.focus();
					return false;
				} 
				
				var gender = document.join.gender.value;
				if (gender == "") {
					alert(' 성별을 확인하세요! ');
					return false;
				}
				var phone2 = document.join.phone2.value;
				if (phone2 == "") {
					alert(' 휴대폰 번호를 확인하세요! ');
					document.join.phone2.focus();
					return false;
				
				}
				var phone3 = document.join.phone3.value;
				if (phone3 == "") {
					alert(' 휴대폰 번호를 확인하세요! ');
					document.join.phone3.focus();
					return false;
				}
				var address = document.join.address.value;
				if (address == "") {
					alert(' 주소를 확인하세요! ');
					document.join.address.focus();
					return false;
				}
				var user_nickname = document.join.user_nickname.value;
				if (user_nickname == "") {
					alert(' 닉네임을 확인하세요! ');
					document.join.user_nickname.focus();
					return false;
				}
			}
			
			function goPopup(){
				// 주소검색을 수행할 팝업 페이지를 호출합니다.
				// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
				var pop = window.open("./jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
				
				// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://business.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
			    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
			}


			function jusoCallBack(address){
					// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
					document.join.address.value = address;
					
			}
			
			
			function checkid() {
				var id = document.join.user_id.value;
				if (id == "") {
					alert(' 아이디를 입력하세요! ');
					document.join.user_id.focus();
					return false;
				}
				if(document.join.user_id.value.length < 5 || document.join.user_id.value.length > 12) {
					alert("아이디는 5자 이상 12자 이하로 작성해주세요");
					document.join.user_id.focus();
					return false;
				}
				let checkid = window.open("./Membercheckid.member","checkid","width=570,height=500, scrollbars=yes, resizable=yes");
				
				// checkid.document.getElementById("id").value = document.getElementById("user_id").value;
				}
			function checkidCallBack(user_id){
				// 중복확인에서 확인받은 정보를 받아서, 현 페이지에 정보를 등록
				document.join.user_id.value = user_id;
			}
			
			
		</script>
		
		
		
		<fieldset>
		<legend> 회원가입 페이지 </legend>
		<form action="./MemberJoinAction.member" method="post" name="join" onsubmit="return check();" enctype="multipart/form-data" >
		<div id="callBackDiv">
			아이디 <br>
			<input type="text" name="user_id" id="user_id" placeholder="5~12자 이내로 입력해주세요" class="in"> 
			<input type="button" value="ID 중복확인" onclick="checkid();" class="in"> <br>
			</div>
					 
					 
			비밀번호 <br> <input type="password" name="password" placeholder="6~15자 이내로 입력해주세요" class="in"><br>
			비밀번호 확인 <br><input type="password" name="passwordcheck" placeholder="비밀번호를 한번 더 입력해주세요" class="in"><br>
			
			
			이메일 <br><input type="text" name="email1" class="in">
				<select id="email" name="email2" size="1" onchange="email_check()">
				<option value="선택하세요">선택하세요</option>
				<option value="@naver.com">@naver.com</option>
				<option value="@hanmail.net">@hanmail.net</option>
				<option value="@daum.net">@daum.net</option>
				<option value="@nate.com">@nate.com</option>
				<option value="@samsung.com">@samsung.com</option>
				<option value="@gmail.com">@gmail.com</option>
				</select><br>
				
						
			이름  <br><input type="text" name="user_name" class="in"><br>
			
			
			생년월일 <br>			
			 <select id="jumin" name="jumin1">
				<option value="년">년</option>
				<c:forEach var="j" begin="0" end="${2023-1900}">
					<c:set var="i" value="${2023-j}" />
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>
			
			<select id="jumin" name="jumin2">
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
			
			<select id="jumin" name="jumin3">
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
			
			성별 <br><input type="radio" name="gender" value="남" class="in"> 남
		 		   <input type="radio" name="gender" value="여" class="in"> 여<br>
		 		   
			휴대폰 번호 <br><select name="phone1">
						 <option value="010">010</option>
						 <option value="011">011</option>
						 <option value="017">017</option>
						 <option value="031">031</option>
						 </select> -
						 <input type="text" name="phone2"> -
						 <input type="text" name="phone3"><br>
						 
			<div id="callBackDiv">			 
			주 소  <br><input type="text" id="address" name="address" class="in"> <input type="button" value="검색하기" onclick="goPopup()" class="in"> <br>
			</div>
			
			닉네임 <br><input type="text" name="user_nickname" class="in"><br>
			
			프로필 <br><input type="file" name="profile" value="등록하기" accept="image/*" class="in"><br>
			
			추천인 입력(선택) <br><input type="text" name="recommend" class="in"><br>
			
			<!-- http://localhost:8088/trade/member/memberjoin.member -->
			
			<input id="allCheck" type="checkbox">이용약관 전체동의
    <hr>
    <input class="must" type="checkbox">이용약관 동의 (필수)
    <span class="show">내용보기</span><br>
    <input class="must" type="checkbox">개인정보 수집 및 이용 동의 (필수)
    <span class="show">내용보기</span><br>
    <input class="must" type="checkbox">개인정보 제3자 제공 동의 (필수)
    <span class="show">내용보기</span><br>
    <input class="must" type="checkbox">개인정보 처리 위탁 동의 (필수)
    <span class="show">내용보기</span><br>
    <input class="choice" type="checkbox">개인정보 수집 및 이용 동의(선택)
    <span class="show">내용보기</span><br>

		<script>
        document.getElementById("allCheck").addEventListener("click", function() {
            var mustCheckboxes = document.querySelectorAll('.must');
            var choiceCheckbox = document.querySelector('.choice');

            mustCheckboxes.forEach(function(checkbox) {
                checkbox.checked = document.getElementById("allCheck").checked;
            });

            choiceCheckbox.checked = document.getElementById("allCheck").checked;
        });
    </script>
			












			
			
			<hr>
			<input type="submit" value="회원가입" class="in">		
			<input type="button" value="취소" class="in">
		</form>	
	</fieldset>
	
	

		
		
		
</body>
</html>