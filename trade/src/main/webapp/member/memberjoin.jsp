<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MTM | 회원가입</title>
<link rel="icon" href="../main/img/16px.ico" type="image/x-icon">e>
<link href="../css/memberjoin.css" rel="stylesheet" />
<link href="../css/agreeModal.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>


<script type="text/javascript">
$(function(){
    $(".name").keyup(function (event) {
         regexp = /[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
         v = $(this).val();
         if (regexp.test(v)) {
             alert("한글만 입력가능 합니다.");
             $(this).val(v.replace(regexp, ''));
         }
     });
    
    $(function(){
    	
    $("#address").click(function(){
    	 var url = './jusoPopup.jsp';
    	window.open(url,'pop','width=570,height=420, scrollbars=yes, resizable=yes');
    });
    
    });
    
    
    
    
});
</script>


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
      
            var pw = $("#password").val();
            var num = pw.search(/[0-9]/g);
            var eng = pw.search(/[a-z]/ig);
            var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
            
            if(pw.length < 6 || pw.length > 15){
            	  alert("6자리 ~ 15자리 이내로 입력해주세요.");
            	  document.join.password.focus();
            	  return false;
            	 }else if(pw.search(/\s/) != -1){
            	  alert("비밀번호는 공백 없이 입력해주세요.");
            	  document.join.password.focus();
            	  return false;
            	 }else if( (num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0) ){
            	  alert("영문,숫자, 특수문자 중 2가지 이상을 혼합하여 입력해주세요.");
            	  document.join.password.focus();
            	  return false;
            	 }
            /* if(password == ""){
               alert('비밀번호를 입력하세요!');
               document.join.password.focus();
               return false;
            }
            if(document.join.password.value.length < 6 || document.join.password.value.length > 15) {
               alert("비밀번호는 6자 이상 15자 이하로 작성해주세요");
               document.join.password.focus();
               return false;
            }  */           
            
            var passwordcheck = document.join.passwordcheck.value;
            if(pw != passwordcheck ){
               alert('비밀번호가 일치하지 않습니다!')
               document.join.passwordcheck.focus();
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
            
            var year = document.join.jumin1.value;
            if (year == "년") {
               alert(' 태어난 년도를 선택하세요! ');
               document.join.jumin1.focus();
               return false;
            } 
            
            var month = document.join.jumin2.value;
            if (month == "월") {
               alert(' 태어난 월을 선택하세요! ');
               document.join.jumin2.focus();
               return false;
            } 
            
            var day = document.join.jumin3.value;
            if (day == "일") {
               alert(' 태어난 일을 선택하세요! ');
               document.join.jumin3.focus();
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
            if (address == "" || document.join.address.value.length < 10) {
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
            
              /* var profile = document.join.profile.value;
              if (profile == "") {
                  alert(' 프로필을 등록하세요! ');
                  document.join.profile.focus();
                  return false;
               } */
              
              var agree1 = document.getElementsByName("agree1").length;
              var agree2 = document.getElementsByName("agree2").length;
              var agree3 = document.getElementsByName("agree3").length;
              
              for (var i=0; i<agree1; i++) {
                  if (document.getElementsByName("agree1")[i].checked == false) {
                      alert("이용약관에 동의해주세요!");
                      return false;
                  } 
              }
               
              for (var i=0; i<agree2; i++) {
                  if (document.getElementsByName("agree2")[i].checked == false) {
                      alert("개인정보 수집 및 이용에 동의해주세요!");
                      return false;
                  }
              }
              
              for (var i=0; i<agree3; i++) {
                  if (document.getElementsByName("agree3")[i].checked == false) {
                      alert("개인정보 제3자  제공에 동의해주세요!");
                      return false;
                  }
              }
             
         }

         function handleOnInput(el, maxlength) {
                 	  if(el.value.length > maxlength)  {
                 	    el.value 
                 	      = el.value.substr(0, maxlength);
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
            let checkid = window.open("./Membercheckid.member","checkid"," width=460, height=220, left=350 , top=280 , scrollbars=yes, resizable=yes");
            
            // checkid.document.getElementById("id").value = document.getElementById("user_id").value;
            }
         function checkidCallBack(user_id){
            // 중복확인에서 확인받은 정보를 받아서, 현 페이지에 정보를 등록
            document.join.user_id.value = user_id;
         }
         
         
      </script>
      
      
      
      <fieldset class="form-group">
      <legend> 회원가입 페이지 </legend>
      <form action="./MemberJoinAction.member" method="post" name="join" onsubmit="return check();" enctype="multipart/form-data" >
      <div id="callBackDiv">
         <label>아이디</label>
         <input type="text" name="user_id" id="user_id" placeholder="5~12자 이내로 입력해주세요" class="in"> 
         <input type="button" value="ID 중복확인" onclick="checkid();" class="in"> <br>
         </div>
                
                
         <label>비밀번호</label>
         <input type="password" id="password" name="password" placeholder="6~15자 이내로 입력해주세요" class="in"><br>
         
         <label>비밀번호 확인</label>
         <input type="password" name="passwordcheck" placeholder="비밀번호를 한번 더 입력해주세요" class="in"><br>
         
         
         <label>이메일</label>
         <input type="text" name="email1" class="in">
            <select id="email" name="email2" size="1" onchange="email_check()">
            <option value="선택하세요">선택하세요</option>
            <option value="@naver.com">@naver.com</option>
            <option value="@hanmail.net">@hanmail.net</option>
            <option value="@daum.net">@daum.net</option>
            <option value="@nate.com">@nate.com</option>
            <option value="@samsung.com">@samsung.com</option>
            <option value="@gmail.com">@gmail.com</option>
            <option value="@kakao.com">@kakao.com</option>
            </select><br>
            
                  
         <label>이름</label>
         <input type="text" name="user_name" class="name" onkeyup="chk_han('user_name')"><br>
         
         <div class="birth">
            <label>생년월일</label>      
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
            </select>
         </div>
         
         <label>성별</label>
         <input type="radio" name="gender" value="남" class="in"> 남
          <input type="radio" name="gender" value="여" class="in"> 여<br>
          
          <div class="birth">
         <label>휴대폰 번호</label>
         <select name="phone1">
            <option value="010">010</option>
            <option value="011">011</option>
            <option value="017">017</option>
            <option value="031">031</option>
         </select> -
         <input type="number" name="phone2" min="0" oninput= "handleOnInput(this, 4)"> -
         <input type="number" name="phone3" min="0" oninput= "handleOnInput(this, 4)" >
          </div>  
                   
         <div id="callBackDiv">          
         <label>주 소</label>
         <input type="text" id="address" name="address" class="in"> <input type="button" value="검색하기" onclick="goPopup()" class="in"> <br>
         </div>
         
         <label>닉네임</label>
         <input type="text" name="user_nickname" class="in"><br>
         
         <label>프로필</label>
         <input type="file" name="profile" value="등록하기" accept="image/*" class="in"><br>
         
         
         
         <label>추천인 입력(선택)</label>
         <input type="text" name="recommend" class="in"><br>

         
         <!-- http://localhost:8088/trade/member/memberjoin.member -->
   <div id="checkDiv">      
   <input id="allCheck" type="checkbox">
    <label for="allCheck"><span>이용약관 전체동의</span></label>
    
    <hr>
    <input class="must" id="agree1" type="checkbox" name="agree1" value="1">
    <label id="label" for="agree1"><span>이용약관 동의 (필수)</span></label>
   <span class="show" onclick="openAgreeModal1()">내용보기</span><br>
    
    <input class="must" id="agree2" type="checkbox" name="agree2" value="2">
    <label id="label" for="agree2"><span>개인정보 수집 및 이용 동의 (필수)</span></label>
    <span class="show" onclick="openAgreeModal2()">내용보기</span><br>
    
    <input class="must" id="agree3" type="checkbox" name="agree3" value="3">
    <label id="label" for="agree3"><span>개인정보 제3자 제공 동의 (필수)</span></label>
    <span class="show" onclick="openAgreeModal3()">내용보기</span><br>
    
    <input class="choice" id="choice" type="checkbox" name="agree" >
        <label id="ladbel" for="choice"><span>개인정보 수집 및 이용 동의(선택)</span></label>
    <span class="show" id="show1" onclick="openAgreeModal4()">내용보기</span><br>
</div>
   
<!-- ========================================================================== -->
 <!-- 1. 이용약관 동의(필수) -->
<div id="agree1Modal" class="modal" style="display: none;">
    <div class="modal-content">
        <span class="close-button" onclick="closeAgreeModal1()">닫기</span>
        <div id="modalContent">
            <h2><u>이용 약관</u></h2>
            <div>
               <span id="countAgree1"> 
            fetchFileContent1();
            </span><br> 
         </div>
        </div>
    </div>
</div> 

 <!-- 2. 개인정보 수집 및 이용 동의 (필수) -->
<div id="agree2Modal" class="modal" style="display: none;">
    <div class="modal-content">
        <span class="close-button" onclick="closeAgreeModal2()">닫기</span>
        <div id="modalContent">
            <h2><u>개인정보 수집 및 이용 동의 (필수)</u></h2>
            <div>
               <span id="countAgree2"> 
            fetchFileContent2();
            </span><br> 
         </div>
        </div>
    </div>
</div>

 <!-- 3. 개인정보 제3자 제공 동의 (필수) -->
<div id="agree3Modal" class="modal" style="display: none;">
    <div class="modal-content">
        <span class="close-button" onclick="closeAgreeModal3()">닫기</span>
        <div id="modalContent">
            <h2><u>개인정보 제3자 제공 동의 (필수)</u></h2>
            <div>
               <span id="countAgree3"> 
            fetchFileContent3();
            </span><br> 
         </div>
        </div>
    </div>
</div>

 <!-- 4. 개인정보 수집 및 이용 동의(선택) -->
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
//==========================================================================
// 1. 이용약관 동의(필수)
  function fetchFileContent1() {
      fetch('../member/agree1.txt') // 서버에서 파일을 가져올 경로
          .then(response => response.text()) // 파일 내용을 텍스트로 읽음
          .then(data => {
              // 가져온 파일 내용을 countAgree 요소에 삽입
              document.getElementById('countAgree1').innerText = data;
          })
          .catch(error => {
              console.error('파일을 가져오는 도중 오류가 발생했습니다.', error);
          });
  }
//==========================================================================
// 2. 개인정보 수집 및 이용 동의 (필수)
  function fetchFileContent2() {
      fetch('../member/agree2.txt') 
          .then(response => response.text()) 
          .then(data => {
              document.getElementById('countAgree2').innerText = data;
          })
          .catch(error => {
              console.error('파일을 가져오는 도중 오류가 발생했습니다.', error);
          });
  }
//==========================================================================
// 3. 개인정보 제3자 제공 동의 (필수)
  function fetchFileContent3() {
      fetch('../member/agree3.txt') 
          .then(response => response.text())
          .then(data => {
              document.getElementById('countAgree3').innerText = data;
          })
          .catch(error => {
              console.error('파일을 가져오는 도중 오류가 발생했습니다.', error);
          });
  }
//==========================================================================
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
       fetchFileContent1();
       fetchFileContent2();
       fetchFileContent3();
       fetchFileContent4();
   };
//==========================================================================
      /*1. 이용약관 동의 (필수)*/
      var modal1 = document.getElementById('agree1Modal'); 
      function openAgreeModal1() {
          modal1.style.display = 'block';
          window.addEventListener('click', outsideClick1);
      }
      function closeAgreeModal1() {
         modal1.style.display = 'none';
          window.removeEventListener('click', outsideClick1);
      }
      // 모달 외부 클릭 시 닫기 함수
      function outsideClick1(e) {
          if (e.target === modal1) {
             modal1.style.display = 'none';
              // 모달 외부 클릭 이벤트 제거
              window.removeEventListener('click', outsideClick1);
          }
      }
      //===========================================================
        /*2. 개인정보 수집 및 이용 동의 (필수)*/
      var modal2 = document.getElementById('agree2Modal'); 
      function openAgreeModal2() {
          modal2.style.display = 'block';
          window.addEventListener('click', outsideClick2);
      }
      function closeAgreeModal2() {
         modal2.style.display = 'none';
          window.removeEventListener('click', outsideClick2);
      }
      // 모달 외부 클릭 시 닫기 함수
      function outsideClick2(e) {
          if (e.target === modal2) {
             modal2.style.display = 'none';
              // 모달 외부 클릭 이벤트 제거
              window.removeEventListener('click', outsideClick2);
          }
      }
      //===========================================================
        /*3. 개인정보 제3자 제공 동의 (필수)*/
      var modal3 = document.getElementById('agree3Modal'); 
      function openAgreeModal3() {
          modal3.style.display = 'block';
          window.addEventListener('click', outsideClick3);
      }
      function closeAgreeModal3() {
         modal3.style.display = 'none';
          window.removeEventListener('click', outsideClick3);
      }
      // 모달 외부 클릭 시 닫기 함수
      function outsideClick3(e) {
          if (e.target === modal3) {
             modal3.style.display = 'none';
              // 모달 외부 클릭 이벤트 제거
              window.removeEventListener('click', outsideClick3);
          }
      }

      //===========================================================
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
      
      /* 전체 동의*/
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
         <input type="submit" value="회원가입" class="in" >     
         <input type="button" value="취소" class="in">
      </form>   
   </fieldset>      
       <%@ include file="../main/footer.jsp"%>
</body>
</html>