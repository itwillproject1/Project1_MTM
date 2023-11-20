package com.itwillbs.employee.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dao.InquiryDAO;
import com.itwillbs.employee.dao.TradeDAO;
import com.itwillbs.employee.dao.UserDAO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

/** EmployeeMainAction : 관리자 메인 페이지 **/

public class EmployeeMainAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		UserDAO udao = new UserDAO();
		TradeDAO tdao = new TradeDAO();
		InquiryDAO idao = new InquiryDAO();
		// 회원 수
		int userCount = udao.userCount();
		
		// 거래 수
		int tradeCount = tdao.tradeCount();
		
		// 최근 거래
		ArrayList tradeList = tdao.tradeList(12);
		
		// 총 충전 금액
		int totalPay = udao.userPaySum();
		int inquiryCount = idao.inquiryCount();
		
		request.setAttribute("pay", totalPay);
		request.setAttribute("userCount", userCount);
		request.setAttribute("tradeCount", tradeCount);
		request.setAttribute("tradeList", tradeList);
		request.setAttribute("inquiryCount", inquiryCount);
		
		System.out.println(tradeList.size());
		forward.setPath("./employee/main.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
