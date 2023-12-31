package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// System.out.println(" M : MemberUpdateProAction_execute() 호출 ");

		// 로그인 세션제어
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("user_id");

		// System.out.println(id);

		ActionForward forward = new ActionForward();
		if (id == null) {
			forward.setPath("./Login.member");
			forward.setRedirect(true);
			return forward;
		}

		// 한글처리
		request.setCharacterEncoding("UTF-8");

		String realPath = request.getRealPath("/uploadprofile");

		int maxSize = 5 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());
		// 전달된 수정정보 저장(DTO)

		MemberDTO dto = new MemberDTO();
		dto.setUser_id(id);
		dto.setPassword(multi.getParameter("password"));
		dto.setUser_nickname(multi.getParameter("user_nickname"));
		dto.setEmail(multi.getParameter("email"));
		dto.setAddress(multi.getParameter("address"));
		dto.setPhone(multi.getParameter("phone"));
		dto.setAgree(multi.getParameter("agree"));
		dto.setProfile(multi.getFilesystemName("profile"));

		// MemberDAO객체 - 정보수정메서드 호출
		MemberDAO dao = new MemberDAO();
		int result = dao.updateMember(dto);

		// 결과에 따른 페이지 이동(JS)
		// JSMoveFunction.alertLocation(response,msg,url);
		if (result == 1) { // 수정완료 -> 메인페이지로 이동
			JSMoveFunction.alertLocation(response, "회원정보 수정완료!", "../main/Main.com");
			return null;
		} else if (result == 0) { // 수정실패 -> 비밀번호 오류 -> 뒤로가기 이동
			JSMoveFunction.alertBack(response, "수정실패X- 비밀번호 오류");
			return null;
		} else { // result == -1
			JSMoveFunction.alertBack(response, "회원정보가 없음!!!");
		}

		return null;
	}

}
