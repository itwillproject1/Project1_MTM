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
<link href="../css/header.css" rel="stylesheet" />
<link href="../css/qna.css" rel="stylesheet" />

<title>1:1 문의</title>
</head>
<body>
	<%@ include file="../main/header.jsp"%>
	<div class="container">
		<div class="form-container">
			<h2>문의글 작성</h2>
			<form action="../member/QnaAction.member" method="post" name="fr1" enctype="multipart/form-data" onsubmit="return check();">
				<div class="form-group">
					<label for="qnaCategory">카테고리:</label>
						<select id="qnaCategory" name="qnaCategory">
							<option disabled selected value="default">카테고리를 선택하세요</option>
							<option value="계정 문의">계정문의</option>
							<option value="구매 문의">구매문의</option>
							<option value="판매 문의">판매문의</option>
							<option value="기타">기타</option>
						</select>
				</div>
				
				<div class="form-group">
					<label for="subject">제목:</label>
					<input type="text" name="subject">
				</div>

				<div class="form-group">
					<label for="content">문의 내용:</label>
					<textarea rows="30" cols="50" name="content"></textarea>
				</div>

				<div class="form-group">
					<label for="productImage">문의 관련 이미지:</label>
					<div id="uploadFile">
						<input type="file" id="image" name="image" accept="image/*">
					</div>
				</div>
				
				<div class="center-btn">
					<button type="submit" class="submit-button">문의글 등록</button>
				</div>
			</form>
		</div>
	</div>

	<script>		
		<!-- 글 유효성 검사 -->
		function check() {
			var qnaCategory = document.fr1.qnaCategory.value;
			var subject = document.fr1.subject.value;
			var content = document.fr1.content.value;
			
			if(qnaCategory == "default") {
				alert('문의 카테고리를 선택하세요.');
				document.fr1.qnaCategory.focus();
				return false;
			}

			if(subject == "") {
				alert('제목을 입력하세요.');
				document.fr1.subject.focus();
				return false;
			}

			if(content == "") {
				alert('내용을 입력하세요.');
				document.fr1.content.focus();
				return false;
			}
		}
	</script>
	
</body>
</html>