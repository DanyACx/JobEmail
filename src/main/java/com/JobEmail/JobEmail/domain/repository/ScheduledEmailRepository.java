package com.JobEmail.JobEmail.domain.repository;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JobEmail.JobEmail.domain.ScheduledEmail;

public interface ScheduledEmailRepository extends JpaRepository<ScheduledEmail, Integer>{

	List<ScheduledEmail> findByScheduledDayAndScheduledTime(DayOfWeek scheduledDay, LocalTime scheduledTime);
}
