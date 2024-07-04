package com.utility;

import java.io.File;

import org.hibernate.pretty.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailSender 
{
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(String subject,String body,String to,File f) {
		
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage, true);
			messageHelper.setSubject(subject);
			messageHelper.setText(body);
			messageHelper.setTo(to);
			messageHelper.addAttachment("Plans-info", f);
			mailSender.send(mimeMessage);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}

}
