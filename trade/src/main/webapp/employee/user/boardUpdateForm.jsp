<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/main.jsp"/>
<title>게시판 수정</title>
  <c:if test="${empty emp_id}">
		<c:redirect url="./Login.emp"/>
  </c:if>
<jsp:include page="../inn/navbar.jsp"/>
   <!-- 메인 -->
	<main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <h2 class="page-title">수정하기</h2>
              <div class="card shadow mb-5">
              <form action="./BoardUpdateAction.emp" method="post" enctype="multipart/form-data">
                <div class="card-body">
                  <div class="row">
                    <div class="col">
                      <div class="form-group mb-3">
                       <label for="emp_id">작성자</label>
                        <input type="text" id="emp_id" value="${bno.emp_id}" class="form-control" readonly value="Readonly value">
                      </div>
                      <div class="form-group mb-3">
                        <label for="subject">제목</label>
                        <input type="text" name="subject" id="subject" value="${bno.subject}" class="form-control" placeholder="제목">
                      </div>
                      <div class="form-group mb-3">
                        <label for="textarea">내용</label>
                        <textarea class="form-control" name="content" id="textarea" rows="4">${bno.content}</textarea>
                      </div>
                      <div class="form-group mb-3">
                          <label for="file">이미지 파일</label>
                          <div class="file">
                            <input type="file" name="image" value="${bno.image}" class="custom-file-input" id="file">
                            <label class="custom-file-label" for="file">파일 선택</label>
                          </div>
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