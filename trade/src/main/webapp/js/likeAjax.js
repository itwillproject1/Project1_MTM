// 로그인 유저의 좋아요 유무 체크
$(document).ready(function() {
	$.ajax({
		url: './product/productContent.jsp',
		type: 'POST',
		data: { result: result },
		success: function(result) {
			if (result === "1") {
				$("#like").text("♥");
			} else if (result === "0") {
				$("#like").text("♡");
			} else {
				$("#like").text("오류! 리턴값 -1");
			}
		}
	});
});
		
	// 좋아요 버튼 클릭 시 실행되는 ajax
	$("#like").on("click", function(){
		console.log("click");
        $.ajax({
            url: './product/productContent.jsp',
            type: 'POST',
            data: { bno: bno, user_id: user_id },
            success: function(result) {
                console.log("데이터 변환됨: " + result);
                if (result === 1) {
                    $("#like").text("♥");
                } else if (result === 0) {
                    $("#like").text("♡");
                } else {
                    $("#like").text("오류! 리턴값 -1");
				}
			}
		})
	})
