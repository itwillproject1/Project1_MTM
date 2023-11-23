<%@page import="com.itwillbs.product.db.SuggestSellDTO"%>
<%@page import="com.itwillbs.product.db.SuggestSellDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.itwillbs.product.db.ProductDAO"%>
<%@page import="com.itwillbs.product.db.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
   href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap">
<link href="../css/productContent.css" rel="stylesheet" />
<link href="../css/productModal.css" rel="stylesheet" />
<title>MTM | 상품 상세보기</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
   $(document).ready(function() {
         // 좋아요 버튼 클릭 시 실행되는 ajax
         $('#like').on('click',function() {
            // 현재 URL에서 bno 값 추출
            var urlParams = new URLSearchParams(window.location.search);
            var bno = urlParams.get('bno');
            var login_id = '<%= session.getAttribute("user_id") %>';
            
            if(login_id == "null") {
            alert('해당 기능은 로그인이 필요합니다');
            window.location.href = "../main/login.member";
            } else {
                $.ajax({
                  url : "./LikeCheck.com",
                  type : 'POST',
                  data : {bno : bno},
                  success : function(response) {                  
                     var result = response.split('\n')[0].trim();
                     var like_count = response.split('\n')[1].trim();
                     
                     $("#like_count").text(like_count);
                     console.log($("#like_count").text());
      
                     if (result === "1") {
                        $("#do_like").html("<img alt='찜하기' src='./img/heart1.png' width='12px'>");
                     } else if (result === "0") {
                        $("#do_like").html("<img alt='찜하기' src='./img/heart0.png' width='12px'>");
                     } else {
                        $("#do_like").text("오류! 리턴값 -1");
                     }
                  }
               });               
            }
         });
      });
</script>
</head>
<link rel="icon" href="../main/img/16px.ico" type="image/x-icon">
<body>

   <%@ include file="../main/header.jsp"%>

   <div class="container
   <c:if test="${product.deal_status == 0 }">
            disabled
         </c:if>">
      <div class="form-group h1">
         <label for="productName">[${dto.deal_way }]${dto.title }</label>
      </div>

      <!-- 이미지 영역 시작 -->
      <c:set var="fileNameArr" value="${fn:split(dto.file_name, ',')}" />
      <div class="form-group2">
         <div class="image-container">
            <!-- 이미지를 클릭하면 JavaScript로 크게 보이게 설정 -->
            <div class="image-preview">
               <img src="<%=request.getContextPath() %>/upload/${fileNameArr[0]}" 
               		onerror="this.onerror=null; this.src='../product/img/default_product_image.png';"
               		id="imagePreview">
            </div>

            <div class="image-preview-choice">
               <c:forEach var="file_name" items="${fileNameArr}">
                  <img src="<%=request.getContextPath() %>/upload/${file_name}"
                  	onerror="this.onerror=null; this.src='../product/img/default_product_image.png';"  
                    id="imagePreviewChoice" class="clickable-image" alt="미리보기">
               </c:forEach>
            </div>
         </div>
         <!-- 이미지 영역 종료 -->

         <div class="form-container">
            <h2>
               상세 페이지
               
               <!-- 신고버튼 또는 기타버튼 -->
               <c:choose>
                  <c:when test="${empty login_id}">
                     <!-- 세션에 사용자 ID가 없을 때 -->
                  </c:when>
                  <c:otherwise>
                     <c:choose>
                        <c:when test="${login_id eq dto.user_id}">
                           <!-- 로그인한 사용자 == 글 작성자 -->
                           <div class="dropdown">
                              <button class="update-content-button" type="button">
                                 <img src="./img/etc-button.png" alt="기타" width="20">
                              </button>
                              <div class="dropdown-content" style="display: none;">
                                 <button onclick="location.href='./ProductUpdate.com?bno=${dto.bno}';"><b id="updateB">수정하기</b>
                                  <svg id="pencil" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
								  <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
								</svg>
                                 </button>
                                 <button id="deleteW" onclick="confirmDelete();"><b id="deleteB">삭제하기</b>
                                <svg id="trash" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
								  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
								  <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
								</svg>
                                 </button>
                              </div>
                           </div>
                        </c:when>
                        <c:when test="${login_id ne dto.user_id}">
                           <!-- 로그인한 사용자 != 글 작성자 -->
                           <input class="complain-button" type="button" value="🚨" onclick="openComplainModal();">
                        </c:when>
                     </c:choose>
                  </c:otherwise>
               </c:choose>
            </h2>
            
            <div class="form-group">
               <label for="user">작성일자: <fmt:formatDate pattern="yyyy-MM-dd" value="${dto.date_time}" />
               </label>
            </div>
            
            <div class="form-group">
               <label for="user">작성자:
                  <button class="profile-button" onclick="openProfileModal();">${dto.user_id }</button>
               </label>
            </div>

            <div class="form-group">
               <label for="user">조회수: ${dto.views }</label>
            </div>

            <div class="form-group">
               <label for="productCategory">카테고리: <a href="../product/ProductList.com?category=${category }">${dto.category }</a></label>
            </div>

            <div class="form-group">
               <label for="productBrand">브랜드: ${dto.brand }</label>
            </div>

            <c:if test="${dto.deal_way.equals('팝니다') }">
               <div class="form-group">
                  <label for="productCondition">상품 상태: ${dto.product_status }</label>
               </div>
            </c:if>

            <div class="form-group">
               <label for="productPrice">가격(원): <fmt:formatNumber value="${dto.price}" /></label>
            </div>

            <!-- 구매 판매 찜 등 버튼 -->
	               <div class="button-container">
            <c:if test="${dto.deal_way.equals('삽니다')}">
            	<c:if test="${dto.deal_status == 1 }">
	                  <c:choose>
	                     <c:when test="${empty login_id}">
	                        <input type="button" class="submit-button" value="판매 제안" onclick="requireLogin();">
	                     </c:when>
	                     <c:when test="${login_id eq dto.user_id}">
	                        <button class="submit-button" onclick="openSuggestModal();">거래 제안 현황</button>
	                     </c:when>
	                     <c:when test="${!empty login_id and login_id ne dto.user_id}">
	                        <button class="submit-button" onclick="openProductModal();">판매 제안</button>
	                     </c:when>
	                  </c:choose>
            	</c:if>
            	<c:if test="${dto.deal_status == 0 }">
            		<input type="button" class="no-button" value="거래 완료">
            	</c:if> 
            </c:if>

				<c:if test="${dto.deal_way.equals('팝니다') }">
						<c:if test="${dto.deal_status == 1 }">
							<c:if test="${login_id eq dto.user_id}">
								<input class="submit-button" type="button" value="판매 제안 현황"
									onclick="openSuggestListModal();">
							</c:if>
							<c:if test="${empty login_id}">
								<input class="submit-button" type="button" value="구매하기"
									onclick="requireLogin();">
							</c:if>
							<c:if test="${not empty login_id and login_id ne dto.user_id}">
								<input class="submit-button" type="button" value="구매하기"
    									onclick="confirmPurchase('${dto.bno}')">
							</c:if>
						</c:if>
						<c:if test="${dto.deal_status == 0 }">
							<input type="button" class="no-button" value="거래 완료">
						</c:if>
				</c:if>

						<!-- 찜 기능 시작 -->
						<button class="submit-button" id="like">
							<span id="do_like"> <c:if test="${likeResult eq 0 }">
									<img alt="찜하기" src="./img/heart0.png" width="12px">
								</c:if> <c:if test="${likeResult eq 1 }">
									<img alt="찜하기" src="./img/heart1.png" width="12px">
								</c:if>
							</span> <span id="like_count"> ${dto.like_count} </span>
						</button>
						<!--  찜 기능 끝 -->
					</div>
			</div>
      </div>
      <div class="form-group product-content">
         <label for="productDescription">상품 설명 </label> ${dto.content }
      </div>
   </div>

   <!-- Modal 시작 -->
   <!-- 프로필 모달 시작 -->
	<div id="profileModal" class="modal">
		<div class="modal-content">
			<span class="close-button" onclick="closeProfileModal();">닫기</span>
			<div id="productInfo">
				<!-- 모달 내용 -->
				<h2>
					<img src="<%=request.getContextPath() %>/uploadprofile/${mdto.profile }" onerror="this.onerror=null; this.src='../member/img/member.png';" alt="프로필" id="pf"> ${dto.user_id}
				</h2>

				<h3 id="h3">${dto.user_id}님의 판매 상품 목록</h3>
				<c:forEach var="userProduct" items="${userProducts }">
					<c:set var="fileNameArr4" value="${fn:split(userProduct.file_name, ',')}" />
						<c:if test="${userProduct.deal_way == '팝니다'}">
							<div id="productList" onclick="location.href='./ProductContent.com?bno=${userProduct.bno}';">
								<span id="middle">
									<img id="pfImage" src="<%=request.getContextPath() %>/upload/${fileNameArr4[0]}" onerror="this.onerror=null; this.src='../product/img/default_product_image.png';" alt="미리보기">
								</span>
								<div id="pfDiv">
									<span>상품명: ${userProduct.title}<br></span>
									<span>가격: <fmt:formatNumber value="${userProduct.price}" />원</span>
								</div>
								<hr id="pfHr">
							</div>
						</c:if>
							<c:if test="${sellCount == 0}">
			            		<div id="no-item">판매 상품이 없습니다.</div>
							</c:if>
				</c:forEach>
				
				<br>
				<br>
				
				<h3 id="h3">${dto.user_id}님의 구매 상품 목록</h3>
				<c:forEach var="userProduct" items="${userProducts }">
					<c:set var="fileNameArr4" value="${fn:split(userProduct.file_name, ',')}" />
						<c:if test="${userProduct.deal_way == '삽니다'}">
							<div id="productList" onclick="location.href='./ProductContent.com?bno=${userProduct.bno}';">
								<span id="middle"> <img id="pfImage" src="<%=request.getContextPath() %>/upload/${fileNameArr4[0]}" onerror="this.onerror=null; this.src='../product/img/default_product_image.png';" alt="미리보기">
								</span>
								<div id="pfDiv">
									<span>상품명: ${userProduct.title}<br></span> <span>가격: <fmt:formatNumber value="${userProduct.price}" />원
									</span>
								</div>
								<hr id="pfHr">
							</div>
						</c:if>
						
						<c:if test="${buyCount == 0}">
			            	<div id="no-item">구매 상품이 없습니다.</div>
						</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- 프로필 모달 종료 -->
   
     <!-- 신고하기 모달창 -->
   <div id="complainModal" class="modal">
       <div class="modal-content">
           <form id="ComplainForm" action="./Complain.com?bno=${dto.bno}" method="post">
               <input type="radio" id="postReportRadio" class="productRadio" name="reportType" value="postReport" data-productid="1">
               <label for="postReportRadio">게시글 신고</label><br>
               <div id="postReportOptions" style="display: none;">
                   <input type="radio" class="reasonRadio" name="reason" value="1">
                   <label for="postReason1">불법 상품 또는 서비스 판매</label><br>
                   <input type="radio" class="reasonRadio" name="reason" value="2">
                   <label for="postReason2">불쾌한, 혐오스러운 내용이나 이미지 포함</label><br>
                   <input type="radio" class="reasonRadio" name="reason" value="3">
                   <label for="postReason3">거짓 정보, 거짓 광고, 또는 과장된 설명</label><br>
                   <input type="radio" class="reasonRadio" name="reason" value="4">
                   <label for="postReason4">저작권 침해 (타인의 이미지 또는 콘텐츠 무단 사용)</label><br>
                   <input type="radio" class="reasonRadio" name="reason" value="5">
                   <label for="postReason5">사기성 게시글 (실제로 판매되지 않는 상품)</label><br>
                   <input type="radio" class="reasonRadio" name="reason" value="6">
                   <label for="postReason6">개인 정보 침해 (타인의 개인 정보 공개)</label><br>
                   <input type="radio" class="reasonRadio" name="reason" value="7">
                   <label for="postReason7">광고 스팸 또는 중복 게시글</label><br>
                   
                   <input type="radio" class="reasonRadio" name="reason" value="8" onchange="showTextarea('post')">
                   <label for="postReason8">기타</label><br>
                   <div id="otherReason" style="display: none;">
                       <textarea name="otherReason" id="otherReasonText" placeholder="기타 이유를 입력하세요"></textarea>
                   </div>
           </div>
               <input type="radio" id="authorReportRadio" class="productRadio" name="reportType" value="authorReport" data-productid="2">
               <label for="authorReportRadio">작성자 신고</label><br>
               <div id="authorReportOptions" style="display: none;">
                   <input type="radio" class="reasonRadio" name="reason" value="1">
                   <label for="authorReason1">거래 사기 또는 부정행위 (송금 후 발송X)</label><br>
                   <input type="radio" class="reasonRadio" name="reason" value="2">
                   <label for="authorReason2">거래 후 불만 및 환불 요청 무시</label><br>
                   <input type="radio" class="reasonRadio" name="reason" value="3">
                   <label for="authorReason3">불쾌한 언행 또는 협상 방해</label><br>
                   <input type="radio" class="reasonRadio" name="reason" value="4">
                   <label for="authorReason4">거짓 프로필 정보 또는 사진 사용</label><br>
                   <input type="radio" class="reasonRadio" name="reason" value="5">
                   <label for="authorReason5">반복적인 불법 행동 (여러 사용자를 속임)</label><br>
                   <input type="radio" class="reasonRadio" name="reason" value="6">
                   <label for="authorReason6">규정 위반 (중고거래 플랫폼의 규정을 어기는 행동)</label><br>
                   <input type="radio" class="reasonRadio" name="reason" value="7">
                   <label for="authorReason7">욕설, 혐오 내용 또는 괴롭힘</label><br>
                   
                   <input type="radio" class="reasonRadio" name="reason" value="8" onchange="showTextarea('author')">
                   <label for="authorReason8">기타</label><br>
                   <div id="otherReason2" style="display: none;">
                       <textarea name="otherReason2" id="otherReasonText2" placeholder="기타 이유를 입력하세요"></textarea>
                   </div>
                   
               </div>
               <div class="button-container1" >
               	<button class="confirm-button" onclick="submitComplainOffer()">신고하기</button>
               </div>
           </form>
               <button class="close-button" onclick="closeComplainModal()">닫기</button>
       </div>
   </div>
   <!-- 신고하기 모달창 종료-->


   <!-- 판매하기 모달 시작 -->
   <div id="sellModal" class="modal">
      <div class="modal-content">
         <span class="close-button" onclick="closeProductModal()">닫기</span>
         <div id="productInfo">
            <!-- 상품 정보 -->

            <c:if test="${!empty sellProduct}">
               <h2>${login_id }님의 판매상품목록</h2>
               <form action="./SuggestSell.com?bno=${dto.bno }" method="post" id="SuggestSellForm">
                  <c:forEach var="sellProduct" items="${sellProduct}">
                     <div>
                        <c:if test="${sellProduct.isOffered }">
                           <input type="radio" id="sellCheckbox" class="productCheckbox" name="sellProductBno" value="${sellProduct.bno }" disabled="disabled">
                        </c:if>
                        <c:if test="${!sellProduct.isOffered }">
                           <input type="radio" id="sellCheckbox" class="productCheckbox" name="sellProductBno" value="${sellProduct.bno }">
                        </c:if>
                        <img id="sellImage" src="<%=request.getContextPath()%>/upload/${sellProduct.file_name }" 
                        onerror="this.onerror=null; this.src='../product/img/default_product_image.png';"
                        alt="미리보기">
                     </div>
                     <div>
                        <span id="sellDiv">
                           <span>상품명: ${sellProduct.title }<br> </span>
                           <span>상품상태: ${sellProduct.product_status }<br></span>
                           <span> 가격: <span id="priceSpan"><fmt:formatNumber value="${sellProduct.price }" />원 </span>
                              <span id="priceSpan2"><fmt:formatNumber value="${dto.price}" />원 </span>
                           </span>
                        </span>
                        <hr id="hr1">
                     </div>

                  </c:forEach>
               </form>
            </c:if>
            <c:if test="${empty sellProduct}">
               <p id="noSell">판매 등록 상품이 없습니다.</p>
               <button class="sell-button" onclick="location.href='../product/ProductUpload.com'">판매하러가기</button>
            </c:if>
            <c:if test="${empty login_id}">
               <p id="noSell">
                  해당 기능은 로그인이 필요합니다. <a href="../main/login.member">로그인</a>
               </p>
            </c:if>

            <c:if test="${!empty login_id && !empty sellProduct}">
            <div class="button-container">
               <button class="submit-button" onclick="submitProductOffer();">판매 제안</button>
               </div>
            </c:if>

         </div>
      </div>
   </div>
   <!-- 판매하기 모달 종료 -->


	<!-- 거래 제안 현황 모달 시작-->
	<div id="suggestProductModal" class="modal">
		<div class="modal-content">
			<span class="close-button" onclick="closeSuggestModal()">닫기</span>
			<div id="productInfo">
				<!-- 모달 내용 -->
				<h3 id="h3">거래 제안 현황</h3>
				<c:if test="${!empty suggestList }">

					<form action="../product/ProductTradeAction.com?buy_bno=${dto.bno}"  method="post" id="SubmitSuggestForm">

						<!-- 거래 제안 들어온 상품 목록 가져오기 -->
						<c:forEach var="spdto" items="${spdto }">
							<c:set var="fileNameArr2" value="${fn:split(spdto.file_name, ',')}" />
							<div>
								<input type="radio" id="sellCheckbox" class="productCheckbox" name="sell_bno" value="${spdto.bno }">
								<div id="productList" onclick="location.href='./ProductContent.com?bno=${spdto.bno}';">
                           <img id="sellImage" src="<%=request.getContextPath()%>/upload/${fileNameArr2[0] }" 
                           onerror="this.onerror=null; this.src='../product/img/default_product_image.png';"
                           alt="미리보기">
                           <span id="sellDiv">
                              <span>상품명: ${spdto.title}<br></span>
                              <span>상품상태: ${spdto.product_status}<br></span>
                              <span>가격: <span id="priceSpan"><fmt:formatNumber value="${spdto.price}" />원 </span>
                                 <span id="priceSpan2"><fmt:formatNumber value="${dto.price}" />원 </span>
                              </span>
                           </span>
                        </div>
                        <hr id="hr1">
                     </div>
                  </c:forEach>
                  <div class="button-container">
                  	<button type="button" class="submit-button" onclick="submitSuggest();">거래 하기</button>
                  </div>
               </form>
            </c:if>
            <c:if test="${empty suggestList }">
               <p id="noSell">거래 제안 상품이 없습니다.</p>
            </c:if>
         </div>
      </div>
   </div>
   <!-- 거래 제안 현황 모달 종료-->
   
   <!-- 판매 제안 현황 리스트 모달 시작 -->
   <div id="suggestListModal" class="modal">
      <div class="modal-content">
         <span class="close-button" onclick="closeSuggestListModal()">닫기</span>
         
         <!-- 모달 내용 -->
         <h3 id="h3">현재 상품의 판매 제안 현황</h3>
         <c:if test="${!empty ssldto }">
            <form action="./CancleSuggest.com?bno=${dto.bno }" method="post" id="cancleSuggestForm">
               <!-- 판매 제안한 상품 리스트 가져오기 -->
               <c:forEach var="ssldto" items="${ssldto }">
                  <c:set var="fileNameArr3" value="${fn:split(ssldto.file_name, ',')}" />
                  <div>
                     <input type="checkbox" id="sellCheckbox" class="productCheckbox" name="cancle_bno" value="${ssldto.bno }">
                     <div id="productList" onclick="location.href='./ProductContent.com?bno=${ssldto.bno}';">

                        <img id="sellImage" src="<%=request.getContextPath()%>/upload/${fileNameArr3[0] }" 
                        onerror="this.onerror=null; this.src='../product/img/default_product_image.png';"
                        alt="미리보기">
                        <span id="sellDiv">
                           <span>상품명: ${ssldto.title}<br></span>
                           <span>상품상태: ${ssldto.product_status}<br></span>
                           <span>가격: <span id="priceSpan"><fmt:formatNumber value="${dto.price}" />원 </span>
                              <span id="priceSpan2"><fmt:formatNumber value="${ssldto.price}" />원 </span>
                           </span>
                        </span>
                     </div>
                     <hr id="hr1">
                  </div>
               </c:forEach>
               <div class="button-container">
               	<button type="button" class="submit-button" onclick="cancleSuggest();">판매제안 취소</button>
               </div>
            </form>
         </c:if>
         <c:if test="${empty ssldto }">
            <p id="noSell">판매 제안 현황이 없습니다.</p>
         </c:if>
      </div>
   </div>
   <!-- 판매 제안 현황 리스트 모달 종료 -->
   <!-- Modal 종료 -->
   
   
   <!-- script 시작 -->
   <!-- 이미지 미리보기 시작 -->
   <script>
            // 이미지를 클릭할 때 이미지를 크게 보기
            var imageChoiceElements = document.querySelectorAll("#imagePreviewChoice");
            var imagePreviewElement = document.getElementById("imagePreview");

            imageChoiceElements.forEach(function(imageChoice) {
               imageChoice.addEventListener("click", function() {
                  imagePreviewElement.src = imageChoice.src;
               });
            });
         </script>
   <!-- 이미지 미리보기 종료 -->

<!-- 구매하기 전 가격확인 -->
<script>
function confirmPurchase(bno) {
	var price = Number("${dto.price}");
    var fPrice = price.toLocaleString();
	
    var result = confirm('해당 상품을 ' + fPrice + '원에 구매하시겠습니까?');
    if (result) {
        location.href = `../pay/payment.com?bno=${dto.bno}`;
    } else {
    }
}
</script>



<!-- 신고창 시작 -->
   <script>
   var cModal = document.getElementById("complainModal");
   var postReportRadio = document.getElementById("postReportRadio");
   var postReportOptions = document.getElementById("postReportOptions");
   var authorReportRadio = document.getElementById("authorReportRadio");
   var authorReportOptions = document.getElementById("authorReportOptions");

   function openComplainModal() {
      cModal.style.display = "block";
       window.addEventListener('click', outsideClick);
   }

   
   function closeComplainModal() {
      cModal.style.display = "none";
       window.removeEventListener('click', outsideClick);
   }
   
   // 모달 외부 클릭 시 닫기 함수
     function outsideClick(e) {
       if (e.target === cModal) {
          cModal.style.display = 'none';
         // 모달 외부 클릭 이벤트 제거
         window.removeEventListener('click', outsideClick);
       }
     }

   postReportRadio.addEventListener("change", function() {
      postReportOptions.style.display = this.checked ? 'block' : 'none';
       authorReportOptions.style.display = 'none'; // 게시글 신고 선택 시 작성자 신고의 하위 라디오 버튼을 숨김
       resetComplainForm();

   });

   authorReportRadio.addEventListener("change", function() {
      authorReportOptions.style.display = this.checked ? 'block' : 'none';
       postReportOptions.style.display = 'none'; // 작성자 신고 선택 시 게시글 신고의 하위 라디오 버튼을 숨김
       resetComplainForm();

   });

   function showTextarea(type) {
       if (type === 'post') {
           document.getElementById('otherReason').style.display = 'block';
           document.getElementById('otherReasonText').focus(); // 포커스 설정
           document.getElementById('otherReason2').style.display = 'none'; // 다른 textarea 감추기
       } else if (type === 'author') {
           document.getElementById('otherReason2').style.display = 'block';
           document.getElementById('otherReasonText2').focus(); // 포커스 설정
           document.getElementById('otherReason').style.display = 'none'; // 다른 textarea 감추기
       }
   }
   
   function resetComplainForm() {
       var radioGroups = document.querySelectorAll('input[name="reason"]');
       radioGroups.forEach(group => {
           group.checked = false;
       });
       var textareas = document.querySelectorAll('textarea');
       textareas.forEach(textarea => {
           textarea.value = "";
       });
   }
   
   function submitComplainOffer() {

       var postReportRadio = postReportOptions.querySelectorAll('.reasonRadio:checked');
      var authorReportRadio = authorReportOptions.querySelectorAll('.reasonRadio:checked');

      // 기타 라디오 버튼 체크 및 입력 확인
       var otherReasonTextarea = document.getElementById('otherReasonText');
       var otherReason2Textarea = document.getElementById('otherReasonText2');
       var isPostReportChecked = postReportRadio.length > 0 && postReportRadio[0].value === '8';
       var isAuthorReportChecked = authorReportRadio.length > 0 && authorReportRadio[0].value === '8';
       var isPostReasonTextareaEmpty = isPostReportChecked && otherReasonTextarea.value.trim() === '';
       var isAuthorReasonTextareaEmpty = isAuthorReportChecked && otherReason2Textarea.value.trim() === '';

       if ((isPostReportChecked && isPostReasonTextareaEmpty) || (isAuthorReportChecked && isAuthorReasonTextareaEmpty)) {
           alert('기타 이유를 알려주세요');
           event.preventDefault();
           return closeComplainModal();
       } else if (postReportRadio.length === 0 && authorReportRadio.length === 0) {
           alert('신고 사유를 선택해주세요');
           event.preventDefault();
           return closeComplainModal();
       } else {
           event.preventDefault();
           var result = confirm('신고 접수를 하시겠습니까?');

           if (result === true) {
               // 확인을 클릭한 경우에만 제출
               document.getElementById('ComplainForm').submit();
           } else {
               // 취소를 눌렀을 때의 동작
               alert('신고 접수가 취소되었습니다');
               return closeComplainModal();
           }
       }
   }
   </script>
   <!-- 신고창 종료 -->


   <!-- 상세페이지 오른쪽 ... 버튼 시작-->
   <script>
   // ... 버튼 클릭 시 드롭다운을 열거나 닫기
   document.addEventListener("DOMContentLoaded", function() {
      var buttons = document.querySelectorAll('.update-content-button');
         buttons.forEach(function(button) {
            button.addEventListener('click', function(event) {
               var dropdown = this.nextElementSibling;
                  if (dropdown.style.display === 'block') {
                  dropdown.style.display = 'none';
               } else {
                  dropdown.style.display = 'block';
               }
            
            // 이벤트 전파 방지
            event.stopPropagation();
         });
      });
      
           // 다른 곳을 클릭하면 모든 드롭다운 닫기
      document.addEventListener('click', function(event) {
         buttons.forEach(function(button) {
            var dropdown = button.nextElementSibling;
            if (event.target !== button) {
               dropdown.style.display = 'none';
            }
         });
      });
   });
   </script>
   <!-- 상세페이지 오른쪽 ... 버튼 종료 -->

   <!-- 삭제하기 시작 -->
   <script>
         function confirmDelete() {
            // 'confirm' 창을 표시하고 사용자가 확인을 누르면 true를 반환
            const shouldDelete = confirm('글을 삭제하시겠습니까?');
            // 현재 URL 주소창을 통해 전달 된 정보 저장
            const urlParams = new URLSearchParams(location.search);
            // URL 주소창에서 원하는 값 저장
            const bno = urlParams.get("bno");

            const newURL = "./DeleteProduct.com?bno=" + bno;

         if (shouldDelete) {
            location.href = newURL;
         } else {
        	 alert('글 삭제를 취소하였습니다.');
        	 location.reload();
         }
      }
   </script>
   <!-- 삭제하기 종료 -->

   <!-- 프로필 모달창 시작 -->
   <script>
   var pfModal = document.getElementById('profileModal');
   // 모달 열기 함수
   function openProfileModal() {
      pfModal.style.display = 'block';
       window.addEventListener('click', outsideClick1);

   }

   // 모달 외부 클릭 시 닫기 함수
     function outsideClick1(e) {
       if (e.target === pfModal) {
         pfModal.style.display = 'none';
         // 모달 외부 클릭 이벤트 제거
         window.removeEventListener('click', outsideClick1);
       }
     }
   // 모달 닫기 함수
   function closeProfileModal() {
      pfModal.style.display = 'none';
       window.removeEventListener('click', outsideClick1);

   }
   </script>
   <!-- 프로필 모달창 종료 -->

   <!-- 판매 제안 모달창 시작 -->
   <script>
    var modal = document.getElementById('sellModal');
    var login_id = '<%= session.getAttribute("user_id") %>';

    function requireLogin() {
        if (login_id === "null") {
            alert("해당 기능은 로그인이 필요합니다");
            window.location.href = "../main/login.member";
        } else {
            openProductModal();
        }
    }

    // 판매 제안 모달 열기
    function openProductModal() {
        modal.style.display = "block";
       window.addEventListener('click', outsideClick2);

    }
    
    // 판매 제안 모달 닫기
    function closeProductModal() {
       modal.style.display = 'none';
       window.removeEventListener('click', outsideClick2);

    }

 // 모달 외부 클릭 시 닫기 함수
     function outsideClick2(e) {
       if (e.target === modal) {
          modal.style.display = 'none';
         // 모달 외부 클릭 이벤트 제거
         window.removeEventListener('click', outsideClick2);
       }
     }

    // 판매 제안 클릭
    function submitProductOffer() {
        var checkboxes = document.querySelectorAll('.productCheckbox:checked');

        if (checkboxes.length === 0) {
            alert("판매할 물품을 선택해주세요");
        } else {
            var productIds = [];
            var price = Number("${dto.price}");
            var fPrice = price.toLocaleString();

            var result = confirm('해당 상품을 ' + fPrice + '원에 판매 제안하시겠습니까?');

            if (result === true) {
                document.getElementById("SuggestSellForm").submit();
            } else {
                closeProductModal(); // 모달을 닫도록 호출
            }
        }
    }
   </script>
   <!-- 판매 제안 모달창 종료 -->

   <!-- 거래 제안 현황 모달창 시작 -->
      <script>
         var spModal = document.getElementById('suggestProductModal');
         // 모달 열기 함수
         function openSuggestModal() {
            spModal.style.display = 'block';
           window.addEventListener('click', outsideClick3);
         }

         // 모달 닫기 함수
         function closeSuggestModal() {
            spModal.style.display = 'none';
           window.removeEventListener('click', outsideClick3);
         }

      // 모달 외부 클릭 시 닫기 함수
        function outsideClick3(e) {
          if (e.target === spModal) {
             spModal.style.display = 'none';
            // 모달 외부 클릭 이벤트 제거
            window.removeEventListener('click', outsideClick3);
          }
        }

        function submitSuggest() {
            var checkboxes = document.querySelectorAll('.yourCheckboxClass:checked');

            if (checkboxes.length === 0) {
                alert("구매할 상품을 선택해주세요");
            } else {
                var result = confirm('선택한 상품을 구매하시겠습니까?');

                if (result === true) {
                    document.getElementById("SubmitSuggestForm").submit();
                } else {
                    alert('구매를 취소하셨습니다');
                }
            }
        }
      </script>
      <!-- 거래 제안 현황 모달창 종료 -->
      
      <!-- 판매 제안 현황 모달창 시작 -->
      <script>
         var slModal = document.getElementById('suggestListModal');
         // 모달 열기 함수
         function openSuggestListModal() {
            slModal.style.display = 'block';
           window.addEventListener('click', outsideClick4);

         }

         // 모달 닫기 함수
         function closeSuggestListModal() {
            slModal.style.display = 'none';
           window.removeEventListener('click', outsideClick4);

         }

      // 모달 외부 클릭 시 닫기 함수
        function outsideClick4(e) {
          if (e.target === slModal) {
             slModal.style.display = 'none';
            // 모달 외부 클릭 이벤트 제거
            window.removeEventListener('click', outsideClick4);
          }
        }

        function cancleSuggest() {
            var checkboxes = document.querySelectorAll('.yourCheckboxClass:checked');

            if (checkboxes.length === 0) {
                alert("취소할 제안을 선택해주세요");
            } else {
                var result = confirm('선택한 제안을 취소하시겠습니까?');

                if (result === true) {
                    document.getElementById("cancleSuggestForm").submit();
                } else {
                    alert('제안을 유지합니다');
                }
            }
        }
      </script>
      <!-- 판매 제안 현황 모달창 종료 -->
      
       <%@ include file="../main/footer.jsp"%>
</body>
</html>