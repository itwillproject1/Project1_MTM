package com.itwillbs.employee.action.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;

public class LoginForm implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cookie[] cookies = request.getCookies();
		String id_cookie = "";
		for(int i = 0; i<cookies.length; i++) {
			if(cookies[i].getName().equals("emp_id")) {
				id_cookie = cookies[i].getValue();
			}
		}
		request.setAttribute("id_cookie", id_cookie);
		ActionForward forward = new ActionForward();
		forward.setPath("./employee/member/login.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
