<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/memberjoin.css" rel="stylesheet" />
<link href="../css/main_styles_mypage.css" rel="stylesheet" />
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
			
			var price = parseInt("<c:out value='${dto2.buyer_price}'/>");
			var pay = parseInt("<c:out value='${dto.pay}'/>");
			var buyer_id = "<c:out value='${dto.user_id}'/>";
			var seller_id = "<c:out value='${dto1.user_id}'/>";
			
			if(pay < price){

				alert(' 잔액이 부족합니다.');
				alert(' 부족한 금액은 ' + (price-pay) +'원입니다.');
				var url = "../member/MemberPayInfo.member?&id=" + buyer_id;
				window.open(url,"checkid","width=570,height=500, scrollbars=yes, resizable=yes");
				return false;
			}
				
		}
		
		</script>

<body>
		<fieldset>
		<form action="../product/ProductPayAction.com" method="post" name="pay" onsubmit="return check();">
		주문자명 : 
		${dto.user_name}<br>
		전화번호 : 
		${dto.phone}<br>
		<hr>
		배송지<br>
		<input type="text" name="address" value="${dto.address}"> <input type="button" value="변경하기" onclick="goPopup()" class="in">
		<!--  <input type="button" value="변경" class="bu" style="float: right;"><hr> --> 	
		<br><hr>
		주문상품<br>
		<input type="hidden" name="seller_id" value="${dto1.user_id}">
		<input type="hidden" name="price" value="${dto2.buyer_price}">
		<input type="hidden" name="bno" value="${dto1.bno}">
		<input type="hidden" name="deal_way" value="${dto1.deal_way}">
		${dto1.category} / ${dto1.brand} / ${dto1.product_status} <br><hr>
		상품 설명<br>
		${dto1.title}
		<hr>
		주문금액 :
		 <p><STRIKE>${dto1.price}</STRIKE> ${dto2.buyer_price}</p> 
		<hr>
		
		
		<input class="in" type="submit" value="구매하기" >
		<input class="in" type="button" value="취소하기" onclick="cancel();">
		
		
		</form>
		</fieldset>

</body>
</html>