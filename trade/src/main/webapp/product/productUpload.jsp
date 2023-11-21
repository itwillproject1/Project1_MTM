<%@page import="java.util.Collection"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap">
<link href="../css/productUpload.css" rel="stylesheet" />

<title>글쓰기</title>
</head>
<body>
	<%@ include file="../main/header.jsp"%>
	<div class="container">
		<div class="image-container">
			<h2>이미지 미리보기</h2>
			<img id="imagePreview" alt="미리보기">
		</div>

		<div class="form-container">
			<h2>글쓰기</h2>
			<form action="./ProductUploadAction.com" method="post" name="fr1" enctype="multipart/form-data" onsubmit="return check();">
				<div class="form-group">
					<label for="dealWay">거래 방식:</label>
					<select id="deal_way" name="deal_way" onchange="updateSecondDropdown2()">
						<option disabled selected value="default">원하는 거래를 선택하세요</option>
						<option value="삽니다">삽니다</option>
						<option value="팝니다">팝니다</option>
					</select>
				</div>

				<div class="form-group">
					<label for="productCategory">카테고리:</label>
						<select id="productCategory" name="productCategory" onchange="updateDropdown()">
							<option disabled selected value="default">카테고리를 선택하세요</option>
							<option value="0">휴대폰&amp;태블릿</option>
							<option value="1">데스크탑</option>
							<option value="2">노트북</option>
							<option value="3">게임기기</option>
							<option value="4">가전제품</option>
							<option value="5">카메라</option>
							<option value="6">음향기기</option>
							<option value="7">기타</option>
						</select>
				</div>

				<div class="form-group">
					<label for="productBrand">브랜드:</label>
					<select id="brand" name="brand">
						<option disabled selected value="default">브랜드를 선택하세요</option>
					</select>
				</div>

				<!-- 첫번째 드롭다운 항목에 따라 두번째 드롭다운 항목이 바뀌는 코드 -->
				<script>
					function updateDropdown() {
						var selectedCategory = document.getElementById('productCategory').value;
						var brandDropdown = document.getElementById('brand');
						console.log(selectedCategory);
						brandDropdown.innerHTML = ''; // 두 번째 드롭다운 비우기
						

						if (selectedCategory === '0') {
							// 휴대폰&태블릿를 선택한 경우
							brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
							brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
							brandDropdown.innerHTML += '<option value="삼성">삼성</option>';
							brandDropdown.innerHTML += '<option value="애플">애플</option>';
							brandDropdown.innerHTML += '<option value="기타">기타 브랜드</option>';
						} else if (selectedCategory === '1') {
							// 데스크탑 선택한 경우
							brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
							brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
							brandDropdown.innerHTML += '<option value="삼성">삼성</option>';
							brandDropdown.innerHTML += '<option value="엘지">엘지</option>';
							brandDropdown.innerHTML += '<option value="애플">애플</option>';
							brandDropdown.innerHTML += '<option value="hp">hp</option>';
							brandDropdown.innerHTML += '<option value="기타">기타 브랜드</option>';
						} else if (selectedCategory === '2') {
							// 노트북 선택한 경우
							brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
							brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
							brandDropdown.innerHTML += '<option value="삼성">삼성</option>';
							brandDropdown.innerHTML += '<option value="엘지">엘지</option>';
							brandDropdown.innerHTML += '<option value="애플">애플</option>';
							brandDropdown.innerHTML += '<option value="hp">hp</option>';
							brandDropdown.innerHTML += '<option value="레노버">레노버</option>';
							brandDropdown.innerHTML += '<option value="기타">기타 브랜드</option>';
						} else if (selectedCategory === '3') {
							// 게임기기를 선택한 경우
							brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
							brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
							brandDropdown.innerHTML += '<option value="플레이스테이션">플레이스테이션</option>';
							brandDropdown.innerHTML += '<option value="닌텐도">닌텐도</option>';
							brandDropdown.innerHTML += '<option value="기타">기타 브랜드</option>';
						} else if (selectedCategory === '4') {
							// 가전제품을 선택한 경우
							brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
							brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
							brandDropdown.innerHTML += '<option value="삼성">삼성</option>';
							brandDropdown.innerHTML += '<option value="엘지">엘지</option>';
							brandDropdown.innerHTML += '<option value="기타">기타 브랜드</option>';
						} else if (selectedCategory === '5') {
							// 카메라를 선택한 경우
							brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
							brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
							brandDropdown.innerHTML += '<option value="캐논">캐논</option>';
							brandDropdown.innerHTML += '<option value="니콘">니콘</option>';
							brandDropdown.innerHTML += '<option value="소니">소니</option>';
							brandDropdown.innerHTML += '<option value="라이카">라이카</option>';
							brandDropdown.innerHTML += '<option value="코닥">코닥</option>';
							brandDropdown.innerHTML += '<option value="기타">기타 브랜드</option>';
						} else if (selectedCategory === '6') {
							// 음향기기를 선택한 경우
							brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
							brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
							brandDropdown.innerHTML += '<option value="소니">소니</option>';
							brandDropdown.innerHTML += '<option value="보스">보스</option>';
							brandDropdown.innerHTML += '<option value="마샬">마샬</option>';
							brandDropdown.innerHTML += '<option value="기타">기타 브랜드</option>';
						} else if (selectedCategory === '7') {
							//기타를 선택한 경우
							brandDropdown.disabled = true; // 두 번째 드롭다운 비활성화
							brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
							brandDropdown.selectedIndex = 0;
						}
					}
				</script>

				<div class="form-group">
					<label for="productCondition">상품 상태:</label>
					<select id="product_status" name="product_status">
						<option disabled selected value="default">상품 상태를 선택하세요</option>
					</select>
				</div>

				<!-- 거래방식 항목에 따라 상품상태 항목이 바뀌는 코드 -->
				<script>
					function updateSecondDropdown2() {
						var selectedDeal_way = document.getElementById('deal_way').value;
						var product_statusDropdown = document.getElementById('product_status');
						product_statusDropdown.innerHTML = ''; // 두 번째 드롭다운 목록 비우기

						if (selectedDeal_way === '팝니다') {
							// 팝니다를 선택한 경우
							product_statusDropdown.disabled = false; // 두 번째 드롭다운 활성화
							product_statusDropdown.innerHTML += '<option disabled selected>상품 상태를 선택하세요</option>';
							product_statusDropdown.innerHTML += '<option value="미개봉">미개봉</option>';
							product_statusDropdown.innerHTML += '<option value="상">상</option>';
							product_statusDropdown.innerHTML += '<option value="중">중</option>';
							product_statusDropdown.innerHTML += '<option value="하">하</option>';
						} else if (selectedDeal_way === '삽니다') {
							//삽니다를 선택한 경우
							product_statusDropdown.disabled = true; // 두 번째 드롭다운 비활성화
							product_statusDropdown.innerHTML += '<option disabled selected>상품 상태를 선택하세요</option>';
							product_statusDropdown.selectedIndex = 0;
						}
					}
				</script>

				<div class="form-group">
					<label for="productPrice">가격(원):</label> <input type="number"
						id="price" name="price" step="10" placeholder="배송비 포함 금액을 입력하세요">
				</div>

				<div class="form-group">
					<label for="productImage">상품 이미지:</label>
					<div id="uploadFile">
					<c:forEach var="i" begin="1" end="5" step="1">
						<!-- 파일 선택 시 previewImage() 함수 호출 -->
						<input type="file" id="file${i }" name="file${i }"
							accept="image/*" onchange="previewImage(${i })">
					</c:forEach>
					</div>
				</div>


				<c:set var="file_name" value="${fileNames }" scope="request" />

				<div class="form-group">
					<label for="productName">제목:</label>
					<input type="text" id="title" name="title">
				</div>

				<div class="form-group">
					<label for="productDescription">상품 설명:</label>
					<textarea id="content" name="content" rows="4"></textarea>
				</div>

				<button type="submit" class="submit-button">상품 등록</button>
			</form>
		</div>
	</div>

	<script>
		<!-- 이미지 미리보기 관련 스크립트 -->
		function previewImage(index) {
			var fileInput = document.getElementById("file" + index);
			var imagePreview = document.getElementById("imagePreview");

			if (fileInput && fileInput.files && fileInput.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					imagePreview.src = e.target.result;
				};
				reader.readAsDataURL(fileInput.files[0]);
			} else {
				// 파일이 선택되지 않았을 때의 처리 (미리보기 이미지 제거)
				imagePreview.src = "";
			}
		}
		
		<!-- 글 유효성 검사 -->
		function check() {
			var deal_way = document.fr1.deal_way.value;
			var productCategory = document.fr1.productCategory.value;
			var brand = document.fr1.brand.value;
			var product_status = document.fr1.product_status.value;
			var price = document.fr1.price.value;
			var title = document.fr1.title.value;
			var content = document.fr1.content.value;
			
			if(deal_way == "default") {
				alert('거래 방식을 선택하세요.');
				document.fr1.deal_way.focus();
				return false;
			}
			
			if(productCategory == "default") {
				alert('카테고리를 선택하세요.');
				document.fr1.productCategory.focus();
				return false;
			}
			
			if(productCategory == "기타" && brand == "default") {
				alert('브랜드를 선택하세요.');
				document.fr1.productCategory.focus();
				return false;
			}
			
			if(deal_way == "팝니다" && product_status == "default") {
				alert('상품 상태를 선택하세요.');
				document.fr1.product_status.focus();
				return false;
			}

			if(price == "") {
				alert('가격을 입력하세요.');
				document.fr1.price.focus();
				return false;
			}

			if(title == "") {
				alert('제목을 입력하세요.');
				document.fr1.title.focus();
				return false;
			}
			
			if(content == "") {
				alert('상품 설명을 입력하세요.');
				document.fr1.content.focus();
				return false;
			}
		}
	</script>
	 <%@ include file="../main/footer.jsp"%>
</body>
</html>