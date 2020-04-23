package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = HelloController.HELLO_CONTROLLER)
public class HelloController {
	final static String HELLO_CONTROLLER = "/hello";
	
	@GetMapping(value = "/greeting/{name}")
	public ResponseEntity<String> greeting(@PathVariable(value = "name")String name) {
		return new ResponseEntity<String>(new String("Hello" + name), HttpStatus.ACCEPTED);
	}
}
