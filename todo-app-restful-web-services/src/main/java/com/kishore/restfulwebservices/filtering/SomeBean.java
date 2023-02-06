package com.kishore.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SimpleFilter")
public class SomeBean {

	public SomeBean(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	private int id;
	private String name;
	private String address;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "SomeBean [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
