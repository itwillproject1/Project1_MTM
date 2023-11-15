<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <jsp:include page="../inn/head/main.jsp"/> --%>
<title>게시판</title>
  <c:if test="${empty emp_id}">
		<c:redirect url="./Login.emp"/>
  </c:if>
<link rel="stylesheet" href="./employee/template/css/tradePage.css">
<jsp:include page="../inn/navbar.jsp"/>
   <!-- 메인 -->
   <main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12 col-lg-10 col-xl-10">
              <div class="row align-items-center mb-4">
                <div class="col">
                  <h2 class="h2 page-title"><small class="text-muted text-uppercase">#${dto.bno}</small><br>거래 정보</h2>
                </div>
                <div class="col-auto">
                  <button type="button" class="btn btn-secondary">삭제</button>
                  <button type="button" class="btn btn-primary">수정</button>
                </div>
              </div>
              <div class="card shadow">
                <div class="card-body p-5">
					<div class="row align-items-center">
                    		<div class="col text-center">
                      			<h4 class="mb-1">${dto.title}</h4>
                      			<span class="badge badge-dark">${dto.deal_way}</span>
                      			<p class="text-muted"> ${dto.content} </p>
                    		</div>
                  		</div>
                  		<div class="row align-items-center">
                    		<div class="col text-center">
                    		<br>
								<table class="table table-borderless table-striped" style="margin:auto;">
									<tbody>
									    <tr>
                   							<td><strong>글 번호</strong></td><th class="text-muted">${dto.bno}</th>
                   							<td><strong>아이디</strong></td><th class="text-muted">${dto.user_id}</th>
                   						</tr>
                   						<tr>
                   							<td><strong>카테고리</strong></td><th class="text-muted">${dto.category}</th>
                   							<td><strong>등록일</strong></td><th class="text-muted">${dto.date_time}</th>
                   						</tr>
                   						<tr>
                   							<td><strong>브랜드</strong></td><th class="text-muted">${dto.brand}</th>
                   							<td><strong>가격</strong></td><th class="text-muted">${dto.price}</th>
                   						</tr>
                   						<tr>
                   							<td>
                   								<strong>거래 상태</strong>
                   							</td>
                   								<th class="text-muted">
                   									<c:if test="${dto.deal_status == 1}">
														<span class="badge badge-pill badge-success">거래 중</span>
													</c:if>
													<c:if test="${dto.deal_status == 0}">
														<span class="badge badge-pill badge-secondary">거래 완료</span>
													</c:if>
                   								</th>
                   							<td><strong>좋아요</strong></td><th class="text-muted">${dto.like_count}</th>
                   						</tr>
                   						<c:if test="${dto.deal_status == 0}">
                   							<tr>
                   								<td><strong>거래자</strong></td><th class="text-muted">${deal_user_id}</th>
                   							</tr>
                   						</c:if>
                   						</tbody>
									</table>
                  				</div>
						</div>
						<div class="row align-items-center">						
							<div class="col">
								<img src="./employee/template/assets/images/productImage.png" alt="..." class="product-image">
							</div>
						</div>
                	</div> <!-- /.card-body -->
              	</div> <!-- /.card -->
              </div>
            </div> <!-- /.col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
      </main>
  </div> <!-- .wrapper -->
<jsp:include page="../inn/footer.jsp"/>