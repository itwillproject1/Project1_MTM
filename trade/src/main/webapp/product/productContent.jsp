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
</head>
<body>

	<%@ include file="../main/header.jsp"%>
	<%-- <%
		String filename = request.getParameter("fileName");
		String savePath = "upload";
		String realPath = request.getContextPath() + "/" + savePath;
	%> --%>
	<div class="container">
		<div class="form-group h1">
			<label for="productName">[${dto.deal_way }]${dto.title }</label>
		</div>

		<%-- 		<c:set var="fileNameArr" value="${fn:split(dto.file_name,',') }" /> --%>
		<!-- 		<div class="form-group2"> -->
		<!-- 			<div class="image-container"> -->
		<!-- 				<img src="" -->
		<!-- 					id="imagePreview" alt="미리보기"> -->
		<%-- 				<c:forEach var="file_name" items="${fileNameArr }"> --%>
		<%-- 					<img src="<%=request.getContextPath() %>/upload/${file_name}" --%>
		<!-- 						id="imagePreviewChoice" alt="미리보기"> -->
		<%-- 				</c:forEach> --%>
		<!-- 			</div> -->

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



		<div class="form-container">
			<h2>상세 페이지</h2>
			<div class="form-group">
				<label for="user"><a href="작성자프로필">작성자: ${dto.user_id }</a></label>
			</div>

			<div class="form-group">
				<label for="user">조회수: ${dto.views }</label>
			</div>

			<div class="form-group">
				<label for="productCategory">카테고리: <a href="카테고리 검색결과">${dto.category }</a></label>
			</div>

			<div class="form-group">
				<label for="productBrand">브랜드: <a href="브랜드 검색결과">${dto.brand }</a></label>
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
				<input class="submit-button" type="button" value="구매하기"
					onclick="location.href='결제페이지';">
					<input class="submit-button" type="button" value="찜하기"
					onclick="찜하기">
			</div>
			</c:if>
			<c:if test="${dto.deal_way.equals('삽니다') }">
				<button class="submit-button" onclick="openProductModal();">판매하기</button>
			</c:if>
			<%
String user_id = request.getParameter("user_id"); // 사용자 아이디 값 설정
ProductDAO dao = new ProductDAO();
ProductDTO dto = dao.ProductInfo(user_id); // ProductInfo는 상품 정보를 가져오는 메서드

if (dto != null) {
%>

			<script>
    var modal;

    function openProductModal() {
        var modalContent = `
            <div class="modal" id="productModal">
                <div class="modal-content">
                    <!-- 모달 내에 체크박스와 제품 정보 설정 -->
                    <input type="checkbox" id="checkBox" class="productCheckbox" data-productid="1" style="width: 30px; height: 30px;">
                    <!-- 제품 정보 -->
                    <img src="<%=request.getContextPath() %>/upload/${dto.file_name}" id="imagePreview" alt="미리보기" width="60px" height="60px">
                    상품명: <label for="productName">${dto.title}</label>
                    가격: <label for="productPrice"><fmt:formatNumber value="${dto.price}"/>원</label>
                    <span class="close-button" onclick="closeProductModal();">닫기</span>
                    <button class="confirm-button" onclick="confirmProduct();">확인</button>
                </div>
            </div>
        `;

        // 모달 열기
        document.body.insertAdjacentHTML('beforeend', modalContent);
        modal = document.getElementById('productModal');
        modal.style.display = 'block';
    }

    function closeProductModal() {
        if (modal) {
            modal.style.display = 'none'; // 모달 닫기
        }
    }

    function confirmProduct() {
        var checkBox = document.getElementById('checkBox');
        if (checkBox.checked) { // 체크박스가 체크된 경우만 정보전달
            // 정보전달 코드를 추가해야 합니다.
            alert('제안 완료!');
            closeProductModal(); // 모달 창 닫기
        } else {
            alert('제안할 물품을 선택하세요.');
        }
    }
</script>
			<script>
			    var modal; // 모달을 저장할 변수
			
			    function openProductModal() {
			        var modalContent = `
			            <div class="modal" id="productModal">
			                <div class="modal-content">
			                    <!-- 모달 내에 체크박스와 제품 정보 설정 -->
			                    <input type="checkbox" id="checkBox" class="productCheckbox" data-productid="1" style="width: 30px; height: 30px;">
			                    <!-- 제품 정보 -->
			                    <img src="<%=request.getContextPath() %>/upload/${dto.file_name}" id="imagePreview" alt="미리보기" width="60px" height="60px">
			                    상품명: <label for="productName">${dto.title}</label>
			                    가격: <label for="productPrice"><fmt:formatNumber value="${dto.price}"/>원</label>
			                     <span class="close-button" onclick="closeProductModal();">닫기</span>
			                     <button class="confirm-button" onclick="confirmProduct();">확인</button>
			                </div>
			            </div>
			        `;
			
			        // 모달 열기
			        document.body.insertAdjacentHTML('beforeend', modalContent);
			        modal = document.getElementById('productModal');
			        modal.style.display = 'block';
			    }
			
			    function closeProductModal() {
			        if (modal) {
			            modal.style.display = 'none'; // 모달 닫기
			        }
			    }
			    
			    function confirmProduct() {
			        var checkBox = document.getElementById('checkBox');
			        if (checkBox.checked) { // 체크박스가 체크된 경우만 정보전달
			            // 정보전달 코드짜야함!!!!!!!!!!
			            alert('제안 완료!');
			            closeProductModal(); // 모달 창 닫기
			        } else {
			            alert('제안할 물품을 선택하세요.');
			        }
			    }
			</script>

			<%
			}
			// else {
			//     response.sendRedirect("login.com"); // 로그인 페이지로 이동
			// }
			%>
		</div>
	</div>
	<div class="form-group">
		<label for="productDescription">상품 설명: </label> ${dto.content }
	</div>
	</div>

</body>
</html>