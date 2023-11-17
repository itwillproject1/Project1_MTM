package com.itwillbs.employee.action.mail;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.action.JSConfirmMoveFunction;
import com.itwillbs.employee.dao.MailDAO;
import com.itwillbs.employee.dao.UserDAO;
import com.itwillbs.employee.dto.MailDTO;
import com.itwillbs.employee.dto.MemberDTO;
import com.itwillbs.employee.dto.UserDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.FileUpload;
import com.itwillbs.util.JSMoveFunction;
import com.oreilly.servlet.MultipartRequest;

public class EmployeeMailSendAction implements Action{
	@SuppressWarnings("deprecation")
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDAO dao = new UserDAO();
		ArrayList<UserDTO> list = dao.mailAgreeList();
		if(list.size() == 0) {
			JSMoveFunction.alertBack(response, "수신 할 수 있는 회원이 없습니다!");
		}
		MultipartRequest multi = FileUpload.fileUpload(request);
		MailDTO mail = new MailDTO();
		mail.setEmp_id((String) request.getSession().getAttribute("emp_id"));
		mail.setSubject(multi.getParameter("subject"));
		mail.setContent(multi.getParameter("content"));
		mail.setImage(multi.getFilesystemName("image"));
		if(mail.getImage() == null) EmployeeMailSend.sendMail(mail, list);
		else EmployeeMailSend.sendMail(mail, list, request.getRealPath("upload"));
		
		MailDAO mdao = new MailDAO();
		mdao.mailInsert(mail);
		
		String result = "result=" + list.get(0).getUser_id();
		result += "&size=" + list.size();
		
		JSConfirmMoveFunction.moveLocation(response, result);
		return null;
	}
}
