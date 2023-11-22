<%@page import="com.itwillbs.product.db.ProductDTO"%>
<%@page import="java.util.Collection"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap">
<link href="../css/header.css" rel="stylesheet" />
<link href="../css/productUpdate.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
/* $(document).ready(function() {
	$('#load-img').click(function() {
		$('#deletebtn${i}').html('추가하기');
	});
} */
</script>
<title>글쓰기</title>
</head>

<!-- 첫번째 드롭다운 항목에 따라 두번째 드롭다운 항목이 바뀌는 코드 -->
<script>
	var selectedBrand = '<%=((ProductDTO) request.getAttribute("pdto")).getBrand()%>';
	var br1 = ["삼성", "애플", "기타"];
	var br2 = ["삼성", "엘지", "애플", "hp", "기타"];
	var br3 = ["삼성", "엘지", "애플", "hp", "레노버", "기타"];
	var br4 = ["플레이스테이션", "닌텐도", "기타"];
	var br5 = ["삼성", "엘지", "기타"];
	var br6 = ["캐논", "니콘", "소니", "라이카", "코닥", "기타"];
	var br7 = ["소니", "보스", "마샬", "기타"];
	
	function updateSecondDropdown() {
	    var selectedCategory = document.getElementById('productCategory').value;
	    var brandDropdown = document.getElementById('brand');
	    
	    brandDropdown.innerHTML = ''; // 두 번째 드롭다운 목록 비우기
	    brandDropdown.disabled = true; // 두 번째 드롭다운 비활성화
	
	    if (selectedCategory === '0') {
	        brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
	        brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
	        for (var i = 0; i < br1.length; i++) {
	            var option = document.createElement('option');
	            option.value = br1[i];
	            option.text = br1[i];
	            if (br1[i] === selectedBrand) {
	                option.setAttribute('selected', 'selected');
	            }
	            brandDropdown.appendChild(option);
	        }
	    } else if (selectedCategory === '1') {
			// 데스크탑 선택한 경우
			brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
			brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
			for (var i = 0; i < br2.length; i++) {
				var option = document.createElement('option');
					 option.value = br2[i];
					 option.text = br2[i];
	            // 특정 조건을 만족하는 경우 selected 속성 추가
	            if (br2[i] === selectedBrand) {
	            	option.setAttribute('selected', 'selected');
	            }
	            brandDropdown.appendChild(option);
	        }
		} else if (selectedCategory === '2') {
			// 노트북 선택한 경우
			brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
			brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
			for (var i = 0; i < br3.length; i++) {
				var option = document.createElement('option');
					 option.value = br3[i];
					 option.text = br3[i];
	            // 특정 조건을 만족하는 경우 selected 속성 추가
	            if (br3[i] === selectedBrand) {
	            	option.setAttribute('selected', 'selected');
	            }
	            brandDropdown.appendChild(option);
	        }
		} else if (selectedCategory === '3') {
			// 게임기기를 선택한 경우
			brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
			brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
			for (var i = 0; i < br4.length; i++) {
				var option = document.createElement('option');
					 option.value = br4[i];
					 option.text = br4[i];
	            // 특정 조건을 만족하는 경우 selected 속성 추가
	            if (br4[i] === selectedBrand) {
	            	option.setAttribute('selected', 'selected');
	            }
	            brandDropdown.appendChild(option);
	        }
		} else if (selectedCategory === '4') {
			// 가전제품을 선택한 경우
			brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
			brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
			for (var i = 0; i < br5.length; i++) {
				var option = document.createElement('option');
					 option.value = br5[i];
					 option.text = br5[i];
	            // 특정 조건을 만족하는 경우 selected 속성 추가
	            if (br5[i] === selectedBrand) {
	            	option.setAttribute('selected', 'selected');
	            }
	            brandDropdown.appendChild(option);
	        }
		} else if (selectedCategory === '5') {
			// 카메라를 선택한 경우
			brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
			brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
			for (var i = 0; i < br6.length; i++) {
				var option = document.createElement('option');
					 option.value = br6[i];
					 option.text = br6[i];
	            // 특정 조건을 만족하는 경우 selected 속성 추가
	            if (br6[i] === selectedBrand) {
	            	option.setAttribute('selected', 'selected');
	            }
	            brandDropdown.appendChild(option);
	        }
		} else if (selectedCategory === '6') {
			// 음향기기를 선택한 경우
			brandDropdown.disabled = false; // 두 번째 드롭다운 활성화
			brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
			for (var i = 0; i < br7.length; i++) {
				var option = document.createElement('option');
					 option.value = br7[i];
					 option.text = br7[i];
	            // 특정 조건을 만족하는 경우 selected 속성 추가
	            if (br7[i] === selectedBrand) {
	            	option.setAttribute('selected', 'selected');
	            }
	            brandDropdown.appendChild(option);
	        }
		} else if (selectedCategory === '7') {
			//기타를 선택한 경우
			brandDropdown.disabled = true; // 두 번째 드롭다운 비활성화
			brandDropdown.innerHTML += '<option disabled selected>브랜드를 선택하세요</option>';
			brandDropdown.selectedIndex = 0;
		}
	}

<!-- 거래방식 항목에 따라 상품상태 항목이 바뀌는 코드 -->

	var status = '<%=((ProductDTO) request.getAttribute("pdto")).getProduct_status()%>';
	var stt = ["미개봉", "상", "중", "하"]
	
	function updateSecondDropdown2() {
		var selectedDeal_way = document
				.getElementById('deal_way').value;
		var product_statusDropdown = document
				.getElementById('product_status');
		product_statusDropdown.innerHTML = ''; // 두 번째 드롭다운 목록 비우기
		if (selectedDeal_way === '팝니다') {
			// 팝니다를 선택한 경우
			product_statusDropdown.disabled = false; // 두 번째 드롭다운 활성화
			product_statusDropdown.innerHTML += '<option disabled selected>상품 상태를 선택하세요</option>';
			for(var i = 0; i<stt.length; i++) {
				var option = document.createElement('option');
				option.value = stt[i];
				option.text = stt[i];
	           	// 특정 조건을 만족하는 경우 selected 속성 추가
	           	if (stt[i] === status) {
	           		option.setAttribute('selected', 'selected');
	           	}
          		product_statusDropdown.appendChild(option);
			}
		} else if (selectedDeal_way === '삽니다') {
			//삽니다를 선택한 경우
			product_statusDropdown.disabled = true; // 두 번째 드롭다운 비활성화
			product_statusDropdown.innerHTML += '<option disabled selected>상품 상태를 선택하세요</option>';
			product_statusDropdown.selectedIndex = 0;
		}
	}
	
	function loadDropdown() {
	    updateSecondDropdown();
	    updateSecondDropdown2();
	}
	onload = loadDropdown;
</script>

<body>
	<%@ include file="../main/header.jsp"%>
	<div class="container">
		<!-- 미리보기 영역 시작 -->
			<c:set var="fileNameArr" value="${fn:split(pdto.file_name, ',')}" />
				<div class="image-container">
					<h2>이미지 미리보기</h2>
					<div class="image-preview">
						<img src="<%=request.getContextPath() %>/upload/${fileNameArr[0]}"
							id="imagePreview" alt="미리보기">
					</div>
				</div>
		<!-- 미리보기 영역 종료 -->

		<div class="form-container">
			<h2>글 수정하기</h2>
			<form action="./ProductUpdateProAction.com?bno=${pdto.bno}" name="fr1" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="dealWay">거래 방식:</label> <select id="deal_way"
						name="deal_way" onchange="updateSecondDropdown2()">
						<option disabled selected>원하는 거래를 선택하세요</option>
						<option value="삽니다" <c:if test="${pdto.deal_way.equals('삽니다')}">selected</c:if>>삽니다</option>
						<option value="팝니다" <c:if test="${pdto.deal_way.equals('팝니다')}">selected</c:if>>팝니다</option>
					</select>
				</div>
				
				<div class="form-group">
					<label for="productCategory">카테고리:</label> 
					<select id="productCategory" name="productCategory" onchange="updateSecondDropdown()" >
						<option disabled selected>카테고리를 선택하세요</option>
						<c:forEach var="cgValue" items="${cg }" >
							<option value="${cgValue}" <c:if test="${pdto.category eq cgValue}">selected</c:if>>${cgValue}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<label for="productBrand">브랜드:</label>
					<select id="brand" name="brand">
						<option disabled selected>브랜드를 선택하세요</option>
					</select>
				</div>

				<div class="form-group">
					<label for="productCondition">상품 상태:</label>
					<select id="product_status" name="product_status">
						<option disabled selected>상품 상태를 선택하세요</option>
					</select>
				</div>

				<div class="form-group">
					<label for="productPrice">가격(원):</label>
					<input type="number" id="price" name="price" value="${pdto.price }" step="500">
				</div>
				
				<div class="form-group">
					<label for="productImage">상품 이미지:</label>
					<div id="uploadFile">
						<div>
							<c:forEach var="i" begin="1" end="5" step="1">
							<div id="load-img">
								<input type="hidden" name="before_file_name" value="${pdto.file_name }">
								<%-- 글자 클릭 시 showImagePreview() 함수 호출 --%>
								<input type="text" id="fni${i}" name="file_name${i }" value="${fileNameArr[i-1]}"
									onclick="showImagePreview(${i})" class="fntext" readonly>
								
								<!-- 수정하기 또는 추가하기 버튼 클릭 시 아래 input 태그 나타남 -->
								<c:if test="${fileNameArr[i-1] != null}">
									<button type="button" class="updateImg" onclick="showFileInput(${i })" id="fbtn${i }">수정</button>
								</c:if>
								<c:if test="${fileNameArr[i-1] == null}">
									<button type="button" class="updateImg" onclick="showFileInput(${i })"id="fbtn${i }">추가</button>
								</c:if>

								<button type="button" class="updateImg" onclick="deleteImage(${i })" id="deletebtn${i}">삭제</button>
								
							</div>
							
								<!-- 파일 선택 시 previewImage() 함수 호출 -->
								<input type="file" id="file${i }" name="file${i }"
								accept="image/*" onchange="previewImage(${i })" style="display: none;">
								<br>
							</c:forEach>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="productName">제목:</label> <input type="text" id="title"
						name="title" value="${pdto.title }" required>
				</div>

				<div class="form-group">
					<label for="productDescription">상품 설명:</label>
					<textarea id="content" name="content" rows="4" required>${pdto.content }</textarea>
				</div>

				<button type="submit" class="submit-button">상품 수정</button>
			</form>
		</div>
	</div>

	<script>
		<!-- 이미지 미리보기 관련 스크립트 -->
		function previewImage(i) {
			const fileNameE = document.getElementById('fni' + i);
	        const fileName = fileNameE.value;
	        var fileInput = document.getElementById("file" + i);
			var imagePreview = document.getElementById("imagePreview");

			if (fileInput && fileInput.files && fileInput.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					imagePreview.src = e.target.result;
				};
				reader.readAsDataURL(fileInput.files[0]);
			} else {
		        // 이미지의 src를 해당 파일의 경로로 설정
		        imagePreview.src = "<%= request.getContextPath() %>/upload/" + fileName;
			}
		}
		
		function showImagePreview(i) {
		    var imagePreview = document.getElementById("imagePreview");
			var fileNameE = document.getElementById("fni"+i);
			var fileName = fileNameE.value;
		    console.log(fileName);

		    // 이미지의 src를 해당 파일의 경로로 설정
		    imagePreview.src = "<%= request.getContextPath() %>/upload/" + fileName;
		  }
		
		<!-- 수정하기 누르면 파일 인풋태그 나타나게 -->
		function showFileInput(i) {
			  const fileInput = document.getElementById('file' + i);
			  const fniInput = document.getElementById('fni' + i);
			  
			  // 인풋태그 나타내기
			  fileInput.style.display = fileInput.style.display === 'none' ? 'block' : 'none';
			  
			  // 파일 입력하면 해당 파일명으로 변경
			  fileInput.addEventListener('change', function () {
		            const selectedFile = fileInput.files[0];
		            fniInput.value = selectedFile ? selectedFile.name : '';
		        });
		}
		
		<!-- 파일 삭제 -->
		function deleteImage(i, action) {
			const fniInput = document.getElementById('fni' + i);
	        const fileInput = document.getElementById('file' + i);
	        const imagePreview = document.getElementById('imagePreview');

	        // 파일 입력 초기화
	        fileInput.value = "";
	        fileInput.dispatchEvent(new Event('change'));

	        // 파일명 초기화
	        fniInput.value = "";

	        // 이미지 미리보기 감추기
	        imagePreview.src = "";
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
		
	</script>

</body>
</html>