<%@page import="com.itwillbs.product.db.ProductDAO"%>
<%@page import="com.itwillbs.product.db.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link href="../css/mypage.css" rel="stylesheet" />
<link href="../css/main_styles_mypage.css" rel="stylesheet" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#arrow1').click(function(){
			var img_src = document.getElementById('down1').src;
			console.log("img_src: " + img_src);
			
			if(img_src == 'http://localhost:8088/trade/member/img/down_arrow.png') {
				$('.none1').css('display', 'inline-block');
				$('#down1').attr('src','./img/up_arrow.png');
			} else if(img_src == 'http://localhost:8088/trade/member/img/up_arrow.png') {
				$('.none1').css('display', 'none');
				$('#down1').attr('src','./img/down_arrow.png');
				
				$('html, body').animate({
		            scrollTop: $('#title1').offset().top
		        });
			}
		});
	});
</script>
</head>
<body>
<%@ include file="../main/header.jsp"%>
<script type="text/javascript">
	function pay() {
		let checkid = window.open("../member/MemberPayInfo.member","pay","width=600,height=650, scrollbars=yes, resizable=yes");	
	}
</script>

	<div class="container">
		<div class="form-group h1">
			<label for="productName">${dto.user_id }님의 마이페이지</label>
				<button class="qnaBtn" onclick="openQnaList();">1:1 문의내역</button>
				<button class="qnaBtn" onclick="openQna();">1:1 문의하기</button>
		</div>

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


		<!-- 본문 내용 시작 -->
		<div class="form-group2">

			<!-- 이미지 영역 시작 -->
			<div class="image-container">

				<div class="image-preview">
					<img src="<%=request.getContextPath() %>/uploadprofile/${dto.profile }" id="imagePreview" alt="미리보기">
				</div>
			</div>
			<!-- 이미지 영역 종료 -->

			<!--  내 정보 영역 -->
			<div class="form-container">
				<h2> 내 정보 </h2>
				
				<div class="form-group">
					<label for="user">아이디 : ${dto.user_id }</label>
				</div>
				
				<div class="form-group2">
					<label for="user">
						현재 포인트 : <fmt:formatNumber value="${dto.pay }"/>P
					</label>
				<input class="payBtn" type="button" value="충전하기" onclick="pay();">
				</div>

				<div class="form-group">
					<label for="user">이름: ${dto.user_name }</label>
				</div>

				<div class="form-group">
					<label for="user">닉네임 : ${dto.user_nickname }</label>
				</div>

				<div class="form-group">
					<label for="user">생년월일: ${dto.jumin }</label>
				</div>

				<div class="form-group">
					<label for="user">성별 : ${dto.gender }</label>
				</div>

				<div class="form-group">
					<label for="user">이메일 : ${dto.email }</label>
				</div>

				<div class="form-group">
					<label for="user">주소 : ${dto.address }</label>
				</div>

				<div class="form-group">
					<label for="user">전화번호: ${dto.phone }</label>
				</div>



				<div class="button-container">
					<button class="submit-button" type="button" onclick="window.location.href = '../member/Memberupdate.member'">정보수정</button>
					<button class="submit-button" type="button" onclick="window.location.href = '../member/removemember.member'">회원탈퇴</button>

				</div>

			</div>
			<!--  내 정보 영역 끝 -->

		</div>
		<!-- 본문 내용 끝 -->
	</div>

	<!--  내가 올린 상품  시작-->
	<div class="title1" id="title1">내가 올린 상품</div>
	<div class="container1">
		<c:forEach var="product" items="${mpbdto}" varStatus="loop">
			<c:set var="fileNameArr" value="${fn:split(product.file_name, ',')}" />

			<div class="product1
			<c:if test="${product.deal_status == 0 }">
				 disabled1
			</c:if>
			<c:if test="${loop.index > 3 }">
				 none1
			</c:if>
			" onclick="toProductContent('../product/ProductContent.com?bno=${product.bno}')">
				<img src="<%=request.getContextPath() %>/upload/${fileNameArr[0] }" alt="${product.title}">
				<div class="product-info">
					<h3>[${product.deal_way }]${product.title }</h3>
				</div>
				<div class="product-price">
					<p>
						<fmt:formatNumber value="${product.price }" />
						원
					</p>
					
				</div>
			</div>
		</c:forEach>
	</div>
	<c:if test="${mpbdto.size() > 4 }">
		<div class="arrow" id="arrow1">
			<img src="./img/down_arrow.png" id="down1">
		</div>
	</c:if>

	<script>
		function toProductContent(url) {
			window.location.href = url;
		}
	</script>
	

	<!--  내가 올린 상품 끝 -->


	<!--  내가 찜한 상품 시작-->
	<div class="title1" id="title2">내가 찜한 상품</div>
	<div class="container1">

		<c:forEach var="product" items="${productlikelist}"  varStatus="loop">
			<c:set var="fileNameArr" value="${fn:split(product.file_name, ',')}" />
			<div class="product1
			<c:if test="${product.deal_status == 0 }">
				 disabled1
			</c:if>
			<c:if test="${loop.index > 3 }">
				 none1
			</c:if>" onclick="toProductContent('../product/ProductContent.com?bno=${product.bno}')">
				<img src="<%=request.getContextPath() %>/upload/${fileNameArr[0] }" alt="${product.title}">
				<div class="product-info">
					<h3>[${product.deal_way }]${product.title }</h3>
				</div>
				<div class="product-price">
					<p>
						<fmt:formatNumber value="${product.price }" />
						원
					</p>
				</div>
			</div>
		</c:forEach>
	</div>
	<c:if test="${productlikelist.size() > 4 }">
		<div class="arrow">
			<img src="./img/down_arrow.png" id="down">
		</div>
	</c:if>
	<!--  내가 찜한 상품 끝 -->

	<!--  내가 구매한 상품 목록 -->
	<div class="title1" id="title3">내가 구매한 상품</div>
	<div class="container1">
		<c:forEach var="i" items="${tradeOkList }">
		<div class="form-group">
			<label><a href="./tradeDetail.member?order_id=${tradeOkList[i].order_id }">주문번호: ${tradeOkList[i].order_id }</a> </label>
			<c:set var="fileNameArr" value="${fn:split(buyList[i].file_name, ',')}" />
			<div class="product1
            <c:if test="${buyList[i].deal_status == 0}">
                disabled1
            </c:if>
			<c:if test="${i > 3 }">
				 none1
			</c:if>" onclick="toProductContent('../product/ProductContent.com?bno=${buyList[i].bno}')">
				<div>
					<img src="${pageContext.request.contextPath}/upload/${buyList[i].file_name}" alt="${buyList[i].title}">
				</div>
				<div class="product-info">
					<h3>[${buyList[i].deal_way}]${buyList[i].title}</h3>
				</div>
				<div class="product-price">
					<p>
						<fmt:formatNumber value="${buyList[i].price}" />원
					</p>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	<c:if test="${tradeOkList.size() > 4 }">
		<div class="arrow">
			<img src="./img/down_arrow.png" id="down">
		</div>
	</c:if>
	<!--  내가 구매한 상품 목록 끝 -->

	<%@ include file="../main/footer.jsp"%>
</body>
</html>