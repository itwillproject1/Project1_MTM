package com.itwillbs.employee.action.inquiry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.action.JSConfirmMoveFunction;
import com.itwillbs.employee.dto.InquiryDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

/** InquiryAction : 문의 답변 처리 **/

public class InquiryAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 관리자 전용
		// 문의에 대한 답 업로드
		InquiryDTO dto = new InquiryDTO();
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dto.setEmp_id((String)request.getSession().getAttribute("emp_id"));
		dto.setAnswerContent(request.getParameter("answerContent"));
		int result = 0;
		if(result == 1) {
			JSConfirmMoveFunction move = new JSConfirmMoveFunction();
			move.moveLocation(response, "./InquiryContent.emp?bno=" + dto.getBno());
		}
		else {
			JSMoveFunction move = new JSMoveFunction();
			move.alertBack(response, "입력 오류");
		}
		return null;
	}
}
