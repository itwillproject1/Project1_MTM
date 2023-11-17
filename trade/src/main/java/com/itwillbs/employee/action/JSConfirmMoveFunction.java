package com.itwillbs.employee.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class JSConfirmMoveFunction {
	// location.href 기능
	public static void moveLocation(HttpServletResponse response, String url) {
		System.out.println(" JSMoveFunction_alertLocation()호출 ");
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println(" location.href='" + url + "'; ");
			out.println("</script>");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
