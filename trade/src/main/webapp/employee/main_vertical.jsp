<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="UTF-8">
  <head>
  	<link href="./employee/template/assets/images/titleIcon.ico" rel="shortcut icon" type="image/x-icon">
    <title>메인</title>
    <meta charset="utf-8">
    <!-- Fonts CSS -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">   
    
    <!-- 아래 CSS는 템플릿에서 복사 후 진행 -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <!-- Simple bar CSS -->
    <link rel="stylesheet" href="./employee/template/css/simplebar.css">
    <!-- Icons CSS -->
    <link rel="stylesheet" href="./employee/template/css/feather.css">
    <!-- Date Range Picker CSS -->
    <link rel="stylesheet" href="./employee/template/css/daterangepicker.css">
    <!-- App CSS -->
    <link rel="stylesheet" href="./employee/template/css/app-light.css" id="lightTheme">
    <link rel="stylesheet" href="./employee/template/css/app-dark.css" id="darkTheme" disabled>
  </head>
  <body class="vertical  light  ">
  <c:if test="${empty emp_id}">
		<c:redirect url="./Login.empm"/>
  </c:if>
    <div class="wrapper">
      <nav class="topnav navbar navbar-light">
        <button type="button" class="navbar-toggler text-muted mt-2 p-0 mr-3 collapseSidebar">
          <i class="fe fe-menu navbar-toggler-icon"></i>
        </button>
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link text-muted my-2" href="#" id="modeSwitcher" data-mode="light">
              <i class="fe fe-sun fe-16"></i>
            </a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle text-muted pr-0" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="avatar avatar-sm mt-2">
                <img src="./assets/avatars/face-1.jpg" alt="..." class="avatar-img rounded-circle">
              </span>
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
              <a class="dropdown-item" href="./ProfileContent.empm">프로필</a>
              <a class="dropdown-item" href="./ProfileChangeForm.empm">프로필 편집</a>
              <a class="dropdown-item" href="./LogoutAction.empm">로그아웃</a>
            </div>
          </li>
        </ul>
      </nav>
      <aside class="sidebar-left border-right bg-white shadow" id="leftSidebar" data-simplebar>
        <a href="#" class="btn collapseSidebar toggle-btn d-lg-none text-muted ml-2 mt-3" data-toggle="toggle">
          <i class="fe fe-x"><span class="sr-only"></span></i>
        </a>
        <nav class="vertnav navbar navbar-light">
          <!-- nav bar -->
          <div class="w-100 mb-4 d-flex">
            <a class="navbar-brand mx-auto mt-2 flex-fill text-center" href="./Main.empm">
            <!-- SVG 이미지 불러오기 -->
              <svg version="1.1" id="logo" class="navbar-brand-img brand-sm" xmlns="http://www.w3.org/2000/svg" shape-rendering="geometricPrecision" text-rendering="geometricPrecision" image-rendering="optimizeQuality" fill-rule="evenodd" clip-rule="evenodd" viewBox="0 0 512 331.617">
				<path fill-rule="nonzero" d="M271.099 21.308C274.787 6.304 289.956-2.873 304.96.815c15.005 3.688 24.181 18.857 20.493 33.862l-68.491 275.632c-3.689 15.005-18.857 24.181-33.862 20.493-15.005-3.688-24.181-18.857-20.493-33.862l68.492-275.632zm-118.45 224.344c11.616 10.167 12.795 27.834 2.628 39.45-10.168 11.615-27.835 12.794-39.45 2.627L9.544 194.604C-2.071 184.437-3.25 166.77 6.918 155.155c.873-.997 1.8-1.912 2.767-2.75l106.142-93.001c11.615-10.168 29.282-8.989 39.45 2.626 10.167 11.616 8.988 29.283-2.628 39.45l-82.27 72.086 82.27 72.086zm243.524 42.077c-11.615 10.167-29.282 8.988-39.45-2.627-10.167-11.616-8.988-29.283 2.628-39.45l82.27-72.086-82.27-72.086c-11.616-10.167-12.795-27.834-2.628-39.45 10.168-11.615 27.835-12.794 39.45-2.626l106.142 93.001a28.366 28.366 0 012.767 2.75c10.168 11.615 8.989 29.282-2.626 39.449l-106.283 93.125z"/>
              </svg>
            </a>
          </div>
          <ul class="navbar-nav flex-fill w-100 mb-2">
             <li class="nav-item w-100">
              <a class="nav-link" href="./Main.empm">
                <i class="fe fe-home fe-16"></i>
                <span class="ml-3 item-text">메인</span>
              </a>
            </li>
          </ul>
          <p class="text-muted nav-heading mt-4 mb-1">
            <span>기본 메뉴</span>
          </p>
          <ul class="navbar-nav flex-fill w-100 mb-2">
          
          <!-- 직원 목록, 프로필 수정(본인 전용), 추가 및 삭제(관리자 전용) -->
          	<li class="nav-item w-100">
            	<a class="nav-link" href="./EmployeeList.empm">
                	<i class="fe fe-user fe-16"></i>
                	<span class="ml-3 item-text">직원 목록</span>
              	</a>
            </li>
            
            <!-- 내부 게시판 목록, 추가 및 수정, 삭제 -->
            <!-- 공지사항, 이벤트 게시판 끝나면 수정하고 복사 -->
            <li class="nav-item w-100">
            	<a class="nav-link" href="./InnerBoard.empm">
                	<i class="fe fe-edit fe-16"></i>
                	<span class="ml-3 item-text">내부 게시판</span>
              	</a>
            </li>
          </ul>
          
          <p class="text-muted nav-heading mt-4 mb-1">
            <span>유저 관리</span>
          </p>
          <ul class="navbar-nav flex-fill w-100 mb-2">
          
          <!-- 유저 목록 : 유저 관리 및 수정, 삭제 -->
          	<li class="nav-item w-100">
            	<a class="nav-link" href="./UserList.empu">
                	<i class="fe fe-users fe-16"></i>
                	<span class="ml-3 item-text">유저 목록</span>
              	</a>
            </li>
            
            <!-- 문의 리스트, 문의 상세, 처리 -->
            <li class="nav-item w-100">
            	<a class="nav-link" href="./InquiryList.empu">
                	<i class="fe fe-help-circle fe-16"></i>
                	<span class="ml-3 item-text">1:1 문의</span>
              	</a>
            </li>
            
            <!-- 신고 리스트, 신고 상세, 처리 -->
            <li class="nav-item w-100">
            	<a class="nav-link" href="./ComplainList.empu">
                	<i class="fe fe-thumbs-down fe-16"></i>
                	<span class="ml-3 item-text">신고 현황</span>
              	</a>
            </li>
            
            <!-- 거래 리스트, 거래 상세, 처리, 현황 조회 -->
            <li class="nav-item w-100">
            	<a class="nav-link" href="./TradeList.empu">
                	<i class="fe fe-refresh-ccw fe-16"></i>
                	<span class="ml-3 item-text">거래 현황</span>
              	</a>
            </li>
            
            <!-- 공지사항, 이벤트 리스트, 추가, 수정 및 삭제, 조회 수 표시 -->
            <li class="nav-item w-100">
            	<a class="nav-link" href="./BoardList.empm">
                	<i class="fe fe-align-left fe-16"></i>
                	<span class="ml-3 item-text">게시판</span>
              	</a>
            </li>
          </ul>

          <c:if test="${sessionScope.emp_id == 'admin'}">
          <p class="text-muted nav-heading mt-4 mb-1">
            <span>기타</span>
          </p>
          <ul class="navbar-nav flex-fill w-100 mb-2">
            <li class="nav-item dropdown">
              <a href="#pages" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link">
                <i class="fe fe-alert-circle fe-16"></i>
                <span class="ml-3 item-text">관리자</span>
              </a>
              <ul class="collapse list-unstyled pl-4 w-100 w-100" id="pages">
              
                <!-- EmployeeList.emp에서도 진행되는 페이지, 추가 -->
                <li class="nav-item">
                  <a class="nav-link pl-3" href="./EmployeeRegisterForm.empm">
                    <span class="ml-1 item-text">직원 추가</span>
                  </a>
                </li>
                
                <!-- EmployeeList.emp에서도 진행되는 페이지, 삭제 -->
                <li class="nav-item">
                  <a class="nav-link pl-3" href="./EmployeeDeleteForm.empm">
                    <span class="ml-1 item-text">직원 삭제</span>
                  </a>
                </li>
              </ul>  
            </li>
          </ul>
          </c:if>
          <div class="btn-box w-100 mt-4 mb-1">
            <a href="./Main.com" target="_blank" class="btn mb-2 btn-primary btn-lg btn-block">
              <i class="fe fe-shopping-cart fe-12 mx-2"></i><span class="small">마켓으로 이동</span>
            </a>
          </div>
        </nav>
      </aside>
      
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
    <!-- 아래 스크립트는 복사 후 진행 -->
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
    <script>
      /* defind global options */
      Chart.defaults.global.defaultFontFamily = base.defaultFontFamily;
      Chart.defaults.global.defaultFontColor = colors.mutedColor;
    </script>
    <script src="./employee/template/js/gauge.min.js"></script>
    <script src="./employee/template/js/jquery.sparkline.min.js"></script>
    <script src="./employee/template/js/apexcharts.min.js"></script>
    <script src="./employee/template/js/apexcharts.custom.js"></script>
    <script src="./employee/template/js/apps.js"></script>
    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-56159088-1"></script>
    <script>
      window.dataLayer = window.dataLayer || [];

      function gtag()
      {
        dataLayer.push(arguments);
      }
      gtag('js', new Date());
      gtag('config', 'UA-56159088-1');
    </script>
  </body>
</html>