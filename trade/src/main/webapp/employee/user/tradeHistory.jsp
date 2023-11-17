<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>거래 내역</title>
<jsp:include page="../inn/head/databaseList.jsp" />
<c:if test="${empty emp_id}">
	<c:redirect url="./Login.emp" />
</c:if>

<%
String link = "./TradeHistory.emp?";
String search = request.getParameter("search");
String searchKeyword = request.getParameter("searchKeyword");
String category = request.getParameter("category");
link += search == null ? "" : "search=" + search;
link += searchKeyword == null ? "" : "&searchKeyword=" + searchKeyword;
link += category == null ? "" : "&category=" + category;
%>

<jsp:include page="../inn/navbar.jsp" />
<main role="main" class="main-content" data-select2-id="9">
	<div class="container-fluid" data-select2-id="8">
		<div class="row justify-content-center" data-select2-id="7">
			<div class="col-12" data-select2-id="6">
				<h2 class="h3 mb-3 page-title">거래 내역</h2>
				<div class="row mb-4 items-align-center">
					<div class="col-md-auto ml-auto text-right">
						<button type="button" class="btn" data-toggle="modal"
							data-target=".modal-slide">
							<span class="fe fe-filter fe-16 text-muted"></span>
						</button>
						<button type="button" class="btn"
							onclick="location.href='./TradeList.emp';">
							<span class="fe fe-refresh-ccw fe-16 text-muted"></span>
						</button>
					</div>
				</div>
				<!-- Slide Modal -->
				<div class="modal fade modal-slide" tabindex="-1" role="dialog"
					aria-labelledby="defaultModalLabel" aria-hidden="true"
					style="display: none;">
					<div class="modal-dialog" role="document">
						<form action="./TradeHistory.emp" method="get">
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
												<c:if test="${search == 'title'}">
													<option value="title" selected>제목</option>
												</c:if>
												<c:if test="${search != 'title'}">
													<option value="title">제목</option>
												</c:if>
												<c:if test="${search == 'user_id'}">
													<option value="user_id" selected>작성자</option>
												</c:if>
												<c:if test="${search != 'user_id'}">
													<option value="user_id">작성자</option>
												</c:if>
												<c:if test="${search == 'trader_id'}">
													<option value="trader_id" selected>거래자</option>
												</c:if>
												<c:if test="${search != 'trader_id'}">
													<option value="trader_id">거래자</option>
												</c:if>
											</select> <input type="text" name="searchKeyword"
												value="${searchKeyword}" class="form-control"
												placeholder="검색어 입력">
										</div>
										<!-- form-group -->
										<div class="form-group my-2">
											<label for="custom-select"><strong>카테고리</strong></label> <select
												name="category" class="custom-select" id="custom-select">
												<option selected>선택</option>
												<option value="0">휴대폰&태블릿</option>
												<option value="1">데스크탑</option>
												<option value="2">노트북</option>
												<option value="3">게임기기</option>
												<option value="4">가전제품</option>
												<option value="5">카메라</option>
												<option value="6">음향기기</option>
												<option value="7">기타</option>
											</select>
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
								<th>아이디</th>
								<th>거래자</th>
								<th>거래일자</th>
								<th>카테고리</th>
								<th>제목</th>
								<th style="text-align: right;">가격(￦)</th>
								<th>기타</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="i" items="${list}">
								<tr>
									<td>${i.bno}</td>
									<td>
										<p class="mb-0 text-muted">
											<a href="./UserInfo.emp?user_id=${i.user_id}"
												class="text-muted">${i.user_id}</a>
										</p>
									</td>
									<td>
										<p class="mb-0 text-muted">
											<a href="./UserInfo.emp?user_id=${i.deal_user_id}"
												class="text-muted">${i.deal_user_id}</a>
										</p>
									</td>
									<td>${i.date_time}</td>
									<td>${i.category}</td>
									<td>
										<p class="mb-0 text-muted">
											<a href="./TradeContent.emp?bno=${i.bno}" class="text-muted">[${i.deal_way}]
												${i.title}</a>
										</p>
									</td>
									<td style="text-align: right;">${i.price}</td>
									<td>
										<div class="dropdown">
											<button class="btn btn-sm dropdown-toggle more-vertical"
												type="button" data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false">
												<span class="text-muted sr-only">Action</span>
											</button>
											<div class="dropdown-menu dropdown-menu-right" style="">
												<a class="dropdown-item"
													href="./TradeContent.emp?bno=${i.bno}&pageNum=${pageNum}">상세보기</a>
												<a class="dropdown-item" href="#">삭제</a>
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
								href="<%=link%>&pageNum=${pageNum-1}">이전</a></li>
						</c:if>
						<c:forEach begin="${startPage}" end="${endPage}" step="1" var="i">
							<c:if test="${i == pageNum}">
								<li class="page-item active"><a class="page-link"
									href="<%=link%>&pageNum=${i}">${i}</a></li>
							</c:if>
							<c:if test="${i != pageNum }">
								<li class="page-item"><a class="page-link"
									href="<%=link%>&pageNum=${i}">${i}</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${pageNum < pageCount}">
							<li class="page-item"><a class="page-link"
								href="<%=link%>&pageNum=${pageNum+1}">다음</a></li>
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