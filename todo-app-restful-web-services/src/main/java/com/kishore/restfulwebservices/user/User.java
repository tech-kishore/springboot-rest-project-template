package com.kishore.restfulwebservices.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class User {

	User() {

	}

	@Id
	@GeneratedValue
	@JsonIgnore // static filtering
	private Integer id;
	@Size(min = 3, message = "Name should contain atleast 3 characters")
	@JsonProperty(value = "user_name")
	private String name;
	@Past(message = "Birth date should be of the past")
	@JsonProperty(value = "birth_date")
	private LocalDate birthDate;


	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}


	@Override
	public String toString() {
		return "UserDaoService [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
}
