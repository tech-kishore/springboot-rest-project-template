package com.kishore.learnjpaandhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kishore.learnjpaandhibernate.course.Course;
import com.kishore.learnjpaandhibernate.course.springdatajap.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	private CourseJdbcRepository courseRepository;

//	private CourseJpaRepository courseRepository;
	private CourseSpringDataJpaRepository courseRepository;

	@Autowired
	public CourseCommandLineRunner(CourseSpringDataJpaRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		courseRepository.save(new Course(1, "Learn AWS 3", "in28Minutes"));
		courseRepository.save(new Course(2, "Learn Spring 3", "in28Minutes"));
		courseRepository.save(new Course(3, "Learn React 3", "in28Minutes"));

		System.out.println(courseRepository.findAll());

		courseRepository.deleteById((long) 1);

		System.out.println(courseRepository.findByAuthor("in28Minutes"));
		
		System.out.println(courseRepository.findByName("Learn Spring 3"));

		/*
		 * System.out.println(courseRepository.findById((long) 1));
		 * System.out.println(courseRepository.findById((long) 2).get());
		 * System.out.println(courseRepository.findById((long) 3));
		 */

	}

}
