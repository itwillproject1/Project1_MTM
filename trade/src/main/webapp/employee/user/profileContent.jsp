<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/main.jsp"/>
<jsp:include page="../inn/navbar.jsp"/>
   <!-- 메인 -->
	<main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12 col-lg-10 col-xl-8">
              <div class="row align-items-center mb-4">
                <div class="col">
                  <h2 class="h5 page-title"><small class="text-muted text-uppercase">프로필</small><br />${requestScope.emp_id}</h2>
                </div>
                <div class="col-auto">
                <c:if test="${sessionScope.emp_id == requestScope.emp_id}">                	
                  <button type="button" class="btn btn-secondary" onclick="./ProfileChangeForm.emp?emp_id=${requestScope.emp_id}">수정</button>
                </c:if>
                <c:if test="${sessionScope.emp_id == 'admin'}">
                  <button type="button" class="btn btn-primary" onclick="./EmployeeDeleteForm.emp?emp_id=${requestScope.emp_id}">삭제</button>
                </c:if>
                </div>
              </div>
              <div class="card shadow">
                <div class="card-body p-5">
                  <div class="row mb-5">
                    <div class="col-12 text-center mb-4">
                      <img src="${'직원 이미지'}" class="navbar-brand-img brand-sm mx-auto mb-4" alt="...">
                      <h2 class="mb-0 text-uppercase">직원명</h2>
                      <p class="text-muted"> 직군<br /> 부서 </p>
                    </div>
                  </div> <!-- /.row -->
                </div> <!-- /.card-body -->
              </div> <!-- /.card -->
            </div> <!-- /.col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
    </main> <!-- main -->    
  </div> <!-- .wrapper -->
<jsp:include page="../inn/footer.jsp"/>