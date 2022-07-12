package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	//GET /users
	//retrieveAllUsers
	@GetMapping("/users")
	public List<User>  retrieveAllUsers(){
		
		return service.findAll();
	}
	
	//retrieveUser
	@GetMapping("/users/{id}")
	public User retrieveUsers(@PathVariable int id){
		
		return service.findOne(id);
	}
	
	//created
	//input -  details of user
	//output - created and return the created URI
	
	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		
		User savedUser = service.save(user);
		
		//ServletUri
		//ResponseEntity<T>.created(null);
	}
		
}
