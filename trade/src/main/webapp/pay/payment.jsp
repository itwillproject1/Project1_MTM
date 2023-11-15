<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="../css/memberjoin.css" rel="stylesheet" />
<title>Insert title here</title>
</head>

	<script type="text/javascript">
	
	
	
	function cancel(){
		
		window.close();
		
	}
	function check() {
		
		var price = "<c:out value='${dto1.price}'/>"
		var pay = "<c:out value='${dto.pay}'/>"
		var buyer_id = "<c:out value='${dto.user_id}'/>"
		var seller_id = "<c:out value='${dto1.user_id}'/>"
		
		if(pay <= price){

			alert(' 잔액이 부족합니다.');
			alert(' 부족한 금액은 ' + (price-pay) +'원입니다.')
			location.href = "../member/MemberPayInfo.member?&id=" + buyer_id;
			return false;
	}
	}
	
	</script>


<body>
		
		<form action="../product/ProductPayAction.com" method="post" onsubmit="return check();">
		주문자명 : 
		${dto.user_name}<br>
		전화번호 : 
		${dto.phone}<br>
		<hr>
		배송지<br>
		${dto.address}
		<!--  <input type="button" value="변경" class="bu" style="float: right;"><hr> --> 	
		<br><hr>
		주문상품<br>
		<input type="hidden" name="seller_id" value="${dto1.user_id}">
		<input type="hidden" name="price" value="${dto1.price}">
		<input type="hidden" name="bno" value="${dto1.bno}">
		${dto1.category} / ${dto1.brand} / ${dto1.product_status} <br><hr>
		상품 설명<br>
		${dto1.title}
		<hr>
		주문금액 :
		${dto1.price}
		<hr>

		<input type="submit" value="구매하기" class="bu">
		<input type="button" value="취소하기" class="bu" onclick="cancel();">
		</form>

</body>
</html>