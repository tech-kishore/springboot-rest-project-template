package com.kishore.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();

	private static int counter = 0;

	static {
		todos.add(new Todo(++counter, "kishore", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++counter, "developer", "Learn Graphic Design", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++counter, "kishore", "Learn DevOps", LocalDate.now().plusYears(3), false));
	}

	public List<Todo> findByUserName(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equals(username);
		return todos.stream().filter(predicate).toList();
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
		Todo todo = new Todo(++counter, username, description, targetDate, isDone);
		todos.add(todo);
	}

	public void delete(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		delete(todo.getId());
		todos.add(todo);
	}

}
