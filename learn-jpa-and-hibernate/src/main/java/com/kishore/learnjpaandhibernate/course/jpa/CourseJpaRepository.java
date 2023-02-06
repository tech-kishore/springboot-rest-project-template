package com.kishore.learnjpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.kishore.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class CourseJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void insert(Course course) {
		entityManager.persist(course);
	}

	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}

	@Transactional
	public void delete(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}

}
