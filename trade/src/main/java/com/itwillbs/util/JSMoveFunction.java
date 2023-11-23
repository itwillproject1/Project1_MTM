package com.itwillbs.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 *  JSMoveFunction : 컨트롤러 사용 없이 JS만 사용해서 페이지 이동처리하는 객체
 *
 */
public class JSMoveFunction {
	
	// alert + location.href 기능
	public static void alertLocation(HttpServletResponse response, 
			                          String msg,
			                          String url) {
	//	System.out.println(" JSMoveFunction_alertLocation()호출 ");
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println(" alert('"+msg+"'); ");
			out.println(" location.href='"+url+"'; ");
			out.println("</script>");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// alert + history.back() 기능
	public static void alertHistory(HttpServletResponse response,
			                     String msg) {
	//	System.out.println(" JSMoveFunction_alertBack()호출 ");
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println(" alert('"+msg+"'); ");
			out.println(" history.back(); ");
			out.println("</script>");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void alertBack(HttpServletResponse response,
            String msg) {
	//	System.out.println(" JSMoveFunction_alertBack()호출  ");
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println(" alert('"+msg+"'); ");
			out.println(" history.back(); ");
			out.println("</script>");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(HttpServletResponse response,
            String msg) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println(" alert('"+msg+"'); ");
			out.println("window.close()");
			out.println("</script>");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close2(HttpServletResponse response) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("window.close()");
			out.println("</script>");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
