<%@page import="com.itwillbs.product.db.ProductDAO"%>
<%@page import="com.itwillbs.product.db.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MTM | 마이페이지</title>
<link rel="icon" href="../main/img/16px.ico" type="image/x-icon">
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
			
			if(img_src == 'http://localhost:8088/trade/member/img/down_arrow.png') {
				$('.none1').css('display', 'inline-block');
				$('#down1').attr('src','../member/img/up_arrow.png');
			} else if(img_src == 'http://localhost:8088/trade/member/img/up_arrow.png') {
				$('.none1').css('display', 'none');
				$('#down1').attr('src','../member/img/down_arrow.png');
				
				$('html, body').animate({
		            scrollTop: $('#title1').offset().top
		        },'fast');
			}
		});
		
		$('#arrow2').click(function(){
			var img_src = document.getElementById('down2').src;
			console.log("img_src: " + img_src);
			
			if(img_src == 'http://localhost:8088/trade/member/img/down_arrow.png') {
				$('.none2').css('display', 'inline-block');
				$('#down2').attr('src','../member/img/up_arrow.png');
			} else if(img_src == 'http://localhost:8088/trade/member/img/up_arrow.png') {
				$('.none2').css('display', 'none');
				$('#down2').attr('src','../member/img/down_arrow.png');
				
				$('html, body').animate({
		            scrollTop: $('#title2').offset().top
		        });
			}
		});
		
		$('#arrow3').click(function(){
			var img_src = document.getElementById('down3').src;
			console.log("img_src: " + img_src);
			
			if(img_src == 'http://localhost:8088/trade/member/img/down_arrow.png') {
				$('.none3').css('display', 'inline-block');
				$('#down3').attr('src','../member/img/up_arrow.png');
			} else if(img_src == 'http://localhost:8088/trade/member/img/up_arrow.png') {
				$('.none3').css('display', 'none');
				$('#down3').attr('src','../member/img/down_arrow.png');
				
				$('html, body').animate({
		            scrollTop: $('#title3').offset().top
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
					<c:if test="${dto.profile != null}" >
					<img src="<%=request.getContextPath() %>/uploadprofile/${dto.profile }" 
					onerror="this.onerror=null; this.src='../member/img/member.png';"
					id="imagePreview" alt="미리보기">
					</c:if>
					<c:if test="${dto.profile == null}" >
					<img src="./img/member.png" id="imagePreview" alt="미리보기">
					</c:if>
				</div>
			</div>
			<!-- 이미지 영역 종료 -->

			<!--  내 정보 영역 -->
			<div class="form-container">
				<h2> 내 정보 </h2>
				
				<div id="fform">
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
	<div class="title1" id="title1">올린 상품 <img src="../main/img/올린상품.png" width="35" alt="올린상품"></div>
	<div class="container1">
		<c:if test="${!empty mpbdto }">
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
				<img src="<%=request.getContextPath() %>/upload/${fileNameArr[0] }" 
					onerror="this.onerror=null; this.src='../product/img/default_product_image.png';" 
					alt="${product.title}">
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
		</c:if>
	</div>
	<c:if test="${empty mpbdto }">
	<div class="cen">
		<label>업로드한 상품이 없습니다.</label>
	</div>
	</c:if>
	<c:if test="${mpbdto.size() > 4 }">
		<div class="arrow" id="arrow1">
			<label><img src="../member/img/down_arrow.png" id="down1"> 펼쳐보기</label>
		</div>
	</c:if>

	<script>
		function toProductContent(url) {
			window.location.href = url;
		}
	</script>
	<!--  내가 올린 상품 끝 -->


	<!--  내가 찜한 상품 시작-->
	<div class="title1" id="title2">찜한 상품 <img src="../main/img/찜2.png" width="35" alt="찜그림"></div>
	<div class="container1">
	<c:if test="${!empty productlikelist }">
		<c:forEach var="product" items="${productlikelist}"  varStatus="loop">
			<c:set var="fileNameArr" value="${fn:split(product.file_name, ',')}" />
			<div class="product1
			<c:if test="${product.deal_status == 0 }">
				 disabled1
			</c:if>
			<c:if test="${loop.index > 3 }">
				 none2
			</c:if>" onclick="toProductContent('../product/ProductContent.com?bno=${product.bno}')">
				<img src="<%=request.getContextPath() %>/upload/${fileNameArr[0] }" 
					onerror="this.onerror=null; this.src='../product/img/default_product_image.png';" 
					alt="${product.title}">
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
		</c:if>
	</div>
		<c:if test="${empty productlikelist }">
		<div class="cen">
		<label>찜한 상품이 없습니다.</label>
		</div>
		</c:if>
	
	<c:if test="${productlikelist.size() > 4 }">
		<div class="arrow" id="arrow2">
			<label><img src="../member/img/down_arrow.png" id="down2"> 펼쳐보기</label>
		</div>
	</c:if>
	<!--  내가 찜한 상품 끝 -->

	<!--  내가 구매한 상품 목록 -->
	<div class="title1" id="title3">구매한 상품 <img src="../main/img/돈.png" width="32" alt="돈그림"></div>
	<div class="container1">
	<c:if test="${!empty buyList }">
		<c:forEach var="i" begin="0" end="${tradeOkList.size()-1 }">
		<div class="form-group
			<c:if test="${i > 3 }">
				 none3
			</c:if>">
			<label><a href="./tradeDetail.member?order_id=${tradeOkList[i].order_id }">주문번호: ${tradeOkList[i].order_id }</a> </label>
			<c:set var="fileNameArr" value="${fn:split(buyList[i].file_name, ',')}" />
			<div class="product1
            <c:if test="${buyList[i].deal_status == 0}">
                disabled1
            </c:if>
			" onclick="toProductContent('../product/ProductContent.com?bno=${buyList[i].bno}')">
				<div>
					<img src="${pageContext.request.contextPath}/upload/${buyList[i].file_name}" 
						onerror="this.onerror=null; this.src='../product/img/default_product_image.png';" 
						alt="${buyList[i].title}">
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
	</c:if>
	</div>
	<c:if test="${empty buyList }">
	<div class="cen">
		<label>구매 상품이 없습니다.</label>
	</div>
	</c:if>
	<c:if test="${tradeOkList.size() > 4 }">
		<div class="arrow" id="arrow3">
			<label><img src="../member/img/down_arrow.png" id="down3"> 펼쳐보기</label>
		</div>
	</c:if>
	<!--  내가 구매한 상품 목록 끝 -->


	 <%@ include file="../main/footer.jsp"%>
</body>
</html>