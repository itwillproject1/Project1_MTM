<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/databaseList.jsp"/>
<title>유저 목록</title>
  <c:if test="${empty emp_id}">
		<c:redirect url="./Login.emp"/>
  </c:if>
<jsp:include page="../inn/navbar.jsp"/>
<main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <div class="row">
                <!-- Striped rows -->
                <div class="col-md-12 my-4">
                  <h2 class="h4 mb-1">유저 목록</h2>
                  <p class="mb-4"> 검색 결과 : ${dto.size()}명 </p>
                  <div class="card shadow">
                    <div class="card-body">
                      <div class="toolbar row mb-3">
                        <div class="col">
                          <form action="./UserList.emp" method="get" class="form-inline">
                            <div class="form-row">
                              <div class="form-group col-auto">
                                <label for="search" class="sr-only">Search</label>
                                <input type="text" name="search" class="form-control" id="search" value="" placeholder="Search">
                              </div>
                            </div>
                          </form>
                        </div>
                        <div class="col ml-auto">
                          <div class="dropdown float-right">
                            <button class="btn btn-primary float-right ml-3" type="button">Add more +</button>
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="actionMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Action </button>
                            <div class="dropdown-menu" aria-labelledby="actionMenuButton">
                              <a class="dropdown-item" href="#">Export</a>
                              <a class="dropdown-item" href="#">Delete</a>
                              <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                          </div>
                        </div>
                      </div>
                      <!-- table -->
                      <table class="table table-borderless table-hover">
                        <thead>
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="all2">
                                <label class="custom-control-label" for="all2"></label>
                              </div>
                            </td>
                            <th>프로필 이미지</th>
                            <th>유저명</th>
                            <th>연락처</th>
                            <th>주소</th>
                            <th>포인트</th>
                            <th>수신동의</th>
                            <th>가입일</th>
                            <th></th>
                          </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${dto}" var="i">
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="2474">
                                <label class="custom-control-label" for="2474"></label>
                              </div>
                            </td>
                            <td>
                              <div class="avatar avatar-md">
                                <img src="./employee/template/assets/images/user.png" alt="..." class="avatar-img rounded-circle">
                              </div>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><strong>${i.user_id}</strong></p>
                              <small class="mb-0 text-muted">${i.user_name}</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted">${i.email}</p>
                              <small class="mb-0 text-muted">${i.phone}</small>
                            </td>
                            <td class="text-muted">${i.address}</td>
                            <td class="text-muted">0</td>
                            <td class="text-muted"><span class="badge badge-success">승인</span></td>
                            <td class="text-muted">2023/10/28</td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="#">수정</a>
                                <a class="dropdown-item" href="#">삭제</a>
                                <a class="dropdown-item" href="#">상세 정보</a>
                              </div>
                            </td>
                          </tr>
                        </c:forEach>
                        </tbody>
                      </table>
                      <nav aria-label="Table Paging" class="mb-0 text-muted">
                        <ul class="pagination justify-content-center mb-0">
                          <li class="page-item"><a class="page-link" href="#">이전</a></li>
                          <li class="page-item"><a class="page-link" href="#">1</a></li>
                          <li class="page-item active"><a class="page-link" href="#">2</a></li>
                          <li class="page-item"><a class="page-link" href="#">3</a></li>
                          <li class="page-item"><a class="page-link" href="#">다음</a></li>
                        </ul>
                      </nav>
                    </div>
                  </div>
                </div>
              </div>
            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
      </main>
    </div> <!-- .wrapper -->
<jsp:include page="../inn/footer.jsp"/>