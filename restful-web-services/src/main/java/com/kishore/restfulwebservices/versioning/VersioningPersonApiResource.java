package com.kishore.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonApiResource {

	/*
	 * Types: 
	 * 1. URL versioning
	 * 2. request param versioning
	 * 3. header versioning
	 * 4. Media type versioning
	 */
	
	
	// URL versioning
	@GetMapping(path = "/v1/persons")
	public Person getPerson() {
		return new Person("Bob Charlie");
	}

	@GetMapping(path = "/v2/persons")
	public PersonV2 getPersonV2() {
		return new PersonV2("Bob", "Charlie");
	}

	// request param versioning
	@GetMapping(path = "/persons/request-params", params = "version=1")
	public Person getPersonReqParamVersion() {
		return new Person("Bob Charlie");
	}

	@GetMapping(path = "/persons/request-params", params = "version=2")
	public PersonV2 getPersonReqParamVersion2() {
		return new PersonV2("Bob", "Charlie");
	}

	// header(custom) versioning
	@GetMapping(path = "/persons/header", headers = "X-API-VERSION=1")
	public Person getPersonHeaderVersion() {
		return new Person("Bob Charlie");
	}

	@GetMapping(path = "/persons/header", headers = "X-API-VERSION=2")
	public PersonV2 getPersonHeaderVersion2() {
		return new PersonV2("Bob", "Charlie");
	}

	// Media type versioning
	@GetMapping(path = "/persons/accept", produces = "application/app-v1+json")
	public Person getPersonMediaTypeVersion() {
		return new Person("Bob Charlie");
	}

	@GetMapping(path = "/persons/accept", produces = "application/app-v2+json")
	public PersonV2 getPersonMediaTypeVersion2() {
		return new PersonV2("Bob", "Charlie");
	}
}
