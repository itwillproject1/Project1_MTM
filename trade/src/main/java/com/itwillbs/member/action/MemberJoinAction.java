package com.itwillbs.member.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class MemberJoinAction implements Action  {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println(" M : MemberJoinAction_execute() 실행 ");
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		String realPath = request.getRealPath("/uploadprofile");
		System.out.println(" M : realPath :"+realPath);
		
		int maxSize = 5 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request,realPath,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		
		// 드롭다운 전달정보 (생년월일, 휴대폰번호, 이메일)
		String jumin = multi.getParameter("jumin1")+"-"+multi.getParameter("jumin2")+"-"+multi.getParameter("jumin3");
		String phone = multi.getParameter("phone1")+"-"+multi.getParameter("phone2")+"-"+multi.getParameter("phone3");
		String email = multi.getParameter("email1")+multi.getParameter("email2");
		
		
		
		// 전달정보
		MemberDTO dto = new MemberDTO();
		dto.setUser_id(multi.getParameter("user_id"));
		dto.setPassword(multi.getParameter("password"));
		dto.setEmail(email);
		dto.setUser_name(multi.getParameter("user_name"));
		dto.setJumin(jumin);
		dto.setGender(multi.getParameter("gender"));
		dto.setPhone(phone);
		dto.setAddress(multi.getParameter("address"));
		dto.setUser_nickname(multi.getParameter("user_nickname"));
		dto.setProfile(multi.getFilesystemName("profile"));
		dto.setRecommend(multi.getParameter("recommend"));
		dto.setAgree(multi.getParameter("agree"));
		
		System.out.println(" M : "+dto);
		MemberDAO dao = new MemberDAO();
		dao.insertMember(dto);
		
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println(" <script> ");
//		out.println("  alert('회원가입완료 '); ");
//		out.println("location.href='../main/Main.com'");
//		out.println(" </script> ");
//		out.close();
		
		ActionForward forward = new ActionForward();
		forward.setPath("../main/realmain.jsp");
		forward.setRedirect(false);
		return forward;
		
	}

	

	
	
}
