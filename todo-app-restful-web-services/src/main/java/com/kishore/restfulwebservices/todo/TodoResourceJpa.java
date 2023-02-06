package com.kishore.restfulwebservices.todo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class TodoResourceJpa {

	private TodoService todoService;
	private TodoJpaRepository repository;
	

	@Autowired
	public TodoResourceJpa(TodoService todoService,TodoJpaRepository repository) {
		super();
		this.todoService = todoService;
		this.repository=repository;
	}

	@GetMapping(value = "/users/{username}/todos")
	public List<Todo> listTodos(@PathVariable String username) {
		List<Todo> todos = repository.findByUsername(username);
		return todos;
	}

	@GetMapping(value = "/users/{username}/todos/{id}")
	public Todo listTodosById(@PathVariable int id) {
		Optional<Todo> todo = repository.findById(id);
		if(todo.isEmpty())
			throw new IllegalArgumentException("Todo ID: " + id +" not found");
		return todo.get();
	}

	@PostMapping(value = "/users/{username}/todos")
	public ResponseEntity<Todo> createTodo(@PathVariable("username") String username,
			@Valid @RequestBody Todo todo) {
		todo.setId(null);
		Todo savedTodo = repository.save(todo);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedTodo.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping(value = "/users/{username}/todos/{id}")
	public Todo updateTodo(@PathVariable("username") String username, @PathVariable("id") int id,
			@Valid @RequestBody Todo todo) {
		repository.save(todo);
		return todo;
	}

	@DeleteMapping(value = "/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable("username") String username, @PathVariable("id") int id) {
		todoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	/*
	 * @RequestMapping(value = "add-todo", method = RequestMethod.GET) public String
	 * showNewTodoPage(Todo todo) { return "todo"; }
	 * 
	 * @RequestMapping(value = "add-todo", method = RequestMethod.POST) public
	 * String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
	 * if (result.hasErrors()) { return "todo"; } // String username = (String)
	 * model.get("name"); todoService.addTodo(getLoggedInUsername(),
	 * todo.getDescription(), LocalDate.now().plusYears(1), false); return
	 * "redirect:list-todos"; }
	 * 
	 * @RequestMapping(value = "delete-todo", method = RequestMethod.GET) public
	 * String deleteTodo(@RequestParam("id") int id) { todoService.delete(id);
	 * return "redirect:list-todos"; }
	 * 
	 * @RequestMapping(value = "update-todo", method = RequestMethod.GET) public
	 * String showUpdateTodoPage(@RequestParam("id") int id, ModelMap model) { Todo
	 * todo = todoService.findById(id); model.addAttribute("todo", todo); return
	 * "todo"; }
	 * 
	 * @RequestMapping(value = "update-todo", method = RequestMethod.POST) public
	 * String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
	 * if (result.hasErrors()) { return "todo"; }
	 * 
	 * String username = getLoggedInUsername(); todo.setUsername(username);
	 * todoService.updateTodo(todo); return "redirect:list-todos"; }
	 * 
	 */

}
