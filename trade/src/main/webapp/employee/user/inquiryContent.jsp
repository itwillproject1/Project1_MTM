<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/main.jsp"/>
<jsp:include page="../inn/navbar.jsp"/>
<main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <div class="row align-items-center mb-4">
                <div class="col">
                  <h2 class="h5 page-title"><small class="text-muted text-uppercase">문의</small><br>${dto.bno}</h2>
                </div>
                <div class="col-auto">
                  <button type="button" class="btn btn-secondary">뒤로가기</button>
                  <button type="button" class="btn btn-primary">Assign</button>
                </div>
              </div> <!-- .row -->
              <div class="row my-4">
                <div class="col-md-9">
                  <div class="card shadow mb-4">
                    <div class="card-header">
                      <strong class="card-title">${dto.subject}</strong>
                      <span class="float-right"><i class="fe fe-flag mr-2"></i><span class="badge badge-pill badge-success text-white">${dto.category}</span></span>
                    </div>
                    <div class="card-body">
                      <dl class="row align-items-center mb-0">
                        <dt class="col-sm-2 mb-3 text-muted">질문자</dt>
                        <dd class="col-sm-4 mb-3">
                          <strong>${dto.user_id}</strong>
                        </dd>
                        <dt class="col-sm-2 mb-3 text-muted">답변자</dt>
                        <dd class="col-sm-4 mb-3">
                          <strong>${dto.emp_id}</strong>
                        </dd>
                      </dl>
                      <dl class="row mb-0">
                        <dt class="col-sm-2 mb-3 text-muted">Plan</dt>
                        <dd class="col-sm-4 mb-3">Basic</dd>
                        <dt class="col-sm-2 mb-3 text-muted">Department</dt>
                        <dd class="col-sm-4 mb-3">Support</dd>
                        <dt class="col-sm-2 mb-3 text-muted">Priority</dt>
                        <dd class="col-sm-4 mb-3">
                          <span class="badge badge-pill badge-danger">High</span>
                          <div class="dropdown d-inline">
                            <button class="btn btn-sm p-0 dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              <span class="sr-only">Change Priority</span>
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                              <a class="dropdown-item" href="#">High</a>
                              <a class="dropdown-item" href="#">Meddium</a>
                              <a class="dropdown-item" href="#">Low</a>
                            </div>
                          </div>
                        </dd>
                        <dt class="col-sm-2 mb-3 text-muted">답변 상태</dt>
                        <dd class="col-sm-4 mb-3">
                          <span class="dot dot-md bg-warning mr-2"></span> Open
                        </dd>
                        <dt class="col-sm-2 mb-3 text-muted">문의 일자</dt>
                        <dd class="col-sm-4 mb-3">${dto.uploadDate}</dd>
                        <dt class="col-sm-2 mb-3 text-muted">답변일자</dt>
                        <dd class="col-sm-4 mb-3">${dto.answerDate}</dd>
                        <dt class="col-sm-2 text-muted">내용</dt>
                        <dd class="col-sm-10"> ${dto.content} </dd>
                      </dl>
                    </div> <!-- .card-body -->
                  </div> <!-- .card -->
                  <div class="card shadow mb-4">
                    <div class="card-body">
                      <div class="row align-items-center mb-4">
                        <div class="col-auto">
                          <div class="avatar avatar-sm mb-3 mx-4">
                            <img src="./assets/avatars/face-3.jpg" alt="..." class="avatar-img rounded-circle">
                          </div>
                        </div>
                        <div class="col">
                          <strong>${dto.user_id}</strong>
                          <div class="mb-2">${dto.content}</div>
                           <c:if test="${dto.image == null}"></c:if>
                          <c:if test="${dto.image != null}">
                          <div class="card mb-3 bg-light w-50">
                            <div class="row no-gutters align-items-center">
                              <div class="col-md-2 text-center">
                                <img src="./assets/products/p1.jpg" alt="..." class="img-fluid rounded m-1">
                              </div>
                              <div class="col-md-10">
                                <div class="card-body py-0">
                                  <p class="card-title mb-0">${dto.image}</p>
                                  <div class="card-text my-0 text-muted small"><span class="mr-2">1.2M</span><span class="mr-2">SVG</span></div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </c:if>
                          <small class="text-muted">${dto.uploadDate}</small>
                        </div>
                        <div class="col-auto">
                          <span class="circle circle-sm bg-light">
                            <i class="fe fe-corner-down-left"></i>
                          </span>
                        </div>
                      </div> <!-- .row-->
                      <c:if test="${dto.complete == 0}"></c:if>
                      <c:if test="${dto.complete == 1}">
                      <div class="row align-items-center mb-4">
                        <div class="col-auto">
                          <div class="avatar avatar-sm mb-3 mx-4">
                            <img src="./assets/avatars/face-4.jpg" alt="..." class="avatar-img rounded-circle">
                          </div>
                        </div>
                        <div class="col">
                          <strong>${dto.emp_id}</strong>
                          <div class="mb-2">${dto.answerContent}</div>
                          <small class="text-muted">${dto.answerDate}</small>
                        </div>
                      </div> <!-- .row-->
                      </c:if>
                      <hr class="my-4">
                      <h6 class="mb-3">답변</h6>
                      <form>
                        <div class="form-group">
                          <label for="exampleFormControlTextarea1" class="sr-only">답변</label>
                          <textarea class="form-control bg-light" id="exampleFormControlTextarea1" rows="2"></textarea>
                        </div>
                        <div class="d-flex justify-content-between align-items-center">
                          <div class="form-check form-check-inline ml-1">
                            <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                            <label class="form-check-label" for="inlineCheckbox1">이메일 전송</label>
                          </div>
                          <div class="flex-fill mr-2 text-right">
                            <a href="#" class="btn"><i class="fe fe-upload"></i></a>
                            <a href="#" class="btn"><i class="fe fe-at-sign"></i></a>
                          </div>
                          <button type="submit" class="btn btn-primary">입력</button>
                        </div>
                      </form>
                    </div> <!-- .card-body -->
                  </div> <!-- .card -->
                </div> <!-- .col-md -->
              </div>
            </div>
          </div> <!-- .col-12 -->
        </div> <!-- .row -->
    </main>
    </div> <!-- .wrapper -->
<jsp:include page="../inn/footer.jsp"/>