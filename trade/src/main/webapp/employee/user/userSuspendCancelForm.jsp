<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/main.jsp"/>
<title>유저 신고 취소</title>
  <c:if test="${empty emp_id}">
		<c:redirect url="./Login.emp"/>
  </c:if>
<jsp:include page="../inn/navbar.jsp"/>
   <!-- 메인 -->
	<main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <h2 class="page-title">유저 신고 취소</h2>
              <div class="card shadow mb-5">
              <form action="./UserSuspendActiveAction.emp" method="post">
                <div class="card-body">
                  <div class="row">
                    <div class="col">
                      <div class="form-group mb-3">
                       <label for="emp_id">피신고자</label>
                        <input type="text" id="emp_id" value="${requestScope.user_id}" class="form-control" readonly value="Readonly value">
                      </div>
                      <div class="form-group mb-3">
                      	<p class="mb-2"><strong>신고 처리</strong></p>
                        	<c:forEach var="i" items="complainList">
                        		<div class="form-check">
                        			<input class="form-check-input" name="complainCheck" type="checkbox" value="${i.bno}" id="${i.complainer_id}">
                        			<label class="form-check-label" for="${i.complainer_id}"> ${i.uploadDate} : ${i.complainReason} </label>
                      			</div>
                        	</c:forEach>
                      </div>
                      <div class="form-group mb-3">
                        <label for="password">비밀번호</label>
                        <input type="password" name="emp_pw" id="emp_pw" class="form-control" placeholder="비밀번호">
                      </div>
                      <button type="submit" id="board-btn" class="btn btn-primary">입력</button>
                      <button type="button" class="btn btn-secondary" onclick="history.back();">취소</button>
                    </div> <!-- /.col -->
                  </div> <!-- /.card -->
                </div> <!-- /.col -->
              </form>
              </div> <!-- end section -->
            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
      </main>
  </div> <!-- .wrapper -->
<jsp:include page="../inn/footer.jsp"/>