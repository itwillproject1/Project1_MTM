<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="UTF-8">
  <head>
  	<link href="./employee/template/assets/images/titleIcon.ico" rel="shortcut icon" type="image/x-icon">
    <title>메인</title>
    
    <!-- Fonts CSS -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">   
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>메인</title>
    
    <!-- Simple bar CSS -->
    <link rel="stylesheet" href="./employee/template/css/simplebar.css">
    
    <!-- Icons CSS -->
    <link rel="stylesheet" href="./employee/template/css/feather.css">
    <link rel="stylesheet" href="./employee/template/css/select2.css">
    <link rel="stylesheet" href="./employee/template/css/dropzone.css">
    <link rel="stylesheet" href="./employee/template/css/uppy.min.css">
    <link rel="stylesheet" href="./employee/template/css/jquery.steps.css">
    <link rel="stylesheet" href="./employee/template/css/jquery.timepicker.css">
    <link rel="stylesheet" href="./employee/template/css/quill.snow.css">
    <!-- Date Range Picker CSS -->
    <link rel="stylesheet" href="./employee/template/css/daterangepicker.css">
    <!-- App CSS -->
    <link rel="stylesheet" href="./employee/template/css/app-light.css" id="lightTheme">
    <link rel="stylesheet" href="./employee/template/css/app-dark.css" id="darkTheme" disabled>
  </head>
  <body class="horizontal light  ">
  <c:if test="${empty emp_id}">
		<c:redirect url="./Login.empm"/>
  </c:if>
    <div class="wrapper">
      <nav class="navbar navbar-expand-lg navbar-light bg-white flex-row border-bottom shadow">
        <div class="container-fluid">
          <a class="navbar-brand mx-lg-1 mr-0" href="./Main.empm">
            <svg version="1.1" id="logo" class="navbar-brand-img brand-sm" xmlns="http://www.w3.org/2000/svg" shape-rendering="geometricPrecision" text-rendering="geometricPrecision" image-rendering="optimizeQuality" fill-rule="evenodd" clip-rule="evenodd" viewBox="0 0 512 331.617">
				<path fill-rule="nonzero" d="M271.099 21.308C274.787 6.304 289.956-2.873 304.96.815c15.005 3.688 24.181 18.857 20.493 33.862l-68.491 275.632c-3.689 15.005-18.857 24.181-33.862 20.493-15.005-3.688-24.181-18.857-20.493-33.862l68.492-275.632zm-118.45 224.344c11.616 10.167 12.795 27.834 2.628 39.45-10.168 11.615-27.835 12.794-39.45 2.627L9.544 194.604C-2.071 184.437-3.25 166.77 6.918 155.155c.873-.997 1.8-1.912 2.767-2.75l106.142-93.001c11.615-10.168 29.282-8.989 39.45 2.626 10.167 11.616 8.988 29.283-2.628 39.45l-82.27 72.086 82.27 72.086zm243.524 42.077c-11.615 10.167-29.282 8.988-39.45-2.627-10.167-11.616-8.988-29.283 2.628-39.45l82.27-72.086-82.27-72.086c-11.616-10.167-12.795-27.834-2.628-39.45 10.168-11.615 27.835-12.794 39.45-2.626l106.142 93.001a28.366 28.366 0 012.767 2.75c10.168 11.615 8.989 29.282-2.626 39.449l-106.283 93.125z"/>
              </svg>
          </a>
          <button class="navbar-toggler mt-2 mr-auto toggle-sidebar text-muted">
            <i class="fe fe-menu navbar-toggler-icon"></i>
          </button>
          <div class="navbar-slide bg-white ml-lg-4" id="navbarSupportedContent">
            <a href="#" class="btn toggle-sidebar d-lg-none text-muted ml-2 mt-3" data-toggle="toggle">
              <i class="fe fe-x"><span class="sr-only"></span></i>
            </a>
            <ul class="navbar-nav mr-auto">
              <li class="nav-item">
                <a class="nav-link" href="./EmployeeList.empm">
                  <span class="ml-lg-2">직원 목록</span>
                </a>
              </li>
              <li class="nav-item dropdown">
                <a href="#" id="userDropdown" class="dropdown-toggle nav-link" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <span class="ml-lg-2">유저 관리</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="userDropdown">
                  <a class="nav-link pl-lg-2" href="./UserList.empu"><span class="ml-1">유저 목록</span></a>
                  <a class="nav-link pl-lg-2" href="./InquiryList.empu"><span class="ml-1">문의 목록</span></a>
                  <a class="nav-link pl-lg-2" href="./ComplainList.empu"><span class="ml-1">신고 목록</span></a>
                  <a class="nav-link pl-lg-2" href="./TradeList.empu"><span class="ml-1">거래 현황</span></a>
                  <a class="nav-link pl-lg-2" href="./BoardList.empu"><span class="ml-1">게시판</span></a>
                </div>
              </li>
             <c:if test="${sessionScope.emp_id == 'admin'}">
             <li class="nav-item dropdown">
                <a href="#" id="adminDropdown" class="dropdown-toggle nav-link" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <span class="ml-lg-2">관리자</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="adminDropdown">
                  <a class="nav-link pl-lg-2" href="./EmployeeRegisterForm.empm"><span class="ml-1">직원 추가</span></a>
                  <a class="nav-link pl-lg-2" href="./EmployeeDeleteForm.empm"><span class="ml-1">직원 삭제</span></a>
                </div>
              </li>
             </c:if>
             <li class="nav-item dropdown more">
                <a href="#" id="elseDropdown" class="dropdown-toggle more-horizontal nav-link" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <span class="ml-lg-2"></span>
                </a>
                <div class="dropdown-menu" aria-labelledby="elseDropdown">
                  <a class="nav-link pl-lg-2" href="./EmployeeRegisterForm.empm"><span class="ml-1">마켓으로 이동</span></a>
                </div>
              </li>
            </ul>
          </div>
          <ul class="navbar-nav d-flex flex-row">
            <li class="nav-item">
              <a class="nav-link text-muted my-2" href="./#" id="modeSwitcher" data-mode="light">
                <i class="fe fe-sun fe-16"></i>
              </a>
            </li>
            <li class="nav-item dropdown ml-lg-0">
              <a class="nav-link dropdown-toggle text-muted" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="avatar avatar-sm mt-2">
                  <img src="./assets/avatars/face-1.jpg" alt="..." class="avatar-img rounded-circle">
                </span>
              </a>
              <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                <li class="nav-item">
                  <a class="nav-link pl-3" href="./ProfileContent.empm">프로필</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="./ProfileChangeForm.empm">프로필 편집</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="./LogoutAction.empm">로그아웃</a>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </nav>
      
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
                <!-- Recent Activity -->
                <div class="col-md-6 mb-4">
                  <div class="card shadow">
                    <div class="card-header">
                      <strong class="card-title float-left">메일</strong>
                      <a class="float-right small text-muted" href="./MailList.empm">View all</a>
                    </div>
                    <div class="card-body">
                      <div class="list-group list-group-flush my-n3">
                      <!-- foreach(3), 최근 메일부터 -->
                      
                        <div class="list-group-item">
                          <div class="row">
                            <div class="col-auto">
                              <div class="avatar avatar-sm mt-2">
                                <img src="${'프로필 이미지'}" alt="..." class="avatar-img rounded-circle">
                              </div>
                            </div>
                            <div class="col">
                              <small><strong>이름</strong></small>
                              <div class="my-0 text-muted small">내용</div>
                              <small class="badge badge-light text-muted">작성일자(시간포함)</small>
                            </div>
                          </div>
                          
                        </div> <!-- / .row -->
                      </div> <!-- / .list-group -->
                    </div> <!-- / .card-body -->
                  </div> <!-- / .card -->
                </div> <!-- / .col-md-3 -->
                <!-- Product List -->
                <div class="col-md-6 mb-4">
                  <div class="card shadow">
                    <div class="card-header">
                      <strong class="card-title">인기 거래 품목</strong>
                      <a class="float-right small text-muted" href="#!">View all</a>
                    </div>
                    <div class="card-body">
                      <div class="list-group list-group-flush my-n3">
                      <!-- 거래 테이블 참조, 이미지 불러오기, 4개 -->
                        <div class="list-group-item">
                          <div class="row align-items-center">
                            <div class="col-3 col-md-2">
                              <img src="${'물품 이미지'}" alt="..." class="thumbnail-sm">
                            </div>
                            <div class="col">
                              <strong>물품명</strong>
                              <div class="my-0 text-muted small">카테고리</div>
                            </div>
                            <div class="col-auto">
                              <strong>거래량(%)</strong>
                              <div class="progress mt-2" style="height: 4px;">
                                <div class="progress-bar" role="progressbar" style="width: 30%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div> <!-- / .list-group -->
                    </div> <!-- / .card-body -->
                  </div> <!-- / .card -->
                </div> <!-- / .col-md-3 -->
            </div>
              <div class="row">
                <!-- Recent orders -->
                <div class="col-md-12">
                  <h6 class="mb-3">최근 거래 이력</h6>
                  <a class="float-right small text-muted" href="./Main.empm">View all</a>
                  <table class="table table-borderless table-striped">
                    <thead>
                      <tr role="row">
                        <th>아이디</th>
                        <th>거래일</th>
                        <th>이름</th>
                        <th>전화번호</th>
                        <th>주소</th>
                        <th>Total</th>
                        <th>Payment</th>
                        <th>상태</th>
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
    <script src="./employee/template/js/jquery.min.js"></script>
    <script src="./employee/template/js/popper.min.js"></script>
    <script src="./employee/template/js/moment.min.js"></script>
    <script src="./employee/template/js/bootstrap.min.js"></script>
    <script src="./employee/template/js/simplebar.min.js"></script>
    <script src='./employee/template/js/daterangepicker.js'></script>
    <script src='./employee/template/js/jquery.stickOnScroll.js'></script>
    <script src="./employee/template/js/tinycolor-min.js"></script>
    <script src="./employee/template/js/config.js"></script>
    <script src="./employee/template/js/d3.min.js"></script>
    <script src="./employee/template/js/datamaps.all.min.js"></script>
    <script src="./employee/template/js/datamaps-zoomto.js"></script>
    <script src="./employee/template/js/datamaps.custom.js"></script>
    <script src="./employee/template/js/gauge.min.js"></script>
    <script src="./employee/template/js/jquery.sparkline.min.js"></script>
    <script src='./employee/template/js/jquery.mask.min.js'></script>
    <script src='./employee/template/js/jquery.steps.min.js'></script>
    <script src='./employee/template/js/jquery.validate.min.js'></script>
    <script src='./employee/template/js/jquery.timepicker.js'></script>
    <script src='./employee/template/js/dropzone.min.js'></script>
    <script src='./employee/template/js/quill.min.js'></script>
    <script src="./employee/template/js/apps.js"></script>
  </body>
</html>