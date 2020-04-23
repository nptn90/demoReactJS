package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping(value = "/api/public/name/{name}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> greetting(@PathVariable String name, HttpServletRequest request) {
		return ResponseEntity.ok("Hello" + name);
	}
	
}
