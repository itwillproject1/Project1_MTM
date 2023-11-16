<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/main.jsp"/>
<jsp:include page="../inn/navbar.jsp"/>
   <!-- 메인 -->
<title>${dto.name}프로필</title>
<main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12 col-lg-10 col-xl-8">
            	 <div class="row align-items-center mb-10">
                	<div class="col">
                  		<h2 class="h3 mb-4 page-title">프로필</h2>
                	</div>
                	<div class="col-auto">
                	<c:if test="${dto.emp_id != 'admin'}">
                		<c:if test="${dto.active == 1}">
 	                 		<button type="button" class="btn btn-secondary" onclick="location.href='./EmployeeDeleteForm.emp?emp_id=${dto.emp_id}'">비활성화</button>
                		</c:if>
                		<c:if test="${dto.active == 0}">
	                  		<button type="button" class="btn btn-primary" onclick="location.href='./EmployeeActiveForm.emp?emp_id=${dto.emp_id}'">활성화</button>
                		</c:if>
                	</c:if>
                	</div>
              	</div>
              <div class="my-4">
               	<div class="row mt-5 align-items-center">
                    <div class="col-md-3 text-center mb-5">
                      <div class="avatar avatar-xl">
                        <img src="./employee/template/assets/images/user.png" alt="${dto.name}의 이미지" class="avatar-img rounded-circle">
                      </div>
                    </div>
					<div class="col">
                      <div class="row align-items-center">
                        <div class="col-md-7">
                          <h4 class="mb-1">${dto.name}</h4>
                          <p class="small mb-3"><span class="badge badge-dark">${dto.emp_id}</span></p>
                        </div>
                      </div>
                      <div class="row mb-4">
                        <div class="col">
                          <p class="small mb-0 text-muted">${dto.address}</p>
                          <p class="small mb-0 text-muted">${dto.email}</p>
                          <p class="small mb-0 text-muted">${dto.tel}</p>
                        </div>
                      </div>
                    </div>
                  </div>
               <c:if test="${sessionScope.emp_id == dto.emp_id}">
                <form action="./ProfileChangeAction.emp" method="post">
                  <hr class="my-4">
                  <div class="form-row">
                    <div class="form-group col-md-6">
                      <label for="inputName">이름</label>
                      <input type="text" name="name" id="inputName" value="${dto.name}" class="form-control" placeholder="${dto.name}">
                    </div>
                    <div class="form-group col-md-6">
                      <label for="inputAddress">주소</label>
                      <input type="tel" name="address" value="${dto.address}" class="form-control" id="inputAddress" placeholder="${dto.address}">
                    </div>
                  </div>
                  <div class="form-row">
                    <div class="form-group col-md-6">
                      <label for="inputTel">전화번호</label>
                      <input type="tel" name="tel" id="inputTel" value="${dto.tel}" class="form-control" placeholder="${dto.tel}">
                    </div>
                    <div class="form-group col-md-6">
                      <label for="inputEmail">이메일</label>
                      <input type="email" name="email" value="${dto.email}" class="form-control" id="inputEmail" placeholder="${dto.email}">
                    </div>
                  </div>
                  <hr class="my-4">
                  <div class="row mb-4">
                    <div class="col-md-6">
                      <div class="form-group">
                        <label for="past_pw">이전 비밀번호</label>
                        <input type="password" name="past_pw" class="form-control" id="past_pw">
                      </div>
                    </div>
                    <div class="col-md-6">
                    <div class="form-group">
                        <label for="new_pw">새 비밀번호</label>
                        <input type="password" name="new_pw" class="form-control" id="new_pw">
                      </div>
                      <div class="form-group">
                        <label for="confirmPw">비밀번호 확인</label>
                        <input type="password" name="confirm_pw" class="form-control" id="confirm_pw">
                      </div>
                    </div>
                  </div>
                  <button type="submit" class="btn btn-primary">저장</button>
                  <button type="button" class="btn btn-secondary" onclick="history.back();">취소</button>
                </form>
               </c:if>
              </div> <!-- /.card-body -->
            </div> <!-- /.col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
      </main>
  </div> <!-- .wrapper -->
<jsp:include page="../inn/footer.jsp"/>