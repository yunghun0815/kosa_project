package com.kosa.app.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@Autowired
	JavaMailSender javaMailSender;
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@ResponseBody
	@GetMapping("/mail")
	public String sendMail() {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			//인증코드 1000 ~ 9999 랜덤한 숫자
			int code = (int) (Math.random() * (9999-1000)) + 1000 ;
			
			
			//메일 제목 설정
			message.setSubject("제목~~");
			
			//메일 내용 설정
			String text = "<div style=\"width: 100px; height: 100px; border: 1px solid black; text-align: center;\">인증코드 :" + code + "</div>";
			message.setText(text, "utf-8", "html");
			
			//받는사람 설정
			message.addRecipients(RecipientType.TO, "yunghun0815@gmail.com");
			
			javaMailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "SUCCESS";
	}
}
