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
<link href="../css/header.css" rel="stylesheet" />
<link href="../css/productContent.css" rel="stylesheet" />
<link href="../css/productPopup.css" rel="stylesheet" />
<title>상세페이지</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {	
	// 좋아요 버튼 클릭 시 실행되는 ajax
	 $(document).on('click', '#like', function(){
			// 현재 URL에서 bno 값 추출
		    var urlParams = new URLSearchParams(window.location.search);
		    var bno = urlParams.get('bno');
	    
	        $.ajax({
	            url: "./LikeCheck.com",
	            type: 'POST',
	            data: {bno: bno},
	            success: function(response) {
	            	var result = response.split('\n')[0].trim();
	                var like_count = response.split('\n')[1].trim();
	                console.log("데이터 변환됨: " + result);
	                console.log("like_count: " + like_count);
	                
	                $("#like_count").text(like_count);
	                console.log($("#like_count").text());
	                
	                if (result === "1") {
	                    $("#do_like").text("♥");
	                } else if (result === "0") {
	                    $("#do_like").text("♡");
	                } else {
	                    $("#do_like").text("오류! 리턴값 -1");
					}
				}
			});
	});
	
});

	function payment(bno){
		var url = "../pay/payment.com?bno=" + bno;	
		var payment = window.open(url,"payment","width=570,height=450, scrollbars=yes, resizable=yes"); 
	}

</script>
</head>
<body>

   <%@ include file="../main/header.jsp"%>

   <div class="container">
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
                  id="imagePreview" alt="미리보기">
            </div>

            <div class="image-preview-choice">
               <c:forEach var="file_name" items="${fileNameArr}">
                  <img src="<%=request.getContextPath() %>/upload/${file_name}"
                     id="imagePreviewChoice" class="clickable-image" alt="미리보기">
               </c:forEach>
            </div>
         </div>

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
         <!-- 이미지 영역 종료 -->



         <div class="form-container">
            <h2>
               상세 페이지
               <%-- 여기부터 나중에 삭제하면 됨(지금 삭제하면 로그인 안하면 버튼 안 뜸)
               <input class="complain-button" type="button" value="🚨" onclick="openComplainModal();">
                  <div class="dropdown">
                     <input class="update-content-button" type="button" value="..." >
                     
                     <div class="dropdown-content">
                        <button onclick="location.href='./ProductUpdate.com?bno=${dto.bno}';">글 수정하기</button>
                        <button onclick="confirmDelete();">글 삭제하기</button>
                     </div>
                  </div>
               여기까지 나중에 삭제하면 됨(지금 삭제하면 로그인 안하면 버튼 안 뜸) --%>

               <c:choose>
                  <c:when test="${empty sessionScope.user_id}">
                     <!-- 세션에 사용자 ID가 없을 때 -->
                  </c:when>
                  <c:otherwise>
                     <c:choose>
                        <c:when test="${sessionScope.user_id eq dto.user_id}">
                           <!-- 로그인한 사용자 == 글 작성자 -->
                           <div class="dropdown">
                              <input class="update-content-button" type="button" value="...">
                              <div class="dropdown-content" style="display: none;">
                                 <button
                                    onclick="location.href='./updateContent.com?bno=${dto.bno}';">글 수정하기</button>
                                 <button onclick="confirmDelete();">글 삭제하기</button>
                              </div>
                           </div>
                        </c:when>
                        <c:when test="${sessionScope.user_id ne dto.user_id}">
                           <!-- 로그인한 사용자 != 글 작성자 -->
                           <input class="complain-button" type="button" value="🚨"
                              onclick="openComplainModal();">
                        </c:when>
                     </c:choose>
                  </c:otherwise>
               </c:choose>

            </h2>
            <div class="form-group">
               <label for="user">작성자:<button class="profile-button" onclick="openProfileModal();">${dto.user_id }</button></label>
            </div>
           <div id="profileModal" class="modal">
             <div class="modal-content">
                 <!-- 모달 내용 -->                
               <h2><img src="" alt="프로필"> ${dto.user_id} (평점) <span class="close-button" onclick="closeProfileModal();">&times;</span></h2>
                 
                 <h3 id="h3">${dto.user_id}님의 판매 상품 목록</h3>
               <c:forEach var="userProduct" items="${userProducts }" varStatus="loopStatus">
                   <c:if test="${userProduct.deal_way == '팝니다'}">
                       <c:if test="${!loopStatus.first}">
                           <hr>
                       </c:if>
                       <div id="productList" onclick="location.href='./ProductContent.com?bno=${userProduct.bno}';">
                           <div><img src="<%=request.getContextPath() %>/upload/${fileNameArr[0]}" alt="미리보기" width="60px" height="60px"></div>
                           <span id="sellDiv">
                               <span>상품명: ${userProduct.title}<br></span>
                               <span>가격: <fmt:formatNumber value="${userProduct.price}"/>원</span>
                           </span>
                       </div>
                   </c:if>
               </c:forEach>
         
                 <h3 id="h3">${dto.user_id}님의 구매 상품 목록</h3>
                 <c:forEach var="userProduct" items="${userProducts}" >
                   <c:if test="${userProduct.deal_way == '삽니다'}">
                       <div id="productList" onclick="location.href='./ProductContent.com?bno=${userProduct.bno}';">
                           <div><img src="<%=request.getContextPath() %>/upload/${fileNameArr[0]}" alt="미리보기" width="60px" height="60px"></div>
                           <span id="sellDiv">
                               <span>상품명: ${userProduct.title}<br></span>
                               <span>가격: <fmt:formatNumber value="${userProduct.price}"/>원<hr></span>
                           </span>
                       </div>
                   </c:if>
               </c:forEach>
         
                 <c:if test="${empty userProducts}">
                     <p id="noSell">등록 상품이 없습니다.</p>
                 </c:if>
            </div>
            </div>

            <div class="form-group">
               <label for="user">조회수: ${dto.views }</label>
            </div>

            <div class="form-group">
               <label for="productCategory">카테고리: <a
                  href="../product/ProductList.com?category=${dto.category }">${dto.category }</a></label>
            </div>

            <div class="form-group">
               <label for="productBrand">브랜드: <a
                  href="../product/ProductList.com?category=${dto.brand }">${dto.brand }</a></label>
            </div>

            <c:if test="${dto.deal_way.equals('팝니다') }">
               <div class="form-group">
                  <label for="productCondition">상품 상태: ${dto.product_status }</label>
               </div>
            </c:if>

            <div class="form-group">
               <label for="productPrice">가격(원): <fmt:formatNumber
                     value="${dto.price}" /></label>
            </div>

            <c:if test="${dto.deal_way.equals('팝니다') }">
               <div class="button-container">
                  <input class="submit-button" type="button" value="구매하기" onclick="payment(${dto.bno});">

                  <!-- 찜 기능 시작 -->
                  <button class="submit-button" id="like">
	                  <span id="do_like">
		                  <c:if test="${likeResult eq 0 }">
		                  	♡
		                  </c:if>
		                  <c:if test="${likeResult eq 1 }">
		                  	♥
		                  </c:if>    
	                  </span>
	                  <span id="like_count">
	                  ${dto.like_count}
	                  </span>
                  </button>
                  <%-- <input class="submit-button" type="button"
                     value="♡${dto.like_count }" onclick="찜하거나 찜취소, db도 연결돼야함"> --%>
                  <!--  찜 기능 끝 -->

               </div>
            </c:if>

<c:if test="${dto.deal_way.equals('삽니다')}">
    <c:choose>
        <c:when test="${empty sessionScope.user_id}">
            <button class="submit-button" onclick="requireLogin();">판매 제안</button>
        </c:when>
        <c:when test="${sessionScope.id eq dto.user_id}">
            <button class="submit-button" onclick="openSuggestModal();">거래 제안 현황</button>
        </c:when>
        <c:otherwise>
            <button class="submit-button" onclick="openProductModal();">판매 제안</button>
        </c:otherwise>
    </c:choose>
</c:if>

<!-- 판매하기 모달 -->
<div id="sellModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeProductModal()">&times;</span>
        <div id="productInfo">
            <!-- 상품 정보 -->

			<c:if test="${!empty sellProduct}">
                 <h2>${sessionScope.id }님의 판매 상품 목록</h2>
                 <form id="SuggestSellForm" action="./SuggestSell.com?bno=${dto.bno }" method="post">
            <c:forEach var="sellProduct" items="${sellProduct}">
             <div>
                        <input type="checkbox" id="sellCheckbox" class="productCheckbox" name="sellProductBno"
                           value="${sellProduct.bno }">
                           <%-- <img
                           id="sellImage"
                           src="<%=request.getContextPath()%>/upload/${sellProd uct.file_name }"
                           alt="미리보기"> --%>
                     </div>
                     <div>
                        <span id="sellDiv"> <span>상품명: ${sellProduct.title }<br></span>
                           <span>상품상태: ${sellProduct.product_status }<br></span>
                           <span>가격: <span id="priceSpan"><fmt:formatNumber
                                 value="${sellProduct.price }" />원 </span>
                                 
                                  <span id="priceSpan2"><fmt:formatNumber
                                 value="${dto.price}" />원 </span>
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
            <c:if test="${empty sessionScope.user_id}">
                <p id="noSell">로그인이 필요합니다. <a href="../main/login.member">로그인</a></p>
            </c:if>
			<button class="submit-button" onclick="submitProductOffer();">판매 제안</button>
        </div>
    </div>
</div>

<!-- 판매 제안 -->
<script>
var modal = document.getElementById('sellModal');


    function requireLogin() {
        alert("로그인을 해주세요");
        window.location.href = "../main/login.member";
    }
    
    // 판매 제안 모달 열기
    function openProductModal() {
    	 modal.style.display = "block";
    }

     // 모달 닫기
    function closeProductModal() {
    	modal.style.display = "none";
    }

    // 모달 외부 영역을 클릭하면 모달이 닫히도록 설정
    window.onclick = function(event) {
        if (event.target == modal) {
        	modal.style.display = "none";
        }
    }
    
    //판매 제안 클릭
   /* function submitProductOffer() {
    var checkboxes = document.querySelectorAll('.productCheckbox:checked');

    if (checkboxes.length === 0) {
        alert("판매할 물품을 선택해주세요");
    } else {
        var productIds = [];

        var result = confirm('해당 상품을 ${dto.price}원에 판매 제안하시겠습니까?');

        if (result === true) {
            document.getElementById("SuggestSellForm").submit();
        } else {
            closeProductModal(); // 모달을 닫도록 호출
        }
    }
} */




</script>
<!-- 판매 제안 -->

<!-- 거래 제안 현황 모달 시작-->
<div id="suggestProductModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeSuggestModal()">&times;</span>
        <div id="productInfo" style="max-height: 400px; overflow-y: auto; overflow-x: hidden;">
            <!-- 상품 정보 -->
            <c:if test="${!empty suggestList }">
            <form action="결제페이지" method="post" id="SubmitSuggestForm">
	               <!-- 거래 제안 들어온 상품 목록 가져오기 -->
	               <c:forEach var="spdto" items="${spdto }" >
	                  <div>
	                        <input type="radio" id="sellCheckbox" class="productCheckbox" name="sell_bno"
	                           value="${ssdto.sell_bno }">
	                           <img
	                           id="sellImage"
	                           src="<%=request.getContextPath()%>/upload/${spdto.file_name }"
	                           alt="미리보기">
	                     </div>
	                     <div>
	                        <span id="sellDiv"> <span>상품명: ${spdto.title}<br></span>
	                           <span>상품상태: ${spdto.product_status}<br></span>
	                           <span>가격: <span id="priceSpan"><fmt:formatNumber
	                                 value="${spdto.price}" />원 </span>
	                                 
	                                  <span id="priceSpan2"><fmt:formatNumber
	                                 value="${dto.price}" />원 </span>
	                        </span>
	                        </span>
	                     <hr id="hr1">
	                     </div>      
	               </c:forEach>
	         <button class="submit-button" onclick="submitSuggest();">거래 하기</button>
            </form>
	        </c:if>
	            <c:if test="${empty suggestList }">
	               <p id="noSell">거래 제안 상품이 없습니다.</p>
	         </c:if>
        </div>
    </div>
</div>
<!-- 거래 제안 현황 모달 종료-->
	</div>
   </div>
      <div class="form-group">
         <label for="productDescription">상품 설명: </label> ${dto.content }
      </div>

   <!-- 신고하기 모달창 -->
   <form action="" method="post">
      <div id="complainModal" class="modal">
         <div class="modal-content">
            <input type="checkbox" id="postReportCheckbox"
               class="productCheckbox" data-productid="1"> <label
               for="postReportCheckbox">게시글 신고</label><br>
            <div id="postReportOptions" style="display: none;">
               <input type="checkbox" class="reasonCheckbox" id="postReason1">
               <label for="postReason1">불법 상품 또는 서비스 판매</label><br> <input
                  type="checkbox" class="reasonCheckbox" id="postReason2"> <label
                  for="postReason2">불쾌한, 혐오스러운 내용이나 이미지 포함</label><br> <input
                  type="checkbox" class="reasonCheckbox" id="postReason3"> <label
                  for="postReason3">거짓 정보, 거짓 광고, 또는 과장된 설명</label><br> <input
                  type="checkbox" class="reasonCheckbox" id="postReason4"> <label
                  for="postReason4">저작권 침해 (타인의 이미지 또는 콘텐츠 무단 사용)</label><br> <input
                  type="checkbox" class="reasonCheckbox" id="postReason5"> <label
                  for="postReason5">사기성 게시글 (실제로 판매되지 않는 상품)</label><br> <input
                  type="checkbox" class="reasonCheckbox" id="postReason6"> <label
                  for="postReason6">개인 정보 침해 (타인의 개인 정보 공개)</label><br> <input
                  type="checkbox" class="reasonCheckbox" id="postReason7"> <label
                  for="postReason7">광고 스팸 또는 중복 게시글</label><br> <input
                  type="checkbox" class="reasonCheckbox" id="postReason8"
                  onchange="showTextarea()"> <label for="postReason8">기타</label><br>
               <div id="otherReason" style="display: none;">
                  <textarea id="otherReasonText" placeholder="기타 이유를 입력하세요"></textarea>
               </div>
            </div>
            <input type="checkbox" id="authorReportCheckbox"
               class="productCheckbox" data-productid="2"> <label
               for="authorReportCheckbox">작성자 신고</label><br>
            <div id="authorReportOptions" style="display: none;">
               <input type="checkbox" class="reasonCheckbox" id="authorReason1">
               <label for="authorReason1">거래 사기 또는 부정행위 (상품 송금 후 발송하지 않음)</label><br>
               <input type="checkbox" class="reasonCheckbox" id="authorReason2">
               <label for="authorReason2">거래 후 불만 및 환불 요청 무시</label><br> <input
                  type="checkbox" class="reasonCheckbox" id="authorReason3">
               <label for="authorReason3">불쾌한 언행 또는 협상 방해</label><br> <input
                  type="checkbox" class="reasonCheckbox" id="authorReason4">
               <label for="authorReason4">거짓 프로필 정보 또는 사진 사용</label><br> <input
                  type="checkbox" class="reasonCheckbox" id="authorReason5">
               <label for="authorReason5">반복적인 불법 행동 (여러 사용자를 속임)</label><br>
               <input type="checkbox" class="reasonCheckbox" id="authorReason6">
               <label for="authorReason6">규정 위반 (중고거래 플랫폼의 규정을 어기는 행동)</label><br>
               <input type="checkbox" class="reasonCheckbox" id="authorReason7">
               <label for="authorReason7">욕설, 혐오 내용 또는 괴롭힘</label><br> <input
                  type="checkbox" class="reasonCheckbox" id="authorReason8"
                  onchange="showTextarea()"> <label for="authorReason8">기타</label><br>
               <div id="otherReason2" style="display: none;">
                  <textarea id="otherReasonText2" placeholder="기타 이유를 입력하세요"></textarea>
               </div>
            </div>
            <button class="close-button" onclick="closeComplainModal()">닫기</button>
            <button class="confirm-button" onclick="submitComplainOffer()">신고하기</button>
         </div>
      </div>
   </form>
   <!-- 신고하기 모달창 종료-->
   
   <script>
    var complainModal = document.getElementById("complainModal");
    var postReportCheckbox = document.getElementById("postReportCheckbox");
    var postReportOptions = document.getElementById("postReportOptions");
    var authorReportCheckbox = document.getElementById("authorReportCheckbox");
    var authorReportOptions = document.getElementById("authorReportOptions");

    function openComplainModal() {
       // 체크박스가 하나도 선택되지 않은 경우에만 경고 메시지 표시
        
        complainModal.style.display = "block";
      }
    
    // 모달 닫기
    function closeComplainModal() {
       modal.style.display = "none";
    }
    
    // 모달 닫기
    function closeProductModal() {
        modal.style.display = "none";
    }

    // 모달 외부 영역을 클릭하면 모달이 닫히도록 설정
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

    postReportCheckbox.addEventListener("change", function() {
        postReportOptions.style.display = this.checked ? 'block' : 'none';
        authorReportCheckbox.disabled = this.checked;
    });

    authorReportCheckbox.addEventListener("change", function() {
        authorReportOptions.style.display = this.checked ? 'block' : 'none';
        postReportCheckbox.disabled = this.checked;
    });
    
    function showTextarea() {
        var postCheckbox = document.getElementById("postReason8");
         var authorCheckbox = document.getElementById("authorReason8");
         var postTextarea = document.getElementById("otherReason");
         var authorTextarea = document.getElementById("otherReason2");

         if (postCheckbox.checked) {
             postTextarea.style.display = "block";
         } else {
             postTextarea.style.display = "none";
         }

         if (authorCheckbox.checked) {
             authorTextarea.style.display = "block";
         } else {
             authorTextarea.style.display = "none";
         }
     }
    
    
        
        function submitComplainOffer() {
           var postReportCheckboxes = postReportOptions.querySelectorAll('.reasonCheckbox:checked');
            var authorReportCheckboxes = authorReportOptions.querySelectorAll('.reasonCheckbox:checked');

            if (postReportCheckboxes.length === 0 && authorReportCheckboxes.length === 0 &&
                (!postReportCheckbox.checked || !authorReportCheckbox.checked)) {
                alert("신고 사유를 선택해주세요");
            } else {
                var productIds = [];

                // 선택된 체크박스를 관리자에게 전달하는 코드 추가해야함!!!!!!!!!!!!
                window.location.href = "관리자에게전달.com";
                
            }
        }
    </script>
    


   <!-- 상세페이지 오른쪽 ... 버튼 -->
   <script>
    // ... 버튼 클릭 시 드롭다운을 열거나 닫기
    document.addEventListener("DOMContentLoaded", function() {
        var buttons = document.querySelectorAll('.update-content-button');
        buttons.forEach(function(button) {
            button.addEventListener('click', function (event) {
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
        document.addEventListener('click', function (event) {
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

   <!-- 삭제하기  -->
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
     }
   
     // 모달 닫기 함수
     function closeProfileModal() {
        pfModal.style.display = 'none';
     }
       
     // 모달 외부 영역을 클릭하면 모달이 닫히도록 설정
     window.onclick = function(event) {
         if (event.target == pfModal) {
            pfModal.style.display = "none";
         }
     }
   </script>
   <!-- 프로필 모달창 종료 -->
   
   <!-- 제안 현황 모달창 시작 -->
   <script>
      var spModal = document.getElementById('suggestProductModal');
     // 모달 열기 함수
     function openSuggestModal() {
        spModal.style.display = 'block';
     }
   
     // 모달 닫기 함수
     function closeSuggestModal() {
        spModal.style.display = 'none';
     }
       
     // 모달 외부 영역을 클릭하면 모달이 닫히도록 설정
     window.onclick = function(event) {
         if (event.target == spModal) {
            spModal.style.display = "none";
         }
     }
     
     function submitSuggest() {
    	 var result = confirm('해당 상품을 구매하시겠습니까?');

         if (result === true) {
             document.getElementById("SubmitSuggestForm").submit();
         } else {
        	alert('거래를 취소하셨습니다');
        	closeSuggestModal();
        	/* 자꾸 submit됨..... */
         }
     }
   </script>
   <!-- 제안 현황 모달창 종료 -->
</body>
</html>