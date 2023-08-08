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
				//�̸��� ���� ���! 
		public String joinEmail(String email) {
			String setFrom = new EmailVO().getUserName(); // email-config�� ������ �ڽ��� �̸��� �ּҸ� �Է� 
			String toMail = email;
			String title = "ȸ�� ���� ���� �̸��� �Դϴ�."; // �̸��� ���� 
			String content = 
					"[Cucumber]ȸ������ ������ȣ �̸���" + 	//html �������� �ۼ� ! 
	                "<br><br>" + 
				    "���� ��ȣ�� " + authNumber + "�Դϴ�." + 
				    "<br>" + 
				    "�ش� ������ȣ�� ������ȣ Ȯ�ζ��� �����Ͽ� �ּ���."; //�̸��� ���� ����
			mailSend(setFrom, toMail, title, content);
			return authNumber;
		}
		
		public String sendPw(String email) {
			String setFrom = new EmailVO().getUserName(); // email-config�� ������ �ڽ��� �̸��� �ּҸ� �Է� 
			String toMail = email;
			String title = "��й�ȣ �缳�� �����Դϴ�"; // �̸��� ���� 
			String content = 
					"[Cucumber]��й�ȣ �缳�� �̸���" + 	//html �������� �ۼ� ! 
	                "<br><br>" + 
				    "��й�ȣ�� " + randomPw + "�Դϴ�." + 
				    "<br>" + 
				    "�ش� ��й�ȣ�� �α��� �� ��й�ȣ�� �ݵ�� �缳�� ���ּ���."; //�̸��� ���� ����
			mailSend(setFrom, toMail, title, content);
			return randomPw;
		}
		public int sendDel(String email) {
			String setFrom = new EmailVO().getUserName(); // email-config�� ������ �ڽ��� �̸��� �ּҸ� �Է� 
			String toMail = email;
			String title = "Cucumber �̿�ȳ�"; // �̸��� ���� 
			String content = 
					"[Cucumber]�̿�ȳ�" + 	//html �������� �ۼ� ! 
	                "<br><br>" + 
				    "�� ȸ�������� ������������ Ż��Ǿ����� �˷��帳�ϴ�."; //�̸��� ���� ����
			mailSend(setFrom, toMail, title, content);
			return 1;
		}
		
		//�̸��� ���� �޼ҵ�
		public void mailSend(String setFrom, String toMail, String title, String content) { 
			MimeMessage message = mailSender.createMimeMessage();
			// true �Ű����� �����ϸ� multipart ������ �޼��� ������ ����.���� ���ڵ� ������ �����ϴ�.
			try {
				MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
				helper.setFrom(setFrom);
				helper.setTo(toMail);
				helper.setSubject(title);
				// true ���� > html �������� ���� , �ۼ����� ������ �ܼ� �ؽ�Ʈ�� ����.
				helper.setText(content,true);
				mailSender.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		
	
}