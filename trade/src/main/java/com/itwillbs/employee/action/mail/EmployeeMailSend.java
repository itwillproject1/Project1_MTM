package com.itwillbs.employee.action.mail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.itwillbs.employee.dto.MailDTO;

/** EmployeeMailSend : 직원용 단체 메일 발송 **/

public class EmployeeMailSend {
	private static final String id = "qhtjd0812";   //발신메일 (이 사람 계정으로 보내겠다.)
    private static final String pw = "vnoefkhfagpbbpzd";   //패스워드
	private static String email = "@gmail.com";
	private static String port = "25";
	private static Session session;
	private static Transport transport;

	private static Session setSession(Properties prop) {
		// 메일 세션 설정
		return Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(id, pw);
			}
		});
	}

	private static MimeMessage getMessage() {
		// 세션에 의한 메일 생성 및 발신자 이메일 적용
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(id + email));
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return message;
	}


	public static boolean sendMail(MailDTO mdto, InternetAddress[] address){
		// 이미지 없이 발송
		Properties prop = new Properties();
		try {
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", port);
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			prop.put("mail.smtp.starttls.enable", "true");
		} catch (Exception e) {
			e.printStackTrace();
		}

		session = setSession(prop);
		session.setDebug(true);

		try {
			transport = session.getTransport();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
		MimeMessage message = getMessage();
		try {
			// 제목 설정
			message.setSubject(mdto.getSubject());
			
			// MimeBodyPart 저장할 구간
			MimeMultipart multipart = new MimeMultipart("related");
			
			// 텍스트 설정
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText(mdto.getContent(), "UTF-8", "html");
			multipart.addBodyPart(textPart);
			
			// 메세지 세팅
			message.setContent(multipart);
			
			// 연결
			transport.connect();
			
			for(int i = 0; i<address.length; i++) {
				// 메세지 발송
				message.setRecipient(Message.RecipientType.TO, address[i]);
				Transport.send(message);
			}
			// 연결 해제
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean sendMail(MailDTO mdto, InternetAddress[] address, String realPath) {
		// 이미지 포함 발송
		Properties prop = new Properties();
		try {
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", port);
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			prop.put("mail.smtp.starttls.enable", "true");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session = setSession(prop);
		session.setDebug(true);
		try {
			transport = session.getTransport();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
		
		MimeMessage message = getMessage();
		try {
			// 제목 설정
			message.setSubject(mdto.getSubject());
			
			// MimeBodyPart을 여러개 저장
			MimeMultipart multipart = new MimeMultipart("related");
			
			// 텍스트
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText(mdto.getContent(), "UTF-8", "html");
			multipart.addBodyPart(textPart);
			
			// 파일
			MimeBodyPart imagePart = new MimeBodyPart();
			DataSource image = new FileDataSource(realPath + "\\" + mdto.getImage());	// 파일 데이터 경로(/upload/fileName)"
			imagePart.setDataHandler(new DataHandler(image));	// 파일 데이터 불러오기 및 저장
			multipart.addBodyPart(imagePart);
			
			// 메세지 세팅
			message.setContent(multipart);
			
			// 연결
			transport.connect();
			for(int i = 0; i<address.length; i++) {
				// 메일 전송
				message.setRecipient(Message.RecipientType.TO, address[i]);
				Transport.send(message);
			}
			// 연결 해제
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;	// 발송 실패
		}
		return true;	// 발송 성공
	}
}
