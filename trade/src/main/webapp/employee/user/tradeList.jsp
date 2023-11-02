<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/databaseList.jsp"/>
<head><title>거래 현황</title></head>
<jsp:include page="../inn/navbar.jsp"/>
      <main role="main" class="main-content">
        <div class="container-fluid">
          <div class="row justify-content-center">
            <div class="col-12">
              <div class="row">
                <!-- Striped rows -->
                <div class="col-md-12 my-4">
                  <h2 class="h4 mb-1">거래 현황</h2>
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
                                  <option value="1">삽니다</option>
                                  <option value="2">팝니다</option>
                                </select>
                              </div>
                            </div>
                          </form>
                        </div>
                        <div class="col ml-auto">
                          <div class="dropdown float-right">
                            <button class="btn btn-danger float-right ml-3" type="button">거래 삭제</button>
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
                            <th>카테고리</th>
                            <th>물품명(제목)</th>
                            <th>가격</th>
                            <th>거래상태</th>
                            <th>거래자</th>
                            <th></th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr role="group" class="bg-light">
                            <td colspan="10"><strong>삽니다</strong></td>
                          </tr>
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="2576">
                                <label class="custom-control-label" for="2576"></label>
                              </div>
                            </td>
                            <td>1234</td>
                            <td>2020-07-14 17:18:27</td>
                            <td>사람</td>
                            <td>노트북</td>
                            <td><p class="mb-0 text-muted"><a href="#" class="text-muted">노트북 팔아요</a></p></td>
                            <td>2,000,000 원</td>
                            <td><span class="badge badge-success">거래 완료</span></td>
                            <td>거래자 이름</td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
								<a class="dropdown-item" href="#">삭제</a>
                                <a class="dropdown-item" href="#">상품 페이지로</a>
                              </div>
                            </td>
                          </tr>
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="2397">
                                <label class="custom-control-label" for="2397"></label>
                              </div>
                            </td>
                            <td>2397</td>
                            <td>2020-12-25 13:35:39</td>
                            <td>Fletcher Petty</td>
                            <td>(115) 625-5813</td>
                            <td>8907 Orci St.</td>
                            <td>$75.69</td>
                            <td><span class="badge badge-success">거래 완료</span></td>
                            <td>039606-5955</td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
								<a class="dropdown-item" href="#">삭제</a>
                                <a class="dropdown-item" href="#">상품 페이지로</a>
                              </div>
                            </td>
                          </tr>
                          <tr role="group" class="bg-light">
                            <td colspan="10"><strong>팝니다</strong></td>
                          </tr>
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="4028">
                                <label class="custom-control-label" for="4028"></label>
                              </div>
                            </td>
                            <td>4028</td>
                            <td>2021-04-11 22:33:47</td>
                            <td>Kasimir Carr</td>
                            <td>(266) 991-0479</td>
                            <td>489-624 Quis St.</td>
                            <td>$86.89</td>
                            <td><span class="badge badge-danger">신고됨</span></td>
                            <td></td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
								<a class="dropdown-item" href="#">삭제</a>
                                <a class="dropdown-item" href="#">상품 페이지로</a>
                              </div>
                            </td>
                          </tr>
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="3782">
                                <label class="custom-control-label" for="3782"></label>
                              </div>
                            </td>
                            <td>3782</td>
                            <td>2020-03-01 10:44:03</td>
                            <td>Daria Frank</td>
                            <td>(599) 361-7999</td>
                            <td>Ap #875-5778 Massa. Av.</td>
                            <td>$38.04</td>
                            <td><span class="badge badge-primary">배송 중</span></td>
                            <td>072140-0703</td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="#">삭제</a>
                                <a class="dropdown-item" href="#">상품 페이지로</a>
                              </div>
                            </td>
                          </tr>
                          <tr>
                            <td>
                              <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="3881">
                                <label class="custom-control-label" for="3881"></label>
                              </div>
                            </td>
                            <td>3881</td>
                            <td>2019-12-17 00:40:24</td>
                            <td>Herrod Byrd</td>
                            <td>(878) 901-7269</td>
                            <td>P.O. Box 107, 3720 Vitae, Ave</td>
                            <td>$73.38</td>
                            <td><span class="badge badge-primary">배송 중</span></td>
                            <td>047336-4370</td>
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
                        <ul class="pagination justify-content-end mb-0">
                          <li class="page-item"><a class="page-link" href="#">이전</a></li>
                          <li class="page-item"><a class="page-link" href="#">1</a></li>
                          <li class="page-item"><a class="page-link" href="#">2</a></li>
                          <li class="page-item"><a class="page-link" href="#">3</a></li>
                          <li class="page-item"><a class="page-link" href="#">다음</a></li>
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