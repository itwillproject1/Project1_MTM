<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MTM | 결제페이지</title>
<link rel="icon" href="../main/img/16px.ico" type="image/x-icon">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<link href="../css/pay.css" rel="stylesheet" />
</head>
		
		<script type="text/javascript">
		
		function goPopup(){
			
			var pop = window.open("../member/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
			
		}
		function jusoCallBack(address){
			document.pay.address.value = address;
		}
		
		function cancel(){
			
			history.back();
			
		}
		function check() {
			
			var price = parseInt(${probuyerdto.price});
			var pay = parseInt(${membuyerdto.pay});
			var buyer_id = "<c:out value='${membuyerdto.user_id}'/>";
			var seller_id = "<c:out value='${prosellerdto.user_id}'/>";
			
			//alert("잔액"+pay);
			//alert("구매금액"+price);
			
			if(pay < price){
				alert(' 잔액이 부족합니다.');
				alert(' 부족한 금액은 ' + (price-pay) +'원입니다.');
				var url = "../member/MemberPayInfo.member?&id=" + buyer_id;
				window.open(url,"checkid","width=570,height=500, scrollbars=yes, resizable=yes");
				return false;
			} else {
				$(document).ready(function() {
					$('body').css({
						background : '#e7e7e7',
						opacity : '0.3',
						'pointer-events': 'none'
					});
					
					$('fieldset').append("<img alt='결제중' src='../pay/img/pay_loading.gif'>");
				});
			} 
		}
		
		</script>

<body>
<%@ include file="../main/header.jsp"%>
		<fieldset class="container">
		<form action="../product/ProductTradePayAction.com" method="post" name="pay" onsubmit="return check();">
		<div class="form-group">
				<label>주문자명: ${membuyerdto.user_name}</label>
				<hr>
				<label>전화번호: ${membuyerdto.phone}</label>
				<hr>
				<label>배송지:</label>
				<div class="btn">
					<input type="text" name="address" id="address" value="${membuyerdto.address}">
					<input type="button" class="submit-button" value="변경하기" onclick="goPopup();">
				</div>
				<hr>			
				<label>주문상품:
				<input type="hidden" name="seller_id" value="${prosellerdto.user_id}">
				<input type="hidden" name="price" value="${probuyerdto.price}">
				<input type="hidden" name="sell_bno" value="${prosellerdto.bno}">
				<input type="hidden" name="buy_bno" value="${probuyerdto.bno}">
				<input type="hidden" name="buy_deal_way" value="${probuyerdto.deal_way}">
				<input type="hidden" name="sell_deal_way" value="${probuyerdto.deal_way}">
				${probuyerdto.category} / ${probuyerdto.brand} / ${probuyerdto.product_status}
				</label>
				<hr>
				<label>상품명: ${probuyerdto.title}</label>
				<hr>				
				<label>주문금액: <STRIKE>${prosellerdto.price}</STRIKE> ${probuyerdto.price}</label>
				
				<div class="btn">
					<input type="submit" id="sbtn" class="submit-button" value="결제하기">
					<input type="button" class="submit-button" value="취소하기" onclick="cancel();">
				</div>
		</div>
		</form>
	</fieldset>
	<%@ include file="../main/footer.jsp"%>
</body>
</html>