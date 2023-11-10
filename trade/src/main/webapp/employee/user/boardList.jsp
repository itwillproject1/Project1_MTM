<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/databaseList.jsp"/>
<title>게시판 목록</title>
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
                  <h2 class="h4 mb-1">게시판</h2>
                  <p class="mb-4"></p>
                  <div class="card shadow">
                    <div class="card-body">
                      <div class="toolbar row mb-3">
                        <div class="col">
                          <form class="form-inline">
                            <div class="form-row">
                              <div class="form-group col-auto">
                                <label for="search" class="sr-only">검색</label>
                                <input type="text" class="form-control" id="search" value="" placeholder="검색">
                              </div>
                              <div class="form-group col-auto ml-3">
                                <label class="my-1 mr-2 sr-only" for="inlineFormCustomSelectPref">Status</label>
                                <select class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
                                  <option selected>선택...</option>
                                  <option value="1">공지사항</option>
                                  <option value="2">이벤트</option>
                                </select>
                              </div>
                            </div>
                          </form>
                        </div>
                        <div class="col ml-auto">
                          <div class="dropdown float-right">
                            <button class="btn btn-danger float-right ml-3" type="button">글 삭제</button>
                            <button class="btn btn-primary float-right ml-3" type="button">글 생성</button>
                          </div>
                        </div>
                      </div>
                      <!-- table -->
                      <table class="table table-bordered">
                        <thead>
                          <tr role="row">
                            <th>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="all">
                                <label class="custom-control-label" for="all"></label>
                              </div>
                            </th>
                            <th>아이디</th>
                            <th>작성일</th>
                            <th>이름</th>
                            <th>제목</th>
                            <th>기간</th>
                            <th>카테고리</th>
                            <th>조회수</th>
                            <th></th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr role="group" class="bg-light">
                            <td colspan="10"><strong>공지사항</strong></td>
                          </tr>
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="2576">
                                <label class="custom-control-label" for="2576"></label>
                              </div>
                            </td>
                            <td>admin</td>
                            <td>제목제목제목제목제목제목</td>
                            <td>관리자</td>
                            <td>업로드 일자</td>
                            <td>기간(이벤트일시)</td>
                            <td><span class="badge badge-warning">공지사항</span></td>
                            <td>1</td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="#">수정</a>
                                <a class="dropdown-item" href="#">삭제</a>
                                <a class="dropdown-item" href="#">사용자 메뉴로 조회</a>
                              </div>
                            </td>
                          </tr>

                          <tr role="group" class="bg-light">
                            <td colspan="10"><strong>이벤트</strong></td>
                          </tr>
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="2576">
                                <label class="custom-control-label" for="2576"></label>
                              </div>
                            </td>
                            <td>admin</td>
                            <td>제목제목제목제목제목제목</td>
                            <td>관리자</td>
                            <td>업로드 일자</td>
                            <td>기간(이벤트일시)</td>
                            <td><span class="badge badge-primary">이벤트</span></td>
                            <td>2</td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="#">수정</a>
                                <a class="dropdown-item" href="#">삭제</a>
                                <a class="dropdown-item" href="#">사용자 메뉴로 조회</a>
                              </div>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                      <nav aria-label="Table Paging" class="mb-0 text-muted">
                        <ul class="pagination justify-content-end mb-0">
                          <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                          <li class="page-item"><a class="page-link" href="#">1</a></li>
                          <li class="page-item"><a class="page-link" href="#">2</a></li>
                          <li class="page-item"><a class="page-link" href="#">3</a></li>
                          <li class="page-item"><a class="page-link" href="#">Next</a></li>
                        </ul>
                      </nav>
                    </div>
                  </div>
                </div> <!-- simple table -->
              </div> <!-- end section -->
            </div>
          </div>
        </div>
      </main>
    </div>
<jsp:include page="../inn/footer.jsp"/>