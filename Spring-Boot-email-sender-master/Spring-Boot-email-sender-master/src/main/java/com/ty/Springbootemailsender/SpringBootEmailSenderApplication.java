package com.ty.Springbootemailsender;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringBootEmailSenderApplication {
	
	@Autowired
	EmailSender emailSender;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailSenderApplication.class, args);
	}
	
//	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail() {
		emailSender.sendMail("prashantha2607@gmail.com", "This is Subject of mail", "This is the Body of the mail");
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void SendMailWithAttachement() throws MessagingException {
		emailSender.sendMailWithAttachment("prashantha2607@gmail.com",
				"This is Subject of mail",
				"This is the Body of the mail", 
				"C:/Users/Prashant/Desktop/Resume/Prashantha Resume.pdf");
	}
}
