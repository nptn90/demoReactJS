package com.example.demo.course;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hazelcast.core.HazelcastInstance;

import net.javacrumbs.shedlock.core.SchedulerLock;

@Service
public class CourseDetailService {
	private static int count = 0;
	
	@Autowired
	private HazelcastInstance hazelCast;
	
	@Scheduled(fixedRate = 5000)
	@SchedulerLock(name = "TaskScheduler_scheduledTask", 
    lockAtLeastForString = "PT5S", lockAtMostForString = "PT10S")
	public void printCourse() {
		Map<String, Integer> mapValue = hazelCast.getMap("configuration");
		mapValue.put("data", ++count);
		System.out.println("I'm " + mapValue.get("data"));
	}
}
