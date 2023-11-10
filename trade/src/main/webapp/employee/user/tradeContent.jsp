<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/main.jsp"/>
<title>거래 정보</title>
  <c:if test="${empty emp_id}">
		<c:redirect url="./Login.emp"/>
  </c:if>
<link rel="stylesheet" href="./employee/template/css/tradePage.css">
<jsp:include page="../inn/navbar.jsp"/>
   <!-- 메인 -->
   <main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
          <div class="col-12">
              <div class="row align-items-center">
                <div class="col-md-8 mb-8" style="margin:0 auto;">
                  <h2 class="page-title">거래 정보</h2>
              		<p class="lead text-muted">#${dto.bno}</p>
                  <div class="card shadow">
                    <div class="card-body">
                      <ul class="nav nav-pills nav-fill mb-3" id="pills-tab" role="tablist">
                        <li class="nav-item">
                          <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true">기본 정보</a>
                        </li>
                        <c:if test="${suggestCount > 0}">
                        <li class="nav-item">
                          <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="false">거래 제안</a>
                        </li>
                        </c:if>
                      </ul>
                      <div class="tab-content mb-1" id="pills-tabContent">
                        <div class="tab-pane fade active show" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                       <div class="row align-items-center">
                    	<div class="col text-center">
                    	<hr>
                      		<h4 class="mb-1">${dto.title}</h4>
                      		<span class="badge badge-dark">${dto.deal_way}</span>
                      		<p class="text-muted"> ${dto.content} </p>
                      		<hr>
                    	</div>
                  	</div>
					<div class="row align-items-center">						
						<div class="col">
							<img src="./employee/template/assets/images/productImage.png" alt="..." class="product-image">
						</div>
					</div>
                  	<div class="row align-items-center">
                    	<div class="col text-center">
                    		<hr>
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
                   						<td><strong>거래 방식</strong></td><th class="text-muted">${dto.deal_way}</th>
                   						<td><strong>거래 제안</strong></td><th class="text-muted">${suggestCount}</th>
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
                   				</tbody>
							</table>
                  		</div>
                        </div>
                        </div>
                        <c:if test="${suggestCount > 0}">
                        	<div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
                      <h5 class="card-title">거래 제안 목록</h5>
                      <p class="card-text">#${suggestCount}건</p>
                      <table class="table table-hover table-sm">
                        <thead>
                          <tr>
                            <th>#</th>
                            <th>거래자 아이디</th>
                            <th>제목</th>
                            <th>거래자 가격</th>
                            <th>등록 일자</th>
                            <th>조회수</th>
                          </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${sList}">
                          <tr>
                            <td>${i.bno}</td>
                            <td>
                            	<p class="mb-0 text-muted">
                            		<c:if test="${empty i.seller_id}">
                            			<a href="./UserInfo.emp?user_id=${i.buyer_id}" class="text-muted">${i.buyer_id}</a>
                            		</c:if>
                            		<c:if test="${empty i.buyer_id}">
                            			<a href="./UserInfo.emp?user_id=${i.seller_id}" class="text-muted">${i.seller_id}</a>	
                            		</c:if>
                    			</p>
                            </td>
                            <td>
                            	<p class="mb-0 text-muted">
                    				<a href="./TradeContent.emp?bno=${i.bno}" class="text-muted">
                    					${i.title}
                    				</a>
                    			</p>
                            </td>
                            <td>
                            	<c:if test="${empty i.seller_id}">${i.buyer_price}</c:if>
                            	<c:if test="${empty i.buyer_id}">${i.seller_price}</c:if>
                            </td>  
                            <td>${i.date_time}</td>
                            <td>${i.views}</td>
                          </tr>
                        </c:forEach>
                        </tbody>
                      </table>
                        	</div>
                        </c:if>
                      </div>
                    </div>
                  </div>
                </div>
              </div> <!-- end section -->
            </div>
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
      </main>
  </div> <!-- .wrapper -->
<jsp:include page="../inn/footer.jsp"/>