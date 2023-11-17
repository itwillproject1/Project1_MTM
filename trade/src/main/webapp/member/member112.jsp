<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/member112.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	$(".hide").hide();
	
    $("h2").click(function() {
        $(this).next().toggle();
    });
    
});
</script>
</head>
<body>
	<%@ include file="../main/header.jsp"%>
	<div class="container">
		<div class="form-group h1">
			<label for="productName">무엇을 도와드릴까요?</label>
			<button class="btn" onclick="openQnaList();">1:1 문의내역</button>
			<button class="btn" onclick="openQna();">1:1 문의하기</button>
		</div>
		
		
		<!-- 본문 내용 시작 -->
		<div class="form-group2">	
			<div class="form-container" id="help">

				<h1>자주하는 질문</h1>

				<h2>Q. [회원탈퇴] 회원 탈퇴는 어떻게 하나요?</h2>
				<div class="hide">
					<p>
					회원 탈퇴는 아래의 절차를 따라 하실 수 있습니다. 탈퇴 시 회원 전용 웹 서비스 이용이 불가합니다. 탈퇴 전 유의사항을 반드시 확인해 주시기 바랍니다.
					<br><br>
					회원 탈퇴하기<br>
					마이페이지 → 회원탈퇴 → 비밀번호 입력 → [삭제하기] 클릭 후 회원탈퇴가 완료됩니다.
					</p>
				</div>
				
				
				<h2>Q. [회원탈퇴] 탈퇴하면 개인정보는 모두 삭제되나요? </h2>
				<div class="hide">
					<p>
						회원 탈퇴와 함께 고객님의 개인정보는 완전히 삭제되므로 재가입을 하여도 구매내역은 확인이 불가합니다.
					</p>
				</div>
				
				<!-- <h2>Q. [회원정보] 광고성 이메일과 문자를 받지 않으려면 어떻게 하나요? </h2>
				<div class="hide">
					<p>
						회원정보 수정 페이지에서 광고성 이메일과 문자 수신 설정을 할 수 있습니다.<br><br>
						마이페이지 → 정보수정 → 광고 수신 동의 설정 후 [정보수정하기] 클릭
					</p>
				</div> -->
				
				<h2>Q. [회원정보] 회원정보 수정은 어떻게 하나요? </h2>
				<div class="hide">
					<p>회원 탈퇴는 아래의 절차를 따라 하실 수 있습니다.
					<br><br>
					회원 정보수정하기<br>
					마이페이지 → 회원정보수정 → 비밀번호 입력 → [수정하기] 클릭 후 회원정보수정이 완료됩니다.</p>
				</div>			
		
				<h2>Q. [회원가입] 아이디를 여러 개 사용할 수 있나요? </h2>
				<div class="hide">
					<p>
						MTM은 이메일 계정을 통해 중복가입을 제한하고 있습니다.<br>
						만약 다른 이메일로 가입한다면, 아이디를 여러 개 사용할 수 있습니다.<br>
					</p>
				</div>
			
				<h2>Q. [인증] 이메일확인을 하는데 메일이 오지 않습니다. </h2>
				<div class="hide">
					<p>
						인증 이메일을 발송했는데도 5분 이상 이메일이 오지 않는다면 아래 내용을 확인해보세요.<br>
						<h4>1. 이메일을 잘못 입력한 경우</h4>
						이메일을 잘못 입력하지 않았는지 확인해주세요.<br>
						이메일을 정확하게 입력했는데도 이메일이 오지 않을 경우, 아래 내용을 확인해보세요.<br>
						
						<h4>2. 이메일 스팸 차단 기능</h4>
						스팸 이메일 창에 해당 이메일이 발송되어있는지 확인해보세요.<br>
						스팸 이메일 창에 있다면, 스팸을 해제해주세요.<br>
					</p>
				</div>
		
				<h2>Q. [결제] 비밀번호 확인없이 결제가 되었는데 안전한가요? </h2>
				<div class="hide">
					<p>
						내용입력!!
					</p>
				</div>
			
				<h2>Q. [회원가입] 인증된 아이디가 이미 존재한다고 나옵니다. </h2>
				<div class="hide">
					<p>
						아이디가 이미 있는 경우라면, 로그인 페이지의 아이디 찾기/비밀번호 찾기 서비스를 이용해 계정정보를 확인하실 수 있습니다.<br>
						해당 서비스를 통해 계정 정보를 찾으신 후 로그인 해주세요.<br>
					</p>
				</div>
			
			</div>
			</div>
			
		</div>	
		<!-- 본문 내용 끝 -->
 	
 	<script>
 		function openQna() {
 			var login_id = '<%= session.getAttribute("user_id") %>';
 			
 			if(login_id == "null") {
 				alert('해당 기능은 로그인이 필요합니다.');
 			} else {
 				location.href="../member/Qna.member";
 			}
 		}
 		
 		function openQnaList() {
			var login_id = '<%= session.getAttribute("user_id") %>';
 			
 			if(login_id == "null") {
 				alert('해당 기능은 로그인이 필요합니다.');
 			} else {
 				location.href="../member/QnaList.member";
 			}
 		}
 	</script>

	<footer>
		<p>&copy; 1조 전자기기 중고거래</p>
	</footer>
</body>
</html>