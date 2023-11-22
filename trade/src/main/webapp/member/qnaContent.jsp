<%@page import="java.util.Collection"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap">
<link href="../css/header.css" rel="stylesheet" />
<link href="../css/qnaContent.css" rel="stylesheet" />
<title>MTM | 1:1 문의</title>
<link rel="icon" href="../main/img/16px.ico" type="image/x-icon">
</head>
<body>
	<%@ include file="../main/header.jsp"%>
	<div class="container">
		<div class="form-container">
			<h2>1:1 문의 내역</h2>
				<c:if test="${idto.user_id ne sessionScope.user_id}">
					<script>
						alert('문의글 작성자가 아닙니다.');
						location.href='../member/MemberInfo.member';
					</script>
				</c:if>
				
				<c:if test="${idto.user_id eq sessionScope.user_id}">
				<div class="form-group">
					<label for="qnaCategory">카테고리</label> ${idto.category }
				</div>
	
				<div class="form-group">
					<label for="subject">제목</label> ${idto.subject }
				</div>
	
				<div class="form-group">
					<label for="content">문의 내용</label>
					${idto.content }
				</div>
	
				<div class="form-group">
				<h2>답변</h2>
				<c:if test="${!idto.complete }">
					등록된 답변이 없습니다.
				</c:if>
				
				<c:if test="${idto.complete }">
					<div class="form-group">
						<label for="emp_id">관리자 아이디</label>
						${idto.emp_id }
					</div>
					<div class="form-group">
						<label for="content">답변 내용</label>
						${idto.answerContent }
					</div>
					
				</c:if>
				</div>
			</c:if>
			<div class="center-btn">
				<button class="submit-button" onclick="history.back();">돌아가기</button>
			</div>
		</div>
	</div>
 <%@ include file="../main/footer.jsp"%>
</body>
</html>