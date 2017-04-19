package com.practice.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {
    final static String MY_MAIL = "@gmail.com";
    final static String MY_PASSWORD = "111";
	
	/**
	 * 發送郵件
	 * 
	 * @param sendTo
	 *            : 收件人
	 * @param subject
	 *            : 主題
	 * @param content
	 *            : 信件內容
	 */
	public static void sendMail(String sendTo, String subject, String content) {
		try {
			Message message = createMail();
			message.addRecipient(RecipientType.TO, new InternetAddress(sendTo)); // 設置收件人
			message.setSubject(subject); // 設置標題
			message.setContent(content,"text/html;charset=UTF-8");
			Transport.send(message);// 發送mail
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	private static Message createMail() throws AddressException, MessagingException{
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", 587);
		

		   props.put("mail.smtp.socketFactory.port", "465");
		   props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

		   
		// 建立連接object
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MY_MAIL, MY_PASSWORD);
			}
		});
		// 建立mail物件
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(MY_MAIL));
		return message;
	}
}
