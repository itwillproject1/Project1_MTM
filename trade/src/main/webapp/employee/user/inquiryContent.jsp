<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../inn/head/main.jsp" />
<jsp:include page="../inn/navbar.jsp" />
<main role="main" class="main-content">
	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-12">
				<div class="row align-items-center">
					<div class="col">
						<h2 class="h5 page-title">
							<small class="text-muted text-uppercase">문의</small><br>${idto.bno}</h2>
					</div>
					<div class="col-auto">
						<button type="button" class="btn btn-secondary"
							onclick="location.href='./InquiryList.emp'">리스트로</button>
					</div>
				</div>
				<!-- .row -->
				<div class="row my-4">
					<div class="col-md-12">
						<div class="card shadow mb-4">
							<div class="card-header">
								<strong class="card-title">${idto.subject}</strong> <span
									class="float-right"><span
									class="badge badge-pill badge-success text-white">${idto.category}</span></span>
							</div>
							<div class="card-body">
								<dl class="row align-items-center mb-0">
									<dt class="col-sm-2 mb-3 text-muted">질문자</dt>
									<dd class="col-sm-4 mb-3">
										<strong>${idto.user_id}</strong>
									</dd>
									<dt class="col-sm-2 mb-3 text-muted">답변 상태</dt>
									<dd class="col-sm-4 mb-3">
										<c:if test="${idto.complete}">
											<span class="dot dot-md bg-success mr-2"></span> 완료
                        				</c:if>
										<c:if test="${!idto.complete}">
											<span class="dot dot-md bg-secondary mr-2"></span> 미완료
                        				</c:if>
									</dd>
								</dl>
								<c:if test="${idto.complete}">
									<dl class="row mb-0">
										<dt class="col-sm-2 mb-3 text-muted">답변자</dt>
										<dd class="col-sm-4 mb-3">
											<strong>${idto.emp_id}</strong>
										</dd>
										<dt class="col-sm-2 mb-3 text-muted">문의 일자</dt>
										<dd class="col-sm-4 mb-3">${idto.uploadDate}</dd>
										<dt class="col-sm-2 mb-3 text-muted">답변일자</dt>
										<dd class="col-sm-4 mb-3">${idto.answerDate}</dd>
									</dl>
								</c:if>
							</div>
							<!-- .card-body -->
						</div>
						<!-- .card -->
						<div class="card shadow mb-4">
							<div class="card-body">
								<div class="row align-items-center mb-4">
									<div class="col-auto">
										<div class="avatar avatar-sm mb-3 mx-4">
											<c:if test="${udto.profile == ''}">
												<img src="./employee/template/assets/images/user.png"
													alt="..." class="avatar-img rounded-circle">
											</c:if>
											<c:if test="${udto.profile != ''}">
												<img
													src="<%=request.getRealPath("upload") %>/${udto.profile}"
													onerror="this.onerror=null; this.src='./employee/template/assets/images/user.png';"
													alt="..." class="avatar-img rounded-circle">
											</c:if>
										</div>
									</div>
									<div class="col">
										<strong>${idto.user_id}</strong>
										<div class="mb-2">${idto.content}</div>
										<c:if test="${idto.image == null}"></c:if>
										<c:if test="${idto.image != null}">
											<div class="card mb-3 bg-light w-50">
												<div class="row no-gutters align-items-center">
													<div class="col-md-2 text-center">
														<img
															src="<%=request.getRealPath("upload") %>/${idto.image}"
															alt="..." class="img-fluid rounded m-1">
													</div>
													<div class="col-md-10">
														<div class="card-body py-0">
															<p class="card-title mb-0">${idto.image}</p>
														</div>
													</div>
												</div>
											</div>
										</c:if>
										<small class="text-muted">${dto.uploadDate}</small>
									</div>
								</div>
								<!-- .row-->
								<c:if test="${!idto.complete}"></c:if>
								<c:if test="${idto.complete}">
									<div class="row align-items-center mb-4">
										<div class="col-auto">
											<div class="avatar avatar-sm mb-3 mx-4">
												<img src="./employee/template/assets/images/user.png"
													alt="..." class="avatar-img rounded-circle">
											</div>
										</div>
										<div class="col">
											<strong>${idto.emp_id}</strong>
											<div class="mb-2">${idto.answerContent}</div>
											<small class="text-muted">${idto.answerDate}</small>
										</div>
									</div>
									<!-- .row-->
								</c:if>
								<hr class="my-4">
								<c:if test="${!idto.complete}">
									<h6 class="mb-3">답변</h6>
								</c:if>
								<c:if test="${idto.complete}">
									<h6 class="mb-3">수정</h6>
								</c:if>
								<form action="./InquiryAction.emp?bno=${idto.bno}" method="post">
									<div class="form-group">
										<label for="answerContent" class="sr-only">답변</label>
										<textarea class="form-control bg-light" name="answerContent"
											id="answerContent" rows="2"></textarea>
									</div>
									<div class="d-flex justify-content-between align-items-center">
										<button type="submit" class="btn btn-primary">입력</button>
									</div>
								</form>
							</div>
							<!-- .card-body -->
						</div>
						<!-- .card -->
					</div>
					<!-- .col-md -->
				</div>
			</div>
		</div>
		<!-- .col-12 -->
	</div>
	<!-- .row -->
</main>
</div>
<!-- .wrapper -->
<jsp:include page="../inn/footer.jsp" />