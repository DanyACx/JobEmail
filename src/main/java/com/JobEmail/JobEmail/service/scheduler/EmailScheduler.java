package com.JobEmail.JobEmail.service.scheduler;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.JobEmail.JobEmail.domain.ScheduledEmail;
import com.JobEmail.JobEmail.domain.repository.ScheduledEmailRepository;
import com.JobEmail.JobEmail.service.IEmailService;


@Component
public class EmailScheduler {

	 @Autowired
	 private IEmailService emailService;

	 @Autowired
	 private ScheduledEmailRepository scheduledEmailRepository;

	// @Scheduled(cron = "0 0 10 * * MON-FRI") // Programado para ejecutarse de lunes a viernes a las 10 AM
	 @Scheduled(cron = "0 */1 * * * MON-SUN") // Cada 2 minutos de domingo a sábado
	// @Scheduled(cron = "0 * * * * MON-SUN")
	 public void sendScheduledEmails1() {
	    // sendScheduledEmailsForTime(LocalTime.of(10, 0));
		 sendScheduledEmailsForTime(LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS));
	 }

	// @Scheduled(cron = "0 0 11 * * MON-FRI") // Programado para ejecutarse de lunes a viernes a las 11 AM
	 @Scheduled(cron = "0 */2 * * * MON-SUN") // Cada 4 minutos de domingo a sábado
	 public void sendScheduledEmails2() {
	    // sendScheduledEmailsForTime(LocalTime.of(11, 0));
		 sendScheduledEmailsForTime(LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS));
	 }

	// @Scheduled(cron = "0 0 15 * * MON-FRI") // Programado para ejecutarse de lunes a viernes a las 3 PM
	 @Scheduled(cron = "0 */3 * * * MON-SUN") // Cada 6 minutos de domingo a sábado
	 public void sendScheduledEmails3() {
	     //sendScheduledEmailsForTime(LocalTime.of(15, 0));
		 sendScheduledEmailsForTime(LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS));
	 }

	private void sendScheduledEmailsForTime(LocalTime scheduledTime) {
		 System.out.println("Entró al método sendScheduledEmailsForTime");
	     DayOfWeek currentDay = LocalDate.now().getDayOfWeek();
	     System.out.println("Día de la semana actual: " + currentDay);
	     System.out.println("Holaaa: " + scheduledTime);
	     List<ScheduledEmail> scheduledEmails = scheduledEmailRepository.findByScheduledDayAndScheduledTime(currentDay, scheduledTime);
	     
	     System.out.println("Cantidad de correos programados encontrados: " + scheduledEmails.size());

	     for (ScheduledEmail scheduledEmail : scheduledEmails) {
	         emailService.sendEmail(scheduledEmail.getToUser(), scheduledEmail.getSubject(), scheduledEmail.getMessageSend());
	         System.out.println("veri: "+ scheduledEmail.getToUser());
	         scheduledEmailRepository.delete(scheduledEmail);
	         
	      // Imprimir mensaje en consola
	      System.out.println("Correo enviado a " + scheduledEmail.getToUser() +
	      " con asunto '" + scheduledEmail.getSubject() +
	      "' y mensaje '" + scheduledEmail.getMessageSend() + "'");
	     }
	 }
}
