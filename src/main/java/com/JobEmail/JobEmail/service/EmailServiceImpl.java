package com.JobEmail.JobEmail.service;

import java.time.DayOfWeek;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.JobEmail.JobEmail.domain.ScheduledEmail;
import com.JobEmail.JobEmail.domain.repository.ScheduledEmailRepository;

@Service
public class EmailServiceImpl implements IEmailService{

	@Value("${email.sender}")
	private String emailUser;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
    private ScheduledEmailRepository scheduledEmailRepository;
	
	@Override
	public void sendEmail(String toUser, String subject, String message) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setFrom(emailUser); // cuenta que envia email
		mailMessage.setTo(toUser);
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		
		mailSender.send(mailMessage); // enviando el correo
		
	}
	
    @Override
    public void scheduleEmail(String toUser, String subject, String message, DayOfWeek scheduledDay, LocalTime scheduledTime) {
        ScheduledEmail scheduledEmail = new ScheduledEmail();
        scheduledEmail.setToUser(toUser);
        scheduledEmail.setSubject(subject);
        scheduledEmail.setMessageSend(message);
        scheduledEmail.setScheduledDay(scheduledDay);
        scheduledEmail.setScheduledTime(scheduledTime);
        System.out.println("hollaa");
        scheduledEmailRepository.save(scheduledEmail);
    }
}
