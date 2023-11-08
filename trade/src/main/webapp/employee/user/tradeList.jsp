<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/databaseList.jsp"/>
<head><title>거래 현황</title></head>
<jsp:include page="../inn/navbar.jsp"/>
      <main role="main" class="main-content" data-select2-id="9">
        <div class="container-fluid" data-select2-id="8">
          <div class="row justify-content-center" data-select2-id="7">
            <div class="col-12" data-select2-id="6">
              <h2 class="h3 mb-3 page-title">거래 목록</h2>
              <div class="row mb-4 items-align-center">
                <div class="col-md">
                  <ul class="nav nav-pills justify-content-start">
                  <c:if test="${pageCategory == 'all'}">
                  	<li class="nav-item">
                      <a class="nav-link active bg-transparent pr-2 pl-0 text-primary" href="./TradeList.emp?pageCategory=all&pageNum=1">전체 <span class="badge badge-pill bg-primary text-white ml-2">${count[0]}</span></a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link text-muted px-2" href="./TradeList.emp?pageCategory=buy&pageNum=1">삽니다 <span class="badge badge-pill bg-white border text-muted ml-2">${count[1]}</span></a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link text-muted px-2" href="./TradeList.emp?pageCategory=sell&pageNum=1">팝니다 <span class="badge badge-pill bg-white border text-muted ml-2">${count[2]}</span></a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link text-muted px-2" href="./TradeList.emp?pageCategory=complete&pageNum=1">거래 완료 <span class="badge badge-pill bg-white border text-muted ml-2">${count[3]}</span></a>
                    </li>
                  </c:if>
                  <c:if test="${pageCategory == 'buy'}">
                  	<li class="nav-item">
                      <a class="nav-link text-muted px-2" href="./TradeList.emp?pageCategory=all&pageNum=1">전체 <span class="badge badge-pill bg-white border text-muted ml-2">${count[0]}</span></a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link active bg-transparent pr-2 pl-0 text-primary" href="./TradeList.emp?pageCategory=buy&pageNum=1">삽니다 <span class="badge badge-pill bg-primary text-white ml-2">${count[1]}</span></a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link text-muted px-2" href="./TradeList.emp?pageCategory=sell&pageNum=1">팝니다 <span class="badge badge-pill bg-white border text-muted ml-2">${count[2]}</span></a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link text-muted px-2" href="./TradeList.emp?pageCategory=complete&pageNum=1">거래 완료 <span class="badge badge-pill bg-white border text-muted ml-2">${count[3]}</span></a>
                    </li>
                  </c:if>
                  <c:if test="${pageCategory == 'sell'}">
                  	<li class="nav-item">
                      <a class="nav-link text-muted px-2" href="./TradeList.emp?pageCategory=all&pageNum=1">전체 <span class="badge badge-pill bg-white border text-muted ml-2">${count[0]}</span></a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link text-muted px-2" href="./TradeList.emp?pageCategory=buy&pageNum=1">삽니다 <span class="badge badge-pill bg-white border text-muted ml-2">${count[1]}</span></a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link active bg-transparent pr-2 pl-0 text-primary" href="./TradeList.emp?pageCategory=sell&pageNum=1">팝니다 <span class="badge badge-pill bg-primary text-white ml-2">${count[2]}</span></a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link text-muted px-2" href="./TradeList.emp?pageCategory=complete&pageNum=1">거래 완료 <span class="badge badge-pill bg-white border text-muted ml-2">${count[3]}</span></a>
                    </li>
                  </c:if>
                  <c:if test="${pageCategory == 'complete'}">
                  	<li class="nav-item">
                      <a class="nav-link text-muted px-2" href="./TradeList.emp?pageCategory=all&pageNum=1">전체 <span class="badge badge-pill bg-white border text-muted ml-2">${count[0]}</span></a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link text-muted px-2" href="./TradeList.emp?pageCategory=buy&pageNum=1">삽니다 <span class="badge badge-pill bg-white border text-muted ml-2">${count[1]}</span></a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link text-muted px-2" href="./TradeList.emp?pageCategory=sell&pageNum=1">팝니다 <span class="badge badge-pill bg-white border text-muted ml-2">${count[2]}</span></a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link active bg-transparent pr-2 pl-0 text-primary" href="./TradeList.emp?pageCategory=complete&pageNum=1">거래 완료 <span class="badge badge-pill bg-primary text-white ml-2">${count[3]}</span></a>
                    </li>
                  </c:if>
                  </ul>
                </div>
                <div class="col-md-auto ml-auto text-right">
                  <button type="button" class="btn" data-toggle="modal" data-target=".modal-slide"><span class="fe fe-filter fe-16 text-muted"></span></button>
                  <button type="button" class="btn"><span class="fe fe-refresh-ccw fe-16 text-muted"></span></button>
                </div>
              </div>
              <!-- Slide Modal -->
              <div class="modal fade modal-slide" tabindex="-1" role="dialog" aria-labelledby="defaultModalLabel" aria-hidden="true" style="display: none;">
                <div class="modal-dialog" role="document">
                 <form action="./TradeList.emp" method="get">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h5 class="modal-title" id="defaultModalLabel">Filters</h5>
                      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <i class="fe fe-x fe-12"></i>
                      </button>
                    </div>
                    <div class="modal-body" data-select2-id="5">
                      <div class="p-2">
                        <div class="form-group my-4">			
                        	<label for="custom-select"><strong>검색</strong></label>
                        	<select name="search" class="custom-select" id="custom-select">
                          		<option selected>선택</option>
                          		<option value="title">제목</option>
                          		<option value="brand">브랜드</option>
                          		<option value="user_id">작성자</option>
                        	</select>
                        	<input type="text" name="searchKeyword" class="form-control" placeholder="검색어 입력">
                        </div> <!-- form-group -->
                        <div class="form-group my-2">			
                        	<label for="custom-select"><strong>카테고리</strong></label>
                        	<select name="category" class="custom-select" id="custom-select">
                          		<option selected>선택</option>
                          		<option value="휴대폰&태블릿">휴대폰&태블릿</option>
								<option value="데스크탑">데스크탑</option>
								<option value="노트북">노트북</option>
								<option value="게임기기">게임기기</option>
								<option value="가전제품">가전제품</option>
								<option value="카메라">카메라</option>
								<option value="음향기기">음향기기</option>
								<option value="기타">기타</option>
                        	</select>
                        </div> <!-- form-group -->
                        <div class="form-group my-4">
                          <p class="mb-2">
                            <strong>거래 완료됨</strong>
                          </p>
                          <div class="custom-control custom-switch">
                          	<c:if test="${checkComplete == true}">
                          		<input type="checkbox" name="checkComplete" value="true" class="custom-control-input" id="customSwitch1" checked>
                          	</c:if>
                          	<c:if test="${checkComplete == null }">                      	
	                            <input type="checkbox" name="checkComplete" value="true" class="custom-control-input" id="customSwitch1">
                          	</c:if>
                            <label class="custom-control-label" for="customSwitch1">포함</label>
                          </div>
                        </div> <!-- form-group -->
                      </div>
                    </div>
                    <div class="modal-footer">
                      <button type="submit" class="btn mb-2 btn-primary btn-block">검색</button>
                      <button type="button" class="btn mb-2 btn-secondary btn-block" onclick="">초기화</button>
                    </div>
                  </div>                  
                 </form>
                </div>
              </div>
              <c:if test="${list == null}">
              	0건
              </c:if>
              <c:if test="${list != null }">
              <table class="table border table-hover bg-white">
                <thead>
                  <tr role="row">
                    <th>
                      <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input" id="all">
                        <label class="custom-control-label" for="all"></label>
                      </div>
                    </th>
                    <th>아이디</th>
                    <th>게시일자</th>
                    <th>브랜드</th>
                    <th>카테고리</th>
                    <th>제목</th>
                    <th style="text-align:right;">가격</th>
                    <th style="text-align:center;">거래 상태</th>
                    <th>거래자</th>
                    <th>기타</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="i" items="${list}">
                  <tr>
                    <td class="align-center">
                      <div class="custom-control custom-checkbox">
                        <input type="checkbox" class="custom-control-input">
                        <label class="custom-control-label"></label>
                      </div>
                    </td>
                    <td>
                    	<p class="mb-0 text-muted">
                    		<a href="./UserInfo.emp?user_id=${i.user_id}" class="text-muted">${i.user_id}</a>
                    	</p>
                    </td>
                    <td>${i.date_time}</td>
                    <td>${i.brand}</td>
                    <td>${i.category}</td>
                    <td>
                    	<p class="mb-0 text-muted">
                    		<a href="./TradeContent.emp?bno=${i.bno}" class="text-muted">${i.title}</a>
                    	</p>
					</td>
                    <td style="text-align:right;">${i.price}</td>
                    <td style="text-align:center;">
                    	<!-- 거래 중 -->
                    	<c:if test="${i.deal_status== 1}">
                    		<span class="dot dot-lg bg-success mr-2"></span>
                    	</c:if>
                    	<!-- 거래 완료 -->
                    	<c:if test="${i.deal_status == 0}">
                    		<span class="dot dot-lg bg-secondary mr-2"></span>
                    	</c:if>
                    </td>
                    
                    <td>
                    	<c:if test="${i.deal_status == 1}">${i.deal_user_id}</c:if>
                    </td>
                    <td>
                      <div class="dropdown">
                        <button class="btn btn-sm dropdown-toggle more-vertical" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          <span class="text-muted sr-only">Action</span>
                        </button>
                        <div class="dropdown-menu dropdown-menu-right" style="">
                          <a class="dropdown-item" href="./TradeContent.emp?bno=${i.bno}&pageNum=${pageNum}">상세보기</a>
                          <a class="dropdown-item" href="#">삭제</a>
                        </div>
                      </div>
                    </td>
                  </tr>
                  </c:forEach>            
                </tbody>
              </table>
              </c:if>
              <nav aria-label="Table Paging" class="my-3">
                <ul class="pagination justify-content-end mb-0">
                  <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                  <li class="page-item"><a class="page-link" href="#">1</a></li>
                  <li class="page-item active"><a class="page-link" href="#">2</a></li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
              </nav>
            </div>
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
      </main>
    </div>
<jsp:include page="../inn/footer.jsp"/>