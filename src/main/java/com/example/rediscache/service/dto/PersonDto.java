package com.example.rediscache.service.dto;

import com.example.rediscache.domain.Person;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public class PersonDto implements Serializable {

	private final Long id;

	private final String name;

	private final int age;

	public static PersonDto of(Person person) {
		return new PersonDto(person.getId(), person.getName(), person.getAge());
	}

}
