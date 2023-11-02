<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/databaseList.jsp"/>
<head><title>신고 목록</title></head>
<jsp:include page="../inn/navbar.jsp"/>
      <main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <div class="row">
                <!-- Small table -->
                <div class="col-md-12 my-4">
                  <h2 class="h4 mb-1">신고 목록</h2>
                  <div class="card shadow">
                    <div class="card-body">
                      <div class="toolbar">
                        <form class="form">
                          <div class="form-row">
                            <div class="form-group col-auto mr-auto">
                              <label class="my-1 mr-2 sr-only" for="inlineFormCustomSelectPref1">Show</label>
                              <select class="custom-select mr-sm-2" id="inlineFormCustomSelectPref1">
                                <option value="">...</option>
                                <option value="1">12</option>
                                <option value="2" selected>32</option>
                                <option value="3">64</option>
                                <option value="3">128</option>
                              </select>
                            </div>
                            <div class="form-group col-auto">
                              <label for="search" class="sr-only">Search</label>
                              <input type="text" class="form-control" id="search1" value="" placeholder="Search">
                            </div>
                          </div>
                        </form>
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
                            <th><!-- 유저 프로필 이미지 --></th>
                            <th>이름(별명)</th>
                            <th>신고자</th>
                            <th>신고 사유</th>
                            <th class="w-25">신고 내용</th>
                            <th>일자</th>
                            <th>기타</th>
                          </tr>
                        </thead>
                        <tbody>
                        <!-- foreach 진행 -->
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="2474">
                                <label class="custom-control-label" for="2474"></label>
                              </div>
                            </td>
                            <td>
                              <div class="avatar avatar-md">
                                <img src="./assets/avatars/face-3.jpg" alt="..." class="avatar-img rounded-circle">
                              </div>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><strong>아이디</strong></p>
                              <small class="mb-0 text-muted">이름</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted">아이디</p>
                              <small class="mb-0 text-muted">이름</small>
                            </td>
                            <td>
                              <p class="mb-0 text-muted"><a href="#" class="text-muted">(958) 421-0798</a></p>
                              <small class="mb-0 text-muted">Nigeria</small>
                            </td>
                            <td class="w-25"><small class="text-muted"> 문의 내용(몇 자 잘라서 내기) </small></td>
                            <td class="text-muted">2023/11/01</td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="#">Edit</a>
                                <a class="dropdown-item" href="#">Remove</a>
                                <a class="dropdown-item" href="#">Assign</a>
                              </div>
                            </td>
                          </tr>

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
                </div> <!-- customized table -->
              </div> <!-- end section -->
            </div>
          </div>
        </div>
      </main>
    </div>
<jsp:include page="../inn/footer.jsp"/>