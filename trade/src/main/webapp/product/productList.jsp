<%@page import="com.itwillbs.product.db.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.itwillbs.product.db.ProductDAO"%>
<%@page import="com.itwillbs.product.db.ProductDTO"%>
<%
ProductDAO productDAO = new ProductDAO();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap">
<link href="../css/header.css" rel="stylesheet" />
<link href="../css/productList.css" rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var selectedDealWay = "${param.deal_way}";
		var selectedSubCategory = "${param.brand}";

		// 페이지 이동 함수
		function changePage(pageNum, search, deal_way,
								category, brand) {
							var url = "./ProductList.com?pageNum=" + pageNum
									+ "&search=" + search;

							if (deal_way) {
								url += "&deal_way=" + deal_way;
								selectedDealWay = deal_way;
							}

							if (category) {
								url += "&category=" + category;
							}

							if (brand) {
								url += "&brand=" + brand;
								selectedSubCategory = brand;
							}

							window.location.href = url;
						}

						// dealWay 및 subCategory 클릭 시 이벤트 처리
						$('#dealWayList a, #subCategory a')
								.on(
										'click',
										function() {
											var categoryType = $(this).closest(
													'ul').attr('id'); // 어떤 카테고리를 클릭했는지 확인

											if (categoryType === 'dealWayList') {
												// dealWay 클릭 시
												var dealWay = $(this).text();
												// 현재 선택된 dealWay와 클릭한 dealWay가 다를 때에만 변경
												if (selectedDealWay !== dealWay) {
													// 이전에 선택된 dealWay의 스타일 초기화
													$('#dealWayList a').css({
														'color' : '',
														'background-color' : ''
													});
													// 현재 선택된 dealWay 업데이트
													selectedDealWay = dealWay;
													// 새로 클릭한 dealWay에 스타일 적용
													$(this)
															.css(
																	{
																		'color' : '#fff',
																		'background-color' : '#6D6D6D'
																	});
													// 페이지 이동 함수 호출
													changePage(
															1,
															'${param.search}',
															dealWay,
															'${param.category}',
															selectedSubCategory);
												}
											} else if (categoryType === 'subCategory') {
												// subCategory 클릭 시
												var subCategory = $(this)
														.text();
												// 현재 선택된 subCategory와 클릭한 subCategory가 다를 때에만 변경
												if (selectedSubCategory !== subCategory) {
													// 이전에 선택된 subCategory의 스타일 초기화
													$('#subCategory a').css({
														'color' : '',
														'background-color' : ''
													});
													// 현재 선택된 subCategory 업데이트
													selectedSubCategory = subCategory;
													// 새로 클릭한 subCategory에 스타일 적용
													$(this)
															.css(
																	{
																		'color' : '#fff',
																		'background-color' : '#6D6D6D'
																	});
													// 페이지 이동 함수 호출
													changePage(
															1,
															'${param.search}',
															selectedDealWay,
															'${param.category}',
															subCategory);
												}
											}
										});

						// 상세 페이지로 이동하는 함수
						function toProductContent(url) {
							window.location.href = url;
						}

						// 상세 페이지 이벤트
						$('.product')
								.on(
										'click',
										function() {
											var bno = $(this).data('bno');
											toProductContent('./ProductContent.com?bno='
													+ bno);
										});

						// 페이지 번호 클릭 시 이벤트 처리
						$('.page-number').on(
								'click',
								function() {
									var pageNum = $(this).text();
									changePage(pageNum, '${param.search}',
											'${param.deal_way}',
											'${param.category}');
								});

						// 이전 페이지 클릭 시 이벤트 처리
						$('.prev-page')
								.on(
										'click',
										function() {
											var pageNum = parseInt('${startPage - pageBlock}');
											changePage(pageNum,
													'${param.search}',
													'${param.deal_way}',
													'${param.category}',
													'${param.brand}');
										});

						// 다음 페이지 클릭 시 이벤트 처리
						$('.next-page')
								.on(
										'click',
										function() {
											var pageNum = parseInt('${startPage + pageBlock}');
											changePage(pageNum,
													'${param.search}',
													'${param.deal_way}',
													'${param.category}',
													'${param.brand}');
										});

						// 초기 로딩 시 현재 선택된 dealWay와 subCategory에 해당하는 스타일 적용
						$('#dealWayList a').each(function() {
							if ($(this).text() === selectedDealWay) {
								$(this).css({
									'color' : '#fff',
									'background-color' : '#6D6D6D'
								});
							}
						});

						$('#subCategory a').each(function() {
							if ($(this).text() === selectedSubCategory) {
								$(this).css({
									'color' : '#fff',
									'background-color' : '#6D6D6D'
								});
							}
						});

					});
</script>
<title>MTM | 상품 목록</title>
<script src="../product/custom.js"></script>
</head>
<link rel="icon" href="../main/img/16px.ico" type="image/x-icon">
<body>
	<jsp:include page="../main/header.jsp" />
	<div class="title" id="product-list-title">상품 목록</div>
	<div id="allproduct">
		<div class="prd-smenu">
			<dl class="cate-1">
				<dt class="blind">상품 분류 리스트</dt>
				<dd>
					<%
					String link = "../product/ProductList.com?category=" + request.getParameter("category");
					String deal_way = request.getParameter("deal_way");
					String brand = request.getParameter("brand");
					String dealLink = link + "&brand=" + (brand == null ? "" : brand);
					String brandLink = link + "&deal_way=" + (deal_way == null ? "" : deal_way);
					%>
					<ul id="dealWayList">
						<c:forEach var="dealWay" items="${dealWayList}">
							<li><a href="<%=dealLink%>&deal_way=${dealWay}">${dealWay}</a></li>
						</c:forEach>
					</ul>
					<ul id="subCategory">
						<c:forEach var="brand" items="${brandList }">
							<li><a href="<%=brandLink%>&brand=${brand}">${brand}</a></li>
						</c:forEach>
					</ul>
				</dd>
			</dl>

		</div>
	</div>
	<div class="container" style="margin-bottom:-50px;">
		<div class="refresh">
			<c:if test="${search == null && category != null}">
				<button class="refresh-btn" type="button"
					onclick="location.href='<%=link%>'">
					<img src="./img/refresh.png">
				</button>
			</c:if>
		</div>
	</div>
	<!-- 여기에 상품 목록 들어갈 부분 -->
	<div class="container">
		<c:forEach var="dto" items="${ProductList }">
			<!-- 상품들 -->
			<div
				class="product 
    <c:if test="${dto.deal_status == 0 }">
        disabled
    </c:if>"
				data-bno="${dto.bno}"
				onclick="toProductContent('./ProductContent.com?bno=${dto.bno}')">
				<div class="product.image">
					<c:set var="fileNameArr" value="${fn:split(dto.file_name, ',')}" />
					<img src="<%=request.getContextPath() %>/upload/${fileNameArr[0]}"
						onerror="this.onerror=null; this.src='../product/img/default_product_image.png';"
						alt="${dto.title}">
				</div>
				<div class="product-info">
					<h3>[${dto.deal_way }]${dto.title }</h3>
				</div>
				<div class="product-price">
					<p>
						<fmt:formatNumber value="${dto.price }" />
						원
					</p>
				</div>
			</div>
		</c:forEach>
	</div>
	<div id="page_control">
		<c:if test="${startPage > pageBlock }">
			<a href="#" class="prev-page">이전 페이지</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			<c:choose>
				<c:when test="${i != 0}">
					<a href="#" class="page-number">${i }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${endPage < pageCount }">
			<a href="#" class="next-page">다음 페이지</a>
		</c:if>
	</div>
	<%@ include file="../main/footer.jsp"%>
</body>
</html>

