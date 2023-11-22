<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../css/pay.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function goPopup() {

			var pop = window.open("../member/jusoPopup.jsp", "pop",
					"width=570,height=420, scrollbars=yes, resizable=yes");

		}
		function jusoCallBack(address) {
			document.pay.address.value = address;
		}

		function cancel() {
			history.back();
			return false;
		}
		
		function check() {

			var price = parseInt("<c:out value='${selldto.price}'/>");
			var pay = parseInt("<c:out value='${user_dto.pay}'/>");
			var buyer_id = "<c:out value='${user_dto.user_id}'/>";
			var seller_id = "<c:out value='${selldto.user_id}'/>";

			if (pay < price) {

				alert(' 잔액이 부족합니다.');
				alert(' 부족한 금액은 ' + (price - pay) + '원입니다.');
				var url = "../member/MemberPayInfo.member?&id=" + buyer_id;
				window.open(url, "checkid",
						"width=570,height=500, scrollbars=yes, resizable=yes");
				return false;
			}

		}
	</script>
	
	<%@ include file="../main/header.jsp"%>
	
	<fieldset class="container">
		<form action="../product/ProductPayAction.com" method="post" name="pay" onsubmit="return check();">
		<div class="form-group">
				<label>주문자명: ${user_dto.user_name}</label>
				<hr>
				<label>전화번호: ${user_dto.phone}</label>
				<hr>
				<label>배송지:</label>
				<div class="btn">
					<input type="text" name="address" id="address" value="${user_dto.address}">
					<input type="button" class="submit-button" value="변경하기" onclick="goPopup();">
				</div>
				<hr>			
				<label>주문상품:
				<input type="hidden" name="seller_id" value="${selldto.user_id}">
				<input type="hidden" name="price" value="${selldto.price}">
				<input type="hidden" name="bno" value="${selldto.bno}">
				<input type="hidden" name="deal_way" value="${selldto.deal_way}">
				${selldto.category}
				</label>
				<hr>
				<label>상품명: ${selldto.title}</label>
				<hr>				
				<label>주문금액: <fmt:formatNumber value="${selldto.price}"/>원</label>
				
				<div class="btn">
					<input type="submit" class="submit-button" value="결제하기">
					<input type="button" class="submit-button" value="취소하기" onclick="cancel();">
				</div>
		</div>
		</form>
	</fieldset>
	
	<%@ include file="../main/footer.jsp"%>
</body>
</html>