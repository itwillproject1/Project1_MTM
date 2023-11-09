<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <body class="horizontal light  ">
    <div class="wrapper">
      <nav class="navbar navbar-expand-lg navbar-light bg-white flex-row border-bottom shadow">
        <div class="container-fluid">
          <a class="navbar-brand mx-lg-1 mr-0" href="./Main.emp">
            <svg version="1.1" id="logo" class="navbar-brand-img brand-sm" xmlns="http://www.w3.org/2000/svg" shape-rendering="geometricPrecision" text-rendering="geometricPrecision" image-rendering="optimizeQuality" fill-rule="evenodd" clip-rule="evenodd" viewBox="0 0 512 331.617">
				<path fill-rule="nonzero" d="M271.099 21.308C274.787 6.304 289.956-2.873 304.96.815c15.005 3.688 24.181 18.857 20.493 33.862l-68.491 275.632c-3.689 15.005-18.857 24.181-33.862 20.493-15.005-3.688-24.181-18.857-20.493-33.862l68.492-275.632zm-118.45 224.344c11.616 10.167 12.795 27.834 2.628 39.45-10.168 11.615-27.835 12.794-39.45 2.627L9.544 194.604C-2.071 184.437-3.25 166.77 6.918 155.155c.873-.997 1.8-1.912 2.767-2.75l106.142-93.001c11.615-10.168 29.282-8.989 39.45 2.626 10.167 11.616 8.988 29.283-2.628 39.45l-82.27 72.086 82.27 72.086zm243.524 42.077c-11.615 10.167-29.282 8.988-39.45-2.627-10.167-11.616-8.988-29.283 2.628-39.45l82.27-72.086-82.27-72.086c-11.616-10.167-12.795-27.834-2.628-39.45 10.168-11.615 27.835-12.794 39.45-2.626l106.142 93.001a28.366 28.366 0 012.767 2.75c10.168 11.615 8.989 29.282-2.626 39.449l-106.283 93.125z"/>
              </svg>
          </a>
          <button class="navbar-toggler mt-2 mr-auto toggle-sidebar text-muted">
            <i class="fe fe-menu navbar-toggler-icon"></i>
          </button>
          <div class="navbar-slide bg-white ml-lg-4" id="navbarSupportedContent" style="margin-right:auto;">
            <a href="#" class="btn toggle-sidebar d-lg-none text-muted ml-2 mt-3" data-toggle="toggle">
              <i class="fe fe-x"><span class="sr-only"></span></i>
            </a>
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="./EmployeeList.emp">
                  <span class="ml-lg-2">직원 목록</span>
                </a>
              </li>
              <li class="nav-item dropdown">
                <a href="#" id="userDropdown" class="dropdown-toggle nav-link" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <span class="ml-lg-2">유저 관리</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="userDropdown">
                  <a class="nav-link pl-lg-2" href="./UserList.emp"><span class="ml-1">유저 목록</span></a>
                  <a class="nav-link pl-lg-2" href="./InquiryList.emp"><span class="ml-1">문의 목록</span></a>
                  <a class="nav-link pl-lg-2" href="./ComplainList.emp"><span class="ml-1">신고 목록</span></a>
                  <a class="nav-link pl-lg-2" href="./TradeList.emp"><span class="ml-1">거래 현황</span></a>
                  <a class="nav-link pl-lg-2" href="./BoardList.emp"><span class="ml-1">게시판</span></a>
                </div>
              </li>
             <c:if test="${sessionScope.emp_id == 'admin'}">
             <li class="nav-item dropdown">
                <a href="#" id="adminDropdown" class="dropdown-toggle nav-link" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <span class="ml-lg-2">관리자</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="adminDropdown">
                  <a class="nav-link pl-lg-2" href="./EmployeeRegisterForm.emp"><span class="ml-1">직원 추가</span></a>
                  <a class="nav-link pl-lg-2" href="./EmployeeDeleteForm.emp"><span class="ml-1">직원 삭제</span></a>
                </div>
              </li>
             </c:if>
             <li class="nav-item dropdown more">
                <a href="#" id="elseDropdown" class="dropdown-toggle more-horizontal nav-link" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <span class="ml-lg-2"></span>
                </a>
                <div class="dropdown-menu" aria-labelledby="elseDropdown">
                  <a class="nav-link pl-lg-2" href="./EmployeeRegisterForm.emp"><span class="ml-1">마켓으로 이동</span></a>
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
                  <img src="./employee/template/assets/images/user.png" alt="..." class="avatar-img rounded-circle">
                </span>
              </a>
              <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                <li class="nav-item">
                  <a class="nav-link pl-3" href="./MemberProfile.emp">프로필</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="./ProfileChangeForm.emp">프로필 편집</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link pl-3" href="./LogoutAction.emp">로그아웃</a>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </nav>
   