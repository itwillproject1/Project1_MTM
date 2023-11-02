<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<jsp:include page="../inn/head/registerForm.jsp"/>
<jsp:include page="../inn/navbar.jsp"/>
<!-- 메인 -->
      <main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <div class="row">
                <div class="col-md-8" style="margin:auto; margin-top:100px;">
                  <div class="card shadow mb-4">
                    <div class="card-header">
                      <strong class="card-title">직원 추가</strong>
                    </div>
                    <div class="card-body">
                      <form action="./EmployeeRegisterAction.emp" method="post">
                      <div class="form-row">
                          <div class="form-group col-md-6">
                            <label for="inputId">사번</label>
                            <input type="text" name="emp_id" class="form-control" id="inputId">
                          </div>
                          <div class="form-group col-md-6">
                            <label for="inputName">이름</label>
                            <input type="text" name="name" class="form-control" id="inputName">
                          </div>
                        </div>
                        <div class="form-row">
                          <div class="form-group col-md-6">
                            <label for="inputEmail">이메일</label>
                            <input type="email" name="email" class="form-control" id="inputEmail">
                          </div>
                          <div class="form-group col-md-6">
                            <label for="inputPassword">비밀번호</label>
                            <input type="password" name="emp_pw" class="form-control" id="inputPassword">
                          </div>
                        </div>
                        <div class="form-row">
                          <div class="form-group col-md-6">
                            <label for="inputTel">전화번호</label>
                            <input type="tel" class="form-control" id="inputTel">
                          </div>
                          <div class="form-group col-md-6">
                            <label for="inputAddress">주소</label>
                            <input type="text" class="form-control" id="inputAddress">
                          </div>
                        </div>
                        <div class="form-row">
                        	<div class="form-group col-md-6">
                        		<label for="joinDate">입사일</label>
                        		<input class="form-control" id="joinDate" type="date" name="join_date">
                      		</div>
                          <div class="custom-file col-md-6">
                            <label for="fileinput">프로필 이미지</label>
                          <input type="file" id="fileinput" class="form-control-file">
                          </div>
                        </div>
                        <br />
                        <button type="submit" class="btn btn-primary">추가</button>
                        <button type="button" class="btn btn-secondary" onclick="history.back();">뒤로가기</button>
                      </form>
                    </div> <!-- /. card-body -->
                  </div> <!-- /. card -->
                </div> <!-- /. col -->
              </div> <!-- /. end-section -->
            </div> <!-- .col-12 -->
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
      </main> <!-- main -->
    </div> <!-- .wrapper -->
<jsp:include page="../inn/footer.jsp"/>