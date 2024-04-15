package com.qa.PersonProject.controllers;

import com.qa.PersonProject.entities.Person;
import com.qa.PersonProject.entities.PersonDTO;
import com.qa.PersonProject.services.PersonService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonController {
	private PersonService service;
	
	public PersonController(PersonService service) {
		super();
		this.service = service;
	}

//    private List<Person> people = new ArrayList<>();
	
	@GetMapping("/health")
	public String health(){
		return "Testing 1, 2, 3!";
	}
	@PostMapping("/create")
	public PersonDTO addPerson(@RequestBody @Valid Person person){
		return this.service.createPerson(person);
//        return this.people.add(person);
	}
	
	@GetMapping("/getall")
	public List<PersonDTO> getAllPeople() {
//        return this.people;
		return this.service.findAllPeople();
	}
	
	@PutMapping("/update")
	public Person updatePerson(@PathParam("id") Long id, @RequestBody @Valid Person person) {
//        this.people.remove(id.intValue());
//        this.people.add(id.intValue(), person);
//        return this.people.get(id.intValue());
		return this.service.modifyPerson(id, person);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean removePerson(@PathVariable("id") Long id) {
//        this.people.remove(id.intValue());
//        return "Deleted: " + id;
		return this.service.deletePerson(id);
	}
	
	@GetMapping("/getbyfirstname/{firstName}")
	public List<PersonDTO> getByFirstName(@RequestParam(value = "firstName") String firstName){
		return this.service.findByFirstName(firstName);
		
	}
	@GetMapping("/getbylastname/{lastName}")
	public List<PersonDTO> getByLastName(@RequestParam(value = "lastName") String lastName) {
		return this.service.findByLastName(lastName);
	}
	@GetMapping("/getbylastnameandage/{age}")
	public List<PersonDTO> getByLastAge(@RequestParam(value = "lastName") String lastName,
									 @RequestParam(value = "age") int age) {
		return this.service.findByLastNameAndAge(lastName,age);
	}
}