package com.itwillbs.product.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.util.Action;
import com.itwillbs.util.ActionForward;
import com.itwillbs.util.JSMoveFunction;

/**
 * 
 * mail-1.4.7.jar
 *
 */

public class SendMail implements Action {
	// Parameters : 에러날짜, 에러시간, 에러타입, (+Shell에서 파일명) ex) 20210420, 14:01:00, DDC,
	// (+FileName)
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//	System.out.println(" M : SendMail.execute() 호출");

		final String user = "qhtjd0812@gmail.com"; // 발신메일 (이 사람 계정으로 보내겠다.)
		final String password = "vnoefkhfagpbbpzd"; // 패스워드
		final String port = "587";
		final String bodyEncoding = "UTF-8"; // 콘텐츠 인코딩

		String seller_email = (String) request.getAttribute("seller_email");

		// SMTP 서버 정보 설정
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", port);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		prop.put("mail.smtp.starttls.enable", "true");

		Session session1 = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
			StringBuffer sb = new StringBuffer();
            
	        //메시징 예외처리
	        try {
	        sb.append("상품정보가 업데이트 되었습니다.<br>"
	        + "이름: " + request.getAttribute("buyer_name")
	        + "번호: " + request.getAttribute("buyer_phone")
	        + "주소: " + request.getAttribute("address")
	        + "판매 물건: <a href='http://c7d2307t1.itwillbs.com/trade/product/ProductContent.com?bno="+ request.getAttribute("sell_bno") +"'>글번호: "+ request.getAttribute("sell_bno") +"</a>" 
	        );
	        
	        //sb.append(arr.get(0)+"\n");
	        //sb.append(arr.get(1)+"\n");
	        String html = sb.toString();
			
			// 메시지 포맷을 담기위해 생성
			MimeMessage message = new MimeMessage(session1);
			
			// 메일 콘텐츠 설정
			Multipart mParts = new MimeMultipart();
			MimeBodyPart mTextPart = new MimeBodyPart();
			MimeBodyPart mFilePart = null;

			// 이메일 헤더 설정
			message.setHeader("content-Type", "text/html");

			// 발신자 설정
			message.setFrom(new InternetAddress(user));

			// 수신자메일
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(seller_email));

			// 제목
			message.setSubject("상품 정보가 업데이트 되었습니다.");
			
			// 메일 콘텐츠 - 내용
			mTextPart.setText(html, bodyEncoding, "html");
			mParts.addBodyPart(mTextPart);

			// 메일 콘텐츠 설정
			message.setContent(mParts);

			// MIME 타입 설정
			MailcapCommandMap MailcapCmdMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
			MailcapCmdMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
			MailcapCmdMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
			MailcapCmdMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
			MailcapCmdMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
			MailcapCmdMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
			CommandMap.setDefaultCommandMap(MailcapCmdMap);

			// send
			Transport.send(message); // javax.mail.Transport임

			// 전송 후, Console 확인용
		//	System.out.println("전송완료");

		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return null;
	}
}