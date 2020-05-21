package com.example.demo.course;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import net.javacrumbs.shedlock.core.SchedulerLock;

@Service
public class CourseDetailService {
	private static int count = 0;
	
	@Scheduled(fixedRate = 5000)
	@SchedulerLock(name = "TaskScheduler_scheduledTask", 
    lockAtLeastForString = "PT5S", lockAtMostForString = "PT10S")
	public void printCourse() {
		System.out.println("I'm " + ++count);
	}
}
