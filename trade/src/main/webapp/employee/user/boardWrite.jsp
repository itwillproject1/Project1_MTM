<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/main.jsp"/>
<title>게시판 작성</title>
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
					
                </div> <!-- /.card-body -->
              </div> <!-- /.card -->
            </div> <!-- /.col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
      </main>
  </div> <!-- .wrapper -->
<jsp:include page="../inn/footer.jsp"/>