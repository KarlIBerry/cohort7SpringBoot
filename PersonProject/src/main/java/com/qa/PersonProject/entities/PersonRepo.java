package com.qa.PersonProject.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo  extends JpaRepository<Person, Long> {
	List<Person> findByFirstName(String firstName);
	List<Person> findByLastName(String LastName);
	List<Person> findByAge(int age);
	
	
	@Query(value = "SELECT * FROM PERSON WHERE LAST_NAME = ?1 and AGE =?2", nativeQuery = true)
	List<Person> findByLastNameAndAgeSQL(String lastName, int age);

}