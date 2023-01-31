package com.cofness.crud.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cofness.crud.crud.entities.PersonEntity;
import com.cofness.crud.crud.repos.PersonRepo;

@RequestMapping("/person")
@RestController
public class PersonController {

	@Autowired
	private PersonRepo personRepo;
	
	@PostMapping
	public PersonEntity savePerson(@Validated @RequestBody PersonEntity person) {
		return personRepo.save(person);
	}
	
	@GetMapping
	public List<PersonEntity> getListOfPerson(){
		return (List<PersonEntity>) personRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public PersonEntity getPerson(@PathVariable(value = "id") long id) {
		Optional<PersonEntity> res = personRepo.findById(id);
		return res.get();
	}
	
	@PutMapping("/{id}")
	public PersonEntity updatePerson(@PathVariable(value = "id") long id, @Validated @RequestBody PersonEntity personReq) {
		Optional<PersonEntity> res = personRepo.findById(id);
		PersonEntity person = res.get();
		person.setName(personReq.getName());
		return personRepo.save(person);
	}
	
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable(value = "id") long id) {
		personRepo.deleteById(id);
	}
}
