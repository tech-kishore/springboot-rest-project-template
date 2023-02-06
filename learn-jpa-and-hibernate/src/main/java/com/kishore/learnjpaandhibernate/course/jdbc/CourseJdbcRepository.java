package com.kishore.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kishore.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {

	private JdbcTemplate springJdbcTemplate;

	@Autowired
	public CourseJdbcRepository(JdbcTemplate springJdbcTemplate) {
		super();
		this.springJdbcTemplate = springJdbcTemplate;
	}

	/*
	 * private static String INSERT_QUERY = """ insert into course values(1,'Learn
	 * Spring','in28Minutes'), (2,'Learn AWS','in28Minutes'); """;
	 */

	private static String INSERT_QUERY = """
					insert into course values(?,?,?);
			""";

	private static String SELECT_QUERY = """
					select * from course where id= ?;
			""";

	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}

	public Course findById(long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
