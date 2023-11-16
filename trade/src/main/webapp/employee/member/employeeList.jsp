<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/employeeList.jsp"/>
<title>직원 목록</title>
<jsp:include page="../inn/navbar.jsp"/>
      <!-- 메인(데이터가 쌓일 때 진행) -->
	<main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <div class="row align-items-center my-4">
                <div class="col">
                  <h2 class="h3 mb-0 page-title">직원 목록</h2>
                </div>
                <c:if test="${sessionScope.emp_id == 'admin'}">
                <div class="col-auto">
                  <button type="button" class="btn btn-primary" onclick="location.href='./EmployeeRegisterForm.emp'"><span class="fe fe-filter fe-12 mr-2"></span>직원 생성</button>
                </div>
                </c:if>
              </div>
              <div class="row">
              <!-- 직원 목록(1 페이지에 8명) -->
              	<c:forEach var="i" items="${list}">
                <div class="col-md-3">
                  <div class="card shadow mb-4">
                    <div class="card-body text-center">
                      <div class="avatar avatar-lg mt-4">
                        <a href="./ProfileContent.emp?emp_id=${i.emp_id}">
                          <img src="./employee/template/assets/images/user.png" alt="${i.name}의 이미지" class="avatar-img rounded-circle">           
                        </a>
                      </div>
                      <div class="card-text my-2">
                        <strong class="card-title my-0">${i.name}</strong>
                        <p class="small"><span class="badge badge-light text-muted">${i.emp_id}</span></p>
                      </div>
                    </div> <!-- ./card-text -->
                    <div class="card-footer">
                      <div class="row align-items-center justify-content-between">
                        <div class="col-auto">
                        <small>
                        	<c:if test="${i.active == 1}">
                            	<span class="dot dot-lg bg-success mr-1"></span> 활성화 </small>
                        	 </c:if>
                        	 <c:if test="${i.active == 0}">
                            	<span class="dot dot-lg bg-secondary mr-1"></span> 비활성화 </small>
                        	 </c:if>
                        	</div>
                        	<div class="col-auto">
                          <div class="file-action">
                            <button type="button" class="btn btn-link dropdown-toggle more-vertical p-0 text-muted mx-auto" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              <span class="text-muted sr-only">메뉴</span>
                            </button>
                            <div class="dropdown-menu m-2">
                            	<a class="dropdown-item" href="./ProfileContent.emp?emp_id=${i.emp_id}"><i class="fe fe-user fe-12 mr-4"></i>상세 정보</a>
                              <c:if test="${i.active == 1 }">
                              	<c:if test="${sessionScope.emp_id == 'admin'}">                              
                              		<a class="dropdown-item" href="./EmployeeDeleteForm.emp?emp_id=${i.emp_id}"><i class="fe fe-delete fe-12 mr-4"></i>직원 비활성화</a>
                              	</c:if>
                              </c:if>
                              <c:if test="${i.active == 0 }">
                              	<c:if test="${sessionScope.emp_id == 'admin'}">                              
                              		<a class="dropdown-item" href="./EmployeeActiveForm.emp?emp_id=${i.emp_id}"><i class="fe fe-delete fe-12 mr-4"></i>직원 활성화</a>
                              	</c:if>
                              </c:if>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div> <!-- /.card-footer -->
                  </div>
                </div> <!-- .col -->
              </c:forEach>
                <div class="col-md-9">
                </div> <!-- .col -->
              </div> <!-- .row -->
              <nav aria-label="Table Paging" class="my-3">
                <ul class="pagination justify-content-end mb-0">
                <c:if test="${1 < pageNum}">
					<li class="page-item"><a class="page-link" href="./EmployeeList.emp&pageNum=${pageNum-1}">이전</a></li>
				</c:if>
				<c:forEach begin="${startPage}" end="${endPage}" step="1" var="i">
					<c:if test="${i == pageNum}">
						<li class="page-item active"><a class="page-link" href="./EmployeeList.emp&pageNum=${i}">${i}</a></li>
					</c:if>
					<c:if test="${i != pageNum }">	
						 <li class="page-item"><a class="page-link" href="./EmployeeList.emp&pageNum=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pageNum < pageCount}">
					<li class="page-item"><a class="page-link" href="./EmployeeList.emp&pageNum=${pageNum+1}">다음</a></li>
				</c:if>
                </ul>
              </nav>
            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
      </main>
    </div> <!-- .wrapper -->
<jsp:include page="../inn/footer.jsp"/>