<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inn/head/databaseList.jsp"/>
<title>피신고자 목록</title>
  <c:if test="${empty emp_id}">
		<c:redirect url="./Login.emp"/>
  </c:if>

<%
	String link = "./ComplainList.emp?";
%>

 <!-- 
 	피신고자 목록, 유저 아이디로 들어가면 신고된 정보 조회 가능, 
 	처리 완료되면 조회되지 않음, 정지된 유저 목록으로 들어감
 -->

<jsp:include page="../inn/navbar.jsp"/>
      <main role="main" class="main-content" data-select2-id="9">
        <div class="container-fluid" data-select2-id="8">
          <div class="row justify-content-center" data-select2-id="7">
            <div class="col-12" data-select2-id="6">
              <h2 class="h3 mb-3 page-title">피신고자 목록</h2>
              <div class="row mb-4 items-align-center">
                <div class="col-md-auto ml-auto text-right">
                  <button type="button" class="btn" onclick="./ComplainList.emp"><span class="fe fe-refresh-ccw fe-16 text-muted"></span></button>
                </div>
              </div>
              <c:if test="${list.size() == 0}">
              	0건
              </c:if>
              <c:if test="${list.size() != 0}">
              <table class="table table-hover table-borderless border-v">
              	<thead class="thead-dark">
                	<tr>
                		<th>피신고자</th>
                    	<th>최초 등록일자</th>
                    	<th>신고 개수</th>
                    	<th>기타</th>
                 	</tr>
                </thead>
                <tbody>
                	<c:forEach var="list" items="${list}">
                 	<tr class="accordion-toggle collapsed" id="c-2474" data-toggle="collapse" data-parent="#c-2474" href="#collap-2474" aria-expanded="false">
                      <td>${list.reported_id}</td>
                            <td>${list.firstComplainedDate}</td>
                            <td>${list.count}</td>
                            <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="text-muted sr-only">Action</span>
                              </button>
                              <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item" href="#">회원 정지</a>
                                <a class="dropdown-item" href="#">회원 상세 정보</a>
                              </div>
                            </td>
                          </tr>
                          <c:forEach var="com" items="${i.reportList}">
                          <tr id="collap-2474" class="in p-3 bg-light collapse show" style="">
                            <td colspan="8">
                              <dl class="row mb-0 mt-1">
                                <dt class="col-sm-1">신고자</dt>
                                <dd class="col-sm-2">${com.reporter_id}</dd>
                                <dt class="col-sm-1">신고 사유</dt>
                                <dd class="col-sm-2">${com.complainReason}</dd>
                                <dt class="col-sm-1">등록 일자</dt>
                                <dd class="col-sm-2">${com.uploadDate}</dd>
                              </dl>
                            </td>
                          </tr>
                          </c:forEach>
                	</c:forEach>
                        </tbody>
                      </table>
              </c:if>
              <nav aria-label="Table Paging" class="my-3">
                <ul class="pagination justify-content-end mb-0">
                <c:if test="${1 < pageNum}">
					<li class="page-item"><a class="page-link" href="<%=link%>&pageNum=${pageNum-1}">이전</a></li>
				</c:if>
				<c:forEach begin="${startPage}" end="${endPage}" step="1" var="i">
					<c:if test="${i == pageNum}">
						<li class="page-item active"><a class="page-link" href="<%=link%>&pageNum=${i}">${i}</a></li>
					</c:if>
					<c:if test="${i != pageNum }">	
						 <li class="page-item"><a class="page-link" href="<%=link%>&pageNum=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${pageNum < pageCount}">
					<li class="page-item"><a class="page-link" href="<%=link%>&pageNum=${pageNum+1}">다음</a></li>
				</c:if>
                </ul>
              </nav>
            </div>
          </div> <!-- .row -->
        </div> <!-- .container-fluid -->
      </main>
    </div>
<jsp:include page="../inn/footer.jsp"/>