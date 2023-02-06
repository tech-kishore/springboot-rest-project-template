package com.kishore.restfulwebservices.versioning;

public class PersonV2 {

	private Name name;

	public PersonV2(String fname, String lname) {
		super();
		this.name = new Name(fname, lname);
	}

	public Name getName() {
		return name;
	}

}
