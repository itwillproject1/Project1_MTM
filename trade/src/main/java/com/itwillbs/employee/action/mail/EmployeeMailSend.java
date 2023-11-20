package com.itwillbs.employee.action.mail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
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
			message.setSubject(mdto.getSubject());
			MimeMultipart multipart = new MimeMultipart("related");

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mdto.getContent(), "text/html;charset=utf-8");

			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);

			transport.connect();
			message.setRecipients(Message.RecipientType.TO, address);
			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
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
			message.setSubject(mdto.getSubject());
			
			MimeMultipart multipart = new MimeMultipart("related");

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mdto.getContent(), "text/html;charset=utf-8");

			multipart.addBodyPart(messageBodyPart);
			FileDataSource image = new FileDataSource(realPath + mdto.getImage());	// 파일 데이터 경로(/upload/fileName)

			messageBodyPart.setDataHandler(new DataHandler(image));	// 파일 데이터 불러오기 및 저장
			message.setContent(multipart);

			transport.connect();
			message.setRecipients(Message.RecipientType.TO, address);
			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;	// 발송 실패
		}
		return true;	// 발송 성공
	}
}
