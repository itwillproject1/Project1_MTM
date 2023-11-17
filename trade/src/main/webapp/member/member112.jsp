<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/mypage.css" rel="stylesheet" />
<link href="../css/main_styles_mypage.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#a").hide();
	
    $("h2").click(function() {
        $(this).next().toggle();
    });
    
});
</script>
</head>
<body>
		<%@ include file="../main/header.jsp"%>
<br><br><br><br><br><br><br>

<div class="container">
		<div class="form-group h1">
			<label for="productName">${dto.user_id }님 무엇을 도와드릴까요?</label>
		</div>
		
		
		<!-- 본문 내용 시작 -->
		<div class="form-group2">
		

			
			<div class="form-container">

				<h1>자주하는 질문</h1>
				
				<h2> </h2>
				
				<h2>Q. [회원탈퇴] 회원 탈퇴는 어떻게 하나요?</h2>
				<div id="a"><p>회원 탈퇴는 아래의 절차를 따라 하실 수 있습니다. 탈퇴 시 회원 전용 웹 서비스 이용이 불가합니다. 탈퇴 전 유의사항을 반드시 확인해 주시기 바랍니다.
								  <br><br>
								  회원 탈퇴하기<br>
								  마이페이지 → 회원탈퇴 → 비밀번호 입력 → [삭제하기] 클릭 후 회원탈퇴가 완료됩니다.
				</p></div>
				
				
				<h2>Q. [회원탈퇴] 탈퇴하면 개인정보는 모두 삭제되나요? </h2>
				<div id="a"><p>회원 탈퇴와 함께 고객님의 개인정보는 완전히 삭제되므로 재가입을 하여도 구매내역은 확인이 불가합니다.</p></div>
				
				<h2>Q. [회원정보] 광고성 이메일과 문자를 받지 않으려면 어떻게 하나요? </h2>
				<div id="a"><p>  </p></div>
				
				<h2>Q. [회원정보] 회원정보 수정은 어떻게 하나요? </h2>
				<div id="a"><p>회원 탈퇴는 아래의 절차를 따라 하실 수 있습니다.
							<br><br>
							   회원 정보수정하기<br>
							   마이페이지 → 회원정보수정 → 비밀번호 입력 → [수정하기] 클릭 후 회원정보수정이 완료됩니다.  </p></div>			
		
				<h2>Q. [회원가입] 아이디를 여러 개 사용할 수 있나요? </h2>
				<div id="a"><p>  </p></div>
			
				<h2>Q. [인증] 이메일확인을 하는데 메일이 오지 않습니다. </h2>
				<div id="a"><p>  </p></div>
		
				<h2>Q. [결제] 비밀번호 확인없이 결제가 되었는데 안전한가요? </h2>
				<div id="a"><p>  </p></div>
			
				<h2>Q. [회원가입] 인증된 아이디가 이미 존재한다고 나옵니다. </h2>
				<div id="a"><p>  </p></div>
			
				<h2>Q. [] </h2>
				
			
				<h2>Q. [] </h2>

			
			</div>
			
			
			
			
			
		</div>	
		<!-- 본문 내용 끝 -->
 </div>	











	<footer>
		<p>&copy; 1조 전자기기 중고거래</p>
	</footer>
</body>
</html>