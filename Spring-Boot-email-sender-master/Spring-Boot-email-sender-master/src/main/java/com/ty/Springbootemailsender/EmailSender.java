package com.ty.Springbootemailsender;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

	@Autowired
	JavaMailSender javaMailSender;

	public void sendMail(String toEmail, String Subject, String body) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		simpleMailMessage.setFrom("prashi9743@gmail.com");
		simpleMailMessage.setTo(toEmail);
		simpleMailMessage.setSubject(Subject);
		simpleMailMessage.setText(body);

		javaMailSender.send(simpleMailMessage);

		System.out.println("mail already sended.....!");
	}

	public void sendMailWithAttachment(String toEmail, String Subject, String body,String attachment) throws MessagingException {
		
		//we are creating MimeMessage object for passing into MimeMessageHelper constructor 
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		//we are creating MimeMessgeHelper Class object for setting the properties
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true); 
		
		mimeMessageHelper.setFrom("prashi9743@gmail.com");
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(Subject);
		
		FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
		
		mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		
		javaMailSender.send(mimeMessage);
		
		System.out.println("Mail send successully with attachment ...!");
	}
}
