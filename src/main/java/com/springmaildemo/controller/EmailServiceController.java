package com.springmaildemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springmaildemo.domain.MailSenderService;
import com.springmaildemo.service.IEmailService;


@RestController
public class EmailServiceController {
	@Autowired
	IEmailService emailService;
	
	@PostMapping("/contactus")
	public String contactus(@RequestBody MailSenderService mailSender) {
		return emailService.sendMail(mailSender);
		
	}
	
	

}
