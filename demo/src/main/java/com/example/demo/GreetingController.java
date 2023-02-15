package com.example.demo;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	//Create variable to store reference to components
	private GreetingComponent gc;
	
	//define a constructor 
	//inject/initialize component in the constructor
	
	public GreetingController(GreetingComponent gc) {
		this.gc=gc;
	}
	

	
	@GetMapping("/testgc")
	public ResponseEntity<String> getMessage(){
		return ResponseEntity.ok(gc.getMessage());
	}
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")
	String name) {
	return new Greeting(counter.incrementAndGet(), String.format(template,
	name));
	}
}
