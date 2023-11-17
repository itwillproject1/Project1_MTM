package com.itwillbs.employee.action.mail;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

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
import com.itwillbs.employee.dto.UserDTO;

public class EmployeeMailSend {
	private static final String id = "qhtjd0812";   //발신메일 (이 사람 계정으로 보내겠다.)
    private static final String pw = "vnoefkhfagpbbpzd";   //패스워드
	private static String email = "@gmail.com";
	private static String port = "25";
	private static Session session;
	private static Transport transport;

	private static Session setSession(Properties prop) {
		return Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(id, pw);
			}
		});
	}

	private static MimeMessage getMessage() {
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

	private static InternetAddress[] getAddress(ArrayList<UserDTO> udto, int start, int size) {
		InternetAddress[] address = new InternetAddress[size];
		for (int i = start; i < start + size; i++) {
			try {
				address[i] = new InternetAddress(udto.get(i).getAddress());
			} catch (AddressException e) {
				e.printStackTrace();
			}
		}
		return address;
	}

	public static void sendMail(MailDTO mdto, ArrayList<UserDTO> udto) throws MessagingException {
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
		message.setSubject(mdto.getSubject());

		MimeMultipart multipart = new MimeMultipart("related");

		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(mdto.getContent(), "text/html;charset=utf-8");

		multipart.addBodyPart(messageBodyPart);
		message.setContent(multipart);
		Queue<InternetAddress> queue = new LinkedList<InternetAddress>();
		int count = 0;
		while (queue.size() < udto.size()) {
			queue.add(new InternetAddress(udto.get(count++).getAddress()));
		}
		InternetAddress[] address = null;
		count = 0;
		address = new InternetAddress[queue.size()];
		while (queue.size() > 0) {
			address[count] = queue.poll();
			count++;
		}

		transport.connect();
		message.setRecipients(Message.RecipientType.TO, address);
		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		transport.close();
	}

	public static void sendMail(MailDTO mdto, ArrayList<UserDTO> udto, String realPath) throws MessagingException {
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
		message.setSubject(mdto.getSubject());

		MimeMultipart multipart = new MimeMultipart("related");

		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(mdto.getContent(), "text/html;charset=utf-8");

		multipart.addBodyPart(messageBodyPart);
		FileDataSource image = new FileDataSource(realPath + mdto.getImage());

		messageBodyPart.setDataHandler(new DataHandler(image));
		message.setContent(multipart);
		Queue<InternetAddress> queue = new LinkedList<InternetAddress>();
		int count = 0;
		while (queue.size() < udto.size()) {
			queue.add(new InternetAddress(udto.get(count++).getAddress()));
		}
		InternetAddress[] address = null;
		count = 0;
		address = new InternetAddress[queue.size()];
		while (queue.size() > 0) {
			address[count] = queue.poll();
			count++;
		}

		transport.connect();
		message.setRecipients(Message.RecipientType.TO, address);
		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		transport.close();
	}
}
