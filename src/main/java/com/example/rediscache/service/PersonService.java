package com.example.rediscache.service;

import com.example.rediscache.domain.Person;
import com.example.rediscache.domain.PersonRepository;
import com.example.rediscache.service.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PersonService {

	private final PersonRepository personRepository;

	@Transactional
	public PersonDto create(String name, int age) {
		return PersonDto.of(personRepository.save(new Person(name, age)));
	}

	@Transactional(readOnly = true)
	public List<PersonDto> getAllPeople() {
		return personRepository.findAll().stream()
				.map(PersonDto::of)
				.collect(Collectors.toList());
	}

	public PersonDto getPeople(String name) {
		Person person = personRepository.findByName(name).get(0);
		return PersonDto.of(person);
	}

	public void deleteAll() {
		personRepository.deleteAll();
	}

}
