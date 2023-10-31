<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<%
		String filename = request.getParameter("fileName");
		String savePath = "upload";
		String realPath = request.getContextPath() + "/" + savePath;
	%>
	<div class="container">

		<div class="form-group h1">
			<label for="productName">[${dto.deal_way }]${dto.title }</label>
		</div>
		<div class="form-group2">
			<div class="image-container">
				<img src="<%=request.getContextPath() %>/upload/${dto.file_name }"
					id="imagePreview" alt="미리보기">
			</div>
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
				<c:if test="${dto.deal_way.equals('buy')}">
					<button class="submit-button" onclick="openProductModal();">판매하기</button>
>>>>>>> 80f3ba7432c370cab42793b440752af1a22d3359
				</c:if>

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

				<c:if test="${dto.deal_way.equals('sell')}">
					<input class="submit-button" type="button" value="구매하기"
						onclick="openProductPopup();">
				</c:if>

			</div>
		</div>
		<div class="form-group">
			<label for="productDescription">상품 설명: </label> ${dto.content }
		</div>
	</div>

</body>
</html>