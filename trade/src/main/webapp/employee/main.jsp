<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./inn/head/main.jsp"/>
<jsp:include page="./inn/navbar.jsp"/>
      <!-- 메인(데이터가 쌓일 때 진행) -->
	<main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <div class="row">
                <div class="col-md-6 col-xl-3 mb-4">
                  <div class="card shadow bg-primary text-white border-0">
                    <div class="card-body">
                      <div class="row align-items-center">
                        <div class="col-3 text-center">
                          <span class="circle circle-sm bg-primary-light">
                            <i class="fe fe-16 fe-shopping-bag text-white mb-0"></i>
                          </span>
                        </div>
                        <div class="col pr-0">
                        <!-- 수수료 수입 -->
                          <p class="small text-muted mb-0">수입</p>
                          <span class="h3 mb-0 text-white">￦50000</span>
                          <span class="small text-muted">+5.5%</span>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-6 col-xl-3 mb-4">
                  <div class="card shadow border-0">
                    <div class="card-body">
                      <div class="row align-items-center">
                        <div class="col-3 text-center">
                          <span class="circle circle-sm bg-primary">
                            <i class="fe fe-16 fe-shopping-cart text-white mb-0"></i>
                          </span>
                        </div>
                        <div class="col pr-0">
                        <!-- 거래 수(count, where(date)) -->
                          <p class="small text-muted mb-0">거래 수</p>
                          <span class="h3 mb-0">1,869</span>
                          <span class="small text-success">+16.5%</span>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                
                <div class="col-md-6 col-xl-3 mb-4">
                  <div class="card shadow border-0">
                    <div class="card-body">
                      <div class="row align-items-center">
                        <div class="col-3 text-center">
                          <span class="circle circle-sm bg-primary">
                            <i class="fe fe-16 fe-filter text-white mb-0"></i>
                          </span>
                        </div>
                        <div class="col">
                        <!-- 가입자 수 -->
                          <p class="small text-muted mb-0">가입자 수</p>
                          <div class="row align-items-center no-gutters">
                            <div class="col-auto">
                              <span class="h3 mr-2 mb-0"> 200 </span>
                            </div>
                            <div class="col-md-12 col-lg">
                              <div class="progress progress-sm mt-2" style="height:3px">
                                <div class="progress-bar bg-success" role="progressbar" style="width: 87%" aria-valuenow="87" aria-valuemin="0" aria-valuemax="100"></div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-6 col-xl-3 mb-4">
                  <div class="card shadow border-0">
                    <div class="card-body">
                      <div class="row align-items-center">
                        <div class="col-3 text-center">
                          <span class="circle circle-sm bg-primary">
                            <i class="fe fe-16 fe-activity text-white mb-0"></i>
                          </span>
                        </div>
                        <div class="col">
                        <!-- 방문자 수 -->
                          <p class="small text-muted mb-0">방문자 수</p>
                          <span class="h3 mb-0">80</span>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div> <!-- end section -->
              <div class="row">
                <!-- Recent orders -->
                <div class="col-md-12">
                  <h6 class="mb-3">최근 거래 이력</h6>
                  <a class="float-right small text-muted" href="./Main.emp">View all</a>
                  <table class="table table-borderless table-striped">
                    <thead>
                      <tr role="row">
                        <th>아이디</th>
                        <th>등록일</th>
                        <th>이름</th>
                        <th>주소</th>
                        <th>카테고리</th>
                        <th>제목</th>
                        <th>상태</th>
                        <th>거래자</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                    <!-- 데이터 목록(최대 10개) -->
                      <tr>
                        <th scope="col">1331</th>
                        <td>2020-12-26 01:32:21</td>
                        <td>Kasimir Lindsey</td>
                        <td>(697) 486-2101</td>
                        <td>996-3523 Et Ave</td>
                        <td>$3.64</td>
                        <td> Paypal</td>
                        <td>Shipped</td>
                        <td>
                          <div class="dropdown">
                            <button class="btn btn-sm dropdown-toggle more-vertical" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              <span class="text-muted sr-only">Action</span>
                            </button>
                            <div class="dropdown-menu dropdown-menu-right">
                              <a class="dropdown-item" href="#">Edit</a>
                              <a class="dropdown-item" href="#">Remove</a>
                              <a class="dropdown-item" href="#">Assign</a>
                            </div>
                          </div>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div> <!-- / .col-md-3 -->
              </div> <!-- end section -->
            </div>
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
      </main> <!-- main -->
    </div> <!-- .wrapper -->
<jsp:include page="./inn/footer.jsp"/>