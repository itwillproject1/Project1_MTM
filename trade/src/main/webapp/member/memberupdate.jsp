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
<link href="../css/agreeModal.css" rel="stylesheet" />

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
	
	전화번호 : <input type="text" name="phone" value="${dto.phone }" class="in"><br><br>
				
		<!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<개인정보 수집 동의><br><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		동의 : <input class="in" id="agree1" name="agree" type="radio" value="동의" checked>
		비동의 : <input class="in" id="agree2" name="agree" type="radio" value="비동의"><br><br> -->
	
	<div id="checkDiv">
	 <input class="choice" id="choice" type="checkbox" name="agree" checked>
        <label id="ladbel" for="choice"></label>
        <span id="choiceSpan">개인정보 수집 및 이용 동의(선택)</span>
    <span class="show" id="show1" onclick="openAgreeModal4()">내용보기</span><br>
    </div>

<div id="agree4Modal" class="modal" style="display: none;">
    <div class="modal-content">
        <span class="close-button" onclick="closeAgreeModal4()">닫기</span>
        <div id="modalContent">
            <h2><u>개인정보 수집 및 이용 동의(선택)</u></h2>
            <div>
               <span id="countAgree4"> 
            fetchFileContent4();
            </span><br> 
         </div>
        </div>
    </div>
</div>

<script>
// 4. 개인정보 수집 및 이용 동의(선택)
  function fetchFileContent4() {
      fetch('../member/agree4.txt') 
          .then(response => response.text())
          .then(data => {
              document.getElementById('countAgree4').innerText = data;
          })
          .catch(error => {
              console.error('파일을 가져오는 도중 오류가 발생했습니다.', error);
          });
  }
  
  
  window.onload = function() {
       fetchFileContent4();
   };
  /*4. 개인정보 수집 및 이용 동의(선택) */
      var modal4 = document.getElementById('agree4Modal'); 
      function openAgreeModal4() {
         modal4.style.display = 'block';
          window.addEventListener('click', outsideClick4);
      }
      function closeAgreeModal4() {
         modal4.style.display = 'none';
          window.removeEventListener('click', outsideClick4);
      }
      // 모달 외부 클릭 시 닫기 함수
      function outsideClick4(e) {
          if (e.target === modal4) {
             modal4.style.display = 'none';
              // 모달 외부 클릭 이벤트 제거
              window.removeEventListener('click', outsideClick4);
          }
      }
</script>
	
	
	
	<input type="submit" value="정보수정하기" class="in">
	<input type="button" value="돌아가기" class="in" onclick="location.href='../member/MemberInfo.member'">
	
</form>	

</body>
</html>