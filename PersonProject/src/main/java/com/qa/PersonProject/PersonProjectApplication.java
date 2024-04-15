package com.qa.PersonProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PersonProjectApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PersonProjectApplication.class, args);
	}
	
	@GetMapping	("/hello")
	public String sayHello() {
		return "Hello World!!!! =) ";
	}
	@GetMapping	("/helloyou")
	public String sayHelloYou(@RequestParam(name="name", defaultValue = "World") String name) {
		return String.format("Hello %s!!", name);
	}
	@GetMapping	("/bye")
	public String sayGoodBye() {
		return "GoodBye World !!!! =( ";
	}
}
