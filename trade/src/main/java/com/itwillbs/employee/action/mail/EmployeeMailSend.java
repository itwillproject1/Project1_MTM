package com.itwillbs.employee.action.mail;

import java.util.ArrayList;

import com.itwillbs.employee.dto.MailDTO;
import com.itwillbs.employee.dto.UserDTO;

public class EmployeeMailSend {
	public static void sendMail(MailDTO mdto, ArrayList<UserDTO> udto) {
		// 이미지 없이 발송
		
	}
	
	public static void sendMail(MailDTO mdto, ArrayList<UserDTO> udto, String realPath) {
		// 이미지 포함 발송
		
	}
}
