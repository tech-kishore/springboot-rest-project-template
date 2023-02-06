package com.kishore.restfulwebservices.posts;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kishore.restfulwebservices.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {

	Post() {

	}

	public Post(int id, String description, LocalDate timestamp) {
		super();
		this.id = id;
		this.description = description;
		this.timestamp = timestamp;
	}

	@Id
	@GeneratedValue
	private int id;
	private String description;
	private LocalDate timestamp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + ", timestamp=" + timestamp + "]";
	}

}
