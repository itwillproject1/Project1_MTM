<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/main.jsp"/>
<title>게시판</title>
  <c:if test="${empty emp_id}">
		<c:redirect url="./Login.emp"/>
  </c:if>
<link rel="stylesheet" href="./employee/template/css/boardImage.css">
<jsp:include page="../inn/navbar.jsp"/>
   <!-- 메인 -->
   <main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12 col-lg-10 col-xl-10">
              <div class="row align-items-center mb-4">
                <div class="col">
                  <h2 class="h2 page-title"><small class="text-muted text-uppercase">#${dto.bno}</small><br>이벤트</h2>
                </div>
                <div class="col-auto">
                  <button type="button" class="btn btn-secondary" onclick="location.href='./BoardDeleteForm.emp?bno=${dto.bno}'">삭제</button>
                  <button type="button" class="btn btn-primary"  onclick="location.href='./BoardUpdateForm.emp?bno=${dto.bno}'">수정</button>
                </div>
              </div>
              <div class="card shadow">
                <div class="card-body p-5">
					<div class="row align-items-center">
                    		<div class="col text-center">
                      			<h4 class="mb-1">${dto.subject}</h4>
                      			<span class="badge badge-dark">${dto.uploadDate}</span>
                    		</div>
                  		</div>
                  		<div class="row align-items-center">
                    		<div class="col text-center">
                    		<hr>
								<p>${dto.content}</p>	
                  			</div>
						</div>
						<c:if test="${dto.image != ''}">
							<div class="row align-items-center">						
								<div class="col" style="margin:auto;">
									<img src="./employee/template/assets/images/eventEx.png" alt="..." class="eventImage">
								</div>
							</div>
						</c:if>
                	</div> <!-- /.card-body -->
              	</div> <!-- /.card -->
              </div>
            </div> <!-- /.col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
      </main>
  </div> <!-- .wrapper -->
<jsp:include page="../inn/footer.jsp"/>