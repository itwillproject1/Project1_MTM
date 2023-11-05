package com.itwillbs.util;

/**
 *  ActionForward - 페이지 이동에 필요한 정보를 저장하는 객체 (기차표-티켓)
 *    이동할 주소 : path (목적지)
 *    이동할 방식 : isRedirect - true  : sendRedirect() 방식으로 이동  (직행/환승)
 *                                       가상->가상 (주소변경O,화면변경O)
 *                             - false : forward() 방식으로 이동
 *                             			 가상->실제 (주소변경X,화면변경O)							
 */
public class ActionForward {
	private String path;
	private boolean isRedirect;
	
	public ActionForward() {
		System.out.println(" -------------------");
		System.out.println(" 티켓정보 생성 ");
		System.out.println(" 목적지-X, 방식-X ");
		System.out.println(" -------------------");
	}
	
	// alt shift s + r  (get/set)
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() { // get메서드
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	// alt shift s + s
	@Override
	public String toString() {
		return "ActionForward(티켓) [path(목적지)=" + path + ", isRedirect(방법)=" + isRedirect + "]";
	}
	
}
