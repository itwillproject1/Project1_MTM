<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../inn/head/databaseList.jsp" />
<title>메일 전송 이력</title>
<c:if test="${empty emp_id}">
	<c:redirect url="./Login.emp" />
</c:if>

<%
String search = request.getParameter("search");
String searchKeyword = request.getParameter("searchKeyword");
String link = "./EmployeeMailList.emp?";
link += search == null || searchKeyword == null || search.equals("선택") ? ""
		: "search=" + search + "&searchKeyword=" + searchKeyword + "&";
%>

<jsp:include page="../inn/navbar.jsp" />
<main role="main" class="main-content" data-select2-id="9">
	<div class="container-fluid" data-select2-id="8">
		<div class="row justify-content-center" data-select2-id="7">
			<div class="col-12" data-select2-id="6">
				<h2 class="h3 mb-3 page-title">메일 전송 이력</h2>
				<div class="row mb-4 items-align-center">
					<div class="col-md-auto ml-auto text-right">
						<button type="button" class="btn" data-toggle="modal"
							data-target=".modal-slide">
							<span class="fe fe-filter fe-16 text-muted"></span>
						</button>
						<button type="button" class="btn" onclick="./MailList.emp">
							<span class="fe fe-refresh-ccw fe-16 text-muted"></span>
						</button>
						<button type="button" class="btn mb-2 btn-primary"
							onclick="location.href='./EmployeeMailSend.emp'">생성</button>
					</div>
				</div>
				<!-- Slide Modal -->
				<div class="modal fade modal-slide" tabindex="-1" role="dialog"
					aria-labelledby="defaultModalLabel" aria-hidden="true"
					style="display: none;">
					<div class="modal-dialog" role="document">
						<form action="./InquiryList.emp" method="get">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="defaultModalLabel">Filters</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<i class="fe fe-x fe-12"></i>
									</button>
								</div>
								<div class="modal-body" data-select2-id="5">
									<div class="p-2">
										<div class="form-group my-4">
											<label for="custom-select"><strong>검색</strong></label> <select
												name="search" class="custom-select" id="custom-select">
												<c:if test="${empty search}">
													<option selected>선택</option>
												</c:if>
												<c:if test="${!empty search}">
													<option>선택</option>
												</c:if>
												<c:if test="${search eq'emp_id'}">
													<option value="emp_id" selected>작성자</option>
												</c:if>
												<c:if test="${search != 'emp_id'}">
													<option value="emp_id">작성자</option>
												</c:if>
												<c:if test="${search eq'subject'}">
													<option value="subject" selected>제목</option>
												</c:if>
												<c:if test="${search != 'subject'}">
													<option value="subject">제목</option>
												</c:if>
												<c:if test="${search eq'content'}">
													<option value="content" selected>내용</option>
												</c:if>
												<c:if test="${search != 'content'}">
													<option value="content">내용</option>
												</c:if>
											</select> <input type="text" name="searchKeyword"
												value="${searchKeyword}" class="form-control"
												placeholder="검색어 입력">
										</div>
										<!-- form-group -->
									</div>
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn mb-2 btn-primary btn-block">검색</button>
									<button type="reset" class="btn mb-2 btn-secondary btn-block">초기화</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<c:if test="${list == null}">
              	0건
              </c:if>
				<c:if test="${list != null }">
					<table class="table border table-hover bg-white">
						<thead>
							<tr role="row">
								<th>글 번호</th>
								<th>발신자</th>
								<th>제목</th>
								<th>게시일자</th>
								<th>기타</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="i" items="${list}">
								<tr>
									<td>${i.bno}</td>
									<td>
										<p class="mb-0 text-muted">
											<a href="./ProfileContent.emp?emp_id=${i.emp_id}"
												class="text-muted">${i.emp_id}</a>
										</p>
									</td>
									<td>
										<p class="mb-0 text-muted">
											<a href="./EmployeeMailContent.emp?bno=${i.bno}" class="text-muted">${i.subject}</a>
										</p>
									</td>
									<td>${i.content}</td>
									<td>${i.sendDate}</td>
									<td>
										<div class="dropdown">
											<button class="btn btn-sm dropdown-toggle more-vertical"
												type="button" data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false">
												<span class="text-muted sr-only">Action</span>
											</button>
											<div class="dropdown-menu dropdown-menu-right" style="">
												<a class="dropdown-item"
													href="./MailContent.emp?bno=${i.bno}">상세보기</a>
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				<nav aria-label="Table Paging" class="my-3">
					<ul class="pagination justify-content-end mb-0">
						<c:if test="${1 < pageNum}">
							<li class="page-item"><a class="page-link"
								href="<%=link%>pageNum=${pageNum-1}">이전</a></li>
						</c:if>
						<c:forEach begin="${startPage}" end="${endPage}" step="1" var="i">
							<c:if test="${i == pageNum}">
								<li class="page-item active"><a class="page-link"
									href="<%=link%>pageNum=${i}">${i}</a></li>
							</c:if>
							<c:if test="${i != pageNum }">
								<li class="page-item"><a class="page-link"
									href="<%=link%>pageNum=${i}">${i}</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${pageNum < pageCount}">
							<li class="page-item"><a class="page-link"
								href="<%=link%>pageNum=${pageNum+1}">다음</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
		<!-- .row -->
	</div>
	<!-- .container-fluid -->
</main>
</div>
<jsp:include page="../inn/footer.jsp" />