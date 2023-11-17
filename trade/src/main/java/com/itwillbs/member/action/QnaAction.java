package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.InquiryDAO;
import com.itwillbs.member.db.InquiryDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class QnaAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");

		ActionForward forward = new ActionForward();

		// 로그인 제어
		if (user_id == null) {
			forward.setPath("./Main.me");
			forward.setRedirect(true);
			return forward;
		}

		// 첨부이미지
		String realPath = request.getRealPath("upload");
		int maxSize = 5 * 1024 * 1024; // 파일 크기 byte * kb * mb(5MB)
		MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());
		
		// 전달정보 저장(DTO)
		InquiryDTO idto = new InquiryDTO();
		
		idto.setUser_id(user_id);
		idto.setSubject(multi.getParameter("subject"));
		idto.setCategory(multi.getParameter("qnaCategory"));
		idto.setContent(multi.getParameter("content"));
		idto.setImage(multi.getFilesystemName("image"));
		idto.setPw(multi.getParameter("pw"));

		// DAO 글작성 메서드
		InquiryDAO idao = new InquiryDAO();
		int bno = idao.uploadQna(idto);
		
		JSMoveFunction.alertLocation(response, "문의글 등록에 성공했습니다.", "../member/QnaContent.member?bno=" + bno);
		
		return null;
	}

}
