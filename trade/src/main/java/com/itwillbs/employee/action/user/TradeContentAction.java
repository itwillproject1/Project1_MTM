package com.itwillbs.employee.action.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dao.TradeDAO;
import com.itwillbs.employee.dto.TradeDTO;
import com.itwillbs.employee.dto.UserDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class TradeContentAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null)
			pageNum = "1";
		int bno = Integer.parseInt(request.getParameter("bno"));
		TradeDAO dao = new TradeDAO();
		TradeDTO dto = dao.tradeContent(bno);

		int suggestCount = dao.suggestCount(bno, dto.getDeal_way());
		ArrayList suggestList = null;
		if (suggestCount > 0)
			suggestList = dao.suggestList(bno, dto.getDeal_way());
		else
			suggestList = new ArrayList();

		ActionForward forward = new ActionForward();
		forward.setPath("./employee/user/tradeContent.jsp");
		forward.setRedirect(false);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("dto", dto);
		request.setAttribute("suggestCount", suggestCount);
		request.setAttribute("sList", suggestList);
		return forward;
	}
}
