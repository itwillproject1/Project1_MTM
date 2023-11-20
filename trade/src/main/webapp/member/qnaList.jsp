<%@page import="java.util.Collection"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap">
<link href="../css/header.css" rel="stylesheet" />
<link href="../css/qnaList.css" rel="stylesheet" />

<title>문의내역</title>
</head>
<body>
	<%@ include file="../main/header.jsp"%>
	<div class="container">
		<div class="form-group">
			<label for="productName">
			<h1>
				${sessionScope.user_id }님의 문의내역
				<button class="submit-button" onclick="location.href='../member/MemberInfo.member';">마이페이지</button>
			</h1>
			</label>
		</div>
		<!-- 본문 내용 시작 -->
		<div class="form-group2">
			<table>
				<tr class="tr1">
					<th class="t1">번호</th>
					<th class="t2">제목</th>
					<th class="t3">작성일</th>
					<th class="t4">답변상태</th>
				</tr>
				<c:forEach var="qnaList" items="${qnaList }">
					<tr class="tr1">
						<td class="t1">${qnaList.bno}</td>
						<td class="t2"><a href="../member/QnaContent.member?bno=${qnaList.bno}" }>${qnaList.subject }</a></td>
						<td class="t3"> <fmt:formatDate pattern="yyyy-MM-dd" value="${qnaList.uploadDate}" /> </td>
						<td class="t4">
							<c:if test="${qnaList.complete }">
								답변완료
							</c:if>
							<c:if test="${!qnaList.complete }">
								답변 대기중
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

 <%@ include file="../main/footer.jsp"%>
</body>
</html>