package com.api.restApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.restApi.entity.User;
import com.api.restApi.repository.UserRepository;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class UserController {
	@Autowired
	UserRepository repo;

	@GetMapping(path = "/user", produces = { "application/json" })
	public List<User> getUsers() {
		return repo.findAll();
	}

	@GetMapping(path = "/user/{user_email}", produces = { "application/json" })
	public Optional<User> getUser(@PathVariable("user_email") String user_email) {
		return repo.findById(user_email);
	}

	@PostMapping(path = "/user", produces = { "application/json" })
	@ResponseBody
	public User addUser(@RequestBody User user) {
		System.out.println(user.getUser_email());
		repo.save(user);
		return user;
	}

	@DeleteMapping("/user/{user_email}")
	public String deleteComment(@PathVariable String user_email) {

		User user = repo.getOne(user_email);
		repo.delete(user);
		return "deleted";
	}

}
