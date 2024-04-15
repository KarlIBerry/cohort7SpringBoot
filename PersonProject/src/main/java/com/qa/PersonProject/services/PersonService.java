package com.qa.PersonProject.services;

import com.qa.PersonProject.entities.Person;
import com.qa.PersonProject.entities.PersonDTO;
import com.qa.PersonProject.entities.PersonRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
	
	private PersonRepo repo;
	
	private ModelMapper mapper;
	
	public PersonService(PersonRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
// used to convert a Person to a PersonDTO

	private PersonDTO mapToDTO(Person person){
		// turning a Person into a PersonDTO
		return this.mapper.map(person, PersonDTO.class);
	}

//    private List<Person> people = new ArrayList<>();
	
//	public Person createPerson(Person person){
////        return this.people.add(person);
//		return this.repo.save(person);
//	}
	public PersonDTO createPerson(Person person) {
		Person saved = this.repo.save(person);
		return this.mapToDTO(saved);
	}
	
//	public List<Person> findAllPeople() {
////        return this.people;
//		return this.repo.findAll();// This is the same as SELECT * FROM Person
//
//	}
	
	public List<PersonDTO> findAllPeople() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	public List<PersonDTO> findByFirstName(String firstName) {
		return	this.repo.findByFirstName(firstName).stream().map(this::mapToDTO).collect(Collectors.toList());
		
	}
	public List<PersonDTO> findByLastName(String lastName) {
		return	this.repo.findByLastName(lastName).stream().map(this::mapToDTO).collect(Collectors.toList());
		
	}
	public List<PersonDTO> findByLastNameAndAge(String lastName,int age) {
		return	this.repo.findByLastNameAndAgeSQL(lastName, age).stream().map(this::mapToDTO).collect(Collectors.toList());
		
	}
	
	public Person modifyPerson(Long id, Person person) {
//        this.people.remove(id.intValue());
//        this.people.add(id.intValue(), person);
//        return this.people.get(id.intValue());
		Optional<Person> optionalPerson = this.repo.findById(id);
		Person existing = optionalPerson.get();
		existing.setFirstName(person.getFirstName()); // This is the same as SET firstName = person.getFirstName()
		existing.setLastName(person.getLastName());
		existing.setAge(person.getAge());
		
		Person updated = this.repo.save(existing);
		return this.repo.save(existing);
		
	}
	
	
	
//    public String deletePerson(Long id) {
////        this.people.remove(id.intValue());
//        this.repo.deleteById(id);
//        return "Deleted: " + id;
//    }
	
	// Shows how to delete with a boolean
	public boolean deletePerson(Long id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists; // If the person does not exist, return true
		
	}
}