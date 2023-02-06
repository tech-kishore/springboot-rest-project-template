package com.kishore.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kishore.restfulwebservices.posts.Post;
import com.kishore.restfulwebservices.posts.PostJpaRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

	private UserRepository repository;
	private PostJpaRepository postRepository;

	@Autowired
	public UserJpaResource(UserRepository _repository, PostJpaRepository _postRepository) {
		super();
		this.repository = _repository;
		this.postRepository = _postRepository;
	}

	// GET /users
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return repository.findAll();
	}

	// GET /users
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("User with id->" + id + " does not exist");

		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());

		EntityModel<User> entityModel = EntityModel.of(user.get());
		entityModel.add(link.withRel("all-users"));

		return entityModel;
	}

	// POST /users
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
		User savedUser = repository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	// DELETE /users/{id}
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}

	// GET /users/{id}/posts
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllUserPosts(@PathVariable int id) {
		Optional<User> user = repository.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("User with id->" + id + " does not exist");

		return user.get().getPosts();
	}

	// GET /jpa/users/{userid}/posts/{postid}
	@GetMapping("/jpa/users/{userid}/posts/{postid}")
	public Post retrieveUserPostByPostId(@PathVariable("userid") int id, @PathVariable("postid") int postid) {
		Optional<User> user = repository.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("User with id->" + id + " does not exist");

		Optional<Post> post = postRepository.findById(postid);
		if (post.isEmpty()) {
			return null;
		}
		return post.get();
	}

	// POST /jpa/users/{userid}/posts/
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Post> savePost(@PathVariable int id, @RequestBody @Valid Post post) {
		
		Optional<User> user = repository.findById(id);
		if(user.isEmpty())
				throw new UserNotFoundException("User with id: " + id +" does not exists");
		
		post.setUser(user.get());
		post.setTimestamp(LocalDate.now());
		
		Post savedPost = postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{postId}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
