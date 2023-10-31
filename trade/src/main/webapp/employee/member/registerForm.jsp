<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="UTF-8">
  <head>
  	<link href="./employee/template/assets/images/titleIcon.ico" rel="shortcut icon" type="image/x-icon">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>직원 추가</title>
    <!-- Simple bar CSS -->
    <link rel="stylesheet" href="./employee/template/css/simplebar.css">
    <!-- Fonts CSS -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">   
    <!-- Icons CSS -->
    <link rel="stylesheet" href="./employee/template/css/feather.css">
    <!-- Date Range Picker CSS -->
    <link rel="stylesheet" href="./employee/template/css/daterangepicker.css">
    <!-- App CSS -->
    <link rel="stylesheet" href="./employee/template/css/app-light.css" id="lightTheme">
    <link rel="stylesheet" href="./employee/template/css/app-dark.css" id="darkTheme" disabled>
  </head>
  <body class="vertical  light  ">
  <c:if test="${empty emp_id or emp_id != 'admin'}">
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
              <a class="dropdown-item" href="./Profile.empm">프로필</a>
              <a class="dropdown-item" href="./MailList.empm">메일</a>
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
              <a class="nav-link" href="./main.empm">
                <i class="fe fe-home fe-16"></i>
                <span class="ml-3 item-text">메인</span>
              </a>
            </li>
          </ul>
          <p class="text-muted nav-heading mt-4 mb-1">
            <span>기본 메뉴</span>
          </p>
          <ul class="navbar-nav flex-fill w-100 mb-2">
          	<li class="nav-item w-100">
            	<a class="nav-link" href="./profile.empm">
                	<i class="fe fe-user fe-16"></i>
                	<span class="ml-3 item-text">프로필</span>
              	</a>
            </li>
            <li class="nav-item w-100">
            	<a class="nav-link" href="./profile.empm">
                	<i class="fe fe-mail fe-16"></i>
                	<span class="ml-3 item-text">메일</span>
              	</a>
            </li>
          </ul>     
          <p class="text-muted nav-heading mt-4 mb-1">
            <span>유저 관리</span>
          </p>
          <ul class="navbar-nav flex-fill w-100 mb-2">
          	<li class="nav-item w-100">
            	<a class="nav-link" href="./profile.empm">
                	<i class="fe fe-users fe-16"></i>
                	<span class="ml-3 item-text">유저 목록</span>
              	</a>
            </li>
            <li class="nav-item w-100">
            	<a class="nav-link" href="./profile.empm">
                	<i class="fe fe-help-circle fe-16"></i>
                	<span class="ml-3 item-text">1:1 문의</span>
              	</a>
            </li>
            <li class="nav-item w-100">
            	<a class="nav-link" href="./profile.empm">
                	<i class="fe fe-thumbs-down fe-16"></i>
                	<span class="ml-3 item-text">신고 현황</span>
              	</a>
            </li>
            <li class="nav-item w-100">
            	<a class="nav-link" href="./profile.empm">
                	<i class="fe fe-refresh-ccw fe-16"></i>
                	<span class="ml-3 item-text">거래 현황</span>
              	</a>
            </li>
            <li class="nav-item w-100">
            	<a class="nav-link" href="./profile.empm">
                	<i class="fe fe-align-left fe-16"></i>
                	<span class="ml-3 item-text">게시판</span>
              	</a>
            </li>
          </ul>
          
          <p class="text-muted nav-heading mt-4 mb-1">
            <span>테이블 관리</span>
          </p>
          <ul class="navbar-nav flex-fill w-100 mb-2">
			<li class="nav-item w-100">
            	<a class="nav-link" href="./profile.empm">
                	<i class="fe fe-layers fe-16"></i>
                	<span class="ml-3 item-text">유저 테이블</span>
              	</a>
            </li>
            
            <li class="nav-item w-100">
            	<a class="nav-link" href="./profile.empm">
                	<i class="fe fe-credit-card fe-16"></i>
                	<span class="ml-3 item-text">거래 테이블</span>
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
                <li class="nav-item">
                  <a class="nav-link pl-3" href="./EmployeeRegisterForm.empm">
                    <span class="ml-1 item-text">직원 추가</span>
                  </a>
                </li>
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
              <i class="fe fe-shopping-cart fe-12 mx-2"></i><span class="small">사용자 페이지로</span>
            </a>
          </div>
        </nav>
      </aside>
	<main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
            <h2 class="page-title">직원 추가</h2>
              <p class="text-muted">Demo for form control styles, layout options, and custom components for creating a wide variety of forms.</p>
              <div class="card shadow mb-4">
                <div class="card-header">
                  <strong class="card-title">Form controls</strong>
                </div>
                <div class="card-body">
                  <div class="row">
                    <div class="col-md-6">
                      <div class="form-group mb-3">
                        <label for="simpleinput">Text</label>
                        <input type="text" id="simpleinput" class="form-control">
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-email">Email</label>
                        <input type="email" id="example-email" name="example-email" class="form-control" placeholder="Email">
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-password">Password</label>
                        <input type="password" id="example-password" class="form-control" value="password">
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-palaceholder">Placeholder</label>
                        <input type="text" id="example-palaceholder" class="form-control" placeholder="placeholder">
                      </div>
                    </div> <!-- /.col -->
                    <div class="col-md-6">
                      <div class="form-group mb-3">
                        <label for="example-helping">Helping text</label>
                        <input type="text" id="example-helping" class="form-control" placeholder="Input with helping text">
                        <span class="help-block"><small>A block of help text that breaks onto a new line.</small></span>
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-readonly">Readonly</label>
                        <input type="text" id="example-readonly" class="form-control" readonly="" value="Readonly value">
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-disable">Disabled</label>
                        <input type="text" class="form-control" id="example-disable" disabled="" value="Disabled value">
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-static">Static control</label>
                        <input type="text" readonly="" class="form-control-plaintext" id="example-static" value="j@example.com">
                      </div>
                    </div>
                  </div>
                </div>
              </div> <!-- / .card -->
              <div class="row">
                <div class="col-md-6 mb-4">
                  <div class="card shadow">
                    <div class="card-body">
                      <div class="form-group mb-3">
                        <label for="example-textarea">Text area</label>
                        <textarea class="form-control" id="example-textarea" rows="4"></textarea>
                      </div>
                    </div> <!-- /.card-body -->
                  </div> <!-- /.card -->
                </div> <!-- /.col -->
                <div class="col-md-6 mb-4">
                  <div class="card shadow">
                    <div class="card-body">
                      <div class="form-group mb-3">
                        <div class="form-group mb-3">
                          <label for="example-fileinput">Default file input</label>
                          <input type="file" id="example-fileinput" class="form-control-file">
                        </div>
                        <div class="form-group mb-3">
                          <label for="customFile">Custom file input</label>
                          <div class="custom-file">
                            <input type="file" class="custom-file-input" id="customFile">
                            <label class="custom-file-label" for="customFile">Choose file</label>
                          </div>
                        </div>
                      </div>
                    </div> <!-- /.card-body -->
                  </div> <!-- /.card -->
                </div> <!-- /.col -->
                <div class="col-md-6 mb-4">
                  <div class="card shadow">
                    <div class="card-body">
                      <div class="form-group mb-3">
                        <label for="example-select">Input Select</label>
                        <select class="form-control" id="example-select">
                          <option>1</option>
                          <option>2</option>
                          <option>3</option>
                          <option>4</option>
                          <option>5</option>
                        </select>
                      </div>
                      <div class="form-group mb-3">
                        <label for="example-multiselect">Multiple Select</label>
                        <select id="example-multiselect" multiple="" class="form-control">
                          <option>1</option>
                          <option>2</option>
                          <option>3</option>
                          <option>4</option>
                          <option>5</option>
                        </select>
                      </div>
                    </div> <!-- /.card-body -->
                  </div> <!-- /.card -->
                </div> <!-- /.col -->
                <div class="col-md-6 mb-4">
                  <div class="card shadow">
                    <div class="card-body">
                      <div class="form-group mb-3">
                        <label for="custom-select">Custom Select</label>
                        <select class="custom-select" id="custom-select">
                          <option selected>Open this select menu</option>
                          <option value="1">One</option>
                          <option value="2">Two</option>
                          <option value="3">Three</option>
                        </select>
                      </div>
                      <div class="form-group mb-3">
                        <label for="custom-multiselect">Custom Multiple Select</label>
                        <select class="custom-select" multiple id="custom-multiselect">
                          <option selected>Open this select menu</option>
                          <option value="1">One</option>
                          <option value="2">Two</option>
                          <option value="3">Three</option>
                        </select>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-6 mb-4">
                  <div class="card shadow">
                    <div class="card-body">
                      <p class="mb-2"><strong>Checkboxes</strong></p>
                      <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                        <label class="form-check-label" for="defaultCheck1"> Default checkbox </label>
                      </div>
                      <div class="form-check mb-2">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck3" disabled>
                        <label class="form-check-label" for="defaultCheck3"> Disabled checkbox </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                        <label class="form-check-label" for="inlineCheckbox1">1</label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                        <label class="form-check-label" for="inlineCheckbox2">2</label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3" disabled>
                        <label class="form-check-label" for="inlineCheckbox3">3 (disabled)</label>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-6 mb-4">
                  <div class="card shadow">
                    <div class="card-body">
                      <p class="mb-2"><strong>Custom checkboxes</strong></p>
                      <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="customCheck1">
                        <label class="custom-control-label" for="customCheck1">Check this first custom checkbox</label>
                      </div>
                      <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="customCheck2">
                        <label class="custom-control-label" for="customCheck2">Check this secondary custom checkbox</label>
                      </div>
                      <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="customCheck1-1" disabled checked>
                        <label class="custom-control-label" for="customCheck1">Disabled custom checkbox</label>
                      </div>
                    </div> <!-- / .card-body -->
                  </div> <!-- / .card -->
                </div> <!-- /. col -->
                <div class="col-md-6 mb-4">
                  <div class="card shadow">
                    <div class="card-body">
                      <p class="mb-2"><strong>Default radio</strong></p>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
                        <label class="form-check-label" for="exampleRadios1"> This is default radio </label>
                      </div>
                      <div class="form-check mb-2">
                        <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios3" value="option3" disabled>
                        <label class="form-check-label" for="exampleRadios3"> Disabled radio </label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                        <label class="form-check-label" for="inlineRadio1">1</label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
                        <label class="form-check-label" for="inlineRadio2">2</label>
                      </div>
                      <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3" disabled>
                        <label class="form-check-label" for="inlineRadio3">3 (disabled)</label>
                      </div>
                    </div> <!-- /.card-body -->
                  </div> <!-- /.card -->
                </div> <!-- /.col -->
                <div class="col-md-6 mb-4">
                  <div class="card shadow">
                    <div class="card-body">
                      <p class="mb-2"><strong>Custom Radios</strong></p>
                      <div class="custom-control custom-radio">
                        <input type="radio" id="customRadio1" name="customRadio" class="custom-control-input">
                        <label class="custom-control-label" for="customRadio1">Toggle this custom radio</label>
                      </div>
                      <div class="custom-control custom-radio">
                        <input type="radio" id="customRadio2" name="customRadio" class="custom-control-input" checked>
                        <label class="custom-control-label" for="customRadio2">Or toggle this other custom radio</label>
                      </div>
                      <div class="custom-control custom-radio">
                        <input type="radio" name="radioDisabled" id="customRadioDisabled2" class="custom-control-input" disabled>
                        <label class="custom-control-label" for="customRadioDisabled2">Disabled this custom radio</label>
                      </div>
                    </div> <!-- /.card-body -->
                  </div> <!-- /.card -->
                </div> <!-- /.col -->
                <div class="col-md-12 mb-4">
                  <div class="card shadow">
                    <div class="card-header">
                      <strong class="card-title">Sizing</strong>
                    </div>
                    <div class="card-body">
                      <div class="form-group">
                        <input class="form-control form-control-lg" type="text" placeholder=".form-control-lg">
                      </div>
                      <div class="form-group">
                        <input class="form-control" type="text" placeholder="Default input">
                      </div>
                      <div class="form-group">
                        <input class="form-control form-control-sm" type="text" placeholder=".form-control-sm">
                      </div>
                    </div>
                  </div>
                </div>
              </div> <!-- end section -->
            </div> <!-- .col-12 -->
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