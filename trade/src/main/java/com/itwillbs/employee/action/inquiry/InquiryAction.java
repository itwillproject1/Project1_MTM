package com.itwillbs.employee.action.inquiry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** InquiryAction : 문의 답변 처리 **/

public class InquiryAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 관리자 전용
		// 문의에 대한 답 업로드
		return null;
	}
}
