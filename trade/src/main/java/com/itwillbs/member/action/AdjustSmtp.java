package com.itwillbs.member.action;

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
 * 		mail-1.4.7.jar
 *
 */
 
public class AdjustSmtp implements Action {
	//Parameters : 에러날짜, 에러시간, 에러타입, (+Shell에서 파일명)	 ex) 20210420, 14:01:00, DDC, (+FileName)
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//	System.out.println(" M : findpwAction_execute() 호출");
		
		final String user = "qhtjd0812@gmail.com";   //발신메일 (이 사람 계정으로 보내겠다.)
        final String password = "vnoefkhfagpbbpzd";   //패스워드
        final String port="587";
        final String bodyEncoding = "UTF-8"; //콘텐츠 인코딩
        
		String rcemail = request.getParameter("email");
        
       // System.out.println(" 전달받은 이메일은" + rcemail);
        
        Random random = new Random();
        
        int ran = random.nextInt(99999);
        
        
        HttpSession session = request.getSession();
		session.setAttribute("random", ran);
		session.setAttribute("rcemail", rcemail);
		//System.out.println("리퀘스트에 저장된 숫자는" + session.getAttribute("random"));
		//System.out.println("숫자" + ran);
		
		
		
		
        List <String> arr=new ArrayList<String>();
        
        /*for (int i=0;i<args.length;i++) {
        arr.add(args[i]);
        } */  
        // SMTP 서버 정보를 설정한다.        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com"); 
        prop.put("mail.smtp.port", port); 
        prop.put("mail.smtp.auth", "true"); 
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.starttls.enable","true"); 
        
        Session session1 = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {        
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
        
        StringBuffer sb = new StringBuffer();
                                          
        //메시징 예외처리
        try {
        sb.append("<div class=\"container\"\r\n"
        + "style=\"max-width: 350px; max-height: 630px; overflow: hidden; margin: 30px auto 0; box-shadow: 0 0 40px #a0a0a0; font-family: '\r\n"
        + "OpenSans', sans-serif; OpenSans', sans-serif;\">\r\n"
        + "<div class=\"timeline\">\r\n"
        + "<ul\r\n"
        + "style=\"padding: 1em 0 0 2em; margin: 0; list-style: none; position: relative;\">\r\n"
        + "<li>\r\n"
        + "<div class=\"bullet pink\"\r\n"
        + "style=\"width: 1em; height: 1em; box-sizing: border-box; border-radius: 50%; background: #fff; z-index: 1; margin-right: 1em; border: 2px solid #f93b69; display: inline-block; margin: 1em 0; vertical-align: top;\"></div>\r\n"
        + "<div class=\"time\"\r\n"
        + "style=\"width: 20%; font-size: 0.75em; padding-top: 0.25em; display: inline-block; margin: 1em 0; vertical-align: top;\"> "+"</div>\r\n"
        + "<div class=\"desc\"\r\n"
        + "style=\"width: 50%; display: inline-block; margin: 1em 0; vertical-align:"
        + " top;\">\r\n"
        + "<h3 style=\"font-size: 0.9em; font-weight: 400; margin: 0;\">인증번호입니당"+ ran +"</h3>\r\n"
        + "<h4\r\n"
        + "style=\"margin: 0; font-size: 0.7em; font-weight: 400; color: #808080;\">  rc이메일 들어갓니? "+"</h4>\r\n"
        + "</div>\r\n"
        + "</li>\r\n"
        + "</ul>\r\n"
        + "</div>\r\n"
        + "</div>");
        
        //sb.append(arr.get(0)+"\n");
        //sb.append(arr.get(1)+"\n");
        String html = sb.toString();
        
        
    		//메시지 포맷을 담기위해 생성
            MimeMessage message = new MimeMessage(session1);
            // 메일 콘텐츠 설정
            Multipart mParts = new MimeMultipart();
            MimeBodyPart mTextPart = new MimeBodyPart();
            MimeBodyPart mFilePart = null;
            
            //이메일 헤더 설정
            message.setHeader("content-Type", "text/html");
            
            
            //발신자 설정
            message.setFrom(new InternetAddress(user));

            //수신자메일
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(rcemail)); 

            //제목
            //message.setSubject("※BATCH ERROR - TYPE : "+arr.get(2)+" // File : "+arr.get(3)); //메일 제목을 입력
            message.setSubject("이메일 인증 해!");
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
            
            //send
            Transport.send(message); //javax.mail.Transport임
            
            //전송 후, Console 확인용
          //  System.out.println("전송완료");
            
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
        
		
        JSMoveFunction.alertLocation(response, "전송완료!", "../member/findpw.jsp");
			
		return null;
		
	}
}