<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./inn/head/main.jsp"/>
<title>메인</title>
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
                            <i class="fe fe-16 fe-pie-chart text-white mb-0"></i>
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
                          <span class="h3 mb-0">${tradeCount}</span>
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
                            <i class="fe fe-16 fe-users text-white mb-0"></i>
                          </span>
                        </div>
                        <div class="col">
                        <!-- 가입자 수 -->
                          <p class="small text-muted mb-0">회원 수</p>
                          <div class="row align-items-center no-gutters">
                            <div class="col-auto">
                              <span class="h3 mr-2 mb-0">${userCount}</span>
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
                  <a class="float-right small text-muted" href="./TradeList.emp">더 보기</a>
                  <table class="table table-borderless table-striped">
                    <thead>
                      <tr role="row">
                        <th>아이디</th>
                        <th>거래타입</th>
                        <th>등록일</th>
                        <th>브랜드</th>
                        <th>카테고리</th>
                        <th>제목</th>
                        <th style="text-align:center;">가격(￦)</th>
                        <th style="text-align:center">조회수</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                    <!-- 데이터 목록(최대 10개) -->
                      <c:forEach items="${tradeList}" var="i" >
                      <tr>
                        <th scope="col">${i.user_id}</th>
                        <td>${i.deal_way}</td>
                        <td>${i.date_time}</td>
                        <td>${i.brand}</td>
                        <td>${i.category}</td>
                        <td>${i.title}</td>
                        <td style="text-align:right;"><fmt:formatNumber type="number" maxFractionDigits="3" value="${i.price}"/></td>
                        <td style="text-align:center">${i.views}</td>
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
                      </c:forEach>
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