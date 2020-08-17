package com.springmaildemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.springmaildemo.domain.MailSenderService;

@Service("emailService")
	public class EmailService  implements IEmailService
	{
	    @Autowired
	    private JavaMailSender mailSender;
	      
	    @Autowired
	    private SimpleMailMessage preConfiguredMessage;
	  
	    @Override
	    public String sendMail(MailSenderService mailSenderService) 
	    {	
	    	
	    	System.out.println(mailSenderService.getMessage());
	    	System.out.println(mailSenderService.getSubject());
	    	System.out.println(mailSenderService.getSenderMailId());
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(mailSenderService.getSenderMailId());
	        message.setSubject(mailSenderService.getSubject());
	        message.setText(mailSenderService.getMessage());
	        mailSender.send(message);
	        return "Mail Sent to successfully";
	    }
	  

	    public void sendPreConfiguredMail(String message) 
	    {
	        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
	        mailMessage.setText(message);
	        mailSender.send(mailMessage);
	    }
	    
	    
	    
	}


