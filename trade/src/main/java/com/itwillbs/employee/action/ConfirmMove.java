package com.itwillbs.employee.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** ConfirmMove() : confirm 페이지로 이동하도록 함 **/

public class ConfirmMove {
		public static void alertLocation(HttpServletResponse response, String title, String msg) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println(" location.href='./Confirm.emp?title=" +title+ "&msg=" + msg);
				out.println("</script>");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
