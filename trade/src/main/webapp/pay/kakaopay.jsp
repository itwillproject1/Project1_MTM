<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script src="../js/jquery-3.7.1.js"></script>

<script>

var IMP = window.IMP;
IMP.init('imp71374124');


function pay(){
var name = "<c:out value='${dto.user_name}'/>"
var id = "<c:out value='${dto.user_id}'/>"
var item = $('input[name="item"]:checked').val();
IMP.request_pay({
    pg : 'kakaopay',
    pay_method : 'trans',
    merchant_uid: 'merchant_' + new Date().getTime(), //상점에서 생성한 고유 주문번호
    name : '포인트 충전 결제',
    amount : item,
    buyer_email : 'iamport@siot.do',
    buyer_name : name,
    buyer_tel : '010-1234-5678',
    buyer_addr : '서울특별시 강남구 삼성동',
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
</script>
</head>
<body>

<input type="radio" name="item" id="item" value="5000"> 5,000 <br>
<input type="radio" name="item" id="item" value="10000"> 10,000 <br>
<input type="radio" name="item" id="item" value="30000"> 30,000 <br>
<input type="radio" name="item" id="item" value="50000"> 50,000 <br>
<input type="radio" name="item" id="item" value="100000"> 100,000 <br>
<p  style="color: #ac2925;">카카오페이의 최소 충전금액은 5,000원이며 <br/>최대 충전금액은 100,000원 입니다.</p>
<hr> 
<button onclick="pay()">결제하기</button>

</body>
</html>