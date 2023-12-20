package com.JobEmail.JobEmail.domain;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@Entity
@Table(name = "scheduledemails", schema = "dev_test")
public class ScheduledEmail implements Serializable{

	@Id
	@Column(name = "id_scheduled_email")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idScheduledEmail;
	
	@Column(name = "touser")
	private String toUser;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "message_send")
	private String messageSend;
	
	@Column(name = "scheduled_time")
	private LocalTime scheduledTime; // Hora programada
	
	@Enumerated(EnumType.STRING)  // Esta anotación indica que el enum se mapea como una cadena
	@Column(name = "scheduled_day")
	private DayOfWeek  scheduledDay;  // Día programado

}
