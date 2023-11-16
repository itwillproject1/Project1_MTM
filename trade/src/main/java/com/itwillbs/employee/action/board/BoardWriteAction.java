package com.itwillbs.employee.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.action.JSConfirmMoveFunction;
import com.itwillbs.employee.dao.BoardDAO;
import com.itwillbs.employee.dao.DAO;
import com.itwillbs.employee.dto.BoardDTO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.FileUpload;
import com.itwillbs.util.JSMoveFunction;
import com.oreilly.servlet.MultipartRequest;

public class BoardWriteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FileUpload upload = new FileUpload();
		MultipartRequest multi = upload.fileUpload(request);
		BoardDTO bdto = new BoardDTO();
		MemberDTO mdto = new MemberDTO();
		bdto.setCategory(multi.getParameter("category"));
		bdto.setContent(multi.getParameter("content"));
		bdto.setImage(multi.getFilesystemName("image"));
		bdto.setSubject(multi.getParameter("subject"));
		
		mdto.setEmp_id((String)request.getSession().getAttribute("emp_id"));
		mdto.setEmp_pw(request.getParameter("emp_pw"));
		BoardDAO dao = new BoardDAO();
		int result = dao.insertBoard(bdto, mdto);
		if(result == 1) {
			JSConfirmMoveFunction move = new JSConfirmMoveFunction();
			move.moveLocation(response, "./BoardWriteConfirm.emp?subject=" + bdto.getSubject());
		}
		else {
			JSMoveFunction move = new JSMoveFunction();
			move.alertBack(response, "오류 발생");
		}
		return null;
	}
}
