package com.three.cucumber.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.three.cucumber.vo.EmailVO;

@Component
public class MailSendService {
	@Autowired
	private JavaMailSender mailSender;
	Makenum makenum = new Makenum();
	MakePw makepw = new MakePw();
	private String authNumber = makenum.random(); 
	private String randomPw = makepw.random();
				//이메일 보낼 양식! 
		public String joinEmail(String email) {
			String setFrom = new EmailVO().getUserName(); // email-config에 설정한 자신의 이메일 주소를 입력 
			String toMail = email;
			String title = "회원 가입 인증 이메일 입니다."; // 이메일 제목 
			String content = 
					"[Cucumber]회원가입 인증번호 이메일" + 	//html 형식으로 작성 ! 
	                "<br><br>" + 
				    "인증 번호는 " + authNumber + "입니다." + 
				    "<br>" + 
				    "해당 인증번호를 인증번호 확인란에 기입하여 주세요."; //이메일 내용 삽입
			mailSend(setFrom, toMail, title, content);
			return authNumber;
		}
		
		public String sendPw(String email) {
			String setFrom = new EmailVO().getUserName(); // email-config에 설정한 자신의 이메일 주소를 입력 
			String toMail = email;
			String title = "비밀번호 재설정 메일입니다"; // 이메일 제목 
			String content = 
					"[Cucumber]비밀번호 재설정 이메일" + 	//html 형식으로 작성 ! 
	                "<br><br>" + 
				    "비밀번호는 " + randomPw + "입니다." + 
				    "<br>" + 
				    "해당 비밀번호로 로그인 후 비밀번호를 반드시 재설정 해주세요."; //이메일 내용 삽입
			mailSend(setFrom, toMail, title, content);
			return randomPw;
		}
		public int sendDel(String email) {
			String setFrom = new EmailVO().getUserName(); // email-config에 설정한 자신의 이메일 주소를 입력 
			String toMail = email;
			String title = "Cucumber 이용안내"; // 이메일 제목 
			String content = 
					"[Cucumber]이용안내" + 	//html 형식으로 작성 ! 
	                "<br><br>" + 
				    "현 회원께서는 규정위반으로 탈퇴되었음을 알려드립니다."; //이메일 내용 삽입
			mailSend(setFrom, toMail, title, content);
			return 1;
		}
		
		//이메일 전송 메소드
		public void mailSend(String setFrom, String toMail, String title, String content) { 
			MimeMessage message = mailSender.createMimeMessage();
			// true 매개값을 전달하면 multipart 형식의 메세지 전달이 가능.문자 인코딩 설정도 가능하다.
			try {
				MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
				helper.setFrom(setFrom);
				helper.setTo(toMail);
				helper.setSubject(title);
				// true 전달 > html 형식으로 전송 , 작성하지 않으면 단순 텍스트로 전달.
				helper.setText(content,true);
				mailSender.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		
	
}