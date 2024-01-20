<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="com.itwillbs.product.db.ProductDAO"%>
<%@page import="com.itwillbs.product.db.ProductDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MTM | 회원정보수정</title>
<link rel="icon" href="../main/img/16px.ico" type="image/x-icon">/title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="../css/memberupdate.css" rel="stylesheet" />
<link href="../css/agreeModal.css" rel="stylesheet" />

<!--  주소 cdn -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</head>
<body>
<%@ include file="../main/header.jsp"%>
<br><br><br><br><br><br>

<script type="text/javascript">

//추가 시 주소 api
function sample1_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수  
                
                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    //document.getElementById("join_detailAddress").value = extraAddr;
                
                } else {
                    //document.getElementById("join_detailAddress").value = '';
                }
                
                var fullAddr = addr + extraAddr;
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                //document.getElementById('join_postcode').value = data.zonecode;
                document.getElementById("join_address").value = fullAddr;
                
                // 커서를 상세주소 필드로 이동한다.
                //document.getElementById("join_address").focus();
                console.log("Full Address:", fullAddr);
                
                
            }
        }).open();
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

<form action="./MemberUpdateProAction.member" method="post" onsubmit="return passwordcheck();" name="join" class="ff" enctype="multipart/form-data">
	
	현재 비밀번호 :<input type="password" name="nowpassword" id=nowpassword class="in"><br>
	
	수정할 비밀번호 : <input type="password" name="password" class="in"> <br>
	
	닉네임 : <input type="text" value="${dto.user_nickname }" name="user_nickname" class="in"> <br>
	
	이메일 : <input type="text" name="email" value="${dto.email }" class="in"> <br>
				
	<div id="callBackDiv">
	주소 : <br><input type="text" id="join_address" name="address" value="${dto.address }" class="in"> <input type="button" value="검색하기" onclick="sample1_execDaumPostcode()" class="in"> <br>
	</div>
	
	<br>
     프로필 :  <input type="file" name="profile" value="등록하기" accept="image/*" class="in"><br><br>
	
	전화번호 : <input type="text" name="phone" value="${dto.phone }" class="in"><br><br>
	
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
 <%@ include file="../main/footer.jsp"%>
</body>
</html>