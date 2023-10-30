<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap">
<link href="../css/header.css" rel="stylesheet" />
<link href="../css/productUpload.css" rel="stylesheet" />
<style>

</style>

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
			<form action="./ProductUploadAction.com" method="post">

				<div class="form-group">
					<label for="dealWay">거래 방식:</label> <select id="deal_way"
						name="deal_way" onchange="updateSecondDropdown2()">
						<option disabled selected>원하는 거래를 선택하세요</option>
						<option value="buy">삽니다</option>
						<option value="sell">팝니다</option>
					</select>
				</div>

				<div class="form-group">
					<label for="productCategory">카테고리:</label> <select id="category"
						name="category" onchange="updateSecondDropdown()">
						<option disabled selected>카테고리를 선택하세요</option>
						<option value="mobile">휴대폰&태블릿</option>
						<option value="desktop">데스크탑</option>
						<option value="notebook">노트북</option>
						<option value="game">게임 기기</option>
						<option value="appliances">가전제품</option>
						<option value="camera">카메라</option>
						<option value="audio">음향 기기</option>
						<option value="etc">기타</option>
					</select>
				</div>

				<div class="form-group">
					<label for="productBrand">브랜드:</label> <select id="brand"
						name="brand">
						<option disabled selected>브랜드를 선택하세요</option>
					</select>
				</div>

				<!-- 첫번째 드롭다운 항목에 따라 두번째 드롭다운 항목이 바뀌는 코드 -->
				<script>
					function updateSecondDropdown() {
						var selectedCategory = document
								.getElementById('category').value;
						var brandDropdown = document.getElementById('brand');
						brandDropdown.innerHTML = ''; // 두 번째 드롭다운 목록 비우기

						if (selectedCategory === 'mobile') {
							// 휴대폰&태블릿를 선택한 경우
							brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
							brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
							brandDropdown.innerHTML += '<option value="samsung">삼성</option>';
							brandDropdown.innerHTML += '<option value="apple">애플</option>';
							brandDropdown.innerHTML += '<option value="etc">기타 브랜드</option>';
						} else if (selectedCategory === 'desktop') {
							// 데스크탑 선택한 경우
							brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
							brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
							brandDropdown.innerHTML += '<option value="samsung">삼성</option>';
							brandDropdown.innerHTML += '<option value="lg">엘지</option>';
							brandDropdown.innerHTML += '<option value="apple">애플</option>';
							brandDropdown.innerHTML += '<option value="hp">hp</option>';
							brandDropdown.innerHTML += '<option value="etc">기타 브랜드</option>';
						} else if (selectedCategory === 'notebook') {
							// 노트북 선택한 경우
							brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
							brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
							brandDropdown.innerHTML += '<option value="samsung">삼성</option>';
							brandDropdown.innerHTML += '<option value="lg">엘지</option>';
							brandDropdown.innerHTML += '<option value="apple">애플</option>';
							brandDropdown.innerHTML += '<option value="hp">hp</option>';
							brandDropdown.innerHTML += '<option value="lenovo">레노버</option>';
							brandDropdown.innerHTML += '<option value="etc">기타 브랜드</option>';
						} else if (selectedCategory === 'game') {
							// 게임 기기를 선택한 경우
							brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
							brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
							brandDropdown.innerHTML += '<option value="playStaion">플레이스테이션</option>';
							brandDropdown.innerHTML += '<option value="nintendo">닌텐도</option>';
							brandDropdown.innerHTML += '<option value="etc">기타 브랜드</option>';
						} else if (selectedCategory === 'appliances') {
							// 가전제품을 선택한 경우
							brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
							brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
							brandDropdown.innerHTML += '<option value="samsung">삼성</option>';
							brandDropdown.innerHTML += '<option value="lg">엘지</option>';
							brandDropdown.innerHTML += '<option value="etc">기타 브랜드</option>';
						} else if (selectedCategory === 'camera') {
							// 카메라를 선택한 경우
							brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
							brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
							brandDropdown.innerHTML += '<option value="canon">캐논</option>';
							brandDropdown.innerHTML += '<option value="nikon">니콘</option>';
							brandDropdown.innerHTML += '<option value="sony">소니</option>';
							brandDropdown.innerHTML += '<option value="leica">라이카</option>';
							brandDropdown.innerHTML += '<option value="kodak">코닥</option>';
							brandDropdown.innerHTML += '<option value="etc">기타 브랜드</option>';
						} else if (selectedCategory === 'audio') {
							// 음향 기기를 선택한 경우
							brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
							brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
							brandDropdown.innerHTML += '<option value="sony">소니</option>';
							brandDropdown.innerHTML += '<option value="bose">보스</option>';
							brandDropdown.innerHTML += '<option value="marshall">마샬</option>';
							brandDropdown.innerHTML += '<option value="etc">기타 브랜드</option>';
						} else if (selectedCategory === 'etc') {
							//기타를 선택한 경우
							brandDropdown.disabled = true; // 두 번째 드롭다운 비활성화
							brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
							brandDropdown.selectedIndex = 0;
						}
					}
				</script>

				<div class="form-group">
					<label for="productCondition">상품 상태:</label> <select
						id="product_status" name="product_status">
						<option disabled selected>상품 상태를 선택하세요</option>
					</select>
				</div>

				<!-- 거래방식 항목에 따라 상품상태 항목이 바뀌는 코드 -->
				<script>
					function updateSecondDropdown2() {
						var selectedDeal_way = document
								.getElementById('deal_way').value;
						var product_statusDropdown = document
								.getElementById('product_status');
						product_statusDropdown.innerHTML = ''; // 두 번째 드롭다운 목록 비우기

						if (selectedDeal_way === 'sell') {
							// 팝니다를 선택한 경우
							product_statusDropdown.disabled = false; // 두 번째 드롭다운 활성화
							product_statusDropdown.innerHTML += '<option disabled selected>상품 상태를 선택하세요</option>';
							product_statusDropdown.innerHTML += '<option value="unopened">미개봉</option>';
							product_statusDropdown.innerHTML += '<option value="upper">상</option>';
							product_statusDropdown.innerHTML += '<option value="middle">중</option>';
							product_statusDropdown.innerHTML += '<option value="lower">하</option>';
						} else if (selectedDeal_way === 'buy') {
							//삽니다를 선택한 경우
							product_statusDropdown.disabled = true; // 두 번째 드롭다운 비활성화
							product_statusDropdown.innerHTML += '<option disabled selected>상품 상태를 선택하세요</option>';
							product_statusDropdown.selectedIndex = 0;
						}
					}
				</script>

				<div class="form-group">
					<label for="productPrice">가격(원):</label> <input type="number"
						id="price" name="price" step="10">
				</div>

				<div class="form-group">
					<label for="productImage">상품 이미지:</label>
					<!-- 파일 선택 시 previewImage() 함수 호출 -->
					<input type="file" id="file_name" name="file_name"
						accept="image/*" multiple onchange="previewImage()">
					<script>
						document.getElementById('file_name').addEventListener(
								'change', handleFileSelect);

						function handleFileSelect(event) {
							var files = event.target.files;

							for (var i = 0; i < files.length; i++) {
								var file = files[i];
								console.log('Selected file:', file);
							}
						}
					</script>
				</div>

				<div class="form-group">
					<label for="productName">제목:</label> <input type="text" id="title"
						name="title" required>
				</div>

				<div class="form-group">
					<label for="productDescription">상품 설명:</label>
					<textarea id="content" name="content" rows="4" required></textarea>
				</div>

				<button type="submit" class="submit-button">상품 등록</button>
			</form>
		</div>
	</div>

	<!-- 이미지 미리보기 관련 스크립트 -->
	<script>
		function previewImage() {
			var preview = document.getElementById('imagePreview');
			var fileInput = document.getElementById('file_name');
			var file = fileInput.files[0];

			if (file) {
				var reader = new FileReader();

				reader.onload = function(e) {
					preview.src = e.target.result;
				};

				reader.readAsDataURL(file);
			}
		}
	</script>

</body>
</html>