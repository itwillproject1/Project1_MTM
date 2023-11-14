<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/main.jsp"/>
<title>유저 정보</title>
  <c:if test="${empty emp_id}">
		<c:redirect url="./Login.emp"/>
  </c:if>
<jsp:include page="../inn/navbar.jsp"/>
   <!-- 메인 -->
	<main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <h2 class="page-title">유저 정보</h2>
              <p class="lead text-muted">${dto.user_id}</p>
              <div class="row"> 
                <div class="col-md-12 mb-12">
                  <div class="card shadow">
                    <div class="card-body">
                      <ul class="nav nav-pills nav-fill mb-3" id="pills-tab" role="tablist">
                        <li class="nav-item">
                          <a class="nav-link active" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="true">기본 프로필</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" id="pills-trade-tab" data-toggle="pill" href="#pills-trade" role="tab" aria-controls="pills-trade" aria-selected="false">거래 이력</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" id="pills-inquiry-tab" data-toggle="pill" href="#pills-inquiry" role="tab" aria-controls="pills-inquiry" aria-selected="false">문의 목록</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" id="pills-complain-tab" data-toggle="pill" href="#pills-complain" role="tab" aria-controls="pills-complain" aria-selected="false">신고 이력</a>
                        </li>
                      </ul>
                      <div class="tab-content mb-1" id="pills-tabContent">
                        <div class="tab-pane fade active show" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
                        	<!-- 기본 프로필 -->
                        	<!-- 마음함 목록도 여기서 공개! -->
                        	<div class="row align-items-center mb-4">
                				<div class="col">
                  					<h2 class="h5 page-title"><small class="text-muted text-uppercase">${dto.user_nickname}</small><br>${dto.user_id}</h2>
                				</div>
              				</div>
              				<div class="row mb-5">
                    			<div class="col-12 text-center mb-4">
                      				<div class="avatar avatar-xl">
                      					<c:if test="${dto.profile == null}">
                    						<img src="./employee/template/assets/images/user.png" alt="..." class="avatar-img rounded-circle">
                      					</c:if>
                      					<c:if test="${dto.profile != null}">
                    						<img src="./employee/template/assets/images/user.png" alt="..." class="avatar-img rounded-circle">
                      					</c:if>
                  					</div>
                      				<h2 class="mb-0 text-uppercase">${dto.user_id}</h2>
                    			</div>
                    			<div class="col-md-8" style="margin:auto;">
                   					<table class="table table-borderless table-striped">
                   						<tbody>
                   							<tr>
                   								<td><strong>이름</strong></td><th class="text-muted">${dto.user_name}</th>
                   								<td><strong>주소</strong></td><th class="text-muted">${dto.address}</th>
                   							</tr>
                   							<tr>
                   								<td><strong>별명</strong></td><th class="text-muted">${dto.user_nickname}</th>
                   								<td><strong>전화번호</strong></td><th class="text-muted">${dto.phone}</th>
                   							</tr>
                   							<tr>
                   								<td><strong>생년월일</strong></td><th class="text-muted">${dto.jumin}</th>
                   								<td><strong>이메일</strong></td><th class="text-muted">${dto.email}</th>
                   							</tr>
                   							<tr>
                   								<td><strong>잔액</strong></td><th class="text-muted">${dto.pay}</th>
                   								<td><strong>수신</strong></td>
                   								<th class="text-muted">
                   									<c:if test="${dto.agree == '동의'}">
														<span class="badge badge-pill badge-primary">동의</span>
													</c:if>
													<c:if test="${dto.agree == '비동의'}">
														<span class="badge badge-pill badge-secondary">비동의</span>
													</c:if>
                   								</th>
                   							</tr>
                   							<c:if test="${dto.suspended}">
                   							<tr>
                   								<td><strong>계정 정지</strong></td>
                   								<th class="text-muted">
                   									<span class="badge badge-pill badge-danger">진행 중</span>
												</th>
                   								<td><strong>남은 기간</strong></td><th class="text-muted">${dto.sus_days}</th>
                   							</tr>
                   							</c:if>
                   						</tbody>
                   					</table>
                    			</div>
                  			</div>
                 		</div>
                  		<div class="tab-pane fade" id="pills-trade" role="tabpanel" aria-labelledby="pills-trade-tab">
                   			<!-- 거래 이력 -->
                  			<div class="row align-items-center mb-10">
                				<div class="col">
                  					<h2 class="h5 page-title"><small class="text-muted text-uppercase">${dto.user_nickname}</small><br>${dto.user_id}</h2>
                				</div>
              				</div>
                  			<div class="row mb-12">
                  				<div class="col-6 text-center mb-12">
              	 					<h3>거래 이력</h3>
                  					<table class="table table-borderless table-striped">
                    					<thead>
                      						<tr>
                        						<th scope="col">#</th>
                        						<th scope="col">제목</th>
                        						<th scope="col" class="text-right">가격</th>
                        						<th scope="col" class="text-right">거래 현황</th>
                        						<th scope="col" class="text-right">거래자</th>
                      						</tr>
                    					</thead>
                    					<tbody>
                    					<c:forEach var="i" items="${tlist}">
                      						<tr>
                        						<th scope="row">${i.bno}</th>
                        						<td>${i.title}<br>
                          							<span class="small text-muted">${i.content}</span>
                        						</td>
                        						<td class="text-right">${i.price}</td>
                        						<td class="text-right">
													<c:if test="${i.deal_status == 1}">
														<span class="badge badge-pill badge-success">거래 중</span>
													</c:if>
													<c:if test="${i.deal_status == 0}">
														<span class="badge badge-pill badge-secondary">거래 완료</span>
													</c:if>
												</td>
                        						<td class="text-right">
                        							<c:if test="${i.deal_status == 0}">${i.deal_user_id}</c:if>
                        						</td>
                      						</tr>
                    					</c:forEach>
                    					</tbody>
                  					</table>
              	 			 	</div>
              	 			 	<div class="col-6 text-center mb-12">
              	 					<h3>마음함 목록</h3>
                  					<table class="table table-borderless table-striped">
                    					<thead>
                      						<tr>
                        						<th scope="col">#</th>
                        						<th scope="col">제목</th>
                        						<th scope="col" class="text-right">가격</th>
                        						<th scope="col" class="text-right">거래 현황</th>
                        						<th scope="col" class="text-right">거래자</th>
                      						</tr>
                    					</thead>
                    					<tbody>
                    					<c:forEach var="i" items="${likelist}">
                      						<tr>
                        						<th scope="row">${i.bno}</th>
                        						<td>${i.title}<br>
                          							<span class="small text-muted">${i.content}</span>
                        						</td>
                        						<td class="text-right">${i.price}</td>
                        						<td class="text-right">
													<c:if test="${i.deal_status == 1}">
														<span class="badge badge-pill badge-success">거래 중</span>
													</c:if>
													<c:if test="${i.deal_status == 0}">
														<span class="badge badge-pill badge-secondary">거래 완료</span>
													</c:if>
												</td>
                        						<td class="text-right">
                        							<c:if test="${i.deal_status == 0}">${i.deal_user_id}</c:if>
                        						</td>
                      						</tr>
                    					</c:forEach>
                    					</tbody>
                  					</table>
              	 			 	</div>
                        	</div>
                        </div>
                        <div class ="tab-pane fade" id="pills-inquiry" role="tabpanel" aria-labelledby="pills-inquiry-tab">
                        	<!-- 문의 목록 -->
                        	<div class="row align-items-center mb-10">
                				<div class="col">
                  					<h2 class="h5 page-title"><small class="text-muted text-uppercase">${dto.user_nickname}</small><br>${dto.user_id}</h2>
                				</div>
              				</div>
                  			<div class="row mb-12">
                  				<div class="col-12 text-center mb-12" style="margin:auto;">
              	 					<h3>문의 이력</h3>
                  					<table class="table table-borderless table-striped">
                    					<thead>
                      						<tr>
                        						<th scope="col">#</th>
                        						<th scope="col">카테고리</th>
                        						<th scope="col">제목</th>
                        						<th scope="col">일자</th>
                        						<th scope="col">답변 현황</th>
                      						</tr>
                    					</thead>
                    					<tbody>
                    					<c:forEach var="i" items="${ilist}">
                      						<tr>
                        						<th scope="row">${i.bno}</th>
                          						<td>${i.category}</td>
                        						<td>${i.subject}</td>
                        						<td>${i.uploadDate}</td>
                        						<td>
													<c:if test="${i.complete}">
														<span class="badge badge-pill badge-success">답변 완료</span>
													</c:if>
													<c:if test="${!i.complete}">
														<span class="badge badge-pill badge-secondary">미완료</span>
													</c:if>
												</td>
                      						</tr>
                    					</c:forEach>
                    					</tbody>
                  					</table>
              	 			 	</div>
                        	</div>
                        </div>
                        <div class ="tab-pane fade" id="pills-complain" role="tabpanel" aria-labelledby="pills-complain-tab">
                        	<!-- 신고 이력 -->
                        	 <div class="row align-items-center mb-10">
                				<div class="col">
                  					<h2 class="h5 page-title"><small class="text-muted text-uppercase">${dto.user_nickname}</small><br>${dto.user_id}</h2>
                				</div>
                				<div class="col-auto">
                  					<button type="button" class="btn btn-secondary" onclick="./UserSuspendCancelForm.emp?user_id=${dto.user_id}&suspended=${dto.suspended}">정지 취소</button>
                  					<button type="button" class="btn btn-primary" onclick="./UserSuspendActiveForm.emp?user_id=${dto.user_id}&suspended=${dto.suspended}">유저 정지</button>
                				</div>
              				</div>
                  			<div class="row mb-12">
                  				<div class="col-12 text-center mb-12"  style="margin:auto;">
              	 					<h3>신고 이력</h3>
                  					<table class="table table-borderless table-striped">
                    					<thead>
                      						<tr>
                        						<th scope="col">#</th>
                        						<th scope="col">신고자</th>
                        						<th scope="col" class="text-right">사유</th>
                        						<th scope="col" class="text-right">일자</th>
                        						<th scope="col" class="text-right">신고 처리</th>
                      						</tr>
                    					</thead>
                    					<tbody>
                    					<c:forEach var="i" items="${clist}">
                      						<tr>
                        						<th scope="row">${i.bno}</th>
                        						<td>${i.complainer_id}</td>
                        						<td class="text-right">${i.complainReason}</td>
                        						<td>${i.uploadDate}</td>
                        						<td class="text-right">
													<c:if test="${!i.complete}">
														<span class="badge badge-pill badge-success">처리 완료</span>
													</c:if>
													<c:if test="${!i.complete}">
														<span class="badge badge-pill badge-secondary">미처리</span>
													</c:if>
												</td>
                      						</tr>
                    					</c:forEach>
                    					</tbody>
                  					</table>
              	 			 	</div>     	 			 
                        	</div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
        </div>
      </main>
  </div> <!-- .wrapper -->
<jsp:include page="../inn/footer.jsp"/>