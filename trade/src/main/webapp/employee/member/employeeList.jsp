<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/employeeList.jsp"/>
<jsp:include page="../inn/navbar.jsp"/>
      <!-- 메인(데이터가 쌓일 때 진행) -->
	<main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <div class="row align-items-center my-4">
                <div class="col">
                  <h2 class="h3 mb-0 page-title">Contacts</h2>
                </div>
                <div class="col-auto">
                  <button type="button" class="btn btn-secondary"><span class="fe fe-trash fe-12 mr-2"></span>Delete</button>
                  <button type="button" class="btn btn-primary"><span class="fe fe-filter fe-12 mr-2"></span>Create</button>
                </div>
              </div>
              <div class="row">
              <!-- 직원 목록(1 페이지에 8명) -->
                <div class="col-md-3">
                  <div class="card shadow mb-4">
                    <div class="card-body text-center">
                      <div class="avatar avatar-lg mt-4">
                        <a href="#">
                          <img src=".${'직원 이미지'}" alt="${'직원 명' + '이미지'}" class="avatar-img rounded-circle">
                        </a>
                      </div>
                      <div class="card-text my-2">
                        <strong class="card-title my-0">직원명</strong>
                        <p class="small text-muted mb-0">부서명</p>
                        <p class="small"><span class="badge badge-light text-muted">전화번호</span></p>
                      </div>
                    </div> <!-- ./card-text -->
                    <div class="card-footer">
                      <div class="row align-items-center justify-content-between">
                        <div class="col-auto">
                          <div class="file-action">
                            <button type="button" class="btn btn-link dropdown-toggle more-vertical p-0 text-muted mx-auto" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              <span class="text-muted sr-only">메뉴</span>
                            </button>
                            <div class="dropdown-menu m-2">
                              <c:if test="${sessionScope.emp_id == 'admin'}">                              
                              	<a class="dropdown-item" href="./EmployeeDeleteForm.emp"><i class="fe fe-delete fe-12 mr-4"></i>삭제</a>
                              </c:if>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div> <!-- /.card-footer -->
                  </div>
                </div> <!-- .col -->
                <div class="col-md-9">
                </div> <!-- .col -->
              </div> <!-- .row -->
              <nav aria-label="Table Paging" class="my-3">
                <ul class="pagination justify-content-end mb-0">
                <!-- 직원 count(*) return 하고 계산 후 색출 -->
                  <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                  <li class="page-item active"><a class="page-link" href="#">1</a></li>
                  <li class="page-item"><a class="page-link" href="#">2</a></li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
              </nav>
            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
      </main>
    </div> <!-- .wrapper -->
<jsp:include page="../inn/footer.jsp"/>