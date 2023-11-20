package com.itwillbs.employee.action.mail;

import java.util.ArrayList;

import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.employee.action.JSConfirmMoveFunction;
import com.itwillbs.employee.dao.MailDAO;
import com.itwillbs.employee.dao.UserDAO;
import com.itwillbs.employee.dto.MailDTO;
import com.itwillbs.employee.dto.UserDTO;
import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.FileUpload;
import com.itwillbs.util.JSMoveFunction;
import com.oreilly.servlet.MultipartRequest;

/** EmployeeMailSendAction : 메일 전송 진행 **/

public class EmployeeMailSendAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDAO dao = new UserDAO();
		
		// agree = '동의' 인 계정 리스트 불러오기
		ArrayList<UserDTO> list = dao.mailAgreeList();
		if(list.size() == 0) {
			// 동의 계정이 한 개도 없을 경우
			JSMoveFunction.alertLocation(response, "수신 할 수 있는 회원이 없습니다!", "./MailList.emp");
		}
		
		MultipartRequest multi = FileUpload.fileUpload(request);
		MailDTO mail = new MailDTO();
		mail.setEmp_id((String) request.getSession().getAttribute("emp_id"));
		mail.setSubject(multi.getParameter("subject"));
		mail.setContent(multi.getParameter("content"));
		mail.setImage(multi.getFilesystemName("image"));
		
		// 이메일 배열 등록
		InternetAddress[] address = new InternetAddress[list.size()];	
		for(int i = 0; i<list.size(); i++) address[i] = new InternetAddress(list.get(i).getAddress());
		
		boolean mailSent = false;
		// 이미지가 없을 시
		if(mail.getImage() == null) mailSent = EmployeeMailSend.sendMail(mail, address);
		
		// 이미지가 있을 시
		else mailSent = EmployeeMailSend.sendMail(mail, address, request.getRealPath("upload"));
		
		if(mailSent) { // 만약 전송이 완료되었을 시
			MailDAO mdao = new MailDAO();
			// 전송 후, 데이터베이스 입력 진행
			mdao.mailInsert(mail);
			
			String result = "result=" + list.get(0).getUser_id();
			result += "&size=" + list.size();
			
			JSConfirmMoveFunction.moveLocation(response, result);
		}
		else {
			JSMoveFunction.alertBack(response, "오류 발생");
		}
		return null;
	}
}
