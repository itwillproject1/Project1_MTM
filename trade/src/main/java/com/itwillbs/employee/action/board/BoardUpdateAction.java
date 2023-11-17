package com.itwillbs.employee.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.action.JSConfirmMoveFunction;
import com.itwillbs.employee.dao.BoardDAO;
import com.itwillbs.employee.dto.BoardDTO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.FileUpload;
import com.itwillbs.util.JSMoveFunction;
import com.oreilly.servlet.MultipartRequest;

/** BoardUpdateAction() : 게시판 수정 **/

public class BoardUpdateAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FileUpload upload = new FileUpload();
		MultipartRequest multi = upload.fileUpload(request);
		BoardDTO bdto = new BoardDTO();
		bdto.setBno(Integer.parseInt(multi.getParameter("bno")));
		bdto.setCategory(multi.getParameter("category"));
		bdto.setContent(multi.getParameter("content"));
		bdto.setSubject(multi.getParameter("subject"));
		bdto.setImage(multi.getFilesystemName("image"));
		MemberDTO mdto = new MemberDTO();
		mdto.setEmp_pw(multi.getParameter("emp_pw"));
		mdto.setEmp_id((String)request.getSession().getAttribute("emp_id"));
		System.out.println(mdto.getEmp_id() + " : " + mdto.getEmp_pw());
		BoardDAO dao = new BoardDAO();
		int result = dao.updateBoard(bdto, mdto);
		if(result == 1) {
			JSConfirmMoveFunction move = new JSConfirmMoveFunction();
			move.moveLocation(response, "./BoardUpdateConfirm.emp?subject=" + bdto.getSubject());
		}
		else {
			// history.back();
			JSMoveFunction move = new JSMoveFunction();
			move.alertBack(response, "오류 발생");
		}
		return null;
	}
}
