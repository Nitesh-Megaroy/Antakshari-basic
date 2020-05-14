package com.poc.pocDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.pocDemo.model.RegisterUser;
import com.poc.pocDemo.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	//Creating user ---->
	@PostMapping("/register")	
	public RegisterUser createUser( @RequestBody RegisterUser registerUser) {
		return this.userRepo.save(registerUser);
	}	
	
	// updating the data of the registered user--->
	@PutMapping("/user/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody RegisterUser user, @PathVariable long id) {

		Optional<RegisterUser> UserOptional = userRepo.findById(id);

		if (!UserOptional.isPresent())
			return ResponseEntity.notFound().build();

		user.setId(id);
		userRepo.save(user);
		return ResponseEntity.noContent().build();
	}
	
	// For getting the list of registered users---->
	@GetMapping("/users")
	public List<RegisterUser> retrieveAllStudents() {
		return (List<RegisterUser>) userRepo.findAll();
	}
}
