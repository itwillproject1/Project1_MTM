package com.itwillbs.employee.action.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.ComplainDAO;
import com.itwillbs.employee.dao.InquiryDAO;
import com.itwillbs.employee.dao.TradeDAO;
import com.itwillbs.employee.dao.UserDAO;
import com.itwillbs.employee.dto.UserDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

/** UserInfoAction : 유저 정보 조회 **/

public class UserInfoAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// DAO
		UserDAO udao = new UserDAO();
		TradeDAO tdao = new TradeDAO();
		InquiryDAO idao = new InquiryDAO();
		ComplainDAO cdao = new ComplainDAO();

		// DTO
		UserDTO udto = new UserDTO();

		udto = udao.userInfo(request.getParameter("user_id"));
		if (udto == null) {
			JSMoveFunction move = new JSMoveFunction();
			move.alertBack(response, "존재하지 않는 아이디입니다!");
		}

		ArrayList tList = tdao.userInfoTrade(udto);
		request.setAttribute("dto", udto);
		request.setAttribute("tlist", tList);

		ArrayList likeList = tdao.userInfoLike(udto);
		request.setAttribute("likelist", likeList);

		ArrayList iList = idao.userInfoInquiry(udto);
		ArrayList cList = cdao.userInfoComplain(udto);

		request.setAttribute("ilist", iList);
		request.setAttribute("clist", cList);

		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/userInfo.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
