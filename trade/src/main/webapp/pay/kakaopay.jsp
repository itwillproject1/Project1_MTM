<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MTM | 포인트 충전</title>
<link rel="icon" href="../main/img/16px.ico" type="image/x-icon">
<link href="../css/kakaopay.css" rel="stylesheet">
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script src="../js/jquery-3.7.1.js"></script>

<script>

var IMP = window.IMP;
IMP.init('imp71374124');


function pay(){
var name = "<c:out value='${dto.user_name}'/>"
var id = "<c:out value='${dto.user_id}'/>"
var email = "<c:out value='${dto.email}'/>"
var phone = "<c:out value='${dto.phone}'/>"
var address = "<c:out value='${dto.address}'/>"
var item = $('input[name="item"]:checked').val();
IMP.request_pay({
    pg : 'kakaopay',
    pay_method : 'trans',
    merchant_uid: 'merchant_' + new Date().getTime(), //상점에서 생성한 고유 주문번호
    name : '포인트 충전 결제',
    amount : item,
    buyer_email : email,
    buyer_name : name,
    buyer_tel : phone,
    buyer_addr : address,
    buyer_postcode : '123-456',
    m_redirect_url : "" // 예: https://www.my-service.com/payments/complete
}, function(rsp) {
    if ( !rsp.success ) {
    	//결제 시작 페이지로 리디렉션되기 전에 오류가 난 경우
        var msg = '오류로 인하여 결제가 시작되지 못하였습니다.';
        msg += rsp.error_msg;

        alert(msg);
    } else {
    	location.href = "../member/MemberPayAction.member?item=" + item + "&id=" + id;
    	
    }
});
}

	function close(){
		window.close();
	}
</script>
</head>
<body>
<div class="image-container">
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F99C4EF3C5C0358F601" width="250" alt="카카오페이"><br>
</div>
<p class="explain">
카카오페이의 최소 충전금액은 5,000원이며 <br>
최대 충전금액은 1,000,000원 입니다.
</p>
<p class="center">
<input type="radio" name="item" id="item" value="10000"> 10,000 
<input type="radio" name="item" id="item" value="30000"> 30,000 
<input type="radio" name="item" id="item" value="50000"> 50,000 <br>
<input type="radio" name="item" id="item" value="100000"> 100,000 
<input type="radio" name="item" id="item" value="500000"> 500,000 
<input type="radio" name="item" id="item" value="1000000"> 1,000,000 <br>
</p>
<hr> 

<div class="find-btn">
<button class="btn" onclick="pay();">결제하기</button>
<!-- <button class="btn" onclick="close();">취소하기</button> -->
</div>

</body>
</html>