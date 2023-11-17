<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<jsp:include page="../inn/head/writer.jsp" />
<script type="text/javascript">
	$(function() {
		$('#board-btn').click(function() {
			var con = $('.ql-editor').html();
			var bno = <%= request.getParameter("bno")%>;
			$('#content').attr('value', con);
			$(".card-body").attr({
				"method" : "post",
				"action" : "./BoardUpdateAction.emp?bno=" + bno,
				"enctype" : "multipart/form-data"
			}).submit();
		});
	});
</script>
<title>게시글 수정</title>
</head>
<jsp:include page="../inn/navbar.jsp" />
<main role="main" class="main-content">
	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-12">
				<h2 class="h3 mb-3 page-title">게시판 수정</h2>
				<div class="row mb-4">
					<div class="col-md-12">
						<div class="card shadow">
							<form class="card-body">
								<div class="form-group mb-3">
									<label for="emp_id"><h5 class="card-title">작성자</h5></label> <input
										type="text" id="emp_id" value="${emp_id}" class="form-control"
										readonly value="Readonly value">
								</div>
								<div class="form-group mb-3">
									<label for="subject"><h5 class="card-title">제목</h5></label> <input
										type="text" name="subject" value="${dto.subject}" id="subject"
										class="form-control" placeholder="제목">
								</div>
								<h5 class="card-title">내용</h5>
								<!-- Create the editor container -->
								<div id="editor" style="min-height: 100px;">${dto.content}</div>
								<input type="hidden" name="content" id="content"> <br>
								<div class="form-group mb-3">
									<label for="fileinput"><h5 class="card-title">이미지
											파일</h5></label> <input type="file" name="image" value="${dto.image}"
										id="fileinput" class="form-control-file">
								</div>
								<div class="form-group mb-3">
									<label for="emp_pw"><h5 class="card-title">비밀번호</h5></label> <input
										type="password" name="emp_pw" id="emp_pw" class="form-control"
										placeholder>
								</div>
								<button type="button" id="board-btn" class="btn btn-primary">입력</button>
								<button type="button" class="btn btn-secondary"
									onclick="history.back();">취소</button>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- end section -->
		</div>
		<!-- .col-12 -->
	</div>
	<!-- .row -->
	</div>
	<!-- .container-fluid -->
</main>
<!-- main -->
</div>
<jsp:include page="../inn/writer.jsp" />
</body>
</html>