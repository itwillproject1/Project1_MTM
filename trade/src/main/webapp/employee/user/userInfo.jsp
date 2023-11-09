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
            <div class="col-12 col-lg-10 col-xl-8">
              <div class="row align-items-center mb-4">
                <div class="col">
                  <h2 class="h5 page-title"><small class="text-muted text-uppercase">${dto.user_nickname}</small><br>${dto.user_id}</h2>
                </div>
                <div class="col-auto">
                  <button type="button" class="btn btn-secondary">삭제</button>
                  <button type="button" class="btn btn-primary">수정</button>
                </div>
              </div>
              <div class="card shadow">
                <div class="card-body p-5">
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
                   			<td>
                   				<strong>수신</strong>
                   			</td>
                   			<th class="text-muted">
                   				<c:if test="${dto.agree == '동의'}">
									<span class="badge badge-pill badge-primary">동의</span>
								</c:if>
								<c:if test="${dto.agree == '비동의'}">
									<span class="badge badge-pill badge-secondary">비동의</span>
								</c:if>
                   			</th>
                   		</tr>
                   	</tbody>
                   </table>
                    </div>
                  </div>
                 <div class="row mb-8">
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
                    <c:forEach var="i" items="${list}">
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
                </div> <!-- /.card-body -->
              </div> <!-- /.card -->
            </div> <!-- /.col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
      </main>
  </div> <!-- .wrapper -->
<jsp:include page="../inn/footer.jsp"/>