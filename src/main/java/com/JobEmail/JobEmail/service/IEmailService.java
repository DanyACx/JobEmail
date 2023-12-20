package com.JobEmail.JobEmail.service;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface IEmailService {

	// solo mensajes
	void sendEmail(String toUser, String subject, String message);
		
	//void sendEmail(String[] to, String subject, String body);
	void scheduleEmail(String to, String subject, String body, DayOfWeek scheduledDay, LocalTime scheduledTime);
}
