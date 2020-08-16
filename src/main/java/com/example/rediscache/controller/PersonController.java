package com.example.rediscache.controller;

import com.example.rediscache.service.PersonService;
import com.example.rediscache.service.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PersonController {

	private final PersonService personService;

	@PostMapping("/create")
	@CachePut(value = "persons", key = "#name")
	public PersonDto create(@RequestParam String name, @RequestParam int age) {
		log.info("create method call");
		return personService.create(name, age);
	}

	@GetMapping("/read")
	@Cacheable(value = "persons")
	public List<PersonDto> read() {
		log.info("get method call");
		return personService.getAllPeople();
	}

	@GetMapping("/read/one")
	@Cacheable(value = "persons", key = "#name")
	public PersonDto readOne(@RequestParam String name) {
		log.info("get method call (1)");
		return personService.getPeople(name);
	}

	@DeleteMapping("/delete")
	@CacheEvict(value = "persons", allEntries = true)
	public void deleteAll() {
		log.info("delete method call");
		personService.deleteAll();
	}

}
